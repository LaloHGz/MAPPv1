package com.aplication.mapp.menu;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.instrucciones.EjerciciosTemasActivity;
import com.aplication.mapp.niveles.PreguntaActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment {


    //private Button Button1,Button2,Button3,Button4,Button5,Button6,Button7,Button8,Button9,Button10;
    private TextView Mapp, Usuario,tv_subtitle;
    String time1,time2,time3,time4,time5,time6,time7,time8,time9,time10,diag1,diag2,diag3,diag4,diag5,diag6,diag7,diag8,diag9,diag10;
    ProgressBar progressBar1,progressBar2,progressBar3,progressBar4,progressBar5,progressBar6,progressBar7,progressBar8,progressBar9,progressBar10;
    private CircleImageView image_personaje;

    private LinearLayout Button1,Button2,Button3,Button4,Button5,Button6,Button7,Button8,Button9,Button10;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    //private ProgressDialog progressDialog;

    private Typeface sp;
    private LinearLayout layoutHome;
    private TextView usuarioBienvenida;

    ScrollView scrollView;

    private TextView porcentaje,porcentaje2,porcentaje3,porcentaje4,porcentaje5,porcentaje6,porcentaje7,porcentaje8,porcentaje9,porcentaje10;
    private ImageView portada1,portada2,portada3,portada4,portada5,portada6,portada7,portada8,portada9,portada10;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        if (ConectionManager.checkConection(getContext()))
        {

        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(getContext(), InternetConectionActivity.class);
                    startActivity(intent);
                }
            },700);
        }

       /* viewPager2 = view.findViewById(R.id.viewpager);

        List<HomeItems> sliderList = new ArrayList<>();
        sliderList.add(new HomeItems(R.drawable.portada1));
        sliderList.add(new HomeItems(R.drawable.mock3));
        sliderList.add(new HomeItems(R.drawable.mock4));

        viewPager2.setAdapter(new HomeViewPagerAdapter(sliderList, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(100));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r= 1-Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);

        */


       /*
        final List<HomeItems> mList = new ArrayList<>();
        mList.add(new HomeItems(R.drawable.portada1));
        mList.add(new HomeItems(R.drawable.mock3));
        mList.add(new HomeItems(R.drawable.mock4));

        // setup viewpager
        screenPager =view.findViewById(R.id.screen_viewpager);
        homeViewPagerAdapter = new HomeViewPagerAdapter(getContext(),mList);
        screenPager.setAdapter(homeViewPagerAdapter);
        screenPager.setPadding(230,0,230,0);

        */
        //scrollView = (ScrollView) getActivity().findViewById(R.id.scroll);



        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        String fuente7 = "fuentes/sp_reg.ttf";
        this.sp = Typeface.createFromAsset(getActivity().getAssets(), fuente7);

        Mapp=(TextView)view.findViewById(R.id.mapp);
        Mapp.setTypeface(sp);
        Usuario=(TextView)view.findViewById(R.id.Tv_Usuario);
        usuarioBienvenida =(TextView) view.findViewById(R.id.tv_usuario_bienvenida);


        progressBar1=view.findViewById(R.id.progressBar);
        progressBar2=view.findViewById(R.id.progressBar2);
        progressBar3=view.findViewById(R.id.progressBar3);
        progressBar4=view.findViewById(R.id.progressBar4);
        progressBar5=view.findViewById(R.id.progressBar5);
        progressBar6=view.findViewById(R.id.progressBar6);
        progressBar7=view.findViewById(R.id.progressBar7);
        progressBar8=view.findViewById(R.id.progressBar8);
        progressBar9=view.findViewById(R.id.progressBar9);
        progressBar10=view.findViewById(R.id.progressBar10);

        porcentaje = view.findViewById(R.id.porcentaje);
        porcentaje2 = view.findViewById(R.id.porcentaje2);
        porcentaje3 = view.findViewById(R.id.porcentaje3);
        porcentaje4 = view.findViewById(R.id.porcentaje4);
        porcentaje5 = view.findViewById(R.id.porcentaje5);
        porcentaje6 = view.findViewById(R.id.porcentaje6);
        porcentaje7 = view.findViewById(R.id.porcentaje7);
        porcentaje8 = view.findViewById(R.id.porcentaje8);
        porcentaje9 = view.findViewById(R.id.porcentaje9);
        porcentaje10 = view.findViewById(R.id.porcentaje10);


        image_personaje=(CircleImageView) view.findViewById(R.id.image_personaje);


        Button1 =view.findViewById(R.id.b1);

        Button2=view.findViewById(R.id.b2);

        Button3=view.findViewById(R.id.b3);

        Button4=view.findViewById(R.id.b4);

        Button5=view.findViewById(R.id.b5);
        Button6=view.findViewById(R.id.b6);

        Button7=view.findViewById(R.id.b7);

        Button8=view.findViewById(R.id.b8);

        Button9=view.findViewById(R.id.b9);

        Button10=view.findViewById(R.id.b10);


        layoutHome =view.findViewById(R.id.layout_home);
        layoutHome.setVisibility(View.GONE);

        portada1 = view.findViewById(R.id.portada1);
        portada2 = view.findViewById(R.id.portada2);
        portada3 = view.findViewById(R.id.portada3);
        portada4 = view.findViewById(R.id.portada4);
        portada5 = view.findViewById(R.id.portada5);
        portada6 = view.findViewById(R.id.portada6);
        portada7 = view.findViewById(R.id.portada7);
        portada8 = view.findViewById(R.id.portada8);
        portada9 = view.findViewById(R.id.portada9);
        portada10 = view.findViewById(R.id.portada10);

        //Button1.setEnabled(false);
        Button2.setEnabled(false);
        Button3.setEnabled(false);
        Button4.setEnabled(false);
        Button5.setEnabled(false);
        Button6.setEnabled(false);
        Button7.setEnabled(false);
        Button8.setEnabled(false);
        Button9.setEnabled(false);
        Button10.setEnabled(false);



        image_personaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new PerfilFragment();
                replaceFragment(fragment);
            }
        });

        final BottomNavigationView bottomNav= view.findViewById(R.id.bottom_navigation);

        getUserInfo();



        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (time1.equals("a") && diag1.equals("a"))
                {
                    Intent intent = new Intent(getActivity(), PreguntaActivity.class);
                    intent.putExtra("niv", "1");
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(), EjerciciosTemasActivity.class);
                    intent.putExtra("niv", "1");
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String >(portada1, "portada_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                    startActivity(intent, options.toBundle());
                }

            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time2.equals("a") && diag2.equals("a"))
                {
                    Intent intent = new Intent(getActivity(), PreguntaActivity.class);
                    intent.putExtra("niv", "2");
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(), EjerciciosTemasActivity.class);
                    intent.putExtra("niv", "2");
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String >(portada2, "portada_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time3.equals("a") && diag3.equals("a"))
                {
                    Intent intent = new Intent(getActivity(), PreguntaActivity.class);
                    intent.putExtra("niv", "3");
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(), EjerciciosTemasActivity.class);
                    intent.putExtra("niv", "3");
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String >(portada3, "portada_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });


        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time4.equals("a") && diag4.equals("a"))
                {
                    Intent intent = new Intent(getActivity(),PreguntaActivity.class);
                    intent.putExtra("niv","4");
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(),EjerciciosTemasActivity.class);
                    intent.putExtra("niv","4");
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String >(portada4, "portada_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time5.equals("a") && diag5.equals("a"))
                {
                    Intent intent = new Intent(getActivity(),PreguntaActivity.class);
                    intent.putExtra("niv","5");
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(),EjerciciosTemasActivity.class);
                    intent.putExtra("niv","5");
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String >(portada5, "portada_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });


        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time6.equals("a") && diag6.equals("a"))
                {
                    Intent intent = new Intent(getActivity(),PreguntaActivity.class);
                    intent.putExtra("niv","6");
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(),EjerciciosTemasActivity.class);
                    intent.putExtra("niv","6");
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String >(portada6, "portada_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });



        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time7.equals("a") && diag7.equals("a"))
                {
                    Intent intent = new Intent(getActivity(),PreguntaActivity.class);
                    intent.putExtra("niv","7");
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(),EjerciciosTemasActivity.class);
                    intent.putExtra("niv","7");
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String >(portada7, "portada_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });

        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time8.equals("a") && diag8.equals("a"))
                {
                    Intent intent = new Intent(getActivity(),PreguntaActivity.class);
                    intent.putExtra("niv","8");
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(),EjerciciosTemasActivity.class);
                    intent.putExtra("niv","8");
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String >(portada8, "portada_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });

        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time9.equals("a") && diag9.equals("a"))
                {
                    Intent intent = new Intent(getActivity(),PreguntaActivity.class);
                    intent.putExtra("niv","9");
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(),EjerciciosTemasActivity.class);
                    intent.putExtra("niv","9");
                    Pair[] pairs = new Pair[1];
                    pairs[0] = new Pair<View, String >(portada9, "portada_transition");
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                    startActivity(intent, options.toBundle());
                }
            }
        });

        Button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (time10.equals("a") && diag10.equals("a"))
               {
                   Intent intent = new Intent(getActivity(),PreguntaActivity.class);
                   intent.putExtra("niv","10");
                   startActivity(intent);
               }
               else
               {
                   Intent intent = new Intent(getActivity(),EjerciciosTemasActivity.class);
                   intent.putExtra("niv","10");
                   Pair[] pairs = new Pair[1];
                   pairs[0] = new Pair<View, String >(portada10, "portada_transition");
                   ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(),pairs);
                   startActivity(intent, options.toBundle());
               }
            }
        });



        return view;
    }


    private void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private void getUserInfo()
    {


        String id=firebaseAuth.getCurrentUser().getUid();

        databaseReference.child("users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    String us= dataSnapshot.child("usuario").getValue().toString();
                    String t1= dataSnapshot.child("tiempo_n1t1").getValue().toString();
                    String t2= dataSnapshot.child("tiempo_n1t2").getValue().toString();
                    String t3= dataSnapshot.child("tiempo_n1t3").getValue().toString();
                    String t4= dataSnapshot.child("tiempo_n1t4").getValue().toString();
                    String t5= dataSnapshot.child("tiempo_n1t5").getValue().toString();
                    String t6= dataSnapshot.child("tiempo_n1t6").getValue().toString();
                    String t7= dataSnapshot.child("tiempo_n1t7").getValue().toString();
                    String t8= dataSnapshot.child("tiempo_n1t8").getValue().toString();
                    String t9= dataSnapshot.child("tiempo_n1t9").getValue().toString();
                    String t10= dataSnapshot.child("tiempo_n1t10").getValue().toString();

                    String t1_2= dataSnapshot.child("tiempo_n2t1").getValue().toString();
                    String t2_2= dataSnapshot.child("tiempo_n2t2").getValue().toString();
                    String t3_2= dataSnapshot.child("tiempo_n2t3").getValue().toString();
                    String t4_2= dataSnapshot.child("tiempo_n2t4").getValue().toString();
                    String t5_2= dataSnapshot.child("tiempo_n2t5").getValue().toString();
                    String t6_2= dataSnapshot.child("tiempo_n2t6").getValue().toString();
                    String t7_2= dataSnapshot.child("tiempo_n2t7").getValue().toString();
                    String t8_2= dataSnapshot.child("tiempo_n2t8").getValue().toString();
                    String t9_2= dataSnapshot.child("tiempo_n2t9").getValue().toString();
                    String t10_2= dataSnapshot.child("tiempo_n2t10").getValue().toString();

                    String t1_3= dataSnapshot.child("tiempo_n3t1").getValue().toString();
                    String t2_3= dataSnapshot.child("tiempo_n3t2").getValue().toString();
                    String t3_3= dataSnapshot.child("tiempo_n3t3").getValue().toString();
                    String t4_3= dataSnapshot.child("tiempo_n3t4").getValue().toString();
                    String t5_3= dataSnapshot.child("tiempo_n3t5").getValue().toString();
                    String t6_3= dataSnapshot.child("tiempo_n3t6").getValue().toString();
                    String t7_3= dataSnapshot.child("tiempo_n3t7").getValue().toString();
                    String t8_3= dataSnapshot.child("tiempo_n3t8").getValue().toString();
                    String t9_3= dataSnapshot.child("tiempo_n3t9").getValue().toString();
                    String t10_3= dataSnapshot.child("tiempo_n3t10").getValue().toString();

                    String t1_4= dataSnapshot.child("tiempo_n4t1").getValue().toString();
                    String t2_4= dataSnapshot.child("tiempo_n4t2").getValue().toString();
                    String t3_4= dataSnapshot.child("tiempo_n4t3").getValue().toString();
                    String t4_4= dataSnapshot.child("tiempo_n4t4").getValue().toString();
                    String t5_4= dataSnapshot.child("tiempo_n4t5").getValue().toString();
                    String t6_4= dataSnapshot.child("tiempo_n4t6").getValue().toString();
                    String t7_4= dataSnapshot.child("tiempo_n4t7").getValue().toString();
                    String t8_4= dataSnapshot.child("tiempo_n4t8").getValue().toString();
                    String t9_4= dataSnapshot.child("tiempo_n4t9").getValue().toString();
                    String t10_4= dataSnapshot.child("tiempo_n4t10").getValue().toString();

                    String t1_5= dataSnapshot.child("tiempo_n5t1").getValue().toString();
                    String t2_5= dataSnapshot.child("tiempo_n5t2").getValue().toString();
                    String t3_5= dataSnapshot.child("tiempo_n5t3").getValue().toString();
                    String t4_5= dataSnapshot.child("tiempo_n5t4").getValue().toString();
                    String t5_5= dataSnapshot.child("tiempo_n5t5").getValue().toString();
                    String t6_5= dataSnapshot.child("tiempo_n5t6").getValue().toString();
                    String t7_5= dataSnapshot.child("tiempo_n5t7").getValue().toString();
                    String t8_5= dataSnapshot.child("tiempo_n5t8").getValue().toString();
                    String t9_5= dataSnapshot.child("tiempo_n5t9").getValue().toString();
                    String t10_5= dataSnapshot.child("tiempo_n5t10").getValue().toString();



                    String d1=dataSnapshot.child("tiempo_diag_t1").getValue().toString();
                    String d2=dataSnapshot.child("tiempo_diag_t2").getValue().toString();
                    String d3=dataSnapshot.child("tiempo_diag_t3").getValue().toString();
                    String d4=dataSnapshot.child("tiempo_diag_t4").getValue().toString();
                    String d5=dataSnapshot.child("tiempo_diag_t5").getValue().toString();
                    String d6=dataSnapshot.child("tiempo_diag_t6").getValue().toString();
                    String d7=dataSnapshot.child("tiempo_diag_t7").getValue().toString();
                    String d8=dataSnapshot.child("tiempo_diag_t8").getValue().toString();
                    String d9=dataSnapshot.child("tiempo_diag_t9").getValue().toString();
                    String d10=dataSnapshot.child("tiempo_diag_t10").getValue().toString();
                    String personaje=dataSnapshot.child("personaje").getValue().toString();
                    Usuario.setText(us);
                    usuarioBienvenida.setText(us);



                    if (!t1.equals("a"))
                    {
                        porcentaje.setText("20%");
                       progressBar1.setProgress(progressBar1.getProgress() + 20);

                    }
                    if (!t1_2.equals("a"))
                    {
                        porcentaje.setText("40%");
                        progressBar1.setProgress(progressBar1.getProgress() + 20);
                    }
                    if (!t1_3.equals("a"))
                    {
                        porcentaje.setText("60%");
                        progressBar1.setProgress(progressBar1.getProgress() + 20);
                    }
                    if (!t1_4.equals("a"))
                    {
                        porcentaje.setText("80%");
                        progressBar1.setProgress(progressBar1.getProgress() + 20);
                    }
                    if (!t1_5.equals("a"))
                    {
                        porcentaje.setText("100%");
                        progressBar2.setVisibility(View.VISIBLE);
                        progressBar1.setProgress(progressBar1.getProgress() + 20);
                        Button2.setVisibility(View.VISIBLE);
                        Button2.setEnabled(true);
                    }




                    if (!t2.equals("a"))
                    {
                        porcentaje2.setText("20%");
                        progressBar2.setProgress(progressBar2.getProgress() + 20);
                    }
                    if (!t2_2.equals("a"))
                    {
                        porcentaje2.setText("40%");
                        progressBar2.setProgress(progressBar2.getProgress() + 20);
                    }
                    if (!t2_3.equals("a"))
                    {
                        porcentaje2.setText("60%");
                        progressBar2.setProgress(progressBar2.getProgress() + 20);
                    }
                    if (!t2_4.equals("a"))
                    {
                        porcentaje2.setText("80%");
                        progressBar2.setProgress(progressBar2.getProgress() + 20);
                    }
                    if (!t2_5.equals("a"))
                    {
                        porcentaje2.setText("100%");
                        progressBar3.setVisibility(View.VISIBLE);
                        progressBar2.setProgress(progressBar2.getProgress() + 20);
                        Button3.setVisibility(View.VISIBLE);
                        Button3.setEnabled(true);
                    }


                    if (!t3.equals("a"))
                    {
                        porcentaje3.setText("20%");
                        progressBar3.setProgress(progressBar3.getProgress() + 20);
                    }
                    if (!t3_2.equals("a"))
                    {
                        porcentaje3.setText("40%");
                        progressBar3.setProgress(progressBar3.getProgress() + 20);
                    }
                    if (!t3_3.equals("a"))
                    {
                        porcentaje3.setText("60%");
                        progressBar3.setProgress(progressBar3.getProgress() + 20);
                    }
                    if (!t3_4.equals("a"))
                    {
                        porcentaje3.setText("80%");
                        progressBar3.setProgress(progressBar3.getProgress() + 20);
                    }
                    if (!t3_5.equals("a"))
                    {
                        porcentaje3.setText("100%");
                        progressBar4.setVisibility(View.VISIBLE);
                        progressBar3.setProgress(progressBar3.getProgress() + 20);
                        Button4.setVisibility(View.VISIBLE);
                        Button4.setEnabled(true);
                    }


                    if (!t4.equals("a"))
                    {
                        porcentaje4.setText("20%");
                        progressBar4.setProgress(progressBar4.getProgress() + 20);
                    }
                    if (!t4_2.equals("a"))
                    {
                        porcentaje4.setText("40%");
                        progressBar4.setProgress(progressBar4.getProgress() + 20);
                    }
                    if (!t4_3.equals("a"))
                    {
                        porcentaje4.setText("60%");
                        progressBar4.setProgress(progressBar4.getProgress() + 20);
                    }
                    if (!t4_4.equals("a"))
                    {
                        porcentaje4.setText("80%");
                        progressBar4.setProgress(progressBar4.getProgress() + 20);
                    }
                    if (!t4_5.equals("a"))
                    {
                        porcentaje4.setText("100%");
                        progressBar5.setVisibility(View.VISIBLE);
                        progressBar4.setProgress(progressBar4.getProgress() + 20);
                        Button5.setVisibility(View.VISIBLE);
                        Button5.setEnabled(true);
                    }




                    if (!t5.equals("a"))
                    {
                        porcentaje5.setText("20%");
                        progressBar5.setProgress(progressBar5.getProgress() + 20);
                    }
                    if (!t5_2.equals("a"))
                    {
                        porcentaje5.setText("40%");
                        progressBar5.setProgress(progressBar5.getProgress() + 20);
                    }
                    if (!t5_3.equals("a"))
                    {
                        porcentaje5.setText("60%");
                        progressBar5.setProgress(progressBar5.getProgress() + 20);
                    }
                    if (!t5_4.equals("a"))
                    {
                        porcentaje5.setText("80%");
                        progressBar5.setProgress(progressBar5.getProgress() + 20);
                    }
                    if (!t5_5.equals("a"))
                    {
                        porcentaje5.setText("100%");
                        progressBar6.setVisibility(View.VISIBLE);
                        progressBar5.setProgress(progressBar5.getProgress() + 20);
                        Button6.setVisibility(View.VISIBLE);
                        Button6.setEnabled(true);
                    }


                    if (!t6.equals("a"))
                    {
                        porcentaje6.setText("20%");
                        progressBar6.setProgress(progressBar6.getProgress() + 20);
                    }
                    if (!t6_2.equals("a"))
                    {
                        porcentaje6.setText("40%");
                        progressBar6.setProgress(progressBar6.getProgress() + 20);
                    }
                    if (!t6_3.equals("a"))
                    {
                        porcentaje6.setText("60%");
                        progressBar6.setProgress(progressBar6.getProgress() + 20);
                    }
                    if (!t6_4.equals("a"))
                    {
                        porcentaje6.setText("80%");
                        progressBar6.setProgress(progressBar6.getProgress() + 20);
                    }
                    if (!t6_5.equals("a"))
                    {
                        porcentaje6.setText("100%");
                        progressBar7.setVisibility(View.VISIBLE);
                        progressBar6.setProgress(progressBar6.getProgress() + 20);
                        Button7.setVisibility(View.VISIBLE);
                        Button7.setEnabled(true);
                    }


                    if (!t7.equals("a"))
                    {
                        porcentaje7.setText("20%");
                        progressBar7.setProgress(progressBar7.getProgress() + 20);
                    }
                    if (!t7_2.equals("a"))
                    {
                        porcentaje7.setText("40%");
                        progressBar7.setProgress(progressBar7.getProgress() + 20);
                    }
                    if (!t7_3.equals("a"))
                    {
                        porcentaje7.setText("60%");
                        progressBar7.setProgress(progressBar7.getProgress() + 20);
                    }
                    if (!t7_4.equals("a"))
                    {
                        porcentaje7.setText("80%");
                        progressBar7.setProgress(progressBar7.getProgress() + 20);
                    }
                    if (!t7_5.equals("a"))
                    {
                        porcentaje7.setText("100%");
                        progressBar8.setVisibility(View.VISIBLE);
                        progressBar7.setProgress(progressBar7.getProgress() + 20);
                        Button8.setVisibility(View.VISIBLE);
                        Button8.setEnabled(true);
                    }


                    if (!t8.equals("a"))
                    {
                        porcentaje8.setText("20%");
                        progressBar8.setProgress(progressBar8.getProgress() + 20);
                    }
                    if (!t8_2.equals("a"))
                    {
                        porcentaje8.setText("40%");
                        progressBar8.setProgress(progressBar8.getProgress() + 20);
                    }
                    if (!t8_3.equals("a"))
                    {
                        porcentaje8.setText("60%");
                        progressBar8.setProgress(progressBar8.getProgress() + 20);
                    }
                    if (!t8_4.equals("a"))
                    {
                        porcentaje8.setText("80%");
                        progressBar8.setProgress(progressBar8.getProgress() + 20);
                    }
                    if (!t8_5.equals("a"))
                    {
                        porcentaje8.setText("100%");
                        progressBar9.setVisibility(View.VISIBLE);
                        progressBar8.setProgress(progressBar8.getProgress() + 20);
                        Button9.setVisibility(View.VISIBLE);
                        Button9.setEnabled(true);
                    }




                    if (!t9.equals("a"))
                    {
                        porcentaje9.setText("20%");
                        progressBar9.setProgress(progressBar9.getProgress() + 20);
                    }
                    if (!t9_2.equals("a"))
                    {
                        porcentaje9.setText("40%");
                        progressBar9.setProgress(progressBar9.getProgress() + 20);
                    }
                    if (!t9_3.equals("a"))
                    {
                        porcentaje9.setText("60%");
                        progressBar9.setProgress(progressBar9.getProgress() + 20);
                    }
                    if (!t9_4.equals("a"))
                    {
                        porcentaje9.setText("80%");
                        progressBar9.setProgress(progressBar9.getProgress() + 20);
                    }
                    if (!t9_5.equals("a"))
                    {
                        porcentaje9.setText("100%");
                        progressBar10.setVisibility(View.VISIBLE);
                        progressBar9.setProgress(progressBar9.getProgress() + 20);
                        Button10.setVisibility(View.VISIBLE);
                        Button10.setEnabled(true);
                    }


                    if (!t10.equals("a"))
                    {
                        porcentaje10.setText("20%");
                        progressBar10.setProgress(progressBar10.getProgress() + 20);
                    }
                    if (!t10_2.equals("a"))
                    {
                        porcentaje10.setText("40%");
                        progressBar10.setProgress(progressBar10.getProgress() + 20);
                    }
                    if (!t10_3.equals("a"))
                    {
                        porcentaje10.setText("60%");
                        progressBar10.setProgress(progressBar10.getProgress() + 20);
                    }
                    if (!t10_4.equals("a"))
                    {
                        porcentaje10.setText("80%");
                        progressBar10.setProgress(progressBar10.getProgress() + 20);
                    }
                    if (!t10_5.equals("a"))
                    {
                        porcentaje10.setText("100%");
                        progressBar10.setProgress(progressBar10.getProgress() + 20);
                    }





                    time1=t1;
                    time2=t2;
                    time3=t3;
                    time4=t4;
                    time5=t5;
                    time6=t6;
                    time7=t7;
                    time8=t8;
                    time9=t9;
                    time10=t10;

                    diag1=d1;
                    diag2=d2;
                    diag3=d3;
                    diag4=d4;
                    diag5=d5;
                    diag6=d6;
                    diag7=d7;
                    diag8=d8;
                    diag9=d9;
                    diag10=d10;
                    layoutHome.setVisibility(View.VISIBLE);
                    //Button1.setEnabled(true);

                    if (personaje.equals("Laoshi"))
                    {
                        image_personaje.setImageResource(R.drawable.laoshi);
                    }
                    if (personaje.equals("Tizoc"))
                    {
                        image_personaje.setImageResource(R.drawable.felis);
                    }
                    if (personaje.equals("Houyi"))
                    {
                        image_personaje.setImageResource(R.drawable.houyi);
                    }
                    if (personaje.equals("Kin"))
                    {
                        image_personaje.setImageResource(R.drawable.kin);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
