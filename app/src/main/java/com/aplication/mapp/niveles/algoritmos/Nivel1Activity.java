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
import android.widget.EditText;
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

public class Nivel1Activity extends AppCompatActivity {
    private Button Buttoncheck;
    private  Typeface Good_sans;
    private TextView Button1;
    private TextView Button2;
    private TextView Button3;
    private TextView Button4;
    private TextView Button5;

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;

    private MediaPlayer mp;

    String l7 = Locale.getDefault().getLanguage();
    String mystring="Casi lo logras, inténtalo de nuevo!!!";

    String tema="",tema1="";
    private Chronometer Chronometro;
    Boolean correr=false;
    long detenerse;
    String nivel="",nivel1="";

    private  Button acept;
    private TextView message;

    private Dialog ins;
    private LottieAnimationView animationCheckMark;
    private LinearLayout animationLayout, ejerciciosLayout;

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
        setContentView(R.layout.activity_nivel1);

        if (ConectionManager.checkConection(getBaseContext())) {

        } else {
            Intent intent = new Intent(getApplication(), InternetConectionActivity.class);
            startActivity(intent);
        }

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        check = new Dialog(this);

        Resources res = getResources();
        tema = res.getString(R.string.TEMA1);
        mystring = res.getString(R.string.casi_lo_logras);

        Intent intent = getIntent();
        Bundle Datos = intent.getExtras();
        nivel = (String) Datos.get("niv");
        nivel1 = nivel;
        tema1 = tema;

        ins=new Dialog(this);

