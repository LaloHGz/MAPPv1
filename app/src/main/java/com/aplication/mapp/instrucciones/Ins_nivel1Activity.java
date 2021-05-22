package com.aplication.mapp.instrucciones;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.niveles.algoritmos.Nivel1Activity;
import com.aplication.mapp.niveles.algoritmos.Nivel5Activity;
import com.aplication.mapp.niveles.print.Nivel1PrintActivity;
import com.aplication.mapp.niveles.variables.Nivel1variablesActivity;
import com.aplication.mapp.niveles.variables.Nivel2variablesActivity;
import com.aplication.mapp.niveles.variables.Nivel3variablesActivity;
import com.aplication.mapp.niveles.variables.Nivel4variablesActivity;
import com.aplication.mapp.niveles.variables.Nivel5variablesActivity;

public class Ins_nivel1Activity extends AppCompatActivity {
    private  Typeface Good_sans;
    private  TextView Texto2;
    private  TextView Texto1;
    private  TextView Title;
    private Button Buttonstart;

    String nivel="0";
    Animation frombottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ins_nivel1);

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
        //Title.setTypeface(Good_sans);

        Texto2=findViewById(R.id.txt_el2);
        //Texto2.setTypeface(Good_sans);

        Texto1=findViewById(R.id.txt_e1);
        //Texto1.setTypeface(Good_sans);

        Buttonstart=findViewById(R.id.bton_nextlvl1n);
        //Buttonstart.setTypeface(Good_sans);


