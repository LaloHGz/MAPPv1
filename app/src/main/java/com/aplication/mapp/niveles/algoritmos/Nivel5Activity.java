package com.aplication.mapp.niveles.algoritmos;

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
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.Locale;

public class Nivel5Activity extends AppCompatActivity {
    private MediaPlayer mp;
    private Button Buttoncheck2;
    private Typeface Good_sans;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private Button Button6;
    private ImageButton Borrar;
    private TextView Algoritmo;

    private Chronometer Chronometro;
    Boolean correr=false;
    long detenerse;
    String l7 = Locale.getDefault().getLanguage();
    String text;
    String mystring="Casi lo logras, inténtalo de nuevo!!!";
    String nivel="Lvl 5";
    String tema="";

    private LottieAnimationView animationView;

    private Dialog check;
    private LinearLayout layout_check;
    private TextView title_check,tema_check;
    private Chronometer Chronometro_check;
    private Button siguiente_check;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private long tiempo;
    private Animation frombottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel5);
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
        tema = res.getString(R.string.TEMA1);
        mystring = res.getString(R.string.casi_lo_logras);

        Buttoncheck2=findViewById(R.id.bton_check2);
        Buttoncheck2.setTypeface(Good_sans);

        String fuete2="fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans=Typeface.createFromAsset(getAssets(),fuete2);

        Algoritmo=findViewById(R.id.algoritmo2);
        //Algoritmo.setTypeface(Good_sans);

        Button1=findViewById(R.id.bton_1);
        //Button1.setTypeface(Good_sans);

        Button2=findViewById(R.id.bton_2);
        //Button2.setTypeface(Good_sans);

        Button3=findViewById(R.id.bton_3);
        //Button3.setTypeface(Good_sans);

        Button4=findViewById(R.id.bton_4);
        //Button4.setTypeface(Good_sans);

        Button5=findViewById(R.id.bton_5);
        //Button5.setTypeface(Good_sans);

        Button6=findViewById(R.id.bton_6);
        //Button6.setTypeface(Good_sans);

        Buttoncheck2=findViewById(R.id.bton_check2);
        //Buttoncheck2.setTypeface(Good_sans);
        Chronometro=findViewById(R.id.chrono);
        animationView = (LottieAnimationView) findViewById(R.id.animation_checkmark);

        Button1=(Button)findViewById(R.id.bton_1);
        Button2=(Button)findViewById(R.id.bton_2);
        Button3=(Button)findViewById(R.id.bton_3);
        Button4=(Button)findViewById(R.id.bton_4);
        Button5=(Button)findViewById(R.id.bton_5);
        Button6=(Button)findViewById(R.id.bton_6);
        Borrar=(ImageButton)findViewById(R.id.bton_borrar);
        Buttoncheck2=(Button)findViewById(R.id.bton_check2);
        Algoritmo=(TextView)findViewById(R.id.algoritmo2);

        BorrarClick();
        Boton1Click();
        Boton2Click();
        Boton3Click();
        Boton4Click();
        Boton5Click();
        Boton6Click();

        startChronometro();
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
    public void BorrarClick(){
        Borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Algoritmo.setText("");
                text=Algoritmo.getText().toString();
            }
        });
    }
    public void Boton1Click(){
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l7.equals("es")){
                Algoritmo.append(" FIN\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" END\n\n");
                }
                if (l7.equals("it"))
                {
                    Algoritmo.append(" FINE\n\n");
                }
                if(l7.equals("pt"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("fr"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("de"))
                {
                    Algoritmo.append(" \n\n");
                }
                text=Algoritmo.getText().toString();
            }
        });
    }
    public void Boton2Click(){
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l7.equals("es")) {
                    Algoritmo.append(" Comprar tu boleto\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" Buy the movie ticket\n\n");
                }
                if (l7.equals("it"))
                {
                    Algoritmo.append(" Acquista il biglietto del cinema\n\n");
                }
                if(l7.equals("pt"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("fr"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("de"))
                {
                    Algoritmo.append(" \n\n");
                }
                text=Algoritmo.getText().toString();
            }
        });
    }
    public void Boton3Click(){
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l7.equals("es")) {
                    Algoritmo.append(" Ir a la taquilla\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" Go for the cinema tickets\n\n");
                }
                if (l7.equals("it"))
                {
                    Algoritmo.append(" Vai per i biglietti del cinema\n\n");
                }
                if(l7.equals("pt"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("fr"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("de"))
                {
                    Algoritmo.append(" \n\n");
                }
                text=Algoritmo.getText().toString();
            }
        });
    }
    public void Boton4Click(){
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l7.equals("es")) {
                    Algoritmo.append(" Entrar a la sala de cine\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" Enter the cinema room\n\n");
                }
                if (l7.equals("it"))
                {
                    Algoritmo.append(" Entra nella sala cinema\n\n");
                }
                if(l7.equals("pt"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("fr"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("de"))
                {
                    Algoritmo.append(" \n\n");
                }
                text=Algoritmo.getText().toString();
            }
        });
    }
    public void Boton5Click(){
        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l7.equals("es")) {
                    Algoritmo.append(" Disfrutar la pelicula\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" Enjoy the movie\n\n");
                }
                if (l7.equals("it"))
                {
                    Algoritmo.append(" Godetevi il film\n\n");
                }
                if(l7.equals("pt"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("fr"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("de"))
                {
                    Algoritmo.append(" \n\n");
                }
                text=Algoritmo.getText().toString();
            }
        });
    }
    public void Boton6Click(){
        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l7.equals("es")) {
                    Algoritmo.append(" INICIO\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" START\n\n");
                }
                if (l7.equals("it"))
                {
                    Algoritmo.append(" INIZIO\n\n");
                }
                if(l7.equals("pt"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("fr"))
                {
                    Algoritmo.append(" \n\n");
                }
                if(l7.equals("de"))
                {
                    Algoritmo.append(" \n\n");
                }
                text=Algoritmo.getText().toString();
            }
        });
    }

    public void Check(View view)
    {
        String texto=Algoritmo.getText().toString();
        if (texto.equals(" INICIO\n\n Ir a la taquilla\n\n Comprar tu boleto\n\n Entrar a la sala de cine\n\n Disfrutar la pelicula\n\n FIN\n\n") || texto.equals(" START\n\n Go for the cinema tickets\n\n Buy the movie ticket\n\n Enter the cinema room\n\n Enjoy the movie\n\n END\n\n")
        || texto.equals(" INIZIO\n\n Vai per i biglietti del cinema\n\n Acquista il biglietto del cinema\n\n Entra nella sala cinema\n\n Godetevi il film\n\n FINE\n\n"))
        {
            Algoritmo.setVisibility(View.GONE);
            animationView.setVisibility(View.VISIBLE);
            animationView.playAnimation();
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
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

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
            },800);
        }
        else
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
            Algoritmo.setText("");
            Toast.makeText(getApplicationContext(),mystring,Toast.LENGTH_SHORT).show();
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

                        String elapsedMillis = Chronometro_check.getText().toString();
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

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}
