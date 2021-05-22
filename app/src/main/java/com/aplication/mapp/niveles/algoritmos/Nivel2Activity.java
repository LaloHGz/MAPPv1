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

public class Nivel2Activity extends AppCompatActivity {
    private Button Buttoncheck2;
    private Typeface Good_sans;

    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private ImageButton Borrar;
    private TextView Algoritmo;


    private Chronometer Chronometro;
    Boolean correr=false;
    long detenerse;
    String l7 = Locale.getDefault().getLanguage();
    String text;
    String mystring="Casi lo logras, inténtalo de nuevo!!!";
    String nivel="Lvl 2";
    String tema="";
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel2);
        Resources res = getResources();
        tema = res.getString(R.string.TEMA1);
        mystring = res.getString(R.string.casi_lo_logras);

        String fuete2="fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans=Typeface.createFromAsset(getAssets(),fuete2);

        Buttoncheck2=findViewById(R.id.bton_check2);
        Buttoncheck2.setTypeface(Good_sans);

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

        Chronometro=findViewById(R.id.chrono);

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

    // Shizong e Laoshi hanno visto una nave spaziale\n\n Shizong ha trovato una foglia in una lingua straniera\n\n I Paythoniani volevano impersonare i panda\n\n Ottenere la fiducia del popolo Karrankawua\n\n attaccare i Karankawuas per ottenere il Moshu\n\n
    public void Boton1Click(){
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (l7.equals("es")) {
                    Algoritmo.append(" Shizong encontro una hoja en un lenguaje extraño\n\n");
                }
                if (l7.equals("en")){
                    Algoritmo.append(" Shizong found a sheet in a strange language\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" Shizong ha trovato una foglia in una lingua straniera\n\n");
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
                    Algoritmo.append(" Shizong y Laoshi vieron una nave espacial\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" Shizong and laoshi saw a spaceship\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" Shizong e Laoshi hanno visto una nave spaziale\n\n");
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
                    Algoritmo.append(" Atacar a los karankawuas para conseguir el Moshu\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" Attack the karankawuas to get the Moshu\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" Attaccare i Karankawuas per ottenere il Moshu\n\n");
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

                    Algoritmo.append(" Los Paythonianos, querian hacerse pasar por pandas\n\n");
                }
                if (l7.equals("en"))
                {
                    Algoritmo.append(" The Paytonians wanted to pass themselves off as pandas\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" I Paythoniani volevano impersonare i panda\n\n");
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
                    Algoritmo.append(" Ganar confianza del pueblo Karrankawua\n\n");
                }
                if (l7.equals("en")){
                    Algoritmo.append(" Gain the trust of the Karrankawua people\n\n");
                }
                if(l7.equals("it"))
                {
                    Algoritmo.append(" Ottenere la fiducia del popolo Karrankawua\n\n");
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
        // Shizong and laoshi saw a spaceship\n\n Shizong found a sheet in a strange language\n\n The Paytonians wanted to pass themselves off as pandas\n\n Gain the trust of the Karrankawua people\n\n Attack the karankawuas to get the Rhodium\n\n
        String texto=Algoritmo.getText().toString();
        if (texto.equals(" Shizong y Laoshi vieron una nave espacial\n\n Shizong encontro una hoja en un lenguaje extraño\n\n Los Paythonianos, querian hacerse pasar por pandas\n\n Ganar confianza del pueblo Karrankawua\n\n Atacar a los karankawuas para conseguir el Moshu\n\n") || texto.equals(" Shizong and laoshi saw a spaceship\n\n Shizong found a sheet in a strange language\n\n The Paytonians wanted to pass themselves off as pandas\n\n Gain the trust of the Karrankawua people\n\n Attack the karankawuas to get the Moshu\n\n")
                || texto.equals(" Shizong e Laoshi hanno visto una nave spaziale\n\n Shizong ha trovato una foglia in una lingua straniera\n\n I Paythoniani volevano impersonare i panda\n\n Ottenere la fiducia del popolo Karrankawua\n\n Attaccare i Karankawuas per ottenere il Moshu\n\n"))
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
            Toast.makeText(getApplicationContext(),mystring,Toast.LENGTH_SHORT).show();
            Algoritmo.setText("");
        }
    }
}