//        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        //      Buttonstart.setAnimation(frombottom);

        if (ins.equals("A1"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);
        }
        if (ins.equals("A2"))
        {
            Title.setText(R.string.nivel2);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl2);
        }
        if (ins.equals("A3"))
        {
            Title.setText(R.string.nivel3);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl3);
        }
        if (ins.equals("A4"))
        {
            Title.setText(R.string.nivel4);
            Texto1.setText(R.string.Insnivel4Tema2);
            Texto2.setText(R.string.ejmplolvl1);
        }
        if (ins.equals("A5"))
        {
            Title.setText(R.string.Nivel5alg);
            Texto1.setText(R.string.Nivel5insalg);
            Texto2.setText(R.string.ejmplolvl1);
        }





        if (ins.equals("V1"))
        {
            Title.setText(R.string.Variables1);
            Texto1.setText("");
            Texto2.setText(R.string.Insnivel1tema2);
        }
        if (ins.equals("V2"))
        {
            Title.setText(R.string.Variables2);
            Texto1.setText("");
            Texto2.setText(R.string.Insnivel2Tema2);
        }
        if (ins.equals("V3"))
        {
            Title.setText(R.string.Variables3);
            Texto1.setText(R.string.insNivel4var);
            Texto2.setText(R.string.ejmplolvlvar4);
        }
        if (ins.equals("V4"))
        {
            Title.setText(R.string.Variables4);
            Texto1.setText("");
            Texto2.setText(R.string.ejemploNivel5Tema2);
        }
        if (ins.equals("V5"))
        {
            Title.setText(R.string.Variables5);
            Texto1.setText("");
            Texto2.setText(R.string.ejemploNivel5Tema2);
        }
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




        if (ins.equals("PS1"))
        {
            Title.setText(R.string.PS1);
            Texto1.setText(R.string.ins_n1_t3);
            Texto2.setText(R.string.ejmplolvl1_t3);

        }
        if (ins.equals("PS2"))
        {
            Title.setText(R.string.PS2);
            Texto1.setText(R.string.ins_n2_t3);
            Texto2.setText(R.string.ejmplolvl1_t3);

        }
        if (ins.equals("PS3"))
        {
            Title.setText(R.string.PS3);
            Texto1.setText(R.string.ins_n3_t3);
            Texto2.setText(R.string.ejmplolvl3_t3);

        }
        if (ins.equals("PS4"))
        {
            Title.setText(R.string.PS4);
            Texto1.setText(R.string.ins_n4_t3);
            Texto2.setText(R.string.ejmplolvl3_t3);

        }
        if (ins.equals("PS5"))
        {
            Title.setText(R.string.PS5);
            Texto1.setText(R.string.ins_n5_t3);
            Texto2.setText(R.string.ejmplolvl5_t3);

        }







        if (ins.equals("AO1"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("AO2"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("AO3"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("AO4"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("AO5"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }











        if (ins.equals("LO1"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("LO2"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("LO3"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("LO4"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("LO5"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }














        if (ins.equals("IS1"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("IS2"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("IS3"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("IS4"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("IS5"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }














        if (ins.equals("1CS1"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("1CS2"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("1CS3"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("1CS4"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("1CS5"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }










        if (ins.equals("2CS1"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("2CS2"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("2CS3"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("2CS4"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("2CS5"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }












        if (ins.equals("1CIS1"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("1CIS2"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("1CIS3"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("1CIS4"))
        {
            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);

        }
        if (ins.equals("1CIS5"))
        {

            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);
        }














        if (ins.equals("2CIS1"))
        {

            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);
        }
        if (ins.equals("2CIS2"))
        {

            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);
        }
        if (ins.equals("2CIS3"))
        {

            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);
        }
        if (ins.equals("2CIS4"))
        {

            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);
        }
        if (ins.equals("2CIS5"))
        {

            Title.setText(R.string.nivel1);
            Texto1.setText(R.string.instruccion);
            Texto2.setText(R.string.ejmplolvl1);
        }

        Buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ins.equals("A1"))
                {
                    nivel="Lvl 1";
                    Intent intent=new Intent(getApplication(), Nivel1Activity.class);
                    intent.putExtra("niv",nivel);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("A2"))
                {
                    nivel="Lvl 2";
                    Intent intent=new Intent(getApplication(), Nivel1Activity.class);
                    intent.putExtra("niv",nivel);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("A3"))
                {
                    nivel="Lvl 3";
                    Intent intent=new Intent(getApplication(), Nivel1Activity.class);
                    intent.putExtra("niv",nivel);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("A4"))
                {
                    nivel="Lvl 4";
                    Intent intent=new Intent(getApplication(), Nivel1Activity.class);
                    intent.putExtra("niv",nivel);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("A5"))
                {
                    Intent intent=new Intent(getApplication(), Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("V1"))
                {
                    Intent intent=new Intent(getApplication(), Nivel1variablesActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("V2"))
                {
                    Intent intent=new Intent(getApplication(), Nivel2variablesActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("V3"))
                {
                    Intent intent=new Intent(getApplication(), Nivel4variablesActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("V4"))
                {
                    Intent intent=new Intent(getApplication(), Nivel3variablesActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("V5"))
                {
                    Intent intent=new Intent(getApplication(), Nivel5variablesActivity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("PS1"))
                {
                    nivel="Lvl 1";
                    Intent intent=new Intent(getApplication(), Nivel1PrintActivity.class);
                    intent.putExtra("niv",nivel);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("PS2"))
                {
                    nivel="Lvl 2";
                    Intent intent=new Intent(getApplication(), Nivel1PrintActivity.class);
                    intent.putExtra("niv",nivel);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("PS3"))
                {
                    nivel="Lvl 3";
                    Intent intent=new Intent(getApplication(), Nivel1PrintActivity.class);
                    intent.putExtra("niv",nivel);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("PS4"))
                {
                    nivel="Lvl 4";
                    Intent intent=new Intent(getApplication(), Nivel1PrintActivity.class);
                    intent.putExtra("niv",nivel);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("PS5"))
                {
                    nivel="Lvl 5";
                    Intent intent=new Intent(getApplication(), Nivel1PrintActivity.class);
                    intent.putExtra("niv",nivel);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("AO1"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("AO2"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("AO3"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("AO4"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("AO5"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("LO1"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("LO2"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("LO3"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("LO4"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("LO5"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("IS1"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("IS2"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("IS3"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("IS4"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("IS5"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CS1"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CS2"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CS3"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CS4"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CS5"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CS1"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CS2"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CS3"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CS4"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CS5"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CIS1"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CIS2"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CIS3"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CIS4"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("1CIS5"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CIS1"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CIS2"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CIS3"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CIS4"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
                if (ins.equals("2CIS5"))
                {
                    Intent intent=new Intent(getApplication(),Nivel5Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }

}