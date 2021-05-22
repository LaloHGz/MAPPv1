package com.aplication.mapp.inicio;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.menu.MapaActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends AppCompatActivity {



    private TextView titulo;
    private Typeface sp;
    private TextView registro;
    private TextView registro1;

    private Button button;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private final static int RC_SIGN_IN = 0;
    private String email="";
    private String usuario="";
    private String password="";

    private String tipo="";

    private TextInputEditText TextEmail;
    private TextInputEditText TextPassword;

    private TextInputLayout text_inputEmail;
    private TextInputLayout text_inputPassword;

    private StorageReference mStorage;
    private Button btnLogin;
    private ProgressDialog progressDialog;
    String l7 = Locale.getDefault().getLanguage();

    GoogleApiClient mGoogleApiClient;

    String Tst1="Se debe ingresar un email";
    String Tst2="Falta ingresar la contraseña";
    String Tst3="Iniciando sesión...";
    String Tst4="Bienvenido: ";
    String Tst6="No se pudo encontrar el usuario";

    //Declaramos un objeto firebaseAuth
    private FirebaseAuth mAuth;

    DatabaseReference databaseReference;
    private boolean a;
    private String us="";

    private CallbackManager mCallbackManager;
    private Button botonFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ConectionManager.checkConection(getBaseContext()))
        {

        }
        else
        {
            Intent intent=new Intent(getApplication(), InternetConectionActivity.class);
            startActivity(intent);
        }
        databaseReference = FirebaseDatabase.getInstance().getReference();
        //inicializamos el objeto firebaseAuth
        mAuth = FirebaseAuth.getInstance();

        mCallbackManager = CallbackManager.Factory.create();

        button=(Button) findViewById(R.id.butongoogle);



        GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(MainActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
        mCallbackManager = CallbackManager.Factory.create();



        String fuente7 = "fuentes/sp_reg.ttf";
        this.sp = Typeface.createFromAsset(getAssets(), fuente7);


        if (l7.equals("es")) {
            Tst1 = "Se debe ingresar un email";
            Tst2 = "Falta ingresar la contraseña";
            Tst3 = "Iniciando sesión...";
            Tst4 = "Bienvenido: ";
            Tst6 = "No se pudo encontrar el usuario";
        }
        if (l7.equals("en")) {
            Tst1 = "You must enter an email";
            Tst2 = "Password is missing";
            Tst3 = "Logging in...";
            Tst4 = "Welcome: ";
            Tst6 = "The user could not be found";
        }

        if (l7.equals("it")) {
            Tst1 = "Se debe ingresar un email";
            Tst2 = "Falta ingresar la contraseña";
            Tst3 = "Iniciando sesión...";
            Tst4 = "Bienvenido: ";
            Tst6 = "No se pudo encontrar el usuario";
        }
        if (l7.equals("ru")) {
            Tst1 = "Se debe ingresar un email";
            Tst2 = "Falta ingresar la contraseña";
            Tst3 = "Iniciando sesión...";
            Tst4 = "Bienvenido: ";
            Tst6 = "No se pudo encontrar el usuario";
        }
        if (l7.equals("pt")) {
            Tst1 = "Se debe ingresar un email";
            Tst2 = "Falta ingresar la contraseña";
            Tst3 = "Iniciando sesión...";
            Tst4 = "Bienvenido: ";
            Tst6 = "No se pudo encontrar el usuario";
        }
        if (l7.equals("fr")) {
            Tst1 = "Se debe ingresar un email";
            Tst2 = "Falta ingresar la contraseña";
            Tst3 = "Iniciando sesión...";
            Tst4 = "Bienvenido: ";
            Tst6 = "No se pudo encontrar el usuario";
        }
        if (l7.equals("de")) {
            Tst1 = "Se debe ingresar un email";
            Tst2 = "Falta ingresar la contraseña";
            Tst3 = "Iniciando sesión...";
            Tst4 = "Bienvenido: ";
            Tst6 = "No se pudo encontrar el usuario";
        }



        titulo = findViewById(R.id.mapp);
        titulo.setTypeface(sp);


        TextEmail = findViewById(R.id.TxtEmail);
        TextPassword = findViewById(R.id.TxtPassword);


        text_inputEmail = findViewById(R.id.text_input_email);
        text_inputPassword = findViewById(R.id.text_input_password);


        btnLogin = (Button) findViewById(R.id.botonLogin);
        registro =(TextView) findViewById(R.id.tv_registro);


        progressDialog = new ProgressDialog(this);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmInput();
                loguearUsuario();
            }
        });
        registro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });
        botonFacebook= (Button) findViewById(R.id.butonfacebook);
        botonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(MainActivity.this, Arrays.asList("email","public_profile"));
                LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
            }
        });



    }

    private void handleFacebookAccessToken(final AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull final Task<AuthResult> task) {
                progressDialog.setMessage(Tst3);
                progressDialog.show();
                final String id = mAuth.getUid();
                databaseReference.child("users").child(id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists())
                        {
                            FirebaseUser user = mAuth.getCurrentUser();
                            email=user.getEmail();
                            Intent i = new Intent(getApplication(), MapaActivity.class);
                            startActivity(i);
                            finishAffinity();

                        }
                        else
                        {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("TAG", "signInWithCredential:success");
                                FirebaseUser user = mAuth.getCurrentUser();

                                email=user.getEmail();
                                usuario=user.getDisplayName();
                                //Uri image=account.getPhotoUrl();

                                Map<String, Object> map = new HashMap<>();
                                map.put("lenguaje", "es");
                                map.put("personaje", "Laoshi");
                                map.put("usuario", usuario);
                                map.put("correo", email);
                                map.put("contraseña", 0);
                                map.put("nivel", 1);
                                map.put("Edad", 16);
                                map.put("Pais", ".");
                                map.put("formato", "Written");
                                map.put("tiempo_diag_t1", "a");
                                map.put("tiempo_n1t1", "a");
                                map.put("tiempo_n2t1", "a");
                                map.put("tiempo_n3t1","a");
                                map.put("tiempo_n4t1", "a");
                                map.put("tiempo_n5t1", "a");
                                map.put("tiempo_diag_t2", "a");
                                map.put("tiempo_n1t2", "a");
                                map.put("tiempo_n2t2", "a");
                                map.put("tiempo_n3t2", "a");
                                map.put("tiempo_n4t2", "a");
                                map.put("tiempo_n5t2", "a");
                                map.put("tiempo_diag_t3", "a");
                                map.put("tiempo_n1t3", "a");
                                map.put("tiempo_n2t3", "a");
                                map.put("tiempo_n3t3", "a");
                                map.put("tiempo_n4t3", "a");
                                map.put("tiempo_n5t3", "a");
                                map.put("tiempo_diag_t4", "a");
                                map.put("tiempo_n1t4", "a");
                                map.put("tiempo_n2t4", "a");
                                map.put("tiempo_n3t4", "a");
                                map.put("tiempo_n4t4", "a");
                                map.put("tiempo_n5t4", "a");
                                map.put("tiempo_diag_t5", "a");
                                map.put("tiempo_n1t5", "a");
                                map.put("tiempo_n2t5", "a");
                                map.put("tiempo_n3t5", "a");
                                map.put("tiempo_n4t5", "a");
                                map.put("tiempo_n5t5", "a");
                                map.put("tiempo_diag_t6", "a");
                                map.put("tiempo_n1t6", "a");
                                map.put("tiempo_n2t6", "a");
                                map.put("tiempo_n3t6", "a");
                                map.put("tiempo_n4t6", "a");
                                map.put("tiempo_n5t6", "a");
                                map.put("tiempo_diag_t7", "a");
                                map.put("tiempo_n1t7", "a");
                                map.put("tiempo_n2t7", "a");
                                map.put("tiempo_n3t7", "a");
                                map.put("tiempo_n4t7", "a");
                                map.put("tiempo_n5t7", "a");
                                map.put("tiempo_diag_t8", "a");
                                map.put("tiempo_n1t8", "a");
                                map.put("tiempo_n2t8", "a");
                                map.put("tiempo_n3t8", "a");
                                map.put("tiempo_n4t8", "a");
                                map.put("tiempo_n5t8", "a");
                                map.put("tiempo_diag_t9", "a");
                                map.put("tiempo_n1t9", "a");
                                map.put("tiempo_n2t9", "a");
                                map.put("tiempo_n3t9", "a");
                                map.put("tiempo_n4t9", "a");
                                map.put("tiempo_n5t9", "a");
                                map.put("tiempo_diag_t10", "a");
                                map.put("tiempo_n1t10", "a");
                                map.put("tiempo_n2t10", "a");
                                map.put("tiempo_n3t10", "a");
                                map.put("tiempo_n4t10", "a");
                                map.put("tiempo_n5t10", "a");

                                databaseReference.child("users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task2) {
                                        if (task2.isSuccessful()){
                                            progressDialog.dismiss();
                                            Intent i = new Intent(getApplication(), MapaActivity.class);
                                            startActivity(i);
                                                    /*Snackbar.make( findViewById(R.id.main),Tst4 + email, Snackbar.LENGTH_LONG)
                                                            .setAction("Action",null).show();

                                                     */
                                            finishAffinity();


                                        }
                                    }
                                });
                                //updateUI(user);
                            }
                            else {
                                Log.w("TAG", "signInWithCredential:failure", task.getException());
                                Toast.makeText(MainActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
                            }


                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {


                    }
                });
            }
        });
    }

    public void loguearUsuario() {
        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        String password = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {//(precio.equals(""))
            Toast.makeText(this, Tst1, Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, Tst2, Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setCancelable(false);
        progressDialog.setMessage(Tst3);
        progressDialog.show();

        //loguear usuario
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            int pos = email.indexOf("@");
                            String user = email.substring(0, pos);
                            Intent i = new Intent(getApplication(), MapaActivity.class);
                            startActivity(i);
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                                Toast.makeText(MainActivity.this, Tst6, Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, Tst6, Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });


    }

    private boolean validateEmail() {
        String emailInput = text_inputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            text_inputEmail.setError("Field can't be empty");
            return false;
        } else {
            text_inputEmail.setError(null);
            return true;
        }
    }


    private boolean validatePassword() {
        String passwordInput = text_inputPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            text_inputPassword.setError("Field can't be empty");
            return false;
        } else {
            text_inputPassword.setError(null);
            return true;
        }
    }


    public void confirmInput() {
        if (!validateEmail() | !validatePassword()) {
            return;
        }
    }
    private void signIn()
    {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RC_SIGN_IN)
        {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);

            if (result.isSuccess())
            {
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);

            }
            else
            {

                Toast.makeText(MainActivity.this,"Auth went wrong", Toast.LENGTH_SHORT).show();
            }


        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.godown1,R.anim.godown);
    }

    private void firebaseAuthWithGoogle(final GoogleSignInAccount account) {
        progressDialog.setCancelable(false);
        progressDialog.setMessage(Tst3);
        progressDialog.show();



        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull final Task<AuthResult> task) {


                        final String id = mAuth.getUid();
                        databaseReference.child("users").child(id).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists())
                                {
                                    email=account.getEmail();
                                    Intent i = new Intent(getApplication(), MapaActivity.class);
                                    startActivity(i);
                                    finishAffinity();

                                }
                                else
                                {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d("TAG", "signInWithCredential:success");
                                        //FirebaseUser user = mAuth.getCurrentUser();
                                        email=account.getEmail();
                                        usuario=account.getDisplayName();
                                        //Uri image=account.getPhotoUrl();

                                        Map<String, Object> map = new HashMap<>();
                                        map.put("lenguaje", "es");
                                        map.put("personaje", "Laoshi");
                                        map.put("usuario", usuario);
                                        map.put("correo", email);
                                        map.put("contraseña", 0);
                                        map.put("nivel", 1);
                                        map.put("Edad", 16);
                                        map.put("Pais", ".");
                                        map.put("formato", "Written");
                                        map.put("tiempo_diag_t1", "a");
                                        map.put("tiempo_n1t1", "a");
                                        map.put("tiempo_n2t1", "a");
                                        map.put("tiempo_n3t1","a");
                                        map.put("tiempo_n4t1", "a");
                                        map.put("tiempo_n5t1", "a");
                                        map.put("tiempo_diag_t2", "a");
                                        map.put("tiempo_n1t2", "a");
                                        map.put("tiempo_n2t2", "a");
                                        map.put("tiempo_n3t2", "a");
                                        map.put("tiempo_n4t2", "a");
                                        map.put("tiempo_n5t2", "a");
                                        map.put("tiempo_diag_t3", "a");
                                        map.put("tiempo_n1t3", "a");
                                        map.put("tiempo_n2t3", "a");
                                        map.put("tiempo_n3t3", "a");
                                        map.put("tiempo_n4t3", "a");
                                        map.put("tiempo_n5t3", "a");
                                        map.put("tiempo_diag_t4", "a");
                                        map.put("tiempo_n1t4", "a");
                                        map.put("tiempo_n2t4", "a");
                                        map.put("tiempo_n3t4", "a");
                                        map.put("tiempo_n4t4", "a");
                                        map.put("tiempo_n5t4", "a");
                                        map.put("tiempo_diag_t5", "a");
                                        map.put("tiempo_n1t5", "a");
                                        map.put("tiempo_n2t5", "a");
                                        map.put("tiempo_n3t5", "a");
                                        map.put("tiempo_n4t5", "a");
                                        map.put("tiempo_n5t5", "a");
                                        map.put("tiempo_diag_t6", "a");
                                        map.put("tiempo_n1t6", "a");
                                        map.put("tiempo_n2t6", "a");
                                        map.put("tiempo_n3t6", "a");
                                        map.put("tiempo_n4t6", "a");
                                        map.put("tiempo_n5t6", "a");
                                        map.put("tiempo_diag_t7", "a");
                                        map.put("tiempo_n1t7", "a");
                                        map.put("tiempo_n2t7", "a");
                                        map.put("tiempo_n3t7", "a");
                                        map.put("tiempo_n4t7", "a");
                                        map.put("tiempo_n5t7", "a");
                                        map.put("tiempo_diag_t8", "a");
                                        map.put("tiempo_n1t8", "a");
                                        map.put("tiempo_n2t8", "a");
                                        map.put("tiempo_n3t8", "a");
                                        map.put("tiempo_n4t8", "a");
                                        map.put("tiempo_n5t8", "a");
                                        map.put("tiempo_diag_t9", "a");
                                        map.put("tiempo_n1t9", "a");
                                        map.put("tiempo_n2t9", "a");
                                        map.put("tiempo_n3t9", "a");
                                        map.put("tiempo_n4t9", "a");
                                        map.put("tiempo_n5t9", "a");
                                        map.put("tiempo_diag_t10", "a");
                                        map.put("tiempo_n1t10", "a");
                                        map.put("tiempo_n2t10", "a");
                                        map.put("tiempo_n3t10", "a");
                                        map.put("tiempo_n4t10", "a");
                                        map.put("tiempo_n5t10", "a");

                                        databaseReference.child("users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task2) {
                                                if (task2.isSuccessful()){
                                                    progressDialog.dismiss();
                                                    Intent i = new Intent(getApplication(), MapaActivity.class);
                                                    startActivity(i);
                                                    /*Snackbar.make( findViewById(R.id.main),Tst4 + email, Snackbar.LENGTH_LONG)
                                                            .setAction("Action",null).show();

                                                     */
                                                    finishAffinity();


                                                }
                                            }
                                        });
                                        //updateUI(user);
                                    }
                                    else {
                                        Log.w("TAG", "signInWithCredential:failure", task.getException());
                                        Toast.makeText(MainActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
                                    }


                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {


                            }
                        });
                    }

                });


    }
    private void registro ()
    {

        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.goup,R.anim.godown1);
    }










}

