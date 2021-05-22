package com.aplication.mapp.menu;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.aplication.mapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MapaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

/*        if (ConectionManager.checkConection(getBaseContext()))
        {

        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
            Intent intent=new Intent(getApplication(), InternetConectionActivity.class);
            startActivity(intent);
                                  }
            },1000);
        }

 */

        BottomNavigationView bottomNav= findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

    }

       /*bottomNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_one:
                    clickedNavItem = R.id.nav_one;
                    fragment = SampleFragment.newInstance(0);
                    break;
                case R.id.nav_two:
                    clickedNavItem = R.id.nav_two;
                    fragment = SampleFragment.newInstance(1);
                    break;
                case R.id.nav_five:
                    //Opens up an Intent
                    clickedNavItem = R.id.nav_five;
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        */



    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragmnet   =   null;

                    switch (menuItem.getItemId())
                    {
                        case R.id.nav_home:
                            selectedFragmnet = new HomeFragment();
                            break;
                        case R.id.nav_teoria:
                            selectedFragmnet = new CompilerFragment();
                            break;
                        case R.id.nav_temas:
                            selectedFragmnet = new TemasFragment();
                            break;
                        case R.id.nav_perfil:
                            selectedFragmnet = new PerfilFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragmnet).commit();
                    return true;
                }
            };


    public void onBackPressed()
    {
        finishAffinity();
    }



}
