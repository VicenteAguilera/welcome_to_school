package com.github.sistemas_tecnm_uruapan;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.github.sistemas_tecnm_uruapan.helpers.interfaces.Information;
import com.github.sistemas_tecnm_uruapan.helpers.models.Alumno;
import com.github.sistemas_tecnm_uruapan.helpers.utility.Encriptacion;
import com.github.sistemas_tecnm_uruapan.helpers.utility.StringHelper;
import com.github.sistemas_tecnm_uruapan.repository.FirestoreHelper;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import net.glxn.qrgen.android.QRCode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;


public class MainActivity extends AppCompatActivity implements Information {

    private final int REQUEST_CODE_ASK_PERMISSION = 111;
    private Button buttonGuardar;
    private Button buttonBuscar;
    private ImageView imageView;
    private Bitmap bitmap;
    private String qr;
    private String nombreQR;
    private final FirestoreHelper firestoreHelper = new FirestoreHelper();

    LottieAnimationView animationView2;
    private final StringHelper stringHelper = new StringHelper();
    private Alumno alumno;
    private File imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonBuscar = findViewById(R.id.buttonBuscar);
        buttonGuardar = findViewById(R.id.buttonGuardar);
        imageView = findViewById(R.id.imageView);
        imageView.setVisibility(View.INVISIBLE);
        animationView2 = findViewById(R.id.animationView2);
        animationView2.setVisibility(View.INVISIBLE);
        setTitle(R.string.nuevo_ingreso);


        buttonGuardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(bitmap!=null)
                {
                    if (solicitarPermiso()) {
                        String nombre = nombreQR;
                        try {
                            saveImage(bitmap, nombre);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(),"Para guardar el pase necesita conceder los permisos.",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Snackbar.make(view, "Debes buscar el pase primero.", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        buttonBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                 /*ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "",
                    "Buscando...", true);
                firestoreHelper.sendAllInformation(MainActivity.this,dialog);*/
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Atención")
                        .setMessage("Para poder descagar tu pase o visualizalo, debes de ingresar un número de teléfono para que el TecNM campus Uruapan, pueda contactarte." +
                                "\nEn el campo NÚMERO DE TELÉFONO deberás ingresarlo, si ya ingresaste uno anteriormente deja el campo vacío.")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                showDialogBuscar();
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        .setNegativeButton(android.R.string.no, null)
                        //.setIcon(android.R.drawable.ic_dialog_alert)
                        .show();

            }
        });

    }

