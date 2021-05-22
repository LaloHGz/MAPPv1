package com.aplication.mapp.formatos;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.instrucciones.Ins_nivel1Activity;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class EscritaActivity extends AppCompatActivity {
    private Typeface Good_sans;
    private TextView Title;
    private JustifyTextView Texto1;
    private Button Siguiente;
    private Button close;
    private TextView numero;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escrita);


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


        String fuete2="fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans=Typeface.createFromAsset(getAssets(),fuete2);

        Intent intent=getIntent();
        Bundle Datos=intent.getExtras();
        final String ins= (String)Datos.get("ins");

        Title=findViewById(R.id.title_e1);

        Texto1=findViewById(R.id.texto1);

        close = findViewById(R.id.image_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Siguiente=(Button) findViewById(R.id.boton_sig);

        numero =(TextView) findViewById(R.id.numero);

        if (ins.equals("A1"))
        {
            numero.setText("1.");
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.texto1);
        }
        if (ins.equals("A2"))
        {
            numero.setText("2.");
            Title.setText(R.string.nivel2);
            Texto1.setText(R.string.texto2);
        }
        if (ins.equals("A3"))
        {
            numero.setText("3.");
            Title.setText(R.string.nivel3);
            Texto1.setText(R.string.texto3);
        }
        if (ins.equals("V1"))
        {
            numero.setText("4.");
            Title.setText(R.string.Nivel1Tema2);
            Texto1.setText(R.string.historiavariables1);
        }
        if (ins.equals("PS1"))
        {
            numero.setText("5.");
            Title.setText(R.string.TEMA3);
            Texto1.setText(R.string.sentenciasprint);
        }
        if (ins.equals("PS2"))
        {

        }
        if (ins.equals("PS3"))
        {

        }
        if (ins.equals("AO1"))
        {

        }
        if (ins.equals("AO2"))
        {

        }
        if (ins.equals("AO3"))
        {

        }
        if (ins.equals("LO1"))
        {

        }
        if (ins.equals("LO2"))
        {

        }
        if (ins.equals("LO3"))
        {

        }
        if (ins.equals("IS1"))
        {

        }
        if (ins.equals("IS2"))
        {

        }
        if (ins.equals("IS3"))
        {

        }
        if (ins.equals("1CS1"))
        {

        }
        if (ins.equals("1CS2"))
        {

        }
        if (ins.equals("1CS3"))
        {

        }
        if (ins.equals("2CS1"))
        {

        }
        if (ins.equals("2CS2"))
        {

        }
        if (ins.equals("2CS3"))
        {

        }
        if (ins.equals("1CIS1"))
        {

        }
        if (ins.equals("1CIS2"))
        {

        }
        if (ins.equals("1CIS3"))
        {

        }
        if (ins.equals("2CIS1"))
        {

        }
        if (ins.equals("2CIS2"))
        {

        }
        if (ins.equals("2CIS3"))
        {

        }


        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ins.equals("A1"))
                {
                    Intent intent=new Intent(getApplication(), Ins_nivel1Activity.class);
                    intent.putExtra("ins","A1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("A2"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","A2");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("A3"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","A3");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("V1"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","V1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("PS1"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("PS2"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS2");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("PS3"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","PS3");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("AO1"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","AO1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("AO2"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","AO2");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("AO3"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","AO3");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("LO1"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","LO1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("LO2"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","LO2");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("LO3"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","LO3");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("IS1"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","IS1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("IS2"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","IS2");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("IS3"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","IS3");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CS1"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CS1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CS2"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CS2");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CS3"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CS3");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CS1"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CS1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CS2"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CS2");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CS3"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CS3");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CIS1"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CIS1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CIS2"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","1CIS2");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CIS3"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CIS3");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CIS1"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CIS1");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CIS2"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CIS2");
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CIS3"))
                {
                    Intent intent=new Intent(getApplication(),Ins_nivel1Activity.class);
                    intent.putExtra("ins","2CIS3");
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

}