        if (!nivel.equals("Lvl 4")) {
        ins.setContentView(R.layout.ins_n5t2);
        ins.setCancelable(false);

        acept=(Button) ins.findViewById(R.id.boton_acept);
        message=(TextView) ins.findViewById(R.id.tv_message);
        message.setText(R.string.instruccion);

        acept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ins.dismiss();
            }
        });
        ins.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ins.show();

        if (l7.equals("es"))
        {
            mp= MediaPlayer.create(this,R.raw.instruccionn1t1esp);
        }
        if (l7.equals("en"))
        {
            mp= MediaPlayer.create(this,R.raw.instruccionn1t1ing);
        }
        if (l7.equals("it"))
        {
            mp= MediaPlayer.create(this,R.raw.instruccionn1t1it);
        }
        if (l7.equals("ru"))
        {
            mp= MediaPlayer.create(this,R.raw.instruccionn1t1jap);
        }
        if (l7.equals("pt"))
        {
            mp= MediaPlayer.create(this,R.raw.instruccionn1t1por);
        }
        if (l7.equals("fr"))
        {
            mp= MediaPlayer.create(this,R.raw.instruccionn1t1fra);
        }
        if (l7.equals("de"))
        {
            mp= MediaPlayer.create(this,R.raw.instruccionn1t1ale);
        }
        if (l7.equals("ja"))
        {
            mp= MediaPlayer.create(this,R.raw.instruccionn1t1jap);
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
        }
        String fuete2="fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans=Typeface.createFromAsset(getAssets(),fuete2);

        animationCheckMark = (LottieAnimationView) findViewById(R.id.animation_checkmark);
        ejerciciosLayout = (LinearLayout) findViewById(R.id.layout_ejercicios);



        Buttoncheck=findViewById(R.id.bton_check);
        //Buttoncheck.setTypeface(Good_sans);

        Button1=findViewById(R.id.bton_laoshi);
        //Button1.setTypeface(Good_sans);

        Button2=findViewById(R.id.bton_lingdao);
        //Button2.setTypeface(Good_sans);

        Button3=findViewById(R.id.bton_zhu);
        //Button3.setTypeface(Good_sans);

        Button4=findViewById(R.id.bton_aren);
        //Button4.setTypeface(Good_sans);

        Button5=findViewById(R.id.bton_houyi);
        //Button5.setTypeface(Good_sans);

        et1=findViewById(R.id.et_1);
        //et1.setTypeface(Good_sans);

        et2=findViewById(R.id.et_2);
        //et2.setTypeface(Good_sans);

        et3=findViewById(R.id.et_3);
        //et3.setTypeface(Good_sans);

        et4=findViewById(R.id.et_4);
        //et4.setTypeface(Good_sans);

        et5=findViewById(R.id.et_5);
        //et5.setTypeface(Good_sans);

        Chronometro=findViewById(R.id.chrono);

        Buttoncheck=(Button)findViewById(R.id.bton_check);

        if (nivel.equals("Lvl 1"))
        {
            Button1.setText(R.string.bton1);
            Button2.setText(R.string.bton2);
            Button3.setText(R.string.bton3);
            Button4.setText(R.string.bton4);
            Button5.setText(R.string.bton5);
        }

        if (nivel.equals("Lvl 2"))
        {
            Button1.setText(R.string.bton1lvl2);
            Button2.setText(R.string.bton2vl2);
            Button3.setText(R.string.bton3lvl2);
            Button4.setText(R.string.bton4lvl2);
            Button5.setText(R.string.bton5lvl2);
        }

        if (nivel.equals("Lvl 3"))
        {
            Button1.setText(R.string.bton1lvl3);
            Button2.setText(R.string.bton2lvl3);
            Button3.setText(R.string.bton3lvl3);
            Button4.setText(R.string.bton4lvl3);
            Button5.setText(R.string.bton5lvl3);
        }

        if (nivel.equals("Lvl 4"))
        {
            Button1.setText(R.string.bton1lvl4);
            Button2.setText(R.string.bton2lvl4);
            Button3.setText(R.string.bton3lvl4);
            Button4.setText(R.string.bton4lvl4);
            Button5.setText(R.string.bton5lvl4);
        }



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




    public void Check(View view)
    {
        int  c=0;

        if (nivel.equals("Lvl 1"))
        {
            if (et1.getText().toString().equals("1"))
            {
                c++;
            }
            else
            {
                et1.setText("");
            }
            if (et2.getText().toString().equals("5"))
            {
                c++;
            }
            else
            {
                et2.setText("");
            }
            if (et3.getText().toString().equals("3"))
            {
                c++;
            }
            else
            {
                et3.setText("");
            }
            if (et4.getText().toString().equals("4"))
            {
                c++;
            }
            else
            {
                et4.setText("");
            }
            if (et5.getText().toString().equals("2"))
            {
                c++;
            }
            else
            {
                et5.setText("");
            }
        }

        if (nivel.equals("Lvl 2"))
        {
            if (et1.getText().toString().equals("2"))
            {
                c++;
            }
            else
            {
                et1.setText("");
            }
            if (et2.getText().toString().equals("5"))
            {
                c++;
            }
            else
            {
                et2.setText("");
            }
            if (et3.getText().toString().equals("1"))
            {
                c++;
            }
            else
            {
                et3.setText("");
            }
            if (et4.getText().toString().equals("3"))
            {
                c++;
            }
            else
            {
                et4.setText("");
            }
            if (et5.getText().toString().equals("4"))
            {
                c++;
            }
            else
            {
                et5.setText("");
            }
        }

        if (nivel.equals("Lvl 3"))
        {
            if (et1.getText().toString().equals("2"))
            {
                c++;
            }
            else
            {
                et1.setText("");
            }
            if (et2.getText().toString().equals("3"))
            {
                c++;
            }
            else
            {
                et2.setText("");
            }
            if (et3.getText().toString().equals("4"))
            {
                c++;
            }
            else
            {
                et3.setText("");
            }
            if (et4.getText().toString().equals("1"))
            {
                c++;
            }
            else
            {
                et4.setText("");
            }
            if (et5.getText().toString().equals("5"))
            {
                c++;
            }
            else
            {
                et5.setText("");
            }
        }

        if (nivel.equals("Lvl 4"))
        {
            if (et1.getText().toString().equals("2"))
            {
                c++;
            }
            else
            {
                et1.setText("");
            }
            if (et2.getText().toString().equals("1"))
            {
                c++;
            }
            else
            {
                et2.setText("");
            }
            if (et3.getText().toString().equals("5"))
            {
                c++;
            }
            else
            {
                et3.setText("");
            }
            if (et4.getText().toString().equals("4"))
            {
                c++;
            }
            else
            {
                et4.setText("");
            }
            if (et5.getText().toString().equals("3"))
            {
                c++;
            }
            else
            {
                et5.setText("");
            }
        }




        if (c==5)
        {
            Buttoncheck.setVisibility(View.GONE);
            ejerciciosLayout.setVisibility(View.GONE);
            animationCheckMark.setVisibility(View.VISIBLE);
            animationCheckMark.playAnimation();
            mp= MediaPlayer.create(getApplicationContext(),R.raw.right);
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
                    String nivel = nivel1;
                    String nive="1";

                        if (nivel.equals("Lvl 1")){
                            String elapsedMillis = Chronometro_check.getText().toString();

                            databaseReference.child("users").child(id).child("tiempo_n1t1").setValue(elapsedMillis);
                            if (numero<2) {
                                databaseReference.child("users").child(id).child("nivel").setValue("2");
                            }
                            Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 2")){
                            String elapsedMillis = Chronometro_check.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n2t1").setValue(elapsedMillis);
                            if (numero<3) {
                                databaseReference.child("users").child(id).child("nivel").setValue("3");
                            }
                            Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 3")){
                            String elapsedMillis = Chronometro_check.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n3t1").setValue(elapsedMillis);
                            if (numero<4) {
                                databaseReference.child("users").child(id).child("nivel").setValue("4");
                            }
                            Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
                            finish();
                        }
                        if (nivel.equals("Lvl 4")){
                            String elapsedMillis = Chronometro_check.getText().toString();
                            databaseReference.child("users").child(id).child("tiempo_n4t1").setValue(elapsedMillis);
                            if (numero<5) {
                                databaseReference.child("users").child(id).child("nivel").setValue("5");
                            }
                            Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                            intent.putExtra("niv",nive);
                            startActivity(intent);
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