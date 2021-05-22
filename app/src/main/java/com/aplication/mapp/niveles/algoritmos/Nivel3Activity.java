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

public class Nivel3Activity extends AppCompatActivity {
    private Button Buttoncheck2;
    private Typeface Good_sans;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private ImageButton Borrar;
    private TextView Algoritmo;

    String l7 = Locale.getDefault().getLanguage();
    private Chronometer Chronometro;
    Boolean correr=false;
    long detenerse;
    String text;
    String mystring="Casi lo logras, inténtalo de nuevo!!!";
    String nivel="Lvl 3";
    String tema="";
    private MediaPlayer mp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel3);

        Resources res = getResources();
        tema = res.getString(R.string.TEMA1);
        mystring = res.getString(R.string.casi_lo_logras);

        String fuete2="fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans=Typeface.createFromAsset(getAssets(),fuete2);

        Chronometro=findViewById(R.id.chrono);
        Algoritmo=findViewById(R.id.algoritmo2);
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
        Algoritmo=(TextView)findViewById(R.id.algoritmo2);

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
                    Algoritmo.append(" Los paythonianos ya habían cambiado su forma a la de un panda\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" The Paytonians had already changed their form to that of a panda\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" I paythoniani avevano già cambiato la loro forma in quella di un panda\n\n");
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
                    Algoritmo.append(" Kin logró cautivar la atención de Shizong\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" Kin managed to captivate Shizong\'s attention\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" Kin riuscì a catturare l\'attenzione di Shizong\n\n");
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
                    Algoritmo.append(" Los Karankawuas hacieron una fiesta de bienvenida para los paythonianos\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" The Karankawuas held a welcome party for the Paytholians\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" I Karankawuas hanno avuto una festa di benvenuto per i Paythoniani\n\n");
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
                    Algoritmo.append(" Lingdao recibio a Kin   y a su tribu en la fortaleza de Aren\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" Lingdao received Kin  and his tribe in the fortress of Aren\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" Lingdao ha ricevuto Kin e la sua tribù nella fortezza di Aren\n\n");
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
                    Algoritmo.append(" Un paythoniano le atravesó el corazón con una espada a un guardia karankawua\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" A paythonian pierced his heart with a sword to a karankawua guard\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" Un paythoniani ha trafitto il cuore di una guardia Karankawua con una spada\n\n");
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
        // Lingdao received Kin  and his tribe in the fortress of Aren\n\n  The Paytonians had already changed their form to that of a panda\n\n  The Karankawuas held a welcome party for the Paytholians\n\n Kin managed to captivate Shizong\'s attention\n\n  A paythonian pierced his heart with a sword to a karankawua guard\n\n
        String texto=Algoritmo.getText().toString();
        if (texto.equals(" Lingdao recibio a Kin   y a su tribu en la fortaleza de Aren\n\n Los paythonianos ya habían cambiado su forma a la de un panda\n\n Los Karankawuas hacieron una fiesta de bienvenida para los paythonianos\n\n Kin logró cautivar la atención de Shizong\n\n Un paythoniano le atravesó el corazón con una espada a un guardia karankawua\n\n") || texto.equals(" Lingdao received Kin  and his tribe in the fortress of Aren\n\n  The Paytonians had already changed their form to that of a panda\n\n  The Karankawuas held a welcome party for the Paytholians\n\n Kin managed to captivate Shizong\'s attention\n\n  A paythonian pierced his heart with a sword to a karankawua guard\n\n")
                || texto.equals("  Lingdao ha ricevuto Kin e la sua tribù nella fortezza di Aren\n\n I paythoniani avevano già cambiato la loro forma in quella di un panda\n\n I Karankawuas hanno avuto una festa di benvenuto per i Paythoniani\n\n Kin riuscì a catturare l\'attenzione di Shizong\n\n Un paythoniani ha trafitto il cuore di una guardia Karankawua con una spada\n\n"))
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
