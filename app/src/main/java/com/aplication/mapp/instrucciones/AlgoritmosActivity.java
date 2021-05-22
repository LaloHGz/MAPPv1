package com.aplication.mapp.instrucciones;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.formatos.EscritaActivity;
import com.aplication.mapp.formatos.NarradoActivity;
import com.aplication.mapp.menu.MapaActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AlgoritmosActivity extends AppCompatActivity {

    /*
    A   = Algorithms
    V   = Type of data
    PS  = Print Sentence
    AO  = Artithmetics Operator
    LO  = Logical Operators
    IS  = Input Sentence
    1CS = Conditional Sentence I
    2CS = Conditional Sentence II
    1CIS= Ciclical Sentence I
    2CIS= Ciclical Sentence II
     */
    private Typeface Good_sans;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private TextView Titulo;


    private String form="",n1t1="",n2t1="",n3t1="",n4t1="",n5t1="",n1t2="",n2t2="",n3t2="",n4t2="",n5t2="",n1t3="",n2t3="",n3t3="",n4t3="",n5t3="",n1t4="",n2t4="",n3t4="",n4t4="",n5t4="",n1t5="",n2t5="",n3t5="",n4t5="",n5t5="",n1t6="",n2t6="",n3t6="",n4t6="",n5t6="";
    private String n1t7="",n2t7="",n3t7="",n4t7="",n5t7="",n1t8="",n2t8="",n3t8="",n4t8="",n5t8="",n1t9="",n2t9="",n3t9="",n4t9="",n5t9="",n1t10="",n2t10="",n3t10="",n4t10="",n5t10="";

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algoritmos);

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


        String fuete2="fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans=Typeface.createFromAsset(getAssets(),fuete2);

        Button1=findViewById(R.id.bton_n1);
        //Button1.setTypeface(Good_sans);


        Button2=findViewById(R.id.bton_n2);
        //Button2.setTypeface(Good_sans);


        Button3=findViewById(R.id.bton_n3);
        //Button3.setTypeface(Good_sans);

        Button4=findViewById(R.id.bton_n4);
        //Button4.setTypeface(Good_sans);

        Button5=findViewById(R.id.bton_n5);
        //Button5.setTypeface(Good_sans);

        Titulo=findViewById(R.id.titulo);
        //Titulo.setTypeface(Good_sans);


        layout=(LinearLayout) findViewById(R.id.layout);


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

                        if (n1t1.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t1.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t1.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t1.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }

                    }
                    if (nivel.equals("2"))
                    {

                        if(n1t2.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t2.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t2.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t2.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }

                    }

                    if (nivel.equals("3"))
                    {
                        if(n1t3.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t3.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t3.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t3.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }

                    }
                    if (nivel.equals("4"))
                    {

                        if(n1t4.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t4.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t4.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t4.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }
                    }
                    if (nivel.equals("5"))
                    {
                        if(n1t5.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t5.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t5.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t5.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }
                    }
                    if (nivel.equals("6"))
                    {

                        if(n1t6.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t6.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t6.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t6.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }
                    }
                    if (nivel.equals("7"))
                    {
                        if(n1t7.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t7.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t7.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t7.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }
                    }
                    if (nivel.equals("8"))
                    {
                        if(n1t8.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t8.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t8.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t8.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }
                    }
                    if (nivel.equals("9"))
                    {
                        if(n1t9.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t9.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t9.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t9.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }
                    }
                    if (nivel.equals("10"))
                    {
                        if(n1t10.equals("a"))
                        {
                            Button2.setEnabled(false);
                            Button2.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n2t10.equals("a"))
                        {
                            Button3.setEnabled(false);
                            Button3.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n3t10.equals("a"))
                        {
                            Button4.setEnabled(false);
                            Button4.setBackgroundResource(R.drawable.boton_temas);
                        }
                        if (n4t10.equals("a"))
                        {
                            Button5.setEnabled(false);
                            Button5.setBackgroundResource(R.drawable.boton_temas);
                        }

                    }



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });

        if (nivel.equals("1"))
        {
            Titulo.setText(R.string.TEMA1);
            Button1.setText(R.string.Nivel1Tema1);
            Button2.setText(R.string.Nivel2Tema1);
            Button3.setText(R.string.Nivel3Tema1);
            Button4.setText(R.string.Nivel4Tema1);
            Button5.setText(R.string.Nivel5Tema1);



            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
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

            Button3.setOnClickListener(new View.OnClickListener() {
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

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","A4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","A5");
                    startActivity(intent);
                }
            });
        }



        if (nivel.equals("2"))
        {
            Titulo.setText(R.string.Nivel1Tema2);
            Button1.setText(R.string.Variables1);
            Button2.setText(R.string.Variables2);
            Button3.setText(R.string.Variables3);
            Button4.setText(R.string.Variables4);
            Button5.setText(R.string.Variables5);


            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","V2");
                    startActivity(intent);
                    finish();
                }
            });

            Button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","V3");
                    startActivity(intent);
                    finish();
                }
            });

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","V4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
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
            Titulo.setText(R.string.TEMA3);
            Button1.setText(R.string.PS1);
            Button2.setText(R.string.PS2);
            Button3.setText(R.string.PS3);
            Button4.setText(R.string.PS4);
            Button5.setText(R.string.PS5);
            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS2");
                    startActivity(intent);
                    finish();
                }
            });

            Button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS3");
                    startActivity(intent);
                    finish();
                }
            });

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
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
            Titulo.setText(R.string.TEMA6);
            Button1.setText(R.string.IS1);
            Button2.setText(R.string.IS2);
            Button3.setText(R.string.IS3);
            Button4.setText(R.string.IS4);
            Button5.setText(R.string.IS5);


            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
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

            Button3.setOnClickListener(new View.OnClickListener() {
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

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","IS4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
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
            Titulo.setText(R.string.TEMA4);
            Button1.setText(R.string.AO1);
            Button2.setText(R.string.AO2);
            Button3.setText(R.string.AO3);
            Button4.setText(R.string.AO4);
            Button5.setText(R.string.AO5);


            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
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

            Button3.setOnClickListener(new View.OnClickListener() {
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

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","AO4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
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
            Titulo.setText(R.string.TEMA5);
            Button1.setText(R.string.LO1);
            Button2.setText(R.string.LO2);
            Button3.setText(R.string.LO3);
            Button4.setText(R.string.LO4);
            Button5.setText(R.string.LO5);


            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
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

            Button3.setOnClickListener(new View.OnClickListener() {
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

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","LO4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
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
            Titulo.setText(R.string.TEMA7);
            Button1.setText(R.string.CS11);
            Button2.setText(R.string.CS12);
            Button3.setText(R.string.CS13);
            Button4.setText(R.string.CS14);
            Button5.setText(R.string.CS15);


            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
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

            Button3.setOnClickListener(new View.OnClickListener() {
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

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CS4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
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
            Titulo.setText(R.string.TEMA8);
            Button1.setText(R.string.CS21);
            Button2.setText(R.string.CS22);
            Button3.setText(R.string.CS23);
            Button4.setText(R.string.CS24);
            Button5.setText(R.string.CS25);


            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
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

            Button3.setOnClickListener(new View.OnClickListener() {
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

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CS4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
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
            Titulo.setText(R.string.TEMA9);
            Button1.setText(R.string.CIS11);
            Button2.setText(R.string.CIS12);
            Button3.setText(R.string.CIS13);
            Button4.setText(R.string.CIS14);
            Button5.setText(R.string.CIS15);


            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
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

            Button3.setOnClickListener(new View.OnClickListener() {
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

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CIS4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
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
            Titulo.setText(R.string.TEMA10);
            Button1.setText(R.string.CIS21);
            Button2.setText(R.string.CIS22);
            Button3.setText(R.string.CIS23);
            Button4.setText(R.string.CIS24);
            Button5.setText(R.string.CIS25);

            Button1.setOnClickListener(new View.OnClickListener() {
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

            Button2.setOnClickListener(new View.OnClickListener() {
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

            Button3.setOnClickListener(new View.OnClickListener() {
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

            Button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CIS4");
                    startActivity(intent);
                    finish();
                }
            });

            Button5.setOnClickListener(new View.OnClickListener() {
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

    public void onBackPressed(){
        Intent intent=new Intent(getApplication(), MapaActivity.class);
        startActivity(intent);
        finishAffinity();
        finish();
    }



}

