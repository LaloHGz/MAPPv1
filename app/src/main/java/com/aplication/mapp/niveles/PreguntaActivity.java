package com.aplication.mapp.niveles;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.aplication.mapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class PreguntaActivity extends AppCompatActivity {

    private static final long START_TIME_IN_MILIS=600000;
    private TextView mTextViewCountDown,titulo;

    private TextView pregunta;
    private MediaPlayer mp;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    private CountDownTimer mCountDownTimer;

    private boolean mTimerRunning;
    private Typeface Good_sans;

    private long mTimeLeftInMilis=START_TIME_IN_MILIS;

    private ProgressBar progressBar;


    private Button respuesta1,respuesta2,respuesta3,respuesta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        Intent intent=getIntent();
        Bundle Datos=intent.getExtras();
        final String nivel= (String)Datos.get("niv");

        String fuete2 = "fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans = Typeface.createFromAsset(getAssets(), fuete2);


        titulo=findViewById(R.id.tv_titulo);
        //titulo.setTypeface(Good_sans);

        mTextViewCountDown=findViewById(R.id.text_view_countdown);
        //mTextViewCountDown.setTypeface(Good_sans);

        pregunta=findViewById(R.id.tv_pregunta);
        //pregunta.setTypeface(Good_sans);

        progressBar = findViewById(R.id.progressBar);

        respuesta1=findViewById(R.id.respuesta1);
        respuesta2=findViewById(R.id.respuesta2);
        respuesta3=findViewById(R.id.respuesta3);
        respuesta4=findViewById(R.id.respuesta4);

        if (nivel.equals("1"))
        {
            titulo.setText(R.string.TEMA1);
            pregunta.setText("¿Que es un algoritmo?");
            respuesta1.setText("Espacio en memoria que permite almacenar información dentro de sí");
            respuesta2.setText("Conjunto de instrucciones/pasos que sirven para resolver un problema");
            respuesta3.setText("Valor que no puede ser alterado durante la ejecución de un programa");
            respuesta4.setText("Función que permite mostrar texto en pantalla");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t1").setValue("Incorrecta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.error);
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
                    respuesta1.setBackgroundResource(R.drawable.rectangle_incorrect);
                    respuesta3.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta1.setBackgroundResource(R.drawable.rectangle_black_press);
                            respuesta3.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "1");
                    startActivity(intent);
                    finish();

                }

            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t1").setValue("Correcta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.right);
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
                    respuesta2.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta2.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "1");
                    startActivity(intent);
                    finish();

                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t1").setValue("Incorrecto");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.error);
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
                    respuesta2.setBackgroundResource(R.drawable.rectangle_correct);
                    respuesta3.setBackgroundResource(R.drawable.rectangle_incorrect);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta3.setBackgroundResource(R.drawable.rectangle_black_press);
                            respuesta2.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "1");
                    startActivity(intent);
                    finish();
                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t1").setValue("Incorrecta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.error);
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
                    respuesta4.setBackgroundResource(R.drawable.rectangle_incorrect);
                    respuesta3.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta4.setBackgroundResource(R.drawable.rectangle_black_press);
                            respuesta3.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "1");
                    startActivity(intent);
                    finish();
                }
            });
        }

        if (nivel.equals("2"))
        {
            pregunta.setText("¿Que es una variable?");
            titulo.setText(R.string.TEMA2);
            respuesta1.setText("Espacio en memoria que permite almacenar información dentro de sí");
            respuesta2.setText("Conjunto de instrucciones/pasos que sirven para resolver un problema");
            respuesta3.setText("Valor que no puede ser alterado durante la ejecución de un programa");
            respuesta4.setText("Función que permite mostrar texto en pantalla");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t2").setValue("Correcta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.right);
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
                    respuesta1.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta1.setBackgroundResource(R.drawable.rectangle_black_press);
                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "2");
                    startActivity(intent);
                    finish();

                }
            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t2").setValue("Incorrecta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.error);
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
                    respuesta2.setBackgroundResource(R.drawable.rectangle_incorrect);
                    respuesta1.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta2.setBackgroundResource(R.drawable.rectangle_black_press);
                            respuesta1.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "2");
                    startActivity(intent);
                    finish();
                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t2").setValue("Incorrecta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.error);
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
                    respuesta2.setBackgroundResource(R.drawable.rectangle_incorrect);
                    respuesta1.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta2.setBackgroundResource(R.drawable.rectangle_black_press);
                            respuesta1.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "2");
                    startActivity(intent);
                    finish();
                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t2").setValue("Incorrecta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.error);
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
                    respuesta4.setBackgroundResource(R.drawable.rectangle_incorrect);
                    respuesta3.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta4.setBackgroundResource(R.drawable.rectangle_black_press);
                            respuesta3.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "2");
                    startActivity(intent);
                    finish();
                }
            });
        }
        if (nivel.equals("3"))
        {
            pregunta.setText("¿Que funcion tiene la sentencia print?");
            titulo.setText("Print");
            respuesta1.setText("Espacio en memoria que permite almacenar información dentro de sí");
            respuesta2.setText("Conjunto de instrucciones/pasos que sirven para resolver un problema");
            respuesta3.setText("Valor que no puede ser alterado durante la ejecución de un programa");
            respuesta4.setText("Función que permite mostrar texto en pantalla");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t3").setValue("Incorrecta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.error);
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
                    respuesta1.setBackgroundResource(R.drawable.rectangle_incorrect);
                    respuesta4.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta4.setBackgroundResource(R.drawable.rectangle_black_press);
                            respuesta1.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "3");
                    startActivity(intent);
                    finish();
                }
            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t3").setValue("Incorrecta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.error);
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
                    respuesta2.setBackgroundResource(R.drawable.rectangle_incorrect);
                    respuesta4.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta4.setBackgroundResource(R.drawable.rectangle_black_press);
                            respuesta2.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "3");
                    startActivity(intent);
                    finish();
                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t3").setValue("Incorrecta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.error);
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
                    respuesta3.setBackgroundResource(R.drawable.rectangle_incorrect);
                    respuesta4.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta4.setBackgroundResource(R.drawable.rectangle_black_press);
                            respuesta3.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "3");
                    startActivity(intent);
                    finish();
                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = firebaseAuth.getUid();
                    databaseReference.child("users").child(id).child("tiempo_diag_t3").setValue("Correcta");
                    mp= MediaPlayer.create(getApplicationContext(),R.raw.right);
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
                    respuesta4.setBackgroundResource(R.drawable.rectangle_correct);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            respuesta4.setBackgroundResource(R.drawable.rectangle_black_press);

                        }
                    }, 1000);
                    Intent intent = new Intent(getApplicationContext(), PreguntaCheckActivity.class);
                    intent.putExtra("niv", "3");
                    startActivity(intent);
                    finish();
                }
            });
        }
        if (nivel.equals("4"))
        {
            pregunta.setText("¿Que funcion tiene la sentencia input?");
            titulo.setText("Input");
            respuesta1.setText("");
            respuesta2.setText("");
            respuesta3.setText("");
            respuesta4.setText("");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        if (nivel.equals("5"))
        {
            pregunta.setText("¿Que es un operador aritmetico?");
            titulo.setText("O.Aritmetico");
            respuesta1.setText("");
            respuesta2.setText("");
            respuesta3.setText("");
            respuesta4.setText("");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        if (nivel.equals("6"))
        {
            pregunta.setText("¿Que es un operador logico?");
            titulo.setText("O.logico");
            respuesta1.setText("");
            respuesta2.setText("");
            respuesta3.setText("");
            respuesta4.setText("");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        if (nivel.equals("7"))
        {
            pregunta.setText("¿Que funcion tiene la sentencia if?");
            titulo.setText("Condiciones I");
            respuesta1.setText("");
            respuesta2.setText("");
            respuesta3.setText("");
            respuesta4.setText("");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        if (nivel.equals("8"))
        {
            pregunta.setText("¿Que funcion tiene la sentencia switch?");
            titulo.setText("Condiciones II");
            respuesta1.setText("");
            respuesta2.setText("");
            respuesta3.setText("");
            respuesta4.setText("");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        if (nivel.equals("9"))
        {
            pregunta.setText("¿Que funcion tiene la sentencia for?");
            titulo.setText("Ciclos I");
            respuesta1.setText("");
            respuesta2.setText("");
            respuesta3.setText("");
            respuesta4.setText("");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        if (nivel.equals("10"))
        {
            pregunta.setText("¿Que funcion tiene la sentencia while?");
            titulo.setText("Ciclos II");
            respuesta1.setText("");
            respuesta2.setText("");
            respuesta3.setText("");
            respuesta4.setText("");
            respuesta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

            respuesta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            respuesta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


        startTime();

        updateCountDownText();
    }

    private void startTime()
    {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMilis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                mTimeLeftInMilis = millisUntilFinished;
                updateCountDownText();

                String ti=mTextViewCountDown.getText().toString();

                if (ti.equals("00\""))
                {
                    mCountDownTimer.cancel();
                    mTimerRunning=false;
                }
            }

            @Override
            public void onFinish() {
                mTimerRunning=false;
                mCountDownTimer.cancel();
            }
        }.start();
        mTimerRunning=true;

    }

    private void updateCountDownText()
    {
        int seconds = (int) (mTimeLeftInMilis/1000)%20;
        if (seconds!=19)
        {
            progressBar.setProgress(progressBar.getProgress() + 100/20);
        }
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d\"",seconds);
        mTextViewCountDown.setText(timeLeftFormatted);


    }
}
