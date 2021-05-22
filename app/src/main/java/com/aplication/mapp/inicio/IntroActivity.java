package com.aplication.mapp.inicio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.aplication.mapp.R;
import com.aplication.mapp.adapters.IntroViewPagerAdapter;
import com.aplication.mapp.adapters.ScreenItem;
import com.aplication.mapp.menu.MapaActivity;
import com.facebook.CallbackManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter ;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0 ;
    Button button;
    private Button btnLogin;
    private final static int RC_SIGN_IN = 2;
    String l7 = Locale.getDefault().getLanguage();
    private ProgressDialog progressDialog;

    private CallbackManager mCallbackManager;
    private String email="";
    private String usuario="";
    String Tst1="Se debe ingresar un email";
    String Tst2="Falta ingresar la contraseña";
    String Tst3="Iniciando sesión...";
    String Tst4="Bienvenido: ";
    String Tst6="No se pudo encontrar el usuario";


    private TextView registro;
    private TextView registro1;
    GoogleApiClient mGoogleApiClient;

    Animation btnAnim ;
    TextView tvSkip;

    private FirebaseAuth mAuth;
    private LottieAnimationView animationView;
    private ImageView imageView;

    DatabaseReference databaseReference;
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                Intent map = new Intent(IntroActivity.this, MapaActivity.class);
                startActivity(map);
                finish();
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_intro);

        if (Build.VERSION.SDK_INT>=21) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorstatusbar));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();
        //inicializamos el objeto firebaseAuth
        mAuth = FirebaseAuth.getInstance();


        if (l7.equals("es"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Iniciando sesión...";
            Tst4="Bienvenido: ";
            Tst6="No se pudo encontrar el usuario";
        }
        if (l7.equals("en"))
        {
            Tst1="You must enter an email";
            Tst2="Password is missing";
            Tst3="Logging in...";
            Tst4="Welcome: ";
            Tst6="The user could not be found";
        }

        if (l7.equals("it"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Iniciando sesión...";
            Tst4="Bienvenido: ";
            Tst6="No se pudo encontrar el usuario";
        }
        if (l7.equals("ru"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Iniciando sesión...";
            Tst4="Bienvenido: ";
            Tst6="No se pudo encontrar el usuario";
        }
        if (l7.equals("pt"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Iniciando sesión...";
            Tst4="Bienvenido: ";
            Tst6="No se pudo encontrar el usuario";
        }
        if (l7.equals("fr"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Iniciando sesión...";
            Tst4="Bienvenido: ";
            Tst6="No se pudo encontrar el usuario";
        }
        if (l7.equals("de"))
        {
            Tst1="Se debe ingresar un email";
            Tst2="Falta ingresar la contraseña";
            Tst3="Iniciando sesión...";
            Tst4="Bienvenido: ";
            Tst6="No se pudo encontrar el usuario";
        }

        // hide the action bar



        // ini views
        btnNext = findViewById(R.id.btn_next);
        button = findViewById(R.id.butongoogle);
        btnLogin = findViewById(R.id.botonLogin);
        tabIndicator = findViewById(R.id.tab_indicator);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);
        tvSkip = findViewById(R.id.tv_skip);
        registro = findViewById(R.id.registro);
        btnLogin.setAnimation(btnAnim);
        button.setAnimation(btnAnim);
        registro1 = findViewById(R.id.bton_registro);


        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Mapp: Aprende a programar","Resuelve retos de programación estructurada en lenguaje Python",R.drawable.mock));
        mList.add(new ScreenItem("Aprende Programación en lenguaje Python","Resuelve problemas de programación para ayudar a los Karankawuas con su lucha contra los extraterrestres Pythonianos",R.drawable.laoshi_tizoc2));
        mList.add(new ScreenItem("Personaliza tu perfil","Puedes personalizar tu perfil eligiendo tu personaje favorito de la historia, tu nombre de usuario, tu país, tu edad y el formato en que se mostrará la historia",R.drawable.mock4));

        // setup viewpager
        screenPager =findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        // setup tablayout with viewpager

        tabIndicator.setupWithViewPager(screenPager);

        // next button click Listner

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = screenPager.getCurrentItem();
                if (position < mList.size()) {

                    position++;
                    screenPager.setCurrentItem(position);


                }

                if (position == mList.size()-1) { // when we rech to the last screen

                    // TODO : show the GETSTARTED Button and hide the indicator and the next button

                    //loaddLastScreen();


                }



            }
        });

        // tablayout add change listener


        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                if (tab.getPosition() == mList.size()-1) {

                    btnLogin.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.GONE);

                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        // Get Started button click listener

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //open main activity

                Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivity);
                overridePendingTransition(R.anim.goup,R.anim.godown1);
                // also we need to save a boolean value to storage so next time when the user run the com
                // we could know that he is already checked the intro screen activity
                // i'm going to use shared preferences to that process
                savePrefsData();



            }
        });

        registro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registro();
            }
        });

        // skip button click listener

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screenPager.setCurrentItem(mList.size());
            }
        });
        // when this activity is about to be launch we need to check if its openened before or not

        GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(IntroActivity.this,"Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
        mCallbackManager = CallbackManager.Factory.create();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivity = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(mainActivity);
            }
        });


        progressDialog = new ProgressDialog(this);
        // fill list screen





    }
    private void registro ()
    {

        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    private boolean restorePrefData() {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        Boolean isIntroActivityOpnendBefore = pref.getBoolean("isIntroOpnend",false);
        return  isIntroActivityOpnendBefore;



    }

    private void savePrefsData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpnend",true);
        editor.commit();


    }

    // show the GETSTARTED Button and hide the indicator and the next button
    /*private void loaddLastScreen() {


        // TODO : ADD an animation the getstarted button
        // setup animation

    }

    /*private void signIn()
    {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

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

                Toast.makeText(IntroActivity.this,"Auth went wrong", Toast.LENGTH_SHORT).show();
            }


        }






    }

   /* private void firebaseAuthWithGoogle(final GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
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

                                        mStorage = FirebaseStorage.getInstance().getReference();
                                        StorageReference filepath = mStorage.child("fotos").child(image.getLastPathSegment());
                                        filepath.putFile(image).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                            @Override
                                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                                            }
                                        });



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
                                        map.put("tiempo_n1t1", "a");
                                        map.put("tiempo_n2t1", "a");
                                        map.put("tiempo_n3t1","a");
                                        map.put("tiempo_n4t1", "a");
                                        map.put("tiempo_n5t1", "a");
                                        map.put("tiempo_n1t2", "a");
                                        map.put("tiempo_n2t2", "a");
                                        map.put("tiempo_n3t2", "a");
                                        map.put("tiempo_n4t2", "a");
                                        map.put("tiempo_n5t2", "a");
                                        map.put("tiempo_n1t3", "a");
                                        map.put("tiempo_n2t3", "a");
                                        map.put("tiempo_n3t3", "a");
                                        map.put("tiempo_n4t3", "a");
                                        map.put("tiempo_n5t3", "a");
                                        map.put("tiempo_n1t4", "a");
                                        map.put("tiempo_n2t4", "a");
                                        map.put("tiempo_n3t4", "a");
                                        map.put("tiempo_n4t4", "a");
                                        map.put("tiempo_n5t4", "a");
                                        map.put("tiempo_n1t5", "a");
                                        map.put("tiempo_n2t5", "a");
                                        map.put("tiempo_n3t5", "a");
                                        map.put("tiempo_n4t5", "a");
                                        map.put("tiempo_n5t5", "a");
                                        map.put("tiempo_n1t6", "a");
                                        map.put("tiempo_n2t6", "a");
                                        map.put("tiempo_n3t6", "a");
                                        map.put("tiempo_n4t6", "a");
                                        map.put("tiempo_n5t6", "a");
                                        map.put("tiempo_n1t7", "a");
                                        map.put("tiempo_n2t7", "a");
                                        map.put("tiempo_n3t7", "a");
                                        map.put("tiempo_n4t7", "a");
                                        map.put("tiempo_n5t7", "a");
                                        map.put("tiempo_n1t8", "a");
                                        map.put("tiempo_n2t8", "a");
                                        map.put("tiempo_n3t8", "a");
                                        map.put("tiempo_n4t8", "a");
                                        map.put("tiempo_n5t8", "a");
                                        map.put("tiempo_n1t9", "a");
                                        map.put("tiempo_n2t9", "a");
                                        map.put("tiempo_n3t9", "a");
                                        map.put("tiempo_n4t9", "a");
                                        map.put("tiempo_n5t9", "a");
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
                                                    finishAffinity();


                                                }
                                            }
                                        });
                                        //updateUI(user);
                                    }
                                    else {
                                        Log.w("TAG", "signInWithCredential:failure", task.getException());
                                        Toast.makeText(IntroActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
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
