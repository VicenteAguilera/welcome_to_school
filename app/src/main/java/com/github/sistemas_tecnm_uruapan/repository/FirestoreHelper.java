package com.github.sistemas_tecnm_uruapan.repository;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

import androidx.annotation.NonNull;

import com.github.sistemas_tecnm_uruapan.MainActivity;
import com.github.sistemas_tecnm_uruapan.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.WriteBatch;

import com.github.sistemas_tecnm_uruapan.helpers.interfaces.Information;
import com.github.sistemas_tecnm_uruapan.helpers.models.Alumno;
import com.github.sistemas_tecnm_uruapan.helpers.utility.StringHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class FirestoreHelper
{
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final CollectionReference AlumnosCollection = db.collection("alumnos");
    public void addPhone(String doc,String telefono,final ProgressDialog dialog, final Information information, final Context context)
    {
        AlumnosCollection.document(doc).update("telefono", telefono)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isComplete()) {
                            dialog.dismiss();
                            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                            alertDialogBuilder.setCancelable(false);
                            alertDialogBuilder.setTitle("Actualización Exitosa");
                            alertDialogBuilder.setMessage("Teléfono actualizado, ahora da click en BUSCAR PASE para obtener tu pase de acceso.");
                            alertDialogBuilder.setPositiveButton("Buscar Pase",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface alertDialog, int i) {
                                            getData(doc, dialog, information, context);
                                            alertDialog.cancel();
                                        }
                                    }
                            );
                            alertDialogBuilder.show();

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        information.status("Error de actualización");
                        dialog.dismiss();
                    }
                });
    }
    public void getData(String document, final ProgressDialog dialog, final Information information, final Context context)
    {
        dialog.show();
        AlumnosCollection.document(document).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (Objects.requireNonNull(document).exists())
                    {
                        Map<String,Object> data=document.getData();
                        Log.e("er",document.getData().toString());
                        Alumno alumno = new  Alumno(document.getId(),String.valueOf(data.get("nombre")),String.valueOf(data.get("carrera")),String.valueOf(data.get("telefono")));
                        if(alumno.getTelefono().length()!=0) {
                            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                            alertDialogBuilder.setCancelable(false);
                            alertDialogBuilder.setTitle("Datos Obtenidos");
                            alertDialogBuilder.setMessage("NCtrol: " + alumno.getId() + "\n" +
                                    "Nombre: " + alumno.getNombre() + "\n" +
                                    "Carrera: " + alumno.getCarrera() + "\n" +
                                    "Telefono: " + alumno.getTelefono() + "\n\n" +
                                    "Si existe algún error, comunícate con el jefe de carrera de ISC.\njuanandrade@tecuruapan.edu.mx \n");
                            alertDialogBuilder.setPositiveButton("Aceptar",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface alertDialog, int i) {
                                            information.status("fiesta");
                                            alertDialog.cancel();
                                        }
                                    }
                            );
                            //alumno.setCarrera(alumno.getCarrera());
                            alertDialogBuilder.show();
                        }
                        information.getData(alumno);



                    }
                    else
                    {
                        final AlertDialog.Builder  alertDialogBuilder = new AlertDialog.Builder(context);
                        alertDialogBuilder.setCancelable(false);
                        alertDialogBuilder.setTitle("Error de Obtención");
                        alertDialogBuilder.setMessage("No hay Información acerca del número de control ingresado, comunícate con el jefe de carrera de ISC. juanandrade@tecuruapan.edu.mx");
                        alertDialogBuilder.setPositiveButton("Aceptar",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface alertDialog, int i)
                                    {

                                        alertDialog.cancel();
                                    }
                                }
                        );
                        information.getData(null);
                        alertDialogBuilder.show();
                    }
                }
                else
                {
                    information.getData(null);
                    information.status("Error, verifique su conexión a Internet, si los problemas continuan contacte al administrador.");
                }
                dialog.dismiss();

            }
        });

    }
    // este proceso solo se puede hacer de 500 en 500 no en más
    public void sendAllInformation(Information information, final ProgressDialog dialog)
    {
        dialog.show();
        WriteBatch batch = db.batch();
        StringHelper stringHelper = new StringHelper();
        ArrayList<Alumno> alumnos = stringHelper.getData();

        DocumentReference nycRef ;
        for(int i =0;i<stringHelper.getData().size();i++)
        {
            nycRef = AlumnosCollection.document(alumnos.get(i).getId());
            //*batch.set(nycRef, new Alumno2());*/

            Map<String,Object> data = new HashMap<>();
            data.put("nombre",alumnos.get(i).getCarrera());
            data.put("telefono",alumnos.get(i).getTelefono());
            data.put("carrera",alumnos.get(i).getNombre());
            data.put("status",alumnos.get(i).getStatus());
            batch.update(nycRef,data);
        }
        batch.commit().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {
                if(task.isComplete())
                {
                    information.status(alumnos.size()+" escritos con éxito");
                    dialog.dismiss();
                }
            }
        });


    }

    class Alumno2
    {
        String nombre;
        String carrera;
        String telefono;
        int status;
        public Alumno2()
        {

        }
        public Alumno2(String nombre, String carrera, String telefono,int status) {
            this.nombre = nombre;
            this.carrera = carrera;
            this.telefono = telefono;
            this.status=status;
        }

        public int getStatus() {
            return status;
        }
        public String getNombre() {
            return nombre;
        }

        public String getCarrera() {
            return carrera;
        }

        public String getTelefono() {
            return telefono;
        }
    }

}
