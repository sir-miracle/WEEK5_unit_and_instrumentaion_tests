package com.example.week5_unit_and_instrumentaion_tests

import android.os.Bundle
import android.provider.Settings.Global.putString
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class RegistrationInformation : Fragment() {
    private lateinit var displayMessage: String
    var displayMessage1: String? = ""
    var displayMessage2: String? = ""
    var displayMessage3: String? = ""


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_registration_information, container, false)

        val outputName = view.findViewById<TextView>(R.id.the_name)
        val outputEmail = view.findViewById<TextView>(R.id.the_email)
        var outputNUmber = view.findViewById<TextView>(R.id.the_number)
       var outputSex = view.findViewById<TextView>(R.id.the_gender)

        displayMessage = arguments?.getString("key").toString()
        displayMessage1 = arguments?.getString("key1")
        displayMessage2 = arguments?.getString("key2")
        displayMessage3 = arguments?.getString("key3")

        outputName.text = displayMessage.trim()  //trimming will remove spaces in front of or after
        outputEmail.text = displayMessage1!!.trim() //the texts
        outputNUmber.text = displayMessage2!!.trim()
        outputSex.text = displayMessage3

        return view
    }

}
