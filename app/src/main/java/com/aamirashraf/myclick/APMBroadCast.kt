package com.aamirashraf.myclick

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log

class APMBroadCast:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        //here we receive the broadcast
        //for the air plane mode
        if(intent?.action==Intent.ACTION_AIRPLANE_MODE_CHANGED){
            val isEnabled= Settings.Global.getInt(
                context?.contentResolver,
                Settings.Global.AIRPLANE_MODE_ON

            )!=0
            Log.d("hello","air plane mode is turned $isEnabled")
        }
    }
}