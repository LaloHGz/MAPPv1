package com.aplication.mapp.instrucciones;


import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.menu.MapaActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CheckActivity extends AppCompatActivity {
    private Typeface Good_sans;
    private TextView Title;
    private TextView Terminado;
    private TextView term;
    private Button siguiente;
    private TextView Tiem;
    private TextView Tema;
    Chronometer Chronometro;
    Animation frombottom;
    long tiempo;
    Boolean correr=false;

    private Dialog atras;
    private  Button cancel,acept;
    private TextView message;

    private LinearLayout checkLayout;
    private LottieAnimationView animationView;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        if (ConectionManager.checkConection(getBaseContext()))
        {

        }
        else
        {
            Intent intent=new Intent(getApplication(), InternetConectionActivity.class);
            startActivity(intent);

        }


        atras=new Dialog(this);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        String fuete2="fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans=Typeface.createFromAsset(getAssets(),fuete2);

        siguiente=findViewById(R.id.siguiente1);
        //siguiente.setTypeface(Good_sans);

        Title=findViewById(R.id.txt_n1);
        //Title.setTypeface(Good_sans);

        Terminado=findViewById(R.id.text_terminado);
        //Terminado.setTypeface(Good_sans);

        term=findViewById(R.id.text_check1);
        //term.setTypeface(Good_sans);

        Tiem=findViewById(R.id.tv_tiemp);
        //Tiem.setTypeface(Good_sans);

        Tema=findViewById(R.id.tema);
        //Tema.setTypeface(Good_sans);



        Chronometro=(Chronometer) findViewById(R.id.Chronometro);
        //Chronometro.setTypeface(Good_sans);
        Intent i=getIntent();
        Bundle Datos=i.getExtras();
        String nivel= (String)Datos.get("nivel");
        tiempo=(long)Datos.get("tiempo");
        String tema=(String)Datos.get("tema");
        TimeChrono();
        Title.setText(nivel);
        Tema.setText(tema);
        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        siguiente.setAnimation(frombottom);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Siguiente();
            }
        });

    }

    private void TimeChrono()
    {
        if (!correr)
        {
            Chronometro.setBase(SystemClock.elapsedRealtime()-tiempo);
        }

    }
    public void Siguiente()
    {


        String id = firebaseAuth.getUid();
        databaseReference.child("users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String id = firebaseAuth.getUid();
                    String niv= dataSnapshot.child("nivel").getValue().toString();
                    Integer numero=Integer.parseInt(niv);
                    String nivel=Title.getText().toString();
                    String tema=Tema.getText().toString();
                    String nive="";
                    Resources res = getResources();
                    String t = res.getString(R.string.TEMA1);
                    String t2 = res.getString(R.string.TEMA2);
                    String t3 = res.getString(R.string.TEMA3);
                    String t4 = res.getString(R.string.TEMA4);
                    String t5 = res.getString(R.string.TEMA5);
                    String t6 = res.getString(R.string.TEMA6);
                    String t7 = res.getString(R.string.TEMA7);
                    String t8 = res.getString(R.string.TEMA8);
                    String t9 = res.getString(R.string.TEMA9);
                    String t10 = res.getString(R.string.TEMA10);
                    if (tema.equals(t)) {
                        nive="1";

                        if (nivel.equals("Lvl 1")){
                            String elapsedMillis = Chronometro.getText().toString();

                            databaseReference.child("users").child(id).child("tiempo_n1t1").setValue(elapsedMillis);
                            if (numero<2) {
                                databaseReference.child("users").child(id).child("nivel").setValue("2");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 2")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n2t1").setValue(elapsedMillis);
                            if (numero<3) {
                                databaseReference.child("users").child(id).child("nivel").setValue("3");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 3")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n3t1").setValue(elapsedMillis);
                            if (numero<4) {
                                databaseReference.child("users").child(id).child("nivel").setValue("4");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 4")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n4t1").setValue(elapsedMillis);
                            if (numero<5) {
                                databaseReference.child("users").child(id).child("nivel").setValue("5");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 5")) {
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n5t1").setValue(elapsedMillis);
                            if (numero<6) {
                                databaseReference.child("users").child(id).child("nivel").setValue("6");
                            }
                            Intent intent = new Intent(getApplicationContext(), MapaActivity.class);
                            startActivity(intent);
                            finishAffinity();
                            finish();
                        }
                    }

                    if (tema.equals(t2))
                    {
                        nive="2";
                        if (nivel.equals("Lvl 1")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n1t2").setValue(elapsedMillis);
                            if (numero<7) {
                                databaseReference.child("users").child(id).child("nivel").setValue("7");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 2")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n2t2").setValue(elapsedMillis);
                            if (numero<8) {
                                databaseReference.child("users").child(id).child("nivel").setValue("8");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 3")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n3t2").setValue(elapsedMillis);
                            if (numero<9) {
                                databaseReference.child("users").child(id).child("nivel").setValue("9");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 4")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n4t2").setValue(elapsedMillis);
                            if (numero<10) {
                                databaseReference.child("users").child(id).child("nivel").setValue("10");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 5")) {
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n5t2").setValue(elapsedMillis);
                            if (numero<11) {
                                databaseReference.child("users").child(id).child("nivel").setValue("11");
                            }
                            Intent intent = new Intent(getApplicationContext(), MapaActivity.class);
                            startActivity(intent);
                            finishAffinity();
                            finish();
                        }
                    }
                    if (tema.equals(t3))
                    {
                        nive="3";
                        if (nivel.equals("Lvl 1")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n1t3").setValue(elapsedMillis);
                            if (numero<12) {
                                databaseReference.child("users").child(id).child("nivel").setValue("12");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 2")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n2t3").setValue(elapsedMillis);
                            if (numero<13) {
                                databaseReference.child("users").child(id).child("nivel").setValue("13");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 3")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n3t3").setValue(elapsedMillis);
                            if (numero<14) {
                                databaseReference.child("users").child(id).child("nivel").setValue("14");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 4")){
                            String elapsedMillis = Chronometro.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n4t3").setValue(elapsedMillis);
                            if (numero<15) {
                                databaseReference.child("users").child(id).child("nivel").setValue("15");
                            }
                            Intent intent = new Intent(getApplicationContext(), AlgoritmosActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 5")) {
                            String elapsedMillis = Chronometro.getText().toString();
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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void onBackPressed()
    {
        String nivel=Title.getText().toString();
        String tema=Tema.getText().toString();
        String nive="";
        if (tema.equals("Algoritmos") || tema.equals("Algorithms")|| tema.equals("Algoritmi")|| tema.equals("Алгоритмы")
                || tema.equals("Algorithmes")|| tema.equals("Algorithmen")) {
            nive="1";


            if (nivel.equals("Lvl 1")){
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n1t1").setValue(elapsedMillis);
                Intent intent = new Intent(this, AlgoritmosActivity.class);
                intent.putExtra("niv",nive);
                startActivity(intent);
                finish();
            }
            if (nivel.equals("Lvl 2")){
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n2t1").setValue(elapsedMillis);
                Intent intent = new Intent(this, AlgoritmosActivity.class);
                intent.putExtra("niv",nive);
                startActivity(intent);
                finish();
            }
            if (nivel.equals("Lvl 3")){
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n3t1").setValue(elapsedMillis);
                Intent intent = new Intent(this, AlgoritmosActivity.class);
                intent.putExtra("niv",nive);
                startActivity(intent);
                finish();
            }
            if (nivel.equals("Lvl 4")){
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n4t1").setValue(elapsedMillis);
                Intent intent = new Intent(this, AlgoritmosActivity.class);
                intent.putExtra("niv",nive);
                startActivity(intent);
                finish();
            }
            if (nivel.equals("Lvl 5")) {
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n5t1").setValue(elapsedMillis);
                Intent intent = new Intent(this, MapaActivity.class);
                startActivity(intent);
                finishAffinity();
                finish();
            }
        }

        if (tema.equals("Variables") || tema.equals("Variabili")|| tema.equals("Переменные")|| tema.equals("Variáveis")
                || tema.equals("Variablen"))
        {
            nive="2";
            if (nivel.equals("Lvl 1")){
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n1t2").setValue(elapsedMillis);
                Intent intent = new Intent(this, AlgoritmosActivity.class);
                intent.putExtra("niv",nive);
                startActivity(intent);
                finish();
            }
            if (nivel.equals("Lvl 2")){
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n2t2").setValue(elapsedMillis);
                Intent intent = new Intent(this, AlgoritmosActivity.class);
                intent.putExtra("niv",nive);
                startActivity(intent);
                finish();
            }
            if (nivel.equals("Lvl 3")){
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n3t2").setValue(elapsedMillis);
                Intent intent = new Intent(this, AlgoritmosActivity.class);
                intent.putExtra("niv",nive);
                startActivity(intent);
                finish();
            }
            if (nivel.equals("Lvl 4")){
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n4t2").setValue(elapsedMillis);
                Intent intent = new Intent(this, AlgoritmosActivity.class);
                intent.putExtra("niv",nive);
                startActivity(intent);
                finish();
            }
            if (nivel.equals("Lvl 5")) {
                String elapsedMillis = Chronometro.getText().toString();
                String id = firebaseAuth.getUid();
                databaseReference.child("users").child(id).child("tiempo_n5t2").setValue(elapsedMillis);
                Intent intent = new Intent(this, MapaActivity.class);
                startActivity(intent);
                finishAffinity();
                finish();
            }
        }
    }


}
