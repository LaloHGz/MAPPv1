package com.aplication.mapp.niveles.variables;

import android.annotation.SuppressLint;
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
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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

public class Nivel3variablesActivity extends AppCompatActivity {

    private TextView TextViewResult;
    private Button TextViewAnswer1, TextViewAnswer2, TextViewAnswer3, TextViewAnswer4, TextViewAnswer5, TextViewAnswer6;
    Button Check;
    String T1 = "", T2 = "", T3 = "", T4 = "", T5 = "", T6 = "", TR = "100";
    private Chronometer Chronometro;
    Boolean correr = false;
    String nivel = "Lvl 4";
    String tema = "";
    private int i = 0;
    private Button acept;
    private TextView message;

    private Dialog ins;

    private ProgressBar progressBar;

    private MediaPlayer mp;
    long detenerse;
    private TextView TextViewDato;
    private String l7 = Locale.getDefault().getLanguage();

    private String mystring = "";
    private Typeface Good_sans;
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

    @SuppressLint({"ClickableViewAccessibility", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel3variables);
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

        String fuete2 = "fuentes/Good_Feeling_Sans.ttf";
        this.Good_sans = Typeface.createFromAsset(getAssets(), fuete2);

        Chronometro = findViewById(R.id.chrono);
        animationView = findViewById(R.id.animation_checkmark);

        TextViewAnswer1 = findViewById(R.id.answer1);
        //TextViewAnswer1.setTypeface(Good_sans);
        TextViewAnswer2 = findViewById(R.id.answer2);
        //TextViewAnswer2.setTypeface(Good_sans);
        TextViewAnswer3 = findViewById(R.id.answer3);
        //TextViewAnswer3.setTypeface(Good_sans);
        TextViewAnswer4 = findViewById(R.id.answer4);
        //TextViewAnswer4.setTypeface(Good_sans);
        TextViewAnswer5 = findViewById(R.id.answer5);
        //TextViewAnswer5.setTypeface(Good_sans);
        TextViewAnswer6 = findViewById(R.id.answer6);
        //TextViewAnswer6.setTypeface(Good_sans);
        TextViewResult = findViewById(R.id.dropAnswer);
        //TextViewResult.setTypeface(Good_sans);
        Check = (Button) findViewById(R.id.check);
        //Check.setTypeface(Good_sans);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        TextViewDato = (TextView) findViewById(R.id.tv_dato);
        //TextViewDato.setTypeface(Good_sans);

       /* TextViewAnswer1.setOnTouchListener(longClickListener);
        TextViewAnswer2.setOnTouchListener(longClickListener);
        TextViewAnswer3.setOnTouchListener(longClickListener);
        TextViewAnswer4.setOnTouchListener(longClickListener);
        TextViewAnswer5.setOnTouchListener(longClickListener);
        TextViewAnswer6.setOnTouchListener(longClickListener);

        TextViewResult.setOnDragListener(dragListener);
        */

        T1 = TextViewAnswer1.getText().toString();
        T2 = TextViewAnswer2.getText().toString();
        T3 = TextViewAnswer3.getText().toString();
        T4 = TextViewAnswer4.getText().toString();
        T5 = TextViewAnswer5.getText().toString();
        T6 = TextViewAnswer6.getText().toString();

        if (i == 0) {
            TextViewDato.setText(R.string.p1n3t2);
            TR = T2;
        }


        startChronometro();
        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Result = TextViewResult.getText().toString();
                if (Result.equals(TR)) {
                    TR = "10";
                    i++;
                    if (i == 1) {
                        TR = T4;
                    }
                    if (i == 2) {
                        TR = T1;
                    }
                    if (i == 3) {
                        TR = T3;
                    }
                    if (i == 4) {
                        TR = T5;
                    }
                    if (i == 5) {
                        TR = T6;
                    }
                    check();
                } else {
                    incorrecta();
                }

            }
        });
        TextViewAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewResult.setText(T1);
            }
        });

        TextViewAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewResult.setText(T2);
            }
        });

        TextViewAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewResult.setText(T3);
            }
        });

        TextViewAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewResult.setText(T4);
            }
        });

        TextViewAnswer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewResult.setText(T5);
            }
        });

        TextViewAnswer6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextViewResult.setText(T6);
            }
        });

    }

    private void startChronometro() {
        if (!correr) {
            Chronometro.setBase(SystemClock.elapsedRealtime());
            Chronometro.start();
            correr = true;
        }
    }

    public void check() {
        TextViewResult.setBackgroundResource(R.drawable.rectangle_gridcorrect);
        mp = MediaPlayer.create(this, R.raw.right);
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
        if (correr) {
            Chronometro.stop();
            detenerse = SystemClock.elapsedRealtime() - Chronometro.getBase();
        }
        if (i < 6) {
            progressBar.setProgress(progressBar.getProgress() + 17);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TextViewResult.setBackgroundResource(R.drawable.botonseleccion);
                    TextViewResult.setText("");
                }
            }, 500);
        } else if (i == 6) {
            progressBar.setProgress(progressBar.getProgress() + 15);
            TextViewDato.setVisibility(View.GONE);
            animationView.setVisibility(View.VISIBLE);
            animationView.playAnimation();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    TextViewResult.setBackgroundResource(R.drawable.botonseleccion);
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
            }, 800);
        }
        if (i == 1) {
            TextViewDato.setText(R.string.p2n3t2);
        }
        if (i == 2) {
            TextViewDato.setText(R.string.p3n3t2);
        }
        if (i == 3) {
            TextViewDato.setText(R.string.p4n3t2);
        }
        if (i == 4) {
            TextViewDato.setText(R.string.p5n3t2);
        }
        if (i == 5) {
            TextViewDato.setText(R.string.p6n3t2);
        }


    }

    private void incorrecta() {
        mp = MediaPlayer.create(this, R.raw.error);
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
        Toast.makeText(Nivel3variablesActivity.this, mystring, Toast.LENGTH_SHORT).show();
        TextViewResult.setBackgroundResource(R.drawable.rectangle_gridincorrect);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextViewResult.setBackgroundResource(R.drawable.botonseleccion);
                TextViewResult.setText("");
            }
        }, 1000);


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
                    databaseReference.child("users").child(id).child("tiempo_n4t2").setValue(elapsedMillis);
                    if (numero<10) {
                        databaseReference.child("users").child(id).child("nivel").setValue("8");
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

    /*View.OnTouchListener longClickListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myshadow = new View.DragShadowBuilder(v);
            v.startDrag(data,myshadow,v,0);
            return true;
        }

    };




    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View vData = (View) event.getLocalState();
            if (i == 0){
                switch (dragEvent) {
                    case DragEvent.ACTION_DRAG_ENTERED:
                        if (vData.getId() == R.id.answer4) {
                            T4 = TextViewAnswer4.getText().toString();
                            TextViewResult.setText(T4);
                        } else if (vData.getId() == R.id.answer2) {
                            T2 = TextViewAnswer2.getText().toString();
                            TR=T2;
                            TextViewResult.setText(T2);
                        } else if (vData.getId() == R.id.answer3) {
                            T3 = TextViewAnswer3.getText().toString();
                            TextViewResult.setText(T3);
                        } else if (vData.getId() == R.id.answer1) {
                            T1 = TextViewAnswer1.getText().toString();
                            TextViewResult.setText(T1);
                        }
                        else if (vData.getId() == R.id.answer5) {
                            T5 = TextViewAnswer5.getText().toString();
                            TextViewResult.setText(T5);
                        }
                        else if (vData.getId() == R.id.answer6) {
                            T6 = TextViewAnswer6.getText().toString();
                            TextViewResult.setText(T6);
                        }
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                }
            }
            if (i == 1){
                switch (dragEvent) {
                    case DragEvent.ACTION_DRAG_ENTERED:
                        if (vData.getId() == R.id.answer2) {
                            T2 = TextViewAnswer2.getText().toString();
                            TextViewResult.setText(T2);
                        } else if (vData.getId() == R.id.answer4) {
                            T4 = TextViewAnswer4.getText().toString();
                            TR=T4;
                            TextViewResult.setText(T4);
                        } else if (vData.getId() == R.id.answer3) {
                            T3 = TextViewAnswer3.getText().toString();
                            TextViewResult.setText(T3);
                        } else if (vData.getId() == R.id.answer1) {
                            T1 = TextViewAnswer1.getText().toString();
                            TextViewResult.setText(T1);
                        }
                        else if (vData.getId() == R.id.answer5) {
                            T5 = TextViewAnswer5.getText().toString();
                            TextViewResult.setText(T5);
                        }
                        else if (vData.getId() == R.id.answer6) {
                            T6 = TextViewAnswer6.getText().toString();
                            TextViewResult.setText(T6);
                        }
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                }
            }
            if (i == 2){
                switch (dragEvent) {
                    case DragEvent.ACTION_DRAG_ENTERED:
                        if (vData.getId() == R.id.answer4) {
                            T4 = TextViewAnswer4.getText().toString();
                            TextViewResult.setText(T4);
                        } else if (vData.getId() == R.id.answer2) {
                            T2 = TextViewAnswer2.getText().toString();
                            TextViewResult.setText(T2);
                        } else if (vData.getId() == R.id.answer3) {
                            T3 = TextViewAnswer3.getText().toString();
                            TextViewResult.setText(T3);
                        } else if (vData.getId() == R.id.answer1) {
                            T1 = TextViewAnswer1.getText().toString();
                            TR=T1;
                            TextViewResult.setText(T1);
                        }
                        else if (vData.getId() == R.id.answer5) {
                            T5 = TextViewAnswer5.getText().toString();
                            TextViewResult.setText(T5);
                        }
                        else if (vData.getId() == R.id.answer6) {
                            T6 = TextViewAnswer6.getText().toString();
                            TextViewResult.setText(T6);
                        }
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                }
            }
            if (i == 3){
                switch (dragEvent) {
                    case DragEvent.ACTION_DRAG_ENTERED:
                        if (vData.getId() == R.id.answer4) {
                            T4 = TextViewAnswer4.getText().toString();
                            TextViewResult.setText(T4);
                        } else if (vData.getId() == R.id.answer2) {
                            T2 = TextViewAnswer2.getText().toString();
                            TextViewResult.setText(T2);
                        } else if (vData.getId() == R.id.answer3) {
                            T3 = TextViewAnswer3.getText().toString();
                            TR=T3;
                            TextViewResult.setText(T3);
                        } else if (vData.getId() == R.id.answer1) {
                            T1 = TextViewAnswer1.getText().toString();
                            TextViewResult.setText(T1);
                        }
                        else if (vData.getId() == R.id.answer5) {
                            T5 = TextViewAnswer5.getText().toString();
                            TextViewResult.setText(T5);
                        }
                        else if (vData.getId() == R.id.answer6) {
                            T6 = TextViewAnswer6.getText().toString();
                            TextViewResult.setText(T6);
                        }
                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                }
            }
            if (i == 4){
                switch (dragEvent) {
                    case DragEvent.ACTION_DRAG_ENTERED:
                        if (vData.getId() == R.id.answer4) {
                            T4 = TextViewAnswer4.getText().toString();
                            TextViewResult.setText(T4);
                        } else if (vData.getId() == R.id.answer2) {
                            T2 = TextViewAnswer2.getText().toString();
                            TextViewResult.setText(T2);
                        } else if (vData.getId() == R.id.answer3) {
                            T3 = TextViewAnswer3.getText().toString();
                            TextViewResult.setText(T3);
                        } else if (vData.getId() == R.id.answer1) {
                            T1 = TextViewAnswer1.getText().toString();
                            TextViewResult.setText(T1);
                        }
                        else if (vData.getId() == R.id.answer5) {
                            T5 = TextViewAnswer5.getText().toString();
                            TR=T5;
                            TextViewResult.setText(T5);
                        }
                        else if (vData.getId() == R.id.answer6) {
                            T6 = TextViewAnswer6.getText().toString();
                            TextViewResult.setText(T6);
                        }

                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                }
            }
            if (i == 5){
                switch (dragEvent) {
                    case DragEvent.ACTION_DRAG_ENTERED:
                        if (vData.getId() == R.id.answer4) {
                            T4 = TextViewAnswer4.getText().toString();
                            TextViewResult.setText(T4);
                        } else if (vData.getId() == R.id.answer2) {
                            T2 = TextViewAnswer2.getText().toString();
                            TextViewResult.setText(T2);
                        } else if (vData.getId() == R.id.answer3) {
                            T3 = TextViewAnswer3.getText().toString();
                            TextViewResult.setText(T3);
                        } else if (vData.getId() == R.id.answer1) {
                            T1 = TextViewAnswer1.getText().toString();
                            TextViewResult.setText(T1);
                        }
                        else if (vData.getId() == R.id.answer5) {
                            T5 = TextViewAnswer5.getText().toString();
                            TextViewResult.setText(T5);
                        }
                        else if (vData.getId() == R.id.answer6) {
                            T6 = TextViewAnswer6.getText().toString();
                            TR=T6;
                            TextViewResult.setText(T6);
                        }

                        break;
                    case DragEvent.ACTION_DRAG_ENDED:
                    case DragEvent.ACTION_DRAG_EXITED:
                        break;
                }
            }
            return true;
        }
    };

    */


}