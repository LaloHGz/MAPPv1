package com.aplication.mapp.inicio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.menu.MapaActivity;
import com.facebook.CallbackManager;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {

    private TextView titulo;
    private Typeface sp;
    private String email="";
    private String usuario="";
    private final static int RC_SIGN_IN = 2;
    private static final String TAG="FACELOG";


    //defining view objects
    private TextInputEditText TextEmail;
    private TextInputEditText TextPassword;
    private TextInputEditText TextUser;

    private TextInputLayout text_inputUser;
    private TextInputLayout text_inputEmail;
    private TextInputLayout text_inputPassword;

    private Button button;
    GoogleApiClient mGoogleApiClient;


    private Button btnRegistrar;
    public ProgressDialog progressDialog;

    String l7 = Locale.getDefault().getLanguage();

    String Tst1 = "Se debe ingresar un email";
    String Tst2 = "Falta ingresar la contraseña";
    String Tst3 = "Realizando registro en linea...";
    String Tst4 = "Se ha registrado el usuario con el email: ";
    String Tst5 = "Ese usuario ya existe";
    String Tst6 = "No se pudo registrar el usuario";

    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    private CallbackManager mCallbackManager;
    private Button botonFacebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (ConectionManager.checkConection(getBaseContext()))
        {

        }
        else
        {
            Intent intent=new Intent(getApplication(), InternetConectionActivity.class);
            startActivity(intent);
        }

        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        mCallbackManager = CallbackManager.Factory.create();

        //button=(Button) findViewById(R.id.butongoogle);

        if (l7.equals("es"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Realizando registro en linea...";
            Tst4="Se ha registrado el usuario con el email: ";
            Tst5="Este usuario ya existe";
            Tst6="No se pudo registrar el usuario";
        }
        if (l7.equals("en"))
        {
            Tst1="You must enter an email";
            Tst2="Password is missing";
            Tst3="Registering online...";
            Tst4="The user has registered with the email: ";
            Tst5="This user already exists";
            Tst6="User could not be registered";
        }

        if (l7.equals("it"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Realizando registro en linea...";
            Tst4="Se ha registrado el usuario con el email: ";
            Tst5="Ese usuario ya existe";
            Tst6="No se pudo registrar el usuario";
        }
        if (l7.equals("ru"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Realizando registro en linea...";
            Tst4="Se ha registrado el usuario con el email: ";
            Tst5="Ese usuario ya existe";
            Tst6="No se pudo registrar el usuario";
        }
        if (l7.equals("pt"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Realizando registro en linea...";
            Tst4="Se ha registrado el usuario con el email: ";
            Tst5="Ese usuario ya existe";
            Tst6="No se pudo registrar el usuario";
        }
        if (l7.equals("fr"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Realizando registro en linea...";
            Tst4="Se ha registrado el usuario con el email: ";
            Tst5="Ese usuario ya existe";
            Tst6="No se pudo registrar el usuario";
        }
        if (l7.equals("de"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Realizando registro en linea...";
            Tst4="Se ha registrado el usuario con el email: ";
            Tst5="Ese usuario ya existe";
            Tst6="No se pudo registrar el usuario";
        }


/*
        GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(LoginActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

 */
        mCallbackManager = CallbackManager.Factory.create();



        String fuente7 = "fuentes/sp_reg.ttf";
        this.sp = Typeface.createFromAsset(getAssets(), fuente7);

        titulo = findViewById(R.id.mapp1);
        titulo.setTypeface(sp);
        //facebook= findViewById(R.id.facebook);


        TextEmail = findViewById(R.id.TxtEmail);


        TextPassword = findViewById(R.id.TxtPassword);

        TextUser=findViewById(R.id.TxtUser);

        text_inputUser=findViewById(R.id.text_input_usuario);

        text_inputEmail=findViewById(R.id.text_input_email);

        text_inputPassword=findViewById(R.id.text_input_password);


        btnRegistrar = (Button) findViewById(R.id.botonRegistrar);

        progressDialog = new ProgressDialog(this);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmInput();
                registrarUsuario();
            }
        });


        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

         */

       /* botonFacebook= (Button) findViewById(R.id.butonfacebook);
        botonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, Arrays.asList("email","public_profile"));
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

        */

    }

    public void registrarUsuario () {

        final String usernameInput = text_inputUser.getEditText().getText().toString().trim();


        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = TextEmail.getText().toString().trim();
        final String password = TextPassword.getText().toString().trim();
        final String user=TextUser.getText().toString();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {//(precio.equals(""))
            Toast.makeText(this, Tst1, Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, Tst2, Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage(Tst3);
        progressDialog.show();
        if (usernameInput.length() > 15) {
            text_inputUser.setError("Username too long");
            progressDialog.dismiss();
        }
        else if (usernameInput.length()<=15) {
            //registramos un nuevo usuario
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //checking if success

                            if (task.isSuccessful()) {
                                Map<String, Object> map = new HashMap<>();
                                map.put("lenguaje", "es");
                                map.put("personaje", "Laoshi");
                                map.put("usuario", user);
                                map.put("correo", email);
                                map.put("contraseña", password);
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
                                String id = firebaseAuth.getUid();
                                databaseReference.child("users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task2) {
                                        if (task2.isSuccessful()) {
                                            Intent i = new Intent(getApplication(), MapaActivity.class);
                                            startActivity(i);
                                            finishAffinity();
                                            finish();
                                        }

                                    }
                                });

                            } else {
                                if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                                    Toast.makeText(LoginActivity.this, Tst5, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(LoginActivity.this, Tst6, Toast.LENGTH_LONG).show();
                                }
                            }
                            progressDialog.dismiss();
                        }
                    });
        }

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

    private boolean validateUsername() {
        String usernameInput = text_inputUser.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            text_inputUser.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            text_inputUser.setError("Username too long");
            return false;
        } else {
            text_inputUser.setError(null);
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
        if (!validateEmail() | !validateUsername() | !validatePassword()) {
            return;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.godown1,R.anim.godown);
    }

   /* private void signIn()
    {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    */
    


   /* @Override
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

                Toast.makeText(LoginActivity.this,"Auth went wrong", Toast.LENGTH_SHORT).show();
            }


        }






    }

   /* private void firebaseAuthWithGoogle(final GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull final Task<AuthResult> task) {

                        progressDialog.setMessage(Tst3);
                        progressDialog.show();
                        final String id = firebaseAuth.getUid();
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
                                                    Snackbar.make( findViewById(R.id.main),Tst4 + email, Snackbar.LENGTH_LONG)
                                                            .setAction("Action",null).show();


                                                    finishAffinity();


                                                }
                                            }
                                        });
                                        //updateUI(user);
                                    }
                                    else {
                                        Log.w("TAG", "signInWithCredential:failure", task.getException());
                                        Toast.makeText(LoginActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
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

    */

       /*private void handleFacebookAccessToken(final AccessToken accessToken) {
        AuthCredential credential = FacebookAuthProvider.getCredential(accessToken.getToken());
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull final Task<AuthResult> task) {
                progressDialog.setMessage(Tst3);
                progressDialog.show();
                final String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists())
                        {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
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
                                FirebaseUser user = firebaseAuth.getCurrentUser();

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
                                                    Snackbar.make( findViewById(R.id.main),Tst4 + email, Snackbar.LENGTH_LONG)
                                                            .setAction("Action",null).show();


                                            finishAffinity();


                                        }
                                    }
                                });
                                //updateUI(user);
                            }
                            else {
                                Log.w("TAG", "signInWithCredential:failure", task.getException());
                                Toast.makeText(LoginActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
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
    */


}

