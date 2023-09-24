package com.aamirashraf.myclick

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlin.concurrent.thread

class Fragmenta : Fragment(R.layout.fragment_fragmenta) {
    private var mlistener:InterfaceOnClick?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is InterfaceOnClick)mlistener=context
        else{
            throw ClassCastException("$context must implement OnFragmentClickListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnA=view.findViewById<Button>(R.id.btnA)
        btnA.setOnClickListener {
//            Toast.makeText(activity,"FragmentA is Clicked",Toast.LENGTH_SHORT).show()
            mlistener?.setOnClick("FragmentA")
        }
    }
}