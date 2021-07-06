package com.github.sistemas_tecnm_uruapan;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.salvador.graduationitsucreateqr.helpers.interfaces.Information;
import com.salvador.graduationitsucreateqr.helpers.models.Alumno;
import com.salvador.graduationitsucreateqr.repository.FirestoreHelper;

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
    private final FirestoreHelper firestoreHelper = new FirestoreHelper();
    LottieAnimationView animationView2;

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
        setTitle(R.string.graduaci_n_itsu);


        buttonGuardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(bitmap!=null)
                {
                    if (solicitarPermiso()) {
                        String nombre = "Invitación Graduación ITSU";
                        try {
                            saveImage(bitmap, nombre);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else {
                        //Toast.makeText(getApplicationContext(),"Para guardar la invitación necesita conceder los permisos.",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Snackbar.make(view, "Debes buscar la invitación primero.", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        buttonBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showDialogBuscar();
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


        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog dialog = ProgressDialog.show(com.salvador.graduationitsucreateqr.MainActivity.this, "",
                        "Buscando...", true);
                dialog.show();
                String numerodecontrol = textInput_numeroCtrl.getEditText().getText().toString();
                if(numerodecontrol.length()==8)
                {
                    firestoreHelper.getData(numerodecontrol,dialog, com.salvador.graduationitsucreateqr.MainActivity.this, com.salvador.graduationitsucreateqr.MainActivity.this);
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
                    String nombre = "Invitación Graduación ITSU";
                    try {
                        saveImage(bitmap, nombre);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    // Permission Denied
                    Snackbar.make(findViewById(android.R.id.content), "Para guardar la invitación necesita conceder los permisos.", Snackbar.LENGTH_SHORT).show();
                }
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void saveImage(Bitmap bitmap, @NonNull String name) throws IOException {
        OutputStream outputStream;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContentResolver contentResolver = getApplicationContext().getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.MediaColumns.DISPLAY_NAME, name + ".jpg");
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg");
            contentValues.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES);
            Uri imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            outputStream = contentResolver.openOutputStream(Objects.requireNonNull(imageUri));

        }
        else {
            String imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath()+"/";
            File dir = new File(imagesDir, "Invitación ITSU" );
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File image = new File(dir, name + ".jpg");
            outputStream = new FileOutputStream(image);
            MakeSureFileWasCreatedThenMakeAvaliable(image);

        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        Objects.requireNonNull(outputStream).close();
        Snackbar.make(findViewById(android.R.id.content), "Imagen guardada en galeria.", Snackbar.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(),"Imagen guardada en galeria.",Toast.LENGTH_SHORT).show();
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
            Snackbar.make(animationView2.getRootView(), "Felicidades Ingeniero ITSU", Snackbar.LENGTH_LONG).show();
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
            qr=alumno.getId()+"|"+alumno.getNombre()+"|"+alumno.getCarrera();//consulta a firebase
            bitmap = QRCode.from(qr).withSize(400, 400).bitmap();
            imageView.setImageBitmap(bitmap);
            imageView.setVisibility(View.VISIBLE);
        }

    }
}