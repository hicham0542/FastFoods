package com.sari3food.sari3fooooooooood;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.kofigyan.stateprogressbar.StateProgressBar;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

public class signupactivity extends AppCompatActivity implements OnMapReadyCallback {
EditText email,user,pass,phone,typework,nomesotre,phonestore;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private GoogleMap mMap;
    DatabaseReference myRef ;
    Boolean find;
    Boolean click1,click2;
    private FirebaseAuth mAuth;
    Uri filePath1,filePath2;

    // request code
    private final int PICK_IMAGE_REQUEST = 1;

    // instance for firebase storage and StorageReference
    FirebaseStorage storage;
    StorageReference storageReference;
     LocationManager locationManager;
     LocationListener listener;
    int PICK_IMAGE_MULTIPLE = 1;
// ...
// Initialize Firebase Auth
final int PICK_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        LayoutInflater factory = LayoutInflater.from(signupactivity.this);
        click1= false;
        click2= false;
// ...
// Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        final AlertDialog deleteDialog = new AlertDialog.Builder(signupactivity.this).create();
        final View deleteDialogView = factory.inflate(R.layout.tpyeaccountexception, null);
        deleteDialog.setView(deleteDialogView);
        deleteDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

/*if (!isOnline()){
    deleteDialog.show();
    TextView textView = deleteDialogView.findViewById(R.id.txtexception);
    textView.setText("تأكد من الاتصال بالانترنيت ");
}*/
    //  final MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.spinner);
    LinearLayout l1 =findViewById(R.id.firstlayoutinscription);
    LinearLayout l2 =findViewById(R.id.storesecondlayoutinscription);
    l1.setVisibility(View.GONE);
    l2.setVisibility(View.VISIBLE);
    email =findViewById(R.id.editText3);
    user = findViewById(R.id.editText4);
    pass =findViewById(R.id.editpass);
    phone = findViewById(R.id.editText5);
    typework = findViewById(R.id.editText10);
    nomesotre = findViewById(R.id.editText6);
    phonestore = findViewById(R.id.editText8);
    //database.getInstance().setPersistenceEnabled(true);

