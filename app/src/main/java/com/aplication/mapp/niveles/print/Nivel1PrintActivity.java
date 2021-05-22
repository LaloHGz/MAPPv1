package com.aplication.mapp.niveles.print;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.instrucciones.EjerciciosTemasActivity;
import com.aplication.mapp.menu.MapaActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class Nivel1PrintActivity extends AppCompatActivity {

    private TextView Instruccion;
    private ImageButton Check;
    private Chronometer Chronometro;
    Boolean correr=false;
    String nivel="";
    String tema="";
    private String respuesta="",respuesta2="",respuesta3="";
    private EditText sentencia1,sentencia2,sentencia3,sentencia4_1,sentencia4_2,sentencia5_1,sentencia5_2,sentencia5_3;
    private  Button acept,acept1;
    private TextView message,message1,titulo,instruccion;

    private LinearLayout lvl1,lvl2,lvl3,lvl4,lvl5;

    private Dialog ins,com,com1;

    private MediaPlayer mp;
    long detenerse;
    private Typeface Good_sans;
    private LottieAnimationView animationView;

    String l7 = Locale.getDefault().getLanguage();

    private Dialog check;
    private LinearLayout layout_check;
    private TextView title_check,tema_check;
    private Chronometer Chronometro_check;
    private Button siguiente_check;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private long tiempo;
    private Animation frombottom;
    private String nivel1 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1_print);
        if (ConectionManager.checkConection(getBaseContext()))
        {

        }
        else
        {
            Intent intent=new Intent(getApplication(), InternetConectionActivity.class);
            startActivity(intent);
        }

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        check = new Dialog(this);

        Resources res = getResources();
        tema = res.getString(R.string.TEMA3);
        String fuete2 = "fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans = Typeface.createFromAsset(getAssets(), fuete2);

        Intent intent=getIntent();
        Bundle Datos=intent.getExtras();
        nivel= (String)Datos.get("niv");
        nivel1 = nivel;


        ins = new Dialog(this);
        com1=new Dialog(this);
        com1.setCancelable(false);
        com= new Dialog(this);
        com.setCancelable(false);

        ins.setContentView(R.layout.ins_n5t2);
        ins.setCancelable(false);
        acept = (Button) ins.findViewById(R.id.boton_acept);
        message = (TextView) ins.findViewById(R.id.tv_message);
        if (nivel.equals("Lvl 1"))
        {
            message.setText(R.string.ins_n1_t3);
        }
        if (nivel.equals("Lvl 2"))
        {
            message.setText(R.string.ins_n2_t3);
        }
        if (nivel.equals("Lvl 3"))
        {
            message.setText(R.string.ins_n3_t3);
        }
        if (nivel.equals("Lvl 4"))
        {
            message.setText(R.string.ins_n4_t3);
        }
        if (nivel.equals("Lvl 5"))
        {
            message.setText(R.string.ins_n5_t3);
        }

        acept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ins.dismiss();
            }
        });
        ins.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ins.show();

        sentencia1 = findViewById(R.id.et_sentencia1);
        sentencia2=findViewById(R.id.et_sentencia2);
        sentencia3 = findViewById(R.id.et_sentencia3);
        sentencia4_1=findViewById(R.id.et_sentencia4_1);
        sentencia4_2 = findViewById(R.id.et_sentencia4_2);
        sentencia5_1=findViewById(R.id.et_sentencia5_1);
        sentencia5_2 = findViewById(R.id.et_sentencia5_2);
        sentencia5_3 = findViewById(R.id.et_sentencia5_3);

        lvl1=findViewById(R.id.lvl1);
        lvl2=findViewById(R.id.lvl2);
        lvl3=findViewById(R.id.lvl3);
        lvl4=findViewById(R.id.lvl4);
        lvl5=findViewById(R.id.lvl5);
        animationView = (LottieAnimationView) findViewById(R.id.animation_checkmark);
        instruccion=findViewById(R.id.tv_ins);

        if(nivel.equals("Lvl 1"))
        {
            instruccion.setText(R.string.ins_n1_t3);
            lvl1.setVisibility(View.VISIBLE);

            if (l7.equals("es"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3esp);
            }
            if (l7.equals("en"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3ing);
            }
            if (l7.equals("it"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3it);
            }
            if (l7.equals("ru"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3jap);
            }
            if (l7.equals("pt"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3por);
            }
            if (l7.equals("fr"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3fra);
            }
            if (l7.equals("de"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3ale);
            }
            if (l7.equals("ja"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3jap);
            }
        }
        if (nivel.equals("Lvl 2"))
        {
            instruccion.setText(R.string.ins_n2_t3);
            lvl2.setVisibility(View.VISIBLE);
            if (l7.equals("es"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn2t3esp);
            }
            if (l7.equals("en"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3ing);
            }
        }
        if (nivel.equals("Lvl 3"))
        {
            instruccion.setText(R.string.ins_n3_t3);
            lvl3.setVisibility(View.VISIBLE);
            if (l7.equals("es"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn3t3esp);
            }
            if (l7.equals("en"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3ing);
            }
        }

        if (nivel.equals("Lvl 4"))
        {
            instruccion.setText(R.string.ins_n4_t3);
            lvl4.setVisibility(View.VISIBLE);
            if (l7.equals("es"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn4t3esp);
            }
            if (l7.equals("en"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3ing);
            }
        }
        if (nivel.equals("Lvl 5"))
        {
            instruccion.setText(R.string.ins_n5_t3);
            lvl5.setVisibility(View.VISIBLE);
            if (l7.equals("es"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn5t3esp);
            }
            if (l7.equals("en"))
            {
                mp= MediaPlayer.create(this,R.raw.instruccionn1t3ing);
            }
        }

        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });


        Check=findViewById(R.id.check);


        Chronometro=findViewById(R.id.chrono);


        startChronometro();
        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nivel.equals("Lvl 1")) {
                    respuesta = sentencia1.getText().toString();
                    if (respuesta.equals("print"))
                    {
                        lvl1.setVisibility(View.GONE);
                        check1();
                    }
                    else
                    {
                        incorrecta();
                    }
                }
                if (nivel.equals("Lvl 2")) {
                    respuesta = sentencia2.getText().toString();
                    if (respuesta.equals("\"Hello world\"") ||respuesta.equals("\"Hello World\"") || respuesta.equals("\"hello world\""))
                    {
                        lvl2.setVisibility(View.GONE);
                                check1();
                    }
                    else
                    {
                        incorrecta();
                    }
                }
                if (nivel.equals("Lvl 3")) {
                    respuesta = sentencia3.getText().toString();
                    if (respuesta.equals("a"))
                    {
                        lvl3.setVisibility(View.GONE);
                                check1();
                    }
                    else
                    {
                        incorrecta();
                    }
                }
                if (nivel.equals("Lvl 4")) {
                    respuesta = sentencia4_1.getText().toString();
                    respuesta2 = sentencia4_2.getText().toString();
                    if (respuesta.equals("\"Hello world\"") ||respuesta.equals("\"Hello World\"") || respuesta.equals("\"hello world\"")
                    && respuesta2.equals("a"))
                    {
                        lvl4.setVisibility(View.GONE);
                                check1();
                    }
                    else
                    {
                        incorrecta();
                    }
                }
                if (nivel.equals("Lvl 5")) {
                    respuesta = sentencia5_1.getText().toString();
                    respuesta2 = sentencia5_2.getText().toString();
                    respuesta3 = sentencia5_3.getText().toString();
                    if (respuesta.equals("\"Laoshi\"") ||respuesta.equals("\"laoshi\"")
                    && respuesta2.equals("a")&& respuesta3.equals("b"))
                    {
                        lvl5.setVisibility(View.GONE);
                                check1();
                    }
                    else
                    {
                        incorrecta();
                    }
                }
            }
        });

    }

    private void startChronometro()
    {
        if (!correr)
        {
            Chronometro.setBase(SystemClock.elapsedRealtime());
            Chronometro.start();
            correr=true;
        }
    }


    public void check1()
    {
        check();
        animationView.setVisibility(View.VISIBLE);
        animationView.playAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
        com.setContentView(R.layout.compilar);
        acept1=(Button) com.findViewById(R.id.boton_acept);
        message1=(TextView) com.findViewById(R.id.tv_message);
        titulo=(TextView)com.findViewById(R.id.tv_titulo);

        if (nivel.equals("Lvl 1") ||nivel.equals("Lvl 2") ||nivel.equals("Lvl 3") ||nivel.equals("Lvl 4") )
        {
            message1.setText("Salida en consola:\n\n<Hello World");
        }
        if (nivel.equals("Lvl 5"))
        {
            message1.setText("Salida en consola:\n\n<Hello World Laoshi");
        }


        titulo.setText(R.string.message_comp_good);
        acept1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com.dismiss();
                check.setContentView(R.layout.check_messagebox);
                check.setCancelable(false);
                layout_check = (LinearLayout) check.findViewById(R.id.layout_check);
                title_check = (TextView) check.findViewById(R.id.numero_nivel);
                tema_check = (TextView) check.findViewById(R.id.tema);
                Chronometro_check = (Chronometer) check.findViewById(R.id.tiempo);
                siguiente_check = (Button) check.findViewById(R.id.boton_siguiente);
                tiempo =  detenerse;
                Chronometro_check.setBase(SystemClock.elapsedRealtime()-tiempo);
                title_check.setText(nivel);
                tema_check.setText(tema);
                frombottom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.goup);
                layout_check.setAnimation(frombottom);

                siguiente_check.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        continuar();
                    }
                });
                check.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                check.show();
            }
        });
        com.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        com.show();
            }
        },800);

    }
    public void incorrecta()
    {
        mp= MediaPlayer.create(this,R.raw.error);
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        com1.setContentView(R.layout.compilar);
        acept1=(Button) com1.findViewById(R.id.boton_acept);
        message1=(TextView) com1.findViewById(R.id.tv_message);
        titulo=(TextView)com1.findViewById(R.id.tv_titulo);
        message1.setText("########");
        titulo.setText(R.string.error_comp);
        acept1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                com1.dismiss();
            }
        });
        com1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        com1.show();
    }

    public void check()

    {
        mp= MediaPlayer.create(this,R.raw.right);
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        if(correr)
        {
            Chronometro.stop();
            detenerse= SystemClock.elapsedRealtime()-Chronometro.getBase();
        }
    }


    public void continuar()
    {
        String id = firebaseAuth.getUid();
        databaseReference.child("users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String id = firebaseAuth.getUid();
                    String niv= dataSnapshot.child("nivel").getValue().toString();
                    int numero = Integer.parseInt(niv);
                    String nivel = nivel1;
                    String nive="3";
                    if (nivel.equals("Lvl 1")){
                        String elapsedMillis = Chronometro_check.getText().toString();
                        databaseReference.child("users").child(id).child("tiempo_n1t3").setValue(elapsedMillis);
                        if (numero<12) {
                            databaseReference.child("users").child(id).child("nivel").setValue("12");
                        }
                        Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                        intent.putExtra("niv",nive);
                        startActivity(intent);
                        finish();
                    }
                    if (nivel.equals("Lvl 2")){
                        String elapsedMillis = Chronometro_check.getText().toString();
                        databaseReference.child("users").child(id).child("tiempo_n2t3").setValue(elapsedMillis);
                        if (numero<13) {
                            databaseReference.child("users").child(id).child("nivel").setValue("13");
                        }
                        Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                        intent.putExtra("niv",nive);
                        startActivity(intent);
                        finish();
                    }
                    if (nivel.equals("Lvl 3")){
                        String elapsedMillis = Chronometro_check.getText().toString();
                        databaseReference.child("users").child(id).child("tiempo_n3t3").setValue(elapsedMillis);
                        if (numero<14) {
                            databaseReference.child("users").child(id).child("nivel").setValue("14");
                        }
                        Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                        intent.putExtra("niv",nive);
                        startActivity(intent);
                        finish();
                    }
                    if (nivel.equals("Lvl 4")){
                        String elapsedMillis = Chronometro_check.getText().toString();
                        databaseReference.child("users").child(id).child("tiempo_n4t3").setValue(elapsedMillis);
                        if (numero<15) {
                            databaseReference.child("users").child(id).child("nivel").setValue("15");
                        }
                        Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                        intent.putExtra("niv",nive);
                        startActivity(intent);
                        finish();
                    }
                    if (nivel.equals("Lvl 5")) {
                        String elapsedMillis = Chronometro_check.getText().toString();
                        databaseReference.child("users").child(id).child("tiempo_n5t3").setValue(elapsedMillis);
                        if (numero<16) {
                            databaseReference.child("users").child(id).child("nivel").setValue("16");
                        }
                        Intent intent = new Intent(getApplicationContext(), MapaActivity.class);
                        startActivity(intent);
                        finishAffinity();
                        finish();
                    }
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void onBackPressed(){
        if (mp.isPlaying())
        {
            mp.stop();
            finish();
        }
        if (!mp.isPlaying())
        {
            finish();
        }

    }
}