    private void showDialogBuscar()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.dialog_search_invitation, null);
        builder.setView(view);

        final AlertDialog dialogSearchInvitation =builder.create();
        dialogSearchInvitation.setCancelable(false);
        dialogSearchInvitation.show();
        Button buttonBuscar = view.findViewById(R.id.buttonBuscar);
        Button buttonClose = view.findViewById(R.id.buttonClose);
        TextInputLayout textInput_numeroCtrl = view.findViewById(R.id.textInput_numeroCtrl);
        TextInputLayout textInput_numeroTelefono = view.findViewById(R.id.textInput_numeroTelefono);

        textWatcher(textInput_numeroCtrl,textInput_numeroTelefono);
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "",
                        "Buscando...", true);
                dialog.show();
                String numerodecontrol = textInput_numeroCtrl.getEditText().getText().toString();
                String numerodetelefono = textInput_numeroTelefono.getEditText().getText().toString();
                if(stringHelper.isCtrolNumber(numerodecontrol))
                {
                    if(stringHelper.isPhone(numerodetelefono))
                    {
                        firestoreHelper.addPhone(numerodecontrol,numerodetelefono,dialog,MainActivity.this, MainActivity.this);
                        Log.e("err","Entre2");
                    }
                    else if(numerodetelefono.length()==0)
                    {
                        firestoreHelper.getData(numerodecontrol, dialog, MainActivity.this, MainActivity.this);
                        Log.e("err","Entre1");
                    }
                    else
                    {

                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("Atención")
                                .setMessage("Introduzca un número de teléfono de 10 dígitos o deje el campo en blanco.")
                                // Specifying a listener allows you to take an action before dismissing the dialog.
                                // The dialog is automatically dismissed when a dialog button is clicked.
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        showDialogBuscar();
                                    }
                                })
                                .setCancelable(false)
                                .show();

                        dialog.dismiss();
                    }
                    dialogSearchInvitation.dismiss();
                }
                else
                {
                    Snackbar.make(view, "Número de control no válido.", Snackbar.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(),"Número de control no válido.",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSearchInvitation.dismiss();
            }
        });
    }


    private boolean solicitarPermiso(){
        int permiso = ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(permiso!= PackageManager.PERMISSION_GRANTED){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE_ASK_PERMISSION);
            }
            return false;
        }else {
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_ASK_PERMISSION:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // Permission Granted
                    // Rutina que se ejecuta al aceptar
                    String nombre = "Pase TecNM campus Uruapan";
                    try {
                        saveImage(bitmap, nombre);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    // Permission Denied
                    Snackbar.make(findViewById(android.R.id.content), "Para guardar el pase necesita conceder los permisos.", Snackbar.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private Uri saveImage(Bitmap bitmap, @NonNull String name) throws IOException {
        OutputStream outputStream;
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentResolver contentResolver = getApplicationContext().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME,"PASE CURSO INDUCCION ITSU - "+name + ".jpg");
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES);
            Uri imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            outputStream = contentResolver.openOutputStream(Objects.requireNonNull(imageUri));
            uri=imageUri;

        } else {
            String imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/";
            File dir = new File(imagesDir, "PASE CURSO INDUCCION ITSU");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File image = new File(dir, name + ".jpg");
            outputStream = new FileOutputStream(image);
            MakeSureFileWasCreatedThenMakeAvaliable(image);
            uri=Uri.fromFile(image);
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        Objects.requireNonNull(outputStream).close();
        Snackbar.make(findViewById(android.R.id.content), "Imagen guardada en galeria. El título del QR es tu nombre.", Snackbar.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(),"Imagen guardada en galeria.",Toast.LENGTH_SHORT).show();
        return  uri;
    }
    /**
     * Metodo para actualizar la galería
     * @param file imagen a guardar
     */
    private void MakeSureFileWasCreatedThenMakeAvaliable(File file){
        MediaScannerConnection.scanFile(getApplicationContext(),
                new String[] { file.toString() } , null,
                new MediaScannerConnection.OnScanCompletedListener() {

                    public void onScanCompleted(String path, Uri uri) {
                    }
                });
    }


    @Override
    public void status(String message)
    {
        if(message.equals("fiesta"))
        {
            animationView2.setVisibility(View.VISIBLE);
            animationView2.playAnimation();
            Snackbar.make(animationView2.getRootView(), "Bienvenido al TecNM campus Uruapan", Snackbar.LENGTH_LONG).show();

        }
        else
        {
            //Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show();
        }
    }

    @Override
    public void getData(Alumno alumno)
    {
        //creacion de QR

        if(alumno!=null)
        {
            if(alumno.getTelefono().length()==0)
            {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Atención")
                        .setMessage("Debes de ingresar un número de teléfono para poder descargar tu pase ya que no hay ninguno registrado.")
                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                showDialogBuscar();
                            }
                        })
                        .setCancelable(false)
                        .show();


            }
            else {
                this.alumno=alumno;
                qr = alumno.getId() + "|" + alumno.getNombre() + "|" + alumno.getCarrera();//consulta a firebase
                nombreQR = alumno.getNombre() + "-" + StringHelper.obtenerFecha();
                bitmap = QRCode.from(new Encriptacion().encryptAE(qr)).withSize(400, 400).bitmap();
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
            }

        }

    }
    public void textWatcher(TextInputLayout textInput_numeroCtrol, TextInputLayout textInput_numeroTelefono)
    {
        textInput_numeroTelefono.getEditText().addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {
                        if(charSequence.length()==0)
                        {
                            textInput_numeroTelefono.setError("Campo vacío");
                        }
                        else if(!stringHelper.isPhone(charSequence.toString()))
                        {
                            textInput_numeroTelefono.setError("Teléfono inválido");
                        }
                        else
                        {
                            textInput_numeroTelefono.setError(null);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );

        textInput_numeroCtrol.getEditText().addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
                    {
                        if(charSequence.length()==0)
                        {
                            textInput_numeroCtrol.setError("Campo vacío");
                        }
                        else if(!stringHelper.isCtrolNumber(charSequence.toString()))
                        {
                            textInput_numeroCtrol.setError("Numero de control inválido");
                        }
                        else
                        {
                            textInput_numeroCtrol.setError(null);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );
    }



    /**
     *  MENU POPUP
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.item_AcercaDe) {
            Toast.makeText(MainActivity.this, getResources().getText(R.string.acerca_de) + "...", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}