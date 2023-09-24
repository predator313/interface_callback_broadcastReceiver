package com.aamirashraf.myclick

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(),InterfaceOnClick {
    private lateinit var tv_man:TextView
    private val apmBroadCast=APMBroadCast()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver(apmBroadCast,
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        )
        setContentView(R.layout.activity_main)
        tv_man=findViewById(R.id.tv_main)
        val fm:FragmentManager=supportFragmentManager
        fm.beginTransaction().replace(R.id.fragmentA,Fragmenta())
            .replace(R.id.fragmentB,Fragmentb()).commit()
    }

    override fun setOnClick(name: String) {
        tv_man.text = name
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(apmBroadCast)
    }
}