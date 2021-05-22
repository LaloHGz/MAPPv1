package com.aplication.mapp.menu;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditUserActivity extends AppCompatActivity {


    private  Spinner pais,formato;
    private Button bton_back,update,adelante,atras;

    private CircleImageView personaje;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    private TextView tv_personaje,tv_titulo,tv_usuario,tv_edad,tv_pais,tv_fornato;

    private TextInputLayout textInputUser,textInputEdad;
    private TextInputEditText et_usuario,et_edad;

    private int[] Personaje = {
            R.drawable.laoshi,
            R.drawable.felis,
            R.drawable.houyi,
            R.drawable.kin,
    };

    Double i=0.0;

    Typeface ttnorms_medium;
    private String tipo="";;
    private String l7 = Locale.getDefault().getLanguage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        if (ConectionManager.checkConection(getBaseContext()))
        {

        }
        else
        {
            Intent intent=new Intent(getApplication(), InternetConectionActivity.class);
            startActivity(intent);
        }

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        pais = (Spinner) findViewById(R.id.sp_Pais);

        formato = (Spinner) findViewById(R.id.sp_Formato);

        update = (Button) findViewById(R.id.boton_Actualizar);

        bton_back = (Button) findViewById(R.id.boton_back);

        textInputUser = (TextInputLayout) findViewById(R.id.text_input_user);
        textInputEdad = (TextInputLayout) findViewById(R.id.text_input_edad);

        et_edad = (TextInputEditText) findViewById(R.id.et_Edad);
        et_usuario = (TextInputEditText) findViewById(R.id.et_Usuario);


        adelante = (Button) findViewById(R.id.boton_adelante);
        atras = (Button) findViewById(R.id.boton_atras);
        personaje = (CircleImageView) findViewById(R.id.iv_personaje);
        tv_personaje = (TextView) findViewById(R.id.tv_personaje);


        tv_titulo=(TextView)findViewById(R.id.tv_change);

        tv_usuario=(TextView)findViewById(R.id.Tv_Us);

        tv_edad=(TextView)findViewById(R.id.Tv_Ed);

        tv_pais=(TextView)findViewById(R.id.Tv_Pa);

        tv_fornato=(TextView)findViewById(R.id.Tv_For);





        ArrayAdapter<String> adapter =  new ArrayAdapter<>(this,
                R.layout.custom_spinner,getResources().getStringArray(R.array.Pais));
        adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
        pais.setAdapter(adapter);


        if(l7.equals("es"))
        {
            ArrayAdapter<String> adapter1 =  new ArrayAdapter<>(this,
                    R.layout.custom_spinner,getResources().getStringArray(R.array.Formatoes));
            adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
            formato.setAdapter(adapter1);
        }
        if(l7.equals("en"))
        {
            ArrayAdapter<String> adapter1 =  new ArrayAdapter<>(this,
                    R.layout.custom_spinner,getResources().getStringArray(R.array.Formatoen));
            adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
            formato.setAdapter(adapter1);
        }
        if(l7.equals("it"))
        {
            ArrayAdapter<String> adapter1 =  new ArrayAdapter<>(this,
                    R.layout.custom_spinner,getResources().getStringArray(R.array.Formatoit));
            adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
            formato.setAdapter(adapter1);
        }
        if(l7.equals("pt"))
        {
            ArrayAdapter<String> adapter1 =  new ArrayAdapter<>(this,
                    R.layout.custom_spinner,getResources().getStringArray(R.array.Formatopt));
            adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
            formato.setAdapter(adapter1);
        }
        if(l7.equals("ru"))
        {
            ArrayAdapter<String> adapter1 =  new ArrayAdapter<>(this,
                    R.layout.custom_spinner,getResources().getStringArray(R.array.Formatoru));
            adapter.setDropDownViewResource(R.layout.custom_spinner_dropdown);
            formato.setAdapter(adapter1);
        }




        final String id=firebaseAuth.getCurrentUser().getUid();
        databaseReference.child("users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String us= dataSnapshot.child("usuario").getValue().toString();
                    String ed= dataSnapshot.child("Edad").getValue().toString();

                    String per=dataSnapshot.child("personaje").getValue().toString();

                    String pa=dataSnapshot.child("Pais").getValue().toString();
                    String form=dataSnapshot.child("formato").getValue().toString();

                    if (form.equals("Written")|| form.equals("Escrito")|| form.equals("Scritto")|| form.equals("Письменный")) {
                        formato.setSelection(0);
                    }
                    if (form.equals("Narrated")|| form.equals("Narrado")|| form.equals("Narrato")|| form.equals("повествовать")) {
                        formato.setSelection(1);
                    }
                    if (form.equals("Comic")|| form.equals("Quadrinho")|| form.equals("Fumetto")|| form.equals("Комикс")) {

                        formato.setSelection(2);
                    }

                    if (pa.equals("México"))
                    {
                        pais.setSelection(0);
                    }
                    if (pa.equals("United States"))
                    {
                        pais.setSelection(1);
                    }
                    if (pa.equals("Shqipërisë"))
                    {
                        pais.setSelection(2);
                    }
                    if (pa.equals("Argelia"))
                    {
                        pais.setSelection(3);
                    }
                    if (pa.equals("Angola"))
                    {
                        pais.setSelection(4);
                    }
                    if (pa.equals("Antigua y Barbuda"))
                    {
                        pais.setSelection(5);
                    }
                    if (pa.equals("Argentina"))
                    {
                        pais.setSelection(6);
                    }
                    if (pa.equals("Armenia"))
                    {
                        pais.setSelection(7);
                    }
                    if (pa.equals("Aruba"))
                    {
                        pais.setSelection(8);
                    }
                    if (pa.equals("Australia"))
                    {
                        pais.setSelection(9);
                    }
                    if (pa.equals("Austria"))
                    {
                        pais.setSelection(10);
                    }
                    if (pa.equals("Azerbaiyán"))
                    {
                        pais.setSelection(11);
                    }
                    if (pa.equals("Bahamas"))
                    {
                        pais.setSelection(12);
                    }
                    if (pa.equals("Baréin"))
                    {
                        pais.setSelection(13);
                    }
                    if (pa.equals("Bangladesh"))
                    {
                        pais.setSelection(14);
                    }
                    if (pa.equals("Bielorrusia"))
                    {
                        pais.setSelection(15);
                    }
                    if (pa.equals("Bélgica"))
                    {
                        pais.setSelection(16);
                    }
                    if (pa.equals("Belice"))
                    {
                        pais.setSelection(17);
                    }
                    if (pa.equals("Benín"))
                    {
                        pais.setSelection(18);
                    }
                    if (pa.equals("Bolivia"))
                    {
                        pais.setSelection(19);
                    }
                    if (pa.equals("Bosnia y Herzegovina"))
                    {
                        pais.setSelection(20);
                    }
                    if (pa.equals("Botsuana"))
                    {
                        pais.setSelection(21);
                    }
                    if (pa.equals("Brasil"))
                    {
                        pais.setSelection(22);
                    }
                    if (pa.equals("Bulgaria"))
                    {
                        pais.setSelection(23);
                    }
                    if (pa.equals("Burkina Faso"))
                    {
                        pais.setSelection(24);
                    }
                    if (pa.equals("Camboya"))
                    {
                        pais.setSelection(25);
                    }
                    if (pa.equals("Camerún"))
                    {
                        pais.setSelection(26);
                    }
                    if (pa.equals("Canadá"))
                    {
                        pais.setSelection(27);
                    }
                    if (pa.equals("Cabo Verde"))
                    {
                        pais.setSelection(28);
                    }
                    if (pa.equals("Chile"))
                    {
                        pais.setSelection(29);
                    }
                    if (pa.equals("Colombia"))
                    {
                        pais.setSelection(30);
                    }
                    if (pa.equals("Costa Rica"))
                    {
                        pais.setSelection(31);
                    }
                    if (pa.equals("Croacia"))
                    {
                        pais.setSelection(32);
                    }
                    if (pa.equals("Chipre"))
                    {
                        pais.setSelection(33);
                    }
                    if (pa.equals("República Checa"))
                    {
                        pais.setSelection(34);
                    }
                    if (pa.equals("Dinamarca"))
                    {
                        pais.setSelection(35);
                    }
                    if (pa.equals("República Dominicana"))
                    {
                        pais.setSelection(36);
                    }
                    if (pa.equals("Dinamarca"))
                    {
                        pais.setSelection(37);
                    }
                    if (pa.equals("Ecuador"))
                    {
                        pais.setSelection(38);
                    }
                    if (pa.equals("Egipto"))
                    {
                        pais.setSelection(39);
                    }
                    if (pa.equals("El Salvador"))
                    {
                        pais.setSelection(40);
                    }
                    if (pa.equals("Estonia"))
                    {
                        pais.setSelection(41);
                    }
                    if (pa.equals("Fiyi"))
                    {
                        pais.setSelection(42);
                    }
                    if (pa.equals("Finlandia"))
                    {
                        pais.setSelection(43);
                    }
                    if (pa.equals("Francia"))
                    {
                        pais.setSelection(44);
                    }
                    if (pa.equals("Gabón"))
                    {
                        pais.setSelection(45);
                    }
                    if (pa.equals("Georgia"))
                    {
                        pais.setSelection(46);
                    }
                    if (pa.equals("Alemania"))
                    {
                        pais.setSelection(47);
                    }
                    if (pa.equals("Ghana"))
                    {
                        pais.setSelection(48);
                    }
                    if (pa.equals("Grecia"))
                    {
                        pais.setSelection(49);
                    }
                    if (pa.equals("Guatemala"))
                    {
                        pais.setSelection(50);
                    }
                    if (pa.equals("Guinea-Bisáu"))
                    {
                        pais.setSelection(51);
                    }
                    if (pa.equals("Haití"))
                    {
                        pais.setSelection(52);
                    }
                    if (pa.equals("Honduras"))
                    {
                        pais.setSelection(53);
                    }
                    if (pa.equals("Hong Kong"))
                    {
                        pais.setSelection(54);
                    }
                    if (pa.equals("Hungría"))
                    {
                        pais.setSelection(55);
                    }
                    if (pa.equals("Islandia"))
                    {
                        pais.setSelection(56);
                    }
                    if (pa.equals("भारत गणराज्य"))
                    {
                        pais.setSelection(57);
                    }
                    if (pa.equals("Indonesia"))
                    {
                        pais.setSelection(58);
                    }
                    if (pa.equals("מדינת ישראל"))
                    {
                        pais.setSelection(59);
                    }
                    if (pa.equals("Italia"))
                    {
                        pais.setSelection(60);
                    }
                    if (pa.equals("Jamaica"))
                    {
                        pais.setSelection(61);
                    }
                    if (pa.equals("Japón"))
                    {
                        pais.setSelection(62);
                    }
                    if (pa.equals("Jordania"))
                    {
                        pais.setSelection(63);
                    }
                    if (pa.equals("Kazajistán"))
                    {
                        pais.setSelection(64);
                    }
                    if (pa.equals("Kenia"))
                    {
                        pais.setSelection(65);
                    }
                    if (pa.equals("Kuwait"))
                    {
                        pais.setSelection(66);
                    }
                    if (pa.equals("Kirguistán"))
                    {
                        pais.setSelection(67);
                    }
                    if (pa.equals("Laos"))
                    {
                        pais.setSelection(68);
                    }
                    if (pa.equals("Letonia"))
                    {
                        pais.setSelection(69);
                    }
                    if (pa.equals("Líbano"))
                    {
                        pais.setSelection(70);
                    }
                    if (pa.equals("Liechtenstein"))
                    {
                        pais.setSelection(71);
                    }
                    if (pa.equals("Lituania"))
                    {
                        pais.setSelection(72);
                    }
                    if (pa.equals("Luxemburgo"))
                    {
                        pais.setSelection(73);
                    }
                    if (pa.equals("Macao"))
                    {
                        pais.setSelection(74);
                    }
                    if (pa.equals("Macedonia"))
                    {
                        pais.setSelection(75);
                    }
                    if (pa.equals("Malasia"))
                    {
                        pais.setSelection(76);
                    }
                    if (pa.equals("Mali"))
                    {
                        pais.setSelection(77);
                    }
                    if (pa.equals("Malta"))
                    {
                        pais.setSelection(78);
                    }
                    if (pa.equals("Mauricio"))
                    {
                        pais.setSelection(79);
                    }
                    if (pa.equals("Moldavia"))
                    {
                        pais.setSelection(80);
                    }
                    if (pa.equals("Marruecos"))
                    {
                        pais.setSelection(81);
                    }
                    if (pa.equals("Mozambique"))
                    {
                        pais.setSelection(82);
                    }
                    if (pa.equals("Myanmar"))
                    {
                        pais.setSelection(83);
                    }
                    if (pa.equals("Namibia"))
                    {
                        pais.setSelection(84);
                    }
                    if (pa.equals("Nepal"))
                    {
                        pais.setSelection(85);
                    }
                    if (pa.equals("Países Bajos"))
                    {
                        pais.setSelection(86);
                    }
                    if (pa.equals("Antillas Holandesas"))
                    {
                        pais.setSelection(87);
                    }
                    if (pa.equals("Nueva Zelanda"))
                    {
                        pais.setSelection(88);
                    }
                    if (pa.equals("Nicaragua"))
                    {
                        pais.setSelection(89);
                    }
                    if (pa.equals("Niger"))
                    {
                        pais.setSelection(90);
                    }
                    if (pa.equals("Nigeria"))
                    {
                        pais.setSelection(91);
                    }
                    if (pa.equals("Noruega"))
                    {
                        pais.setSelection(92);
                    }
                    if (pa.equals("Omán"))
                    {
                        pais.setSelection(93);
                    }
                    if (pa.equals("Pakistán"))
                    {
                        pais.setSelection(94);
                    }
                    if (pa.equals("Panamá"))
                    {
                        pais.setSelection(95);
                    }
                    if (pa.equals("Papúa Nueva Guinea"))
                    {
                        pais.setSelection(96);
                    }
                    if (pa.equals("Paraguay"))
                    {
                        pais.setSelection(97);
                    }
                    if (pa.equals("Perú"))
                    {
                        pais.setSelection(98);
                    }
                    if (pa.equals("Filipinas"))
                    {
                        pais.setSelection(99);
                    }
                    if (pa.equals("Polonia"))
                    {
                        pais.setSelection(100);
                    }
                    if (pa.equals("Portugal"))
                    {
                        pais.setSelection(101);
                    }
                    if (pa.equals("دولة قطر"))
                    {
                        pais.setSelection(102);
                    }
                    if (pa.equals("România"))
                    {
                        pais.setSelection(103);
                    }
                    if (pa.equals("Россия"))
                    {
                        pais.setSelection(104);
                    }
                    if (pa.equals("Ruanda"))
                    {
                        pais.setSelection(105);
                    }
                    if (pa.equals("Arabia Suadita"))
                    {
                        pais.setSelection(106);
                    }
                    if (pa.equals("Senegal"))
                    {
                        pais.setSelection(107);
                    }
                    if (pa.equals("Serbia"))
                    {
                        pais.setSelection(108);
                    }
                    if (pa.equals("Singapur"))
                    {
                        pais.setSelection(109);
                    }
                    if (pa.equals("Eslovaquia"))
                    {
                        pais.setSelection(110);
                    }
                    if (pa.equals("Eslovenia"))
                    {
                        pais.setSelection(111);
                    }
                    if (pa.equals("Sudáfrica"))
                    {
                        pais.setSelection(112);
                    }
                    if (pa.equals("Corea del Sur"))
                    {
                        pais.setSelection(113);
                    }
                    if (pa.equals("España"))
                    {
                        pais.setSelection(114);
                    }
                    if (pa.equals("Sri Lanka"))
                    {
                        pais.setSelection(115);
                    }
                    if (pa.equals("Suecia"))
                    {
                        pais.setSelection(116);
                    }
                    if (pa.equals("Suiza"))
                    {
                        pais.setSelection(117);
                    }
                    if (pa.equals("中華民國"))
                    {
                        pais.setSelection(118);
                    }
                    if (pa.equals("Tanzania"))
                    {
                        pais.setSelection(119);
                    }
                    if (pa.equals("Tayikistán"))
                    {
                        pais.setSelection(120);
                    }
                    if (pa.equals("ราชอาณาจักรไทย"))
                    {
                        pais.setSelection(121);
                    }
                    if (pa.equals("Togo"))
                    {
                        pais.setSelection(122);
                    }
                    if (pa.equals("Trinidad y Tobago"))
                    {
                        pais.setSelection(123);
                    }
                    if (pa.equals("Túnez"))
                    {
                        pais.setSelection(124);
                    }
                    if (pa.equals("Turquía"))
                    {
                        pais.setSelection(125);
                    }
                    if (pa.equals("Turkmenistán"))
                    {
                        pais.setSelection(126);
                    }
                    if (pa.equals("Uganda"))
                    {
                        pais.setSelection(127);
                    }
                    if (pa.equals("Ucrania"))
                    {
                        pais.setSelection(128);
                    }
                    if (pa.equals("دولة الإمارات العربية المتحدة"))
                    {
                        pais.setSelection(129);
                    }
                    if (pa.equals("United Kingdom"))
                    {
                        pais.setSelection(130);
                    }
                    if (pa.equals("Uruguay"))
                    {
                        pais.setSelection(131);
                    }
                    if (pa.equals("Uzbekistán"))
                    {
                        pais.setSelection(132);
                    }
                    if (pa.equals("Venezuela"))
                    {
                        pais.setSelection(133);
                    }
                    if (pa.equals("Vietnam"))
                    {
                        pais.setSelection(134);
                    }
                    if (pa.equals("Yemen"))
                    {
                        pais.setSelection(135);
                    }
                    if (pa.equals("Zambia"))
                    {
                        pais.setSelection(136);
                    }
                    if (pa.equals("Zimbabue"))
                    {
                        pais.setSelection(137);
                    }


                    et_usuario.setText(us);
                    et_edad.setText(ed);

                    if (per.equals("Laoshi"))
                    {
                        personaje.setImageResource(R.drawable.laoshi);
                    }
                    if (per.equals("Tizoc"))
                    {
                        personaje.setImageResource(R.drawable.felis);
                    }
                    if (per.equals("Houyi"))
                    {
                        personaje.setImageResource(R.drawable.houyi);
                    }
                    if (per.equals("Kin"))
                    {
                        personaje.setImageResource(R.drawable.kin);
                    }



                }
            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        adelante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;

                if (i==4)
                {
                    i=0.0;
                }
                if (i==0)
                {
                    personaje.setImageResource(R.drawable.laoshi);
                    tv_personaje.setText("Laoshi");
                }
                if (i==1)
                {
                    personaje.setImageResource(R.drawable.felis);
                    tv_personaje.setText("Tizoc");

                }
                if (i==2)
                {
                    personaje.setImageResource(R.drawable.houyi);
                    tv_personaje.setText("Houyi");

                }
                if (i>=3)
                {
                    personaje.setImageResource(R.drawable.kin);
                    tv_personaje.setText("Kin");
                }


            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if (i==0)
                {
                    personaje.setImageResource(R.drawable.laoshi);
                    tv_personaje.setText("Laoshi");
                }


                if (i==-1)
                {
                    i=3.0;
                }
                if (i==1)
                {
                    personaje.setImageResource(R.drawable.felis);
                    tv_personaje.setText("Tizoc");
                }
                if (i==2)
                {
                    personaje.setImageResource(R.drawable.houyi);
                    tv_personaje.setText("Houyi");

                }
                if (i==3)
                {
                    personaje.setImageResource(R.drawable.kin);
                    tv_personaje.setText("Kin");

                }


            }
        });


        final ProgressDialog progress = new ProgressDialog(this);



        bton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmInput();
                String USUARIO=et_usuario.getText().toString();
                String Edad=et_edad.getText().toString();
                String personaje=tv_personaje.getText().toString();
                String Pais=pais.getSelectedItem().toString();
                String Formato=formato.getSelectedItem().toString();
               /* String update=getString(R.string.Actualizando);
                progress.setMessage(update);
                progress.show();

                Runnable progressRunnable = new Runnable() {

                    @Override
                    public void run() {
                        progress.cancel();
                    }
                };

                Handler pdCanceller = new Handler();
                pdCanceller.postDelayed(progressRunnable, 1000);

                */
                databaseReference.child("users").child(id).child("usuario").setValue(USUARIO);
                databaseReference.child("users").child(id).child("Edad").setValue(Edad);
                databaseReference.child("users").child(id).child("Pais").setValue(Pais);
                databaseReference.child("users").child(id).child("formato").setValue(Formato);
                databaseReference.child("users").child(id).child("personaje").setValue(personaje);
                finish();

            }
        });


    }

    private boolean validateUser() {
        String emailInput = textInputUser.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputUser.setError("Field can't be empty");
            return false;
        } else {
            textInputUser.setError(null);
            return true;
        }
    }

    private boolean validateEdad() {
        String emailInput = textInputEdad.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEdad.setError("Field can't be empty");
            return false;
        } else {
            textInputEdad.setError(null);
            return true;
        }
    }

    public void confirmInput() {
        if (!validateUser() | !validateEdad()) {
            return;
        }
    }


    public void salir()
    {
        finish();
    }



}

