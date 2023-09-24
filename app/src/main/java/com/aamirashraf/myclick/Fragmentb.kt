package com.aamirashraf.myclick

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.lang.ClassCastException


class Fragmentb : Fragment(R.layout.fragment_fragmentb) {
    private var mlistener:InterfaceOnClick?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is InterfaceOnClick){
            mlistener=context
        }
        else{
            throw ClassCastException("$context must implement OnFragmentClickListener")
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnB=view.findViewById<Button>(R.id.btnB)
        btnB.setOnClickListener {
            mlistener?.setOnClick("FragmentB")
        }
    }

}