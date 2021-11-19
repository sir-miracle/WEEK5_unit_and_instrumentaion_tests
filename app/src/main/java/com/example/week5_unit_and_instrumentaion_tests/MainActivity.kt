package com.example.week5_unit_and_instrumentaion_tests

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class MainActivity : AppCompatActivity(), Communicator{

    private val registration = Registration()
    private val registrationInformation = RegistrationInformation()

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.my_fragment_container, fragment)
            transaction.commit()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(registration)

        val register = findViewById<BottomNavigationItemView>(R.id.registration)
        register.setOnClickListener {
            replaceFragment(registration)
        }

        val details = findViewById<BottomNavigationItemView>(R.id.account_details)
        details.setOnClickListener {
            replaceFragment(registrationInformation)
        }

    }
        // Overriding the function created in the Communicator interface, and using bundle to assign
        //what it is going to transfer to the other fragment using keys
    override fun passData(name: String, email: String, number: String, sex: String) {
        val bundle = Bundle()
        bundle.putString("key",name)
        bundle.putString("key1",email)
        bundle.putString("key2",number)
        bundle.putString("key3", sex)
        registrationInformation.arguments = bundle
        replaceFragment(registrationInformation)
    }


}