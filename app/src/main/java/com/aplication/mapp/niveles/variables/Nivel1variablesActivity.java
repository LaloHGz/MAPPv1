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

public class Nivel1variablesActivity extends AppCompatActivity {
    private Typeface Good_sans;
    TextView Tipos,Palabra,Entero,Decimal;
    EditText EPalabra,EEntero,EDecimal;
    Button Check;
    Animation frombottom;
    String mystring="";
    String nivel="Lvl 1";
    String tema="";
    String l7 = Locale.getDefault().getLanguage();
    private Chronometer Chronometro;
    Boolean correr=false;
    long detenerse;
    private MediaPlayer mp;
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
        setContentView(R.layout.activity_nivel1variables);

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
        this.Good_sans=Typeface.createFromAsset(getAssets(),fuete2);

        Chronometro=findViewById(R.id.chrono);

        Tipos=findViewById(R.id.tv_tipos_datos);
        //Tipos.setTypeface(Good_sans);

        Palabra=findViewById(R.id.tv_palabra);
        //Palabra.setTypeface(Good_sans);

        Entero=findViewById(R.id.tv_entero);
        //Entero.setTypeface(Good_sans);

        Decimal=findViewById(R.id.tv_decimal);
        //Decimal.setTypeface(Good_sans);

        EPalabra=findViewById(R.id.et_palabra);
        //EPalabra.setTypeface(Good_sans);

        EEntero=findViewById(R.id.et_entero);
        //EEntero.setTypeface(Good_sans);

        EDecimal=findViewById(R.id.et_decimal);
        //EDecimal.setTypeface(Good_sans);

        Check= findViewById(R.id.bton_check2);
        //Check.setTypeface(Good_sans);

        frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom);
        animationView = (LottieAnimationView) findViewById(R.id.animation_checkmark);

        Check.setAnimation(frombottom);
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
        String Palabra=EPalabra.getText().toString();
        String Entero=EEntero.getText().toString();
        String Decimal=EDecimal.getText().toString();
        int N=0;

        if (Palabra.equals("String") || Palabra.equals("Cadena de Caracteres") || Palabra.equals("Palabra") || Palabra.equals("palabra") || Palabra.equals("Palabras") || Palabra.equals("palabras") || Palabra.equals("string") || Palabra.equals("STRING") || Palabra.equals("Cadena de caracteres") || Palabra.equals("cadena de caracteres") || Palabra.equals("str") || Palabra.equals("Str") || Palabra.equals("STR")|| Palabra.equals("PALABRA (CADENA DE CARACTERRES/STR)")|| Palabra.equals("Palabra (cadena de caracteres/str)")|| Palabra.equals("palabra (cadena de caracteres/str)")|| Palabra.equals("Palabra (Cadena de caracteres/str)")
                ||   Palabra.equals("String of Characters") || Palabra.equals("Word") || Palabra.equals("word") || Palabra.equals("Words") || Palabra.equals("words") || Palabra.equals("string of characters") || Palabra.equals("String of characters")
                ||   Palabra.equals("Cadeia de caracteres") || Palabra.equals("Palavra")||   Palabra.equals("cadeia de caracteres") || Palabra.equals("palavra")|| Palabra.equals("Parola") || Palabra.equals("parola")|| Palabra.equals("PAROLA") || Palabra.equals("Stringa di caratteri")|| Palabra.equals("stringa di caratteri")|| Palabra.equals("STRINGA DI CARATTERI")|| Palabra.equals("Слово") || Palabra.equals("Символьная строка")|| Palabra.equals("строка символов")
                || Palabra.equals("Palavras")|| Palabra.equals("palavras")|| Palabra.equals("PALAVRAS")|| Palabra.equals("PALAVRA")|| Palabra.equals("Parole")|| Palabra.equals("parole")|| Palabra.equals("PAROLE")
                || Palabra.equals("Wörter")|| Palabra.equals("wörter")|| Palabra.equals("Wort")|| Palabra.equals("wort")|| Palabra.equals("WÖRTER")|| Palabra.equals("WORT") || Palabra.equals("Zeichenfolge")|| Palabra.equals("zeichenfolge")|| Palabra.equals("ZEICHENFOLGE")|| Palabra.equals("Mot")|| Palabra.equals("MOT")|| Palabra.equals("mot")|| Palabra.equals("Mots")|| Palabra.equals("mots")|| Palabra.equals("MOTS") || Palabra.equals("Les mots")|| Palabra.equals("Les Mots")|| Palabra.equals("les mots")|| Palabra.equals("LES MOTS")
                || Palabra.equals("chaîne de caractères")|| Palabra.equals("Chaîne de Caractères")|| Palabra.equals("Chaîne de caractères") || Palabra.equals("CHAÎNE DE CARACTÈRES")) {
            N++;
        }

        if (Entero.equals("Entero") || Entero.equals("Int") || Entero.equals("int") || Entero.equals("INT") || Entero.equals("Numero Entero") || Entero.equals("Número Entero") || Entero.equals("Numero entero") || Entero.equals("Número entero") || Entero.equals("Numeros Enteros") || Entero.equals("numeros enteros") || Entero.equals("número entero")|| Entero.equals("números enteros")|| Entero.equals("Números enteros") || Entero.equals("Numero(s) Entero(s)") || Entero.equals("numero entero") || Entero.equals("numero(s) entero(s)")|| Entero.equals("Numero(s) enteros")|| Entero.equals("Numero(s) Enteros")|| Entero.equals("Numero(s) enteros (Float)")|| Entero.equals("Numero(s) Enteros (float)")|| Entero.equals("Numero(s) enteros(float)")|| Entero.equals("Numero(s) Enteros(Float)")|| Entero.equals("numero(s) enteros(float)")|| Entero.equals("numero(s) enteros")|| Entero.equals("numero(s) Enteros")
                ||Entero.equals("Integer")||Entero.equals("integer")||Entero.equals("INTEGER") || Entero.equals("Number Integer") || Entero.equals("Number integer") || Entero.equals("number integer") || Entero.equals("Numbers Integers") || Entero.equals("numbers integers") || Entero.equals("Number(s) Integer(s)") || Entero.equals("number(s) integer(s)")
                || Entero.equals("Весь")|| Entero.equals("целое число")|| Entero.equals("целое")|| Entero.equals("intero")|| Entero.equals("numero intero")|| Entero.equals("Intero")|| Entero.equals("Numero intero")|| Entero.equals("INTERO")|| Entero.equals("NUMERO INTERO")|| Entero.equals("número inteiro")|| Entero.equals("Número inteiro")|| Entero.equals("Número Inteiro")|| Entero.equals("inteiro")|| Entero.equals("Inteiro")|| Entero.equals("INTEIRO")|| Entero.equals("número(s) inteiro(s)")
                || Entero.equals("numero(i) intero(i)")|| Entero.equals("Numero(i) intero(i)")|| Entero.equals("Numero(i) Intero(i)") || Entero.equals("Entier")|| Entero.equals("entier")|| Entero.equals("ENTIER")|| Entero.equals("Ganze")|| Entero.equals("ganze")|| Entero.equals("GANZE")|| Entero.equals("Ganzzahl")|| Entero.equals("ganzzahl")|| Entero.equals("GANZZAHL")|| Entero.equals("GANZE NUMMER")|| Entero.equals("Ganze Nummer")|| Entero.equals("Ganze nummer")|| Entero.equals("ganze nummer")
                || Entero.equals("Ganze Zahl(en)")|| Entero.equals("ganze zahl(en)")|| Entero.equals("Ganze zahl(en)")|| Entero.equals("GANZE ZAHL(EN)")|| Entero.equals("Целый номер(ы)")) {
            N++;
        }
        if (Decimal.equals("float") || Decimal.equals("Float") || Decimal.equals("Numero decimal") || Decimal.equals("Número decimal") || Decimal.equals("número decimal") || Decimal.equals("Numero Decimal") || Decimal.equals("Número Decimal")|| Decimal.equals("Números Decimales")|| Decimal.equals("Números decimales")|| Decimal.equals("números decimales") || Decimal.equals("FLOAT")|| Decimal.equals("Numeros decimales")|| Decimal.equals("NUMEROS DECIMALES")|| Decimal.equals("Numeros decimales (Float)")|| Decimal.equals("NUMEROS DECIMALES (FLOAT)")
                ||  Decimal.equals("Decimal Numbers") || Decimal.equals("Decimal number") || Decimal.equals("decimal number") || Decimal.equals("Decimal Number") || Decimal.equals("DECIMAL NUMBER")
                ||  Decimal.equals("numero decimale")||  Decimal.equals("Numero decimale")||  Decimal.equals("Numero Decimale")||  Decimal.equals("NUMERO DECIMALE")||  Decimal.equals("десятичное число")|| Decimal.equals("Десятичное число") || Decimal.equals("Dezimalzahl")|| Decimal.equals("dezimalzahl")|| Decimal.equals("DEZIMALZAHL")|| Decimal.equals("Nombre décimal")|| Decimal.equals("Nombre Décimal")|| Decimal.equals("nombre décimal")|| Decimal.equals("DIXIÈME NUMÉRO")|| Decimal.equals("NOMBRE DÉCIMAL")|| Decimal.equals("nombre decimal")|| Decimal.equals("Nombre decimal")) {
            N++;
        }

        if (N==3)
        {
            Tipos.setVisibility(View.GONE);
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
                    String nive="2";
                        String elapsedMillis = Chronometro_check.getText().toString();
                        databaseReference.child("users").child(id).child("tiempo_n1t2").setValue(elapsedMillis);
                        if (numero<7) {
                            databaseReference.child("users").child(id).child("nivel").setValue("7");
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