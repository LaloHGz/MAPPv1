package com.aplication.mapp.instrucciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.formatos.EscritaActivity;
import com.aplication.mapp.formatos.NarradoActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EjerciciosTemasActivity extends AppCompatActivity {

    private ImageView back,play1,play2,play3,play4,play5;
    private ImageView imagenTema;
    private TextView ejercicios,dificultad,duracion,tema,duracionN1,duracionN2,duracionN3,duracionN4,duracionN5,
            nombreN1,nombreN2,nombreN3,nombreN4,nombreN5,numeroNivel1,numeroNivel2,numeroNivel3,numeroNivel4,numeroNivel5;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    private String form="",n1t1="",n2t1="",n3t1="",n4t1="",n5t1="",n1t2="",n2t2="",n3t2="",n4t2="",n5t2="",n1t3="",n2t3="",n3t3="",n4t3="",
            n5t3="",n1t4="",n2t4="",n3t4="",n4t4="",n5t4="",n1t5="",n2t5="",n3t5="",n4t5="",n5t5="",n1t6="",n2t6="",n3t6="",n4t6="",n5t6="";

    private String n1t7="",n2t7="",n3t7="",n4t7="",n5t7="",n1t8="",n2t8="",n3t8="",n4t8="",n5t8="",n1t9="",n2t9="",n3t9="",n4t9="",n5t9="",
            n1t10="",n2t10="",n3t10="",n4t10="",n5t10="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios_temas);

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

        Intent intent=getIntent();
        Bundle Datos=intent.getExtras();
        final String nivel= (String)Datos.get("niv");

        back = findViewById(R.id.back);
        imagenTema = findViewById(R.id.imagen_tema);

        ejercicios = findViewById(R.id.ejercicios);
        dificultad = findViewById(R.id.dificultad);
        duracion = findViewById(R.id.duracion);

        tema = findViewById(R.id.tv_tema);

        numeroNivel1 = findViewById(R.id.numero_nivel1);
        numeroNivel2 = findViewById(R.id.numero_nivel2);
        numeroNivel3 = findViewById(R.id.numero_nivel3);
        numeroNivel4 = findViewById(R.id.numero_nivel4);
        numeroNivel5 = findViewById(R.id.numero_nivel5);

        duracionN1 = findViewById(R.id.duracion_n1);
        duracionN2 = findViewById(R.id.duracion_n2);
        duracionN3 = findViewById(R.id.duracion_n3);
        duracionN4 = findViewById(R.id.duracion_n4);
        duracionN5 = findViewById(R.id.duracion_n5);

        nombreN1 = findViewById(R.id.nombre_n1);
        nombreN2 = findViewById(R.id.nombre_n2);
        nombreN3 = findViewById(R.id.nombre_n3);
        nombreN4 = findViewById(R.id.nombre_n4);
        nombreN5 = findViewById(R.id.nombre_n5);

        play1 = findViewById(R.id.iv_play1);
        play2 = findViewById(R.id.iv_play2);
        play3 = findViewById(R.id.iv_play3);
        play4 = findViewById(R.id.iv_play4);
        play5 = findViewById(R.id.iv_play5);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        String id=firebaseAuth.getCurrentUser().getUid();
        databaseReference.child("users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    form= dataSnapshot.child("formato").getValue().toString();

                    n1t1=dataSnapshot.child("tiempo_n1t1").getValue().toString();
                    n2t1=dataSnapshot.child("tiempo_n2t1").getValue().toString();
                    n3t1=dataSnapshot.child("tiempo_n3t1").getValue().toString();
                    n4t1=dataSnapshot.child("tiempo_n4t1").getValue().toString();
                    n5t1=dataSnapshot.child("tiempo_n5t1").getValue().toString();

                    n1t2=dataSnapshot.child("tiempo_n1t2").getValue().toString();
                    n2t2=dataSnapshot.child("tiempo_n2t2").getValue().toString();
                    n3t2=dataSnapshot.child("tiempo_n3t2").getValue().toString();
                    n4t2=dataSnapshot.child("tiempo_n4t2").getValue().toString();
                    n5t2=dataSnapshot.child("tiempo_n5t2").getValue().toString();

                    n1t3=dataSnapshot.child("tiempo_n1t3").getValue().toString();
                    n2t3=dataSnapshot.child("tiempo_n2t3").getValue().toString();
                    n3t3=dataSnapshot.child("tiempo_n3t3").getValue().toString();
                    n4t3=dataSnapshot.child("tiempo_n4t3").getValue().toString();
                    n5t3=dataSnapshot.child("tiempo_n5t3").getValue().toString();

                    n1t4=dataSnapshot.child("tiempo_n1t4").getValue().toString();
                    n2t4=dataSnapshot.child("tiempo_n2t4").getValue().toString();
                    n3t4=dataSnapshot.child("tiempo_n3t4").getValue().toString();
                    n4t4=dataSnapshot.child("tiempo_n4t4").getValue().toString();
                    n5t4=dataSnapshot.child("tiempo_n5t4").getValue().toString();

                    n1t5=dataSnapshot.child("tiempo_n1t5").getValue().toString();
                    n2t5=dataSnapshot.child("tiempo_n2t5").getValue().toString();
                    n3t5=dataSnapshot.child("tiempo_n3t5").getValue().toString();
                    n4t5=dataSnapshot.child("tiempo_n4t5").getValue().toString();
                    n5t5=dataSnapshot.child("tiempo_n5t5").getValue().toString();

                    n1t6=dataSnapshot.child("tiempo_n1t6").getValue().toString();
                    n2t6=dataSnapshot.child("tiempo_n2t6").getValue().toString();
                    n3t6=dataSnapshot.child("tiempo_n3t6").getValue().toString();
                    n4t6=dataSnapshot.child("tiempo_n4t6").getValue().toString();
                    n5t6=dataSnapshot.child("tiempo_n5t6").getValue().toString();

                    n1t7=dataSnapshot.child("tiempo_n1t7").getValue().toString();
                    n2t7=dataSnapshot.child("tiempo_n2t7").getValue().toString();
                    n3t7=dataSnapshot.child("tiempo_n3t7").getValue().toString();
                    n4t7=dataSnapshot.child("tiempo_n4t7").getValue().toString();
                    n5t7=dataSnapshot.child("tiempo_n5t7").getValue().toString();

                    n1t8=dataSnapshot.child("tiempo_n1t8").getValue().toString();
                    n2t8=dataSnapshot.child("tiempo_n2t8").getValue().toString();
                    n3t8=dataSnapshot.child("tiempo_n3t8").getValue().toString();
                    n4t8=dataSnapshot.child("tiempo_n4t8").getValue().toString();
                    n5t8=dataSnapshot.child("tiempo_n5t8").getValue().toString();

                    n1t9=dataSnapshot.child("tiempo_n1t9").getValue().toString();
                    n2t9=dataSnapshot.child("tiempo_n2t9").getValue().toString();
                    n3t9=dataSnapshot.child("tiempo_n3t9").getValue().toString();
                    n4t9=dataSnapshot.child("tiempo_n4t9").getValue().toString();
                    n5t9=dataSnapshot.child("tiempo_n5t9").getValue().toString();
                    n1t10=dataSnapshot.child("tiempo_n1t10").getValue().toString();
                    n2t10=dataSnapshot.child("tiempo_n2t10").getValue().toString();
                    n3t10=dataSnapshot.child("tiempo_n3t10").getValue().toString();
                    n4t10=dataSnapshot.child("tiempo_n4t10").getValue().toString();
                    n5t10=dataSnapshot.child("tiempo_n5t10").getValue().toString();


                    if (nivel.equals("1")) {

                        imagenTema.setImageResource(R.drawable.algoritmos_portada);
                        nombreN1.setText(R.string.nivel1);
                        nombreN2.setText(R.string.nivel2);
                        nombreN3.setText(R.string.nivel3);
                        nombreN4.setText(R.string.nivel4);
                        nombreN5.setText(R.string.Nivel5alg);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Fácil");
                        duracion.setText("15 min");

                        if (n1t1.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t1.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t1.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t1.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }

                    }
                    if (nivel.equals("2"))
                    {
                        imagenTema.setImageResource(R.drawable.portada1);
                        nombreN1.setText(R.string.Variables1);
                        nombreN2.setText(R.string.Variables2);
                        nombreN3.setText(R.string.Variables3);
                        nombreN4.setText(R.string.Variables4);
                        nombreN5.setText(R.string.Variables5);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Fácil");
                        duracion.setText("17 min");

                        if (n1t2.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t2.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t2.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t2.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }

                    }

                    if (nivel.equals("3"))
                    {
                        imagenTema.setImageResource(R.drawable.portada1);
                        nombreN1.setText(R.string.PS1);
                        nombreN2.setText(R.string.PS2);
                        nombreN3.setText(R.string.PS3);
                        nombreN4.setText(R.string.PS4);
                        nombreN5.setText(R.string.PS5);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Media");
                        duracion.setText("20 min");


                        if (n1t3.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t3.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t3.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t3.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }

                    }
                    if (nivel.equals("4"))
                    {
                        imagenTema.setImageResource(R.drawable.portada1);
                        nombreN1.setText(R.string.PS1);
                        nombreN2.setText(R.string.PS2);
                        nombreN3.setText(R.string.PS3);
                        nombreN4.setText(R.string.PS4);
                        nombreN5.setText(R.string.PS5);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Media");
                        duracion.setText("20 min");

                        if (n1t4.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t4.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t4.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t4.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }
                    }
                    if (nivel.equals("5"))
                    {
                        imagenTema.setImageResource(R.drawable.portada1);
                        nombreN1.setText(R.string.PS1);
                        nombreN2.setText(R.string.PS2);
                        nombreN3.setText(R.string.PS3);
                        nombreN4.setText(R.string.PS4);
                        nombreN5.setText(R.string.PS5);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Media");
                        duracion.setText("20 min");

                        if (n1t5.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t5.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t5.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t5.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }
                    }
                    if (nivel.equals("6"))
                    {
                        imagenTema.setImageResource(R.drawable.portada1);
                        nombreN1.setText(R.string.PS1);
                        nombreN2.setText(R.string.PS2);
                        nombreN3.setText(R.string.PS3);
                        nombreN4.setText(R.string.PS4);
                        nombreN5.setText(R.string.PS5);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Media");
                        duracion.setText("20 min");

                        if (n1t6.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t6.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t6.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t6.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }
                    }
                    if (nivel.equals("7"))
                    {
                        imagenTema.setImageResource(R.drawable.portada1);
                        nombreN1.setText(R.string.PS1);
                        nombreN2.setText(R.string.PS2);
                        nombreN3.setText(R.string.PS3);
                        nombreN4.setText(R.string.PS4);
                        nombreN5.setText(R.string.PS5);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Media");
                        duracion.setText("20 min");

                        if (n1t7.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t7.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t7.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t7.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }
                    }
                    if (nivel.equals("8"))
                    {
                        imagenTema.setImageResource(R.drawable.portada1);
                        nombreN1.setText(R.string.PS1);
                        nombreN2.setText(R.string.PS2);
                        nombreN3.setText(R.string.PS3);
                        nombreN4.setText(R.string.PS4);
                        nombreN5.setText(R.string.PS5);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Media");
                        duracion.setText("20 min");


                        if (n1t8.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t8.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t8.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t8.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }
                    }
                    if (nivel.equals("9"))
                    {
                        imagenTema.setImageResource(R.drawable.portada1);
                        nombreN1.setText(R.string.PS1);
                        nombreN2.setText(R.string.PS2);
                        nombreN3.setText(R.string.PS3);
                        nombreN4.setText(R.string.PS4);
                        nombreN5.setText(R.string.PS5);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Media");
                        duracion.setText("20 min");

                        if (n1t9.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t9.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t9.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t9.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }
                    }
                    if (nivel.equals("10"))
                    {
                        imagenTema.setImageResource(R.drawable.portada1);
                        nombreN1.setText(R.string.PS1);
                        nombreN2.setText(R.string.PS2);
                        nombreN3.setText(R.string.PS3);
                        nombreN4.setText(R.string.PS4);
                        nombreN5.setText(R.string.PS5);
                        duracionN1.setText("2 min");
                        duracionN2.setText("4 min");
                        duracionN3.setText("3 min");
                        duracionN4.setText("4 min");
                        duracionN5.setText("2 min");
                        dificultad.setText("Media");
                        duracion.setText("20 min");

                        if (n1t10.equals("a"))
                        {
                            numeroNivel2.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN2.setTextColor(getResources().getColor(R.color.GRIS70));
                            play2.setEnabled(false);
                            play2.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n2t10.equals("a"))
                        {
                            numeroNivel3.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN3.setTextColor(getResources().getColor(R.color.GRIS70));
                            play3.setEnabled(false);
                            play3.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n3t10.equals("a"))
                        {
                            numeroNivel4.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN4.setTextColor(getResources().getColor(R.color.GRIS70));
                            play4.setEnabled(false);
                            play4.setImageResource(R.drawable.ic_play_button_block);
                        }
                        if (n4t10.equals("a"))
                        {
                            numeroNivel5.setTextColor(getResources().getColor(R.color.GRIS70));
                            duracionN5.setTextColor(getResources().getColor(R.color.GRIS70));
                            play5.setEnabled(false);
                            play5.setImageResource(R.drawable.ic_play_button_block);

                        }

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });

        if (nivel.equals("1"))
        {
            tema.setText(R.string.TEMA1);


            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","A1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","A1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","A1");
                        startActivity(intent);
                    }
                    finish();

                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","A2");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","A2");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","A2");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","A3");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","A3");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","A3");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","A4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","A5");
                    startActivity(intent);
                    finish();
                }
            });
        }


        if (nivel.equals("2"))
        {
            tema.setText(R.string.Nivel1Tema2);


            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","V1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","V1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","V1");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","V2");
                    startActivity(intent);
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","V3");
                    startActivity(intent);
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","V4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","V5");
                    startActivity(intent);
                    finish();

                }
            });
        }



        if (nivel.equals("3"))
        {
            tema.setText(R.string.TEMA3);

            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","PS1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","PS1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","PS1");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS2");
                    startActivity(intent);
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS3");
                    startActivity(intent);
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS5");
                    startActivity(intent);
                    finish();
                }
            });
        }



        if (nivel.equals("4")) {
            tema.setText(R.string.TEMA6);

            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","IS1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","IS1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","IS1");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","IS2");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","IS2");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","IS2");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","IS3");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","IS3");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","IS3");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","IS4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","IS5");
                    startActivity(intent);
                    finish();
                }
            });
        }



        if (nivel.equals("5"))
        {
            tema.setText(R.string.TEMA4);


            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","AO1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","AO1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","AO1");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","AO2");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","AO2");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","AO2");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","AO3");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","AO3");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","AO3");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","AO4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","AO5");
                    startActivity(intent);
                    finish();
                }
            });
        }



        if (nivel.equals("6"))
        {
            tema.setText(R.string.TEMA5);


            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","LO1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","LO1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","LO1");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","LO2");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","LO2");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","LO2");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","LO3");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","LO3");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","LO3");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","LO4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","LO5");
                    startActivity(intent);
                    finish();
                }
            });
        }



        if (nivel.equals("7"))
        {
            tema.setText(R.string.TEMA7);


            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","1CS1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CS1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CS1");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","1CS2");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CS2");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CS2");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","1CS3");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CS3");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CS3");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CS4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CS5");
                    startActivity(intent);
                    finish();
                }
            });
        }



        if (nivel.equals("8"))
        {
            tema.setText(R.string.TEMA8);


            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","2CS1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CS1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CS1");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","2CS2");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CS2");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CS2");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","2CS3");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CS3");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CS3");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CS4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CS5");
                    startActivity(intent);
                    finish();
                }
            });
        }


        if (nivel.equals("9"))
        {
            tema.setText(R.string.TEMA9);

            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","1CIS1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CIS1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CIS1");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","1CIS2");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CIS2");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CIS2");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","1CIS3");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CIS3");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","1CIS3");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CIS4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CIS5");
                    startActivity(intent);
                    finish();
                }
            });
        }



        if (nivel.equals("10"))
        {
            tema.setText(R.string.TEMA10);


            play1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","2CIS1");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CIS1");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CIS1");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","2CIS2");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CIS2");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CIS2");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        Intent intent = new Intent(getApplication(), EscritaActivity.class);
                        intent.putExtra("ins","2CIS3");
                        startActivity(intent);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CIS3");
                        startActivity(intent);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {
                        Intent intent = new Intent(getApplication(), NarradoActivity.class);
                        intent.putExtra("ins","2CIS3");
                        startActivity(intent);
                    }
                    finish();
                }
            });

            play4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CIS4");
                    startActivity(intent);
                    finish();
                }
            });

            play5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CIS5");
                    startActivity(intent);
                    finish();
                }
            });
        }



    }



}
