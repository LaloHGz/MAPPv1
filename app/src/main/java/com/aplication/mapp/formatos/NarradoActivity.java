package com.aplication.mapp.formatos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.instrucciones.Ins_nivel1Activity;

import java.util.Locale;

public class NarradoActivity extends AppCompatActivity {
    private Typeface Good_sans;
    private Button Siguiente;
    private ImageButton playBtn;
    private MediaPlayer mp;
    private SeekBar positionBar;
    private TextView Titulo,Texto1, elapsedTimeLabel,remainingTimeLabel,numero;
    int totalTime;
    private Button close;

    String l7 = Locale.getDefault().getLanguage();
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narrado);

        if (Build.VERSION.SDK_INT>=21) {
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.GRIS70));
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        if (ConectionManager.checkConection(getBaseContext()))
        {

        }
        else
        {
            Intent intent=new Intent(getApplication(), InternetConectionActivity.class);
            startActivity(intent);
        }

        String fuete2 = "fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans = Typeface.createFromAsset(getAssets(), fuete2);

        Intent intent=getIntent();
        Bundle Datos=intent.getExtras();
        final String ins= (String)Datos.get("ins");

        Siguiente = findViewById(R.id.boton_siguiente);

        Titulo = findViewById(R.id.titulo_narrado);

        Texto1 = findViewById(R.id.txt_ins);
        //Texto1.setTypeface(Good_sans);

        playBtn = (ImageButton) findViewById(R.id.bton_play);
        numero = (TextView) findViewById(R.id.numero);


        close=findViewById(R.id.image_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                finish();
            }
        });

        elapsedTimeLabel = (TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) findViewById(R.id.remainingTimeLabel);

        if (ins.equals("A1"))
        {
            numero.setText("1.");
            Titulo.setText(R.string.nivel1);
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto1espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto1ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto1italiano);
            }
            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto1ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto1portugues);
            }
            if (l7.equals("ja")) {
                mp = MediaPlayer.create(this, R.raw.texto1japones);
            }
        }
        if (ins.equals("A2"))
        {
            numero.setText("2.");

            Titulo.setText(R.string.nivel2);
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto2frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto2aleman);
            }
            if (l7.equals("ja")) {
                mp = MediaPlayer.create(this, R.raw.texto2japones);
            }

        }
        if (ins.equals("A3"))
        {
            numero.setText("3.");
            Titulo.setText(R.string.nivel3);
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto3espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto3ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto3italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto3ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto3portugues);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto3frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto3aleman);
            }
            if (l7.equals("ja")) {
                mp = MediaPlayer.create(this, R.raw.texto3japones);
            }

        }
        if (ins.equals("V1"))
        {
            numero.setText("4.");
            Titulo.setText(R.string.Nivel1Tema2);
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto4espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto4ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto4italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto4ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto4portugues);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto4ingles);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto4ingles);
            }
            if (l7.equals("ja")) {
                mp = MediaPlayer.create(this, R.raw.texto4ingles);
            }
        }
        if (ins.equals("PS1"))
        {
            numero.setText("5.");
            Titulo.setText(R.string.TEMA3);
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto5espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto5ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto5italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto5ingles);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto5portugues);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto5frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto5aleman);
            }
            if (l7.equals("ja")) {
                mp = MediaPlayer.create(this, R.raw.texto5japones);
            }
        }
        if (ins.equals("PS2"))
        {
            Titulo.setText(R.string.TEMA3);
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("PS3"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("AO1"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("AO2"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("AO3"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("LO1"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("LO2"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("LO3"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("IS1"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("IS2"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("IS3"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("1CS1"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("1CS2"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("1CS3"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("2CS1"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("2CS2"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("2CS3"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("1CIS1"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("1CIS2"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("1CIS3"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("2CIS1"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("2CIS2"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }
        if (ins.equals("2CIS3"))
        {
            if (l7.equals("es")) {
                mp = MediaPlayer.create(this, R.raw.texto2espanol);
            }
            if (l7.equals("en")) {
                mp = MediaPlayer.create(this, R.raw.texto2ingles);
            }
            if (l7.equals("it")) {
                mp = MediaPlayer.create(this, R.raw.texto2italiano);
            }
            if (l7.equals("ru")) {
                mp = MediaPlayer.create(this, R.raw.texto2ruso);
            }
            if (l7.equals("pt")) {
                mp = MediaPlayer.create(this, R.raw.texto2portuges);
            }

            if (l7.equals("fr")) {
                mp = MediaPlayer.create(this, R.raw.texto1frances);
            }
            if (l7.equals("de")) {
                mp = MediaPlayer.create(this, R.raw.texto1aleman);
            }
        }



        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                Intent intent=new Intent(getApplication(), Ins_nivel1Activity.class);
                if (ins.equals("A1"))
                {
                    intent.putExtra("ins","A1");
                    startActivity(intent);
                }
                if (ins.equals("A2"))
                {
                    intent.putExtra("ins","A2");
                    startActivity(intent);
                }
                if (ins.equals("A3"))
                {
                    intent.putExtra("ins","A3");
                    startActivity(intent);
                }
                if (ins.equals("V1"))
                {
                    intent.putExtra("ins","V1");
                    startActivity(intent);
                }
                if (ins.equals("PS1"))
                {
                    intent.putExtra("ins","PS1");
                    startActivity(intent);
                }
                if (ins.equals("PS2"))
                {
                    intent.putExtra("ins","PS2");
                    startActivity(intent);
                }
                if (ins.equals("PS3"))
                {
                    intent.putExtra("ins","PS3");
                    startActivity(intent);
                }
                if (ins.equals("AO1"))
                {
                    intent.putExtra("ins","AO1");
                    startActivity(intent);
                }
                if (ins.equals("AO2"))
                {
                    intent.putExtra("ins","AO2");
                    startActivity(intent);
                }
                if (ins.equals("AO3"))
                {
                    intent.putExtra("ins","AO3");
                    startActivity(intent);
                }
                if (ins.equals("LO1"))
                {
                    intent.putExtra("ins","LO1");
                    startActivity(intent);
                }
                if (ins.equals("LO2"))
                {
                    intent.putExtra("ins","LO2");
                    startActivity(intent);
                }
                if (ins.equals("LO3"))
                {
                    intent.putExtra("ins","LO3");
                    startActivity(intent);
                }
                if (ins.equals("IS1"))
                {
                    intent.putExtra("ins","IS1");
                    startActivity(intent);
                }
                if (ins.equals("IS2"))
                {
                    intent.putExtra("ins","IS2");
                    startActivity(intent);
                }
                if (ins.equals("IS3"))
                {
                    intent.putExtra("ins","IS3");
                    startActivity(intent);
                }
                if (ins.equals("1CS1"))
                {
                    intent.putExtra("ins","1CS1");
                    startActivity(intent);
                }
                if (ins.equals("1CS2"))
                {
                    intent.putExtra("ins","1CS2");
                    startActivity(intent);
                }
                if (ins.equals("1CS3"))
                {
                    intent.putExtra("ins","2CS3");
                    startActivity(intent);
                }
                if (ins.equals("2CS1"))
                {
                    intent.putExtra("ins","2CS1");
                    startActivity(intent);
                }
                if (ins.equals("2CS2"))
                {
                    intent.putExtra("ins","2CS2");
                    startActivity(intent);
                }
                if (ins.equals("2CS3"))
                {
                    intent.putExtra("ins","2CS3");
                    startActivity(intent);
                }
                if (ins.equals("1CIS1"))
                {
                    intent.putExtra("ins","1CIS1");
                    startActivity(intent);
                }
                if (ins.equals("1CIS2"))
                {
                    intent.putExtra("ins","1CIS2");
                    startActivity(intent);
                }
                if (ins.equals("1CIS3"))
                {
                    intent.putExtra("ins","2CIS3");
                    startActivity(intent);
                }
                if (ins.equals("2CIS1"))
                {
                    intent.putExtra("ins","2CIS1");
                    startActivity(intent);
                }
                if (ins.equals("2CIS2"))
                {
                    intent.putExtra("ins","2CIS2");
                    startActivity(intent);
                }
                if (ins.equals("2CIS3"))
                {
                    intent.putExtra("ins","2CIS3");
                    startActivity(intent);
                }
                finish();
            }
        });

        mp.setLooping(true);
        mp.seekTo(0);
        totalTime = mp.getDuration();
        positionBar = (SeekBar) findViewById(R.id.seekbar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mp.seekTo(progress);
                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mp != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mp.getCurrentPosition();
                        handler.sendMessage(msg);

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();


        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()) {
                    mp.start();
                    playBtn.setBackgroundResource(R.drawable.ic_pause);
                } else {
                    mp.pause();
                    playBtn.setBackgroundResource(R.drawable.ic_play_button);
                }

            }
        });



    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int currentPosition = msg.what;
            positionBar.setProgress(currentPosition);
            String elapsedTime = CreateTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime = CreateTimeLabel(totalTime-currentPosition);
            remainingTimeLabel.setText("- "+remainingTime);
        }
    };

    public String CreateTimeLabel(int time){
        String timeLabel= "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return  timeLabel;
    }
    public void onBackPressed() {
        mp.stop();
        finish();
    }

}