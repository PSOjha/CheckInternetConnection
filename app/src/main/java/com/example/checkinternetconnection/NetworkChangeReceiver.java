package com.example.checkinternetconnection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try{
            if(isOnline(context))
            {
                Toast.makeText(context,"Network Connected...",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(context,"Network not Connected...",Toast.LENGTH_LONG).show();
            }
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    public boolean isOnline(Context context){
        try{
            ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            return (networkInfo!=null && networkInfo.isConnected());
        }
        catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

}