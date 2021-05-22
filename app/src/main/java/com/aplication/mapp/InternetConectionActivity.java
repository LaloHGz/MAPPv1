package com.aplication.mapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class InternetConectionActivity extends AppCompatActivity {

    private Button retry;
    private  long backPressedTime;
    private Toast backToast;
    private LinearLayout connection_Layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_conection);

        connection_Layout = findViewById(R.id.connectionLayout);
        retry = findViewById(R.id.bton_retry);
        if (ConectionManager.checkConection(getBaseContext()))
        {
            finish();
        }


        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ConectionManager.checkConection(getBaseContext()))
                {
                    finish();
                }

            }
        });

    }
    public void onBackPressed(){

        if (backPressedTime + 2000> System.currentTimeMillis())
        {
            //backToast.cancel();
            finishAffinity();
            finish();
            //return;
        }
        else
        {
            Snackbar.make(connection_Layout,getString(R.string.backToast),Snackbar.LENGTH_SHORT).show();
            //backToast = Toast.makeText(getBaseContext(),R.string.backToast, Toast.LENGTH_SHORT);
            //backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }

}
