package com.aplication.mapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConectionManager {


    public static boolean checkConection(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null)
        {
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();

            if (info != null)
            {
                for (int i=0;i<info.length;i++)
                {
                    if (info[1].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }
            }

        }




        return false;
    }
}












