package com.aplication.mapp.niveles.algoritmos;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.R;
import com.aplication.mapp.instrucciones.CheckActivity;

import java.util.Locale;

public class Nivel4Activity extends AppCompatActivity {
    private Button Buttoncheck2;
    private Typeface Good_sans;

    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private ImageButton Borrar;
    private TextView Algoritmo;



    private MediaPlayer mp;
    private Chronometer Chronometro;
    Boolean correr=false;
    long detenerse;
    String l7 = Locale.getDefault().getLanguage();
    String text;
    String mystring="Casi lo logras, inténtalo de nuevo!!!";
    String nivel="Lvl 4";
    String tema="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel4);
        Resources res = getResources();
        tema = res.getString(R.string.TEMA1);
        mystring = res.getString(R.string.casi_lo_logras);

        Buttoncheck2=findViewById(R.id.bton_check2);
        Buttoncheck2.setTypeface(Good_sans);


        String fuete2="fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans=Typeface.createFromAsset(getAssets(),fuete2);
        Chronometro=findViewById(R.id.chrono);

        Algoritmo=findViewById(R.id.algoritmo);
        Algoritmo.setTypeface(Good_sans);


        Button1=findViewById(R.id.bton_1);
        Button1.setTypeface(Good_sans);

        Button2=findViewById(R.id.bton_2);
        Button2.setTypeface(Good_sans);

        Button3=findViewById(R.id.bton_3);
        Button3.setTypeface(Good_sans);

        Button4=findViewById(R.id.bton_4);
        Button4.setTypeface(Good_sans);

        Button5=findViewById(R.id.bton_5);
        Button5.setTypeface(Good_sans);

        Buttoncheck2=findViewById(R.id.bton_check2);
        Buttoncheck2.setTypeface(Good_sans);

        Button1=(Button)findViewById(R.id.bton_1);
        Button2=(Button)findViewById(R.id.bton_2);
        Button3=(Button)findViewById(R.id.bton_3);
        Button4=(Button)findViewById(R.id.bton_4);
        Button5=(Button)findViewById(R.id.bton_5);
        Borrar=(ImageButton)findViewById(R.id.bton_borrar);
        Buttoncheck2=(Button)findViewById(R.id.bton_check2);
        Algoritmo=(TextView)findViewById(R.id.algoritmo);

        BorrarClick();
        Boton1Click();
        Boton2Click();
        Boton3Click();
        Boton4Click();
        Boton5Click();
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
                if (l7.equals("es")) {
                    Algoritmo.append(" INTRODUCIR N1, N2, N3\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" INPUT N1, N2, N3\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" INSERISCI N1, N2, N3\n\n");
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
                    Algoritmo.append(" FIN\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" END\n\n");
                }
                if(l7.equals("it"))
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
    public void Boton3Click(){
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l7.equals("es")) {
                    Algoritmo.append(" INICIO\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" START\n\n");
                }
                if(l7.equals("it"))
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
    public void Boton4Click(){
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l7.equals("es")) {
                    Algoritmo.append(" SALIDA DE PROMEDIO\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" OUTPUT THE AVERAGE\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" USCITA LA MEDIA\n\n");
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
                    Algoritmo.append(" PROM=(N1+N2+N3)/3\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" AVERAGE=(N1+N2+N3)/3\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" MEDIA=(N1+n2+N3)/3\n\n");
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
        if (texto.equals(" INICIO\n\n INTRODUCIR N1, N2, N3\n\n PROM=(N1+N2+N3)/3\n\n SALIDA DE PROMEDIO\n\n FIN\n\n") || texto.equals(" START\n\n INPUT N1, N2, N3\n\n AVERAGE=(N1+N2+N3)/3\n\n OUTPUT THE AVERAGE\n\n")
        || texto.equals(" INIZIO\n\n INSERISCI N1, N2, N3\n\n MEDIA=(N1+n2+N3)/3\n\n USCITA LA MEDIA\n\n FINE\n\n"))
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
            Intent i=new Intent(getApplicationContext(), CheckActivity.class);
            i.putExtra("nivel",nivel);
            i.putExtra("tiempo",detenerse);
            i.putExtra("tema",tema);
            startActivity(i);
            finishAffinity();
            finish();
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
}
