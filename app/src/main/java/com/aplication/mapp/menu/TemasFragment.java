package com.aplication.mapp.menu;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;
import java.util.Objects;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;

import static android.Manifest.permission.RECORD_AUDIO;


public class TemasFragment extends Fragment implements AIListener{

    View view;

    private TextToSpeech mTextToSpeech;

    private AIService aiService;
    String l7 = Locale.getDefault().getLanguage();

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    private LinearLayout tema1,tema2,tema3,tema4,tema5,tema6,tema7,tema8,tema9,tema10;

    private FloatingActionButton voice;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AIConfiguration config = null;
        if (l7.equals("es"))
        {
            config = new AIConfiguration("ecefad8a80fc4953a57e59f8ceec9e2e",
                    AIConfiguration.SupportedLanguages.Spanish,
                    AIConfiguration.RecognitionEngine.System);
        }
        else if (l7.equals("en"))
        {
            config = new AIConfiguration("ecefad8a80fc4953a57e59f8ceec9e2e",
                    AIConfiguration.SupportedLanguages.English,
                    AIConfiguration.RecognitionEngine.System);

        }
        else
        {
            config = new AIConfiguration("ecefad8a80fc4953a57e59f8ceec9e2e",
                    AIConfiguration.SupportedLanguages.English,
                    AIConfiguration.RecognitionEngine.System);
        }
        view = inflater.inflate(R.layout.fragment_temas, container, false);
        if (ConectionManager.checkConection(getContext()))
        {

        }
        else
        {
            Intent intent=new Intent(getContext(), InternetConectionActivity.class);
            startActivity(intent);
        }

        voice = (FloatingActionButton) view.findViewById(R.id.voice);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
        tema1 = (LinearLayout) view.findViewById(R.id.tema1);
        tema2 = (LinearLayout) view.findViewById(R.id.tema2);
        tema3 = (LinearLayout) view.findViewById(R.id.tema3);
        tema4 = (LinearLayout) view.findViewById(R.id.tema4);
        tema5 = (LinearLayout) view.findViewById(R.id.tema5);
        tema6 = (LinearLayout) view.findViewById(R.id.tema6);
        tema7 = (LinearLayout) view.findViewById(R.id.tema7);
        tema8 = (LinearLayout) view.findViewById(R.id.tema8);
        tema9 = (LinearLayout) view.findViewById(R.id.tema9);
        tema10 = (LinearLayout) view.findViewById(R.id.tema10);

        String id=firebaseAuth.getCurrentUser().getUid();
        databaseReference.child("users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String n1t2 = dataSnapshot.child("tiempo_n5t1").getValue().toString();
                    String n1t3 = dataSnapshot.child("tiempo_n5t2").getValue().toString();
                    String n1t4 = dataSnapshot.child("tiempo_n5t3").getValue().toString();
                    String n1t5 = dataSnapshot.child("tiempo_n5t4").getValue().toString();
                    String n1t6 = dataSnapshot.child("tiempo_n5t5").getValue().toString();
                    String n1t7 = dataSnapshot.child("tiempo_n5t6").getValue().toString();
                    String n1t8 = dataSnapshot.child("tiempo_n5t7").getValue().toString();
                    String n1t9 = dataSnapshot.child("tiempo_n5t8").getValue().toString();
                    String n1t10 = dataSnapshot.child("tiempo_n5t9").getValue().toString();



                    if (!n1t2.equals("a"))
                    {
                        tema2.setVisibility(View.VISIBLE);
                    }
                    if (!n1t3.equals("a"))
                    {
                        tema3.setVisibility(View.VISIBLE);
                    }
                    if (!n1t4.equals("a"))
                    {
                        tema4.setVisibility(View.VISIBLE);
                    }
                    if (!n1t5.equals("a"))
                    {
                        tema5.setVisibility(View.VISIBLE);
                    }
                    if (!n1t6.equals("a"))
                    {
                        tema6.setVisibility(View.VISIBLE);
                    }
                    if (!n1t7.equals("a"))
                    {
                        tema7.setVisibility(View.VISIBLE);
                    }
                    if (!n1t8.equals("a"))
                    {
                        tema8.setVisibility(View.VISIBLE);
                    }
                    if (!n1t9.equals("a"))
                    {
                        tema9.setVisibility(View.VISIBLE);
                    }
                    if (!n1t10.equals("a"))
                    {
                        tema10.setVisibility(View.VISIBLE);
                    }





                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });

        aiService = AIService.getService(getActivity(), config);
        aiService.setListener(this);

        mTextToSpeech = new TextToSpeech(getActivity(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
            }
        });
        voice.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                voice.setBackgroundColor(R.color.GRIS);
                aiService.startListening();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void run() {
                        voice.setBackgroundColor(R.color.NEGRO);
                    }
                }, 1000);
            }
        });


        validaPermisos();


        return view;
    }

    private boolean validaPermisos() {

        int permisoAudio= ActivityCompat.checkSelfPermission(Objects.requireNonNull(getActivity()), RECORD_AUDIO);

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
            return true;
        }

        if(permisoAudio== PackageManager.PERMISSION_GRANTED){
            return true;
        }

        if((shouldShowRequestPermissionRationale(RECORD_AUDIO)) ){
            cargarDialogoRecomendacion();
        }else{
            requestPermissions(new String[]{RECORD_AUDIO},100);
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100){
            if(grantResults.length==1 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            }else{
                solicitarPermisosManual();
            }
        }

    }

    private void solicitarPermisosManual() {
        final CharSequence[] opciones={"si","no"};
        final AlertDialog.Builder alertOpciones=new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        alertOpciones.setTitle("¿Desea configurar los permisos de forma manual?");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("si")){
                    Intent intent=new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri= Uri.fromParts("package",getTag(),null);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
                    Toast.makeText(getActivity(),"Los permisos no fueron aceptados",Toast.LENGTH_SHORT).show();
                    dialogInterface.dismiss();
                }
            }
        });
        alertOpciones.show();
    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo=new AlertDialog.Builder(Objects.requireNonNull(getActivity()));
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                requestPermissions(new String[]{RECORD_AUDIO},100);
            }
        });
        dialogo.show();
    }



    @Override
    public void onResult(AIResponse response) {

        Result result = response.getResult();
        mTextToSpeech.speak(result.getFulfillment().getSpeech(), TextToSpeech.QUEUE_FLUSH, null, null);

    }

    @Override
    public void onError(AIError error) {
        Log.d("tag", error.toString());
    }

    @Override
    public void onAudioLevel(float level) {

    }

    @Override
    public void onListeningStarted() {

    }

    @Override
    public void onListeningCanceled() {

    }

    @Override
    public void onListeningFinished() {

    }
}