        final StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.state_progress_bar);



    deleteDialogView.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            deleteDialog.dismiss();
        }
    });





    Button btncontinue =findViewById(R.id.button45);
    btncontinue.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // int i= stateProgressBar.getCurrentStateNumber();
            if (!isOnline()){
                deleteDialog.show();
                TextView textView = deleteDialogView.findViewById(R.id.txtexception);
                textView.setText("تأكد من الاتصال بالانترنيت ");
            }
            else if(TextUtils.isEmpty(email.getText()))
            {

                deleteDialog.show();
                TextView textView = deleteDialogView.findViewById(R.id.txtexception);
                textView.setText("املأ خانة الايميل");

            }
            else if(TextUtils.isEmpty(user.getText()))
            {
                deleteDialog.show();
                TextView textView = deleteDialogView.findViewById(R.id.txtexception);
                textView.setText("املأ خانة اسم المستخدم");

            }
            else if(TextUtils.isEmpty(pass.getText()))
            {
                deleteDialog.show();
                TextView textView = deleteDialogView.findViewById(R.id.txtexception);
                textView.setText("املأ خانة كلمة المرور");

            }
            else if(TextUtils.isEmpty(phone.getText()))
            {
                deleteDialog.show();
                TextView textView = deleteDialogView.findViewById(R.id.txtexception);
                textView.setText("املأ خانة الهاتف");

            }
            else if(TextUtils.isEmpty(typework.getText()))
            {
                deleteDialog.show();
                TextView textView = deleteDialogView.findViewById(R.id.txtexception);
                textView.setText("املأ خانة نوع الحرفة");
            }else
            if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
            {
                deleteDialog.show();
                TextView textView = deleteDialogView.findViewById(R.id.txtexception);
                textView.setText("املأ خانة الايميل بايميل صحيح");
            }
            else {
                if(stateProgressBar.getCurrentStateNumber() == 1)
                {
                    showProgress(v);
                    mAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                            .addOnCompleteListener(signupactivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        // Log.d(TAG, "signInWithCredential:success");
                                        myRef = database.getReference("Users");
                                        ClassUser classUser = new ClassUser(email.getText().toString(), user.getText().toString(), pass.getText().toString(), typework.getText().toString(),Integer.valueOf(phone.getText().toString() ),0) ;

                                        FirebaseUser user = mAuth.getCurrentUser();
                                        myRef.child(user.getUid()).setValue(classUser);
                                        l1.setVisibility(View.GONE);
                                        l2.setVisibility(View.VISIBLE);
                                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                                        deleteDialog.show();
                                        TextView textView = deleteDialogView.findViewById(R.id.txtexception);
                                        textView.setText("تم التسجيل بنجاح ");
                                        textView.setCompoundDrawablesWithIntrinsicBounds( R.drawable.happiness, 0, 0, 0);
                                        mAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                                                .addOnCompleteListener(signupactivity.this, new OnCompleteListener<AuthResult>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                                        if (task.isSuccessful()) {
                                                            // Sign in success, update UI with the signed-in user's information
                                                           // Log.d(TAG, "signInWithEmail:success");
                                                            FirebaseUser user = mAuth.getCurrentUser();
                                                            updateUI(user);
                                                        } else {
                                                            // If sign in fails, display a message to the user.
                                                         //   Log.w(TAG, "signInWithEmail:failure", task.getException());
                                                           // Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                                                                 //   Toast.LENGTH_SHORT).show();
                                                          //  updateUI(null);
                                                        }
                                                    }
                                                });

                                    } else {
                                        deleteDialog.show();
                                        TextView textView = deleteDialogView.findViewById(R.id.txtexception);
                                        textView.setText("هناك خطأ أو الايميل مستعمل ");
                                        // If sign in fails, display a message to the user.
                                        //Log.w(TAG, "signInWithCredential:failure", task.getException());
                                        // updateUI(null);
                                    }
                                }
                            });

                }else  if(stateProgressBar.getCurrentStateNumber() == 2)
                {
                    FirebaseUser user = mAuth.getCurrentUser();
                    if(TextUtils.isEmpty(nomesotre.getText().toString()) ||TextUtils.isEmpty(phonestore.getText().toString() ))
                    {

                    }
                    else
                    {
                        Storeuser storeuser= new Storeuser(nomesotre.getText().toString(),phonestore.getText().toString() );
                        myRef.child(user.getUid()).child("Store").setValue(storeuser);

                    }
                    uploadImage();
                }


            }

        }
    });
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        listener = new LocationListener() {


            @Override
            public void onLocationChanged(@NonNull Location location) {

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {
                //
            }

            @Override
            public void onProviderEnabled(String s) {
                //
            }

            @Override
            public void onProviderDisabled(String s) {
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
        Button button ,button1,button2 ;
        button = findViewById(R.id.buttonok);
        button1 = findViewById(R.id.buttonok1);
        button2 = findViewById(R.id.buttonokgps);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectImage();
                click1= true;



            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectImage();
                click2= true;

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog deleteDialog1 = new AlertDialog.Builder(signupactivity.this).create();
                final View deleteDialogView1 = factory.inflate(R.layout.gpschoser, null);
                deleteDialog1.setView(deleteDialogView1);
                deleteDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                deleteDialog1.show();
                deleteDialogView1.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        deleteDialog1.dismiss();
                    }
                });
                deleteDialogView1.findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        configure_button();
                    }
                });




            }
        });



    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
    public void showProgress(View view) {
        final int THREE_SECONDS = 3*1000;
        final ProgressDialog dlg = new ProgressDialog(this);
        dlg.setMessage("انتظر لتحقق من الامر . . ");
        dlg.setCancelable(false);
        dlg.show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                dlg.dismiss();
            }
        }, THREE_SECONDS);
    }
    public void updateUI(FirebaseUser user)
    {

    }








    private void SelectImage()
    {

        // Defining Implicit Intent to mobile gallery
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(
                        intent,
                        "Select Image from here..."),
                PICK_IMAGE_REQUEST);
    }

    // Override onActivityResult method
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data)
    {

        super.onActivityResult(requestCode,
                resultCode,
                data);

        // checking request code and result code
        // if request code is PICK_IMAGE_REQUEST and
        // resultCode is RESULT_OK
        // then set image in the image view
        if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK && null != data) {
            // Get the Image from data
            if (data.getData() != null) {
                if(click1){
                    filePath1 = data.getData();
                }

                if(click2){
                    filePath2 = data.getData();
                }


            }
        }




                if (filePath1 != null) {
                    LinearLayout l = findViewById(R.id.image1);
                    TextView textView = findViewById(R.id.textView4);
                    try {

                        Bitmap bitmap = MediaStore
                                .Images
                                .Media
                                .getBitmap(
                                        getContentResolver(),
                                        filePath1);
                        Uri selectedImageUri = data.getData();

                        textView.setText("تم اختيار 1 عنصر ");
                        l.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(signupactivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                } else {



                }
                if (filePath2 != null) {
                    LinearLayout l = findViewById(R.id.image2);
                    TextView textView = findViewById(R.id.textView11);
                    try {

                        Bitmap bitmap = MediaStore
                                .Images
                                .Media
                                .getBitmap(
                                        getContentResolver(),
                                        filePath2);
                        Uri selectedImageUri = data.getData();

                        textView.setText("تم اختيار 1 عنصر ");
                        l.setVisibility(View.VISIBLE);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(signupactivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                } else {


                }

    }

    // UploadImage method
    private void uploadImage()
    {
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        if (filePath1 != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("جاري التحميل الصور...");
            progressDialog.show();

                FirebaseUser user = mAuth.getCurrentUser();
            // Defining the child of storageReference
            StorageReference ref
                    = storageReference.child(user.getUid())
                    .child(
                            "images/"
                                    + "profile");

            // adding listeners on upload
            // or failure of image
            ref.putFile(filePath1)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(signupactivity.this,
                                                    "تم تحميل الصورة!!",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(signupactivity.this,
                                            "فشل " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "تحميل "
                                                    + (int)progress + "%");
                                }
                            });
        }
        if (filePath2 != null) {

            // Code for showing progressDialog while uploading
            ProgressDialog progressDialog
                    = new ProgressDialog(this);
            progressDialog.setTitle("جاري التحميل الصور...");
            progressDialog.show();

            FirebaseUser user = mAuth.getCurrentUser();
            // Defining the child of storageReference
            StorageReference ref
                    = storageReference.child(user.getUid())
                    .child(
                            "images/"
                                    + "storeface");

            // adding listeners on upload
            // or failure of image
            ref.putFile(filePath2)
                    .addOnSuccessListener(
                            new OnSuccessListener<UploadTask.TaskSnapshot>() {

                                @Override
                                public void onSuccess(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {

                                    // Image uploaded successfully
                                    // Dismiss dialog
                                    progressDialog.dismiss();
                                    Toast
                                            .makeText(signupactivity.this,
                                                    "تم تحميل الصورة",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            })

                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e)
                        {

                            // Error, Image not uploaded
                            progressDialog.dismiss();
                            Toast
                                    .makeText(signupactivity.this,
                                            "فشل " + e.getMessage(),
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                    })
                    .addOnProgressListener(
                            new OnProgressListener<UploadTask.TaskSnapshot>() {

                                // Progress Listener for loading
                                // percentage on the dialog box
                                @Override
                                public void onProgress(
                                        UploadTask.TaskSnapshot taskSnapshot)
                                {
                                    double progress
                                            = (100.0
                                            * taskSnapshot.getBytesTransferred()
                                            / taskSnapshot.getTotalByteCount());
                                    progressDialog.setMessage(
                                            "تحميل "
                                                    + (int)progress + "%");
                                }
                            });
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }

    void configure_button() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(signupactivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(signupactivity.this,
                ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                request_permission();
            }
        } else {


            // permission has been granted
            locationManager.requestLocationUpdates("gps", 5000, 0, listener);
            Location location = locationManager
                    .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Toast.makeText(signupactivity.this,String.valueOf(location.getLatitude()) + "  "+ String.valueOf(location.getLongitude())
                    , Toast.LENGTH_SHORT).show();

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void request_permission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(signupactivity.this,
                ACCESS_COARSE_LOCATION)) {

            Snackbar.make(findViewById(R.id.main_linear_layout), "Location permission is needed because ...",
                    Snackbar.LENGTH_LONG)
                    .setAction("retry", new View.OnClickListener() {
                        @RequiresApi(api = Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View view) {
                            requestPermissions(new String[]{ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 10);
                        }
                    })
                    .show();
        } else {
            // permission has not been granted yet. Request it directly.
            requestPermissions(new String[]{ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 10);
        }
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
}
