package com.aplication.mapp.menu;

import android.Manifest;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.aplication.mapp.ConectionManager;
import com.aplication.mapp.InternetConectionActivity;
import com.aplication.mapp.R;
import com.aplication.mapp.inicio.IntroActivity;
import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;

public class PerfilFragment extends Fragment {
    private Button Sign_Out;

    private TextView Usuario2;
    private TextView Edad2;
    private TextView Pais2;
    private TextView Nivel2;
    private TextView Formato2;
    private TextView Usuario;
    private TextView Edad;
    private TextView Pais;
    private TextView Nivel;
    private TextView Formato;
    private Button Edit;
    private final static int RC_SIGN_IN = 2;

   // private ImageView image_personaje;

    private CircleImageView image_personaje;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    private Dialog log_out;

    private  Button acept;
    private  TextView cancel;
    private TextView message;
    private String tipo="";
    GoogleApiClient mGoogleApiClient;
    private Button mUploadBtn;
    private StorageReference mStorage;
    private static final int GALLERY_INTENT = 1;
    private static int PReqCode = 1;
    private Uri pickedImgUri;

    ListView listView;
    String mTitle[]= new String[] {"Formato de la historia","Califícanos","Versión de app","Cerrar sesión"};
    int images[] = {R.drawable.ic_book_black_24dp,R.drawable.ic_sentiment_satisfied_black_24dp,R.drawable.ic_info_outline_black_24dp,R.drawable.ic_exit_to_app_black_24dp};

    TextView version;
    ImageView arrow;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        if (ConectionManager.checkConection(getContext()))
        {

        }
        else
        {
            Intent intent=new Intent(getContext(), InternetConectionActivity.class);
            startActivity(intent);
        }

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();

        mStorage = FirebaseStorage.getInstance().getReference();

        log_out= new Dialog(getActivity());

        GoogleSignInOptions gso= new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();

        listView= view.findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(getContext(),mTitle,images);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent i = new Intent(getActivity(), EditUserActivity.class);
                    i.putExtra("tipo",tipo);
                    startActivity(i);
                }
                if (position==1)
                {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("market://details?id="+ "com.aplication.mapp")));
                    }catch (ActivityNotFoundException e)
                    {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id="+"com.aplication.mapp")));

                    }
                }
                if (position==3)
                {
                    salir();
                }
            }
        });


        Edit=(Button)view.findViewById(R.id.boton_edit);
        Usuario=(TextView)view.findViewById(R.id.Tv_Usuario);
        Nivel2=(TextView)view.findViewById(R.id.Tv_Ni);
        Nivel=(TextView)view.findViewById(R.id.Tv_Nivel);


/*
        Usuario2=(TextView)view.findViewById(R.id.Tv_Us);
        Edad2=(TextView)view.findViewById(R.id.Tv_Ed);
        Pais2=(TextView)view.findViewById(R.id.Tv_Pa);
        Formato2=(TextView)view.findViewById(R.id.Tv_For);

 */






        image_personaje=(CircleImageView) view.findViewById(R.id.image_personaje);



        image_personaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >=22)
                {
                    checkAndRequestForPermission();
                }
                else
                {
                    openGallery();
                }
            }
        });

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditUserActivity.class);
                i.putExtra("tipo",tipo);
                startActivity(i);
            }
        });


        getUserInfo();


        return view;
    }

    private void openGallery() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, GALLERY_INTENT);

    }

    private void checkAndRequestForPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)){

                Toast.makeText(getActivity(),"Please accept for requiered permission",Toast.LENGTH_SHORT).show();
            }
            else
            {

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        PReqCode);
            }
        }
        else
        {
            openGallery();

        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_INTENT && resultCode == RESULT_OK && data != null)
        {
            pickedImgUri= data.getData();
            image_personaje.setImageURI(pickedImgUri);
         /*StorageReference filepath = mStorage.child("fotos").child(pickedImgUri.getLastPathSegment());
         filepath.putFile(pickedImgUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
             @Override
             public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


             }
         });

          */
        }


    }

    class MyAdapter extends ArrayAdapter<String>
    {
        Context context;
        String rTitle[];
        int rImages[];

        MyAdapter(Context c, String title[], int imgs[]){
            super(c,R.layout.row,R.id.text1,title);
            this.context = c;
            this.rTitle=title;
            this.rImages = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row  = layoutInflater .inflate(R.layout.row,parent,false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.text1);
            version=row.findViewById(R.id.txtversion);
            arrow=row.findViewById(R.id.arrow);
            if (position==2)
            {
                arrow.setVisibility(View.GONE);
                version.setVisibility(View.VISIBLE);
            }
            if (position==3)
            {
                arrow.setVisibility(View.GONE);
                version.setVisibility(View.GONE);
            }

            images.setImageResource(rImages[position]);
            myTitle.setText(rTitle[position]);


            return row;
        }
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
                    String niv= dataSnapshot.child("nivel").getValue().toString();
                    String personaje=dataSnapshot.child("personaje").getValue().toString();

                    //Uri Image= Uri.parse(dataSnapshot.child("image").getValue().toString());


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
                    // image_personaje.setImageURI(Image);

                    Usuario.setText(us);
                    Nivel.setText(niv);



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    public void salir()
    {
        log_out.setContentView(R.layout.log_out);
        log_out.setCancelable(false);
        cancel=(TextView) log_out.findViewById(R.id.boton_cancel);
        acept=(Button) log_out.findViewById(R.id.boton_acept);
        message=(TextView) log_out.findViewById(R.id.tv_message);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log_out.dismiss();
            }
        });
        acept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                LoginManager.getInstance().logOut();
                Intent intencion = new Intent(getActivity(), IntroActivity.class);
                GoogleSignIn.getClient(
                        getContext(),
                        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
                ).signOut();
                startActivity(intencion);
                getActivity().finishAffinity();
            }
        });

        log_out.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        log_out.show();
    }



}