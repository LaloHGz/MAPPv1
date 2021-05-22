package com.aplication.mapp.niveles;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.R;
import com.aplication.mapp.instrucciones.EjerciciosTemasActivity;

public class PreguntaCheckActivity extends AppCompatActivity {

    private ImageView im_ejemplo;
    private TextView tv_ejemplo,tv_titulo;
    private Button bton_siguiente;
    private Typeface Good_sans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_check);

        String fuete2 = "fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans = Typeface.createFromAsset(getAssets(), fuete2);

        Intent intent=getIntent();
        Bundle Datos=intent.getExtras();
        final String nivel= (String)Datos.get("niv");

        tv_titulo=findViewById(R.id.tv_titulo);
        //tv_titulo.setTypeface(Good_sans);
        im_ejemplo=findViewById(R.id.image_ejemplo);
        tv_ejemplo=findViewById(R.id.tv_texto);
        bton_siguiente=findViewById(R.id.siguiente1);
        //bton_siguiente.setTypeface(Good_sans);

        if (nivel.equals("1"))
        {
            im_ejemplo.setImageResource(R.drawable.algoritmo_ejemplo);
            tv_titulo.setText(R.string.TEMA1);
            tv_ejemplo.setText("Un algoritmo informático es una secuencia de instrucciones finitas que llevan a cabo una serie de procesos para dar respuesta a determinados problemas. Es decir, un algoritmo informático resuelve cualquier problema a través de unas instrucciones y reglas concisas, mostrando el resultado obtenido.");
            bton_siguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                    intent.putExtra("niv", "1");
                    startActivity(intent);
                    finish();
                }
            });
        }

        if (nivel.equals("2"))
        {

            im_ejemplo.setImageResource(R.drawable.variables_ejemplo);
            tv_titulo.setText(R.string.TEMA2);
            tv_ejemplo.setText(" una variable está formada por un espacio en el sistema de almacenaje y un nombre simbólico (un identificador) que está asociado a dicho espacio. Ese espacio contiene una cantidad de información conocida o desconocida, es decir un valor.");
            bton_siguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                    intent.putExtra("niv", "2");
                    startActivity(intent);
                    finish();
                }
            });
        }
        if (nivel.equals("3"))
        {

            im_ejemplo.setImageResource(R.drawable.print_ejemplo);
            tv_titulo.setText(R.string.TEMA3);
            tv_ejemplo.setText("Función que permite mostrar texto en pantalla, para mostrar datos en pantalla usamos la sentencia print. Así: \" \n" +
                    "print(\"Hola mundo\")\n" +
                    "También podemos imprimir con cadenas simples: ‘\n" +
                    "print('Hola mundo')");

            bton_siguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), EjerciciosTemasActivity.class);
                    intent.putExtra("niv", "3");
                    startActivity(intent);
                    finish();
                }
            });
        }

        if (nivel.equals("4"))
        {

        }
        if (nivel.equals("5"))
        {

        }
        if (nivel.equals("6"))
        {

        }

        if (nivel.equals("7"))
        {

        }
        if (nivel.equals("8"))
        {

        }
        if (nivel.equals("9"))
        {

        }
        if (nivel.equals("10"))
        {

        }


    }
}
