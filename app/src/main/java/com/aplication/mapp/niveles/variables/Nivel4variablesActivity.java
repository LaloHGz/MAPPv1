package com.aplication.mapp.niveles.variables;

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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.instrucciones.EjerciciosTemasActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class Nivel4variablesActivity extends AppCompatActivity {

    private MediaPlayer mp;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;

    private Typeface Good_sans;
    private TextView ins;


    private Chronometer Chronometro;
    Boolean correr=false;
    long detenerse;
    String l7 = Locale.getDefault().getLanguage();
    String text;
    String mystring="Casi lo logras, inténtalo de nuevo";
    String nivel="Lvl 3";
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
    private Animation goup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel4variables);

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
        tema = res.getString(R.string.TEMA2);
        mystring = res.getString(R.string.casi_lo_logras);

        String fuete2="fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans= Typeface.createFromAsset(getAssets(),fuete2);


        Chronometro=findViewById(R.id.chrono);
        animationView= findViewById(R.id.animation_checkmark);

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

        ins=findViewById(R.id.algoritmo2);
        //ins.setTypeface(Good_sans);

        Button1=(Button)findViewById(R.id.bton_1);
        Button2=(Button)findViewById(R.id.bton_2);
        Button3=(Button)findViewById(R.id.bton_3);
        Button4=(Button)findViewById(R.id.bton_4);
        Button5=(Button)findViewById(R.id.bton_5);

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


    public void INT(View view)
    {
        ins.setVisibility(View.GONE);
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
                goup = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.goup);
                layout_check.setAnimation(goup);

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

    public void incorrecta(View view)
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
        Toast.makeText(getApplicationContext(),mystring,Toast.LENGTH_SHORT).show();
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
                    String nive="2";
                    String elapsedMillis = Chronometro_check.getText().toString();
                    databaseReference.child("users").child(id).child("tiempo_n3t2").setValue(elapsedMillis);
                    if (numero<9) {
                        databaseReference.child("users").child(id).child("nivel").setValue("8");
                    }
                    Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                    intent.putExtra("niv",nive);
                    startActivity(intent);
                    finish();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
