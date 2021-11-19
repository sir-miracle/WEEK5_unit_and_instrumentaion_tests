package com.example.week5_unit_and_instrumentaion_tests

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.text.isDigitsOnly


class Registration : Fragment() {
private lateinit var communicator: Communicator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        var inputName = view.findViewById<EditText>(R.id.name)
        var inputEmail = view.findViewById<EditText>(R.id.email)
        var inputNum = view.findViewById<EditText>(R.id.phone_number)

        //validation function starts here

        fun registrationValidation(name: Editable, email: Editable, phoneNumber: Editable, sex: String):Boolean{

            if(name!!.trim().isEmpty()){
                inputName.error="Your name is not valid"
                return false
            }

            if(email!!.trim().isEmpty()){
                inputEmail.error= "Your Email is not valid"
                return false
            }

            if(phoneNumber!!.trim().isEmpty()){
                inputNum.error= "Your phone number is not valid"
                return false
            }

            if(sex.isEmpty()){
                return false
            }

            if(!email.contains("@")){
                inputEmail.error = "Your email is not valid"
                return false
            }

            if(!phoneNumber.isDigitsOnly()){
                inputNum.error = "Your phone number is not valid"

                return false
            }

            if(!(phoneNumber.startsWith("0")||phoneNumber.startsWith("2"))){

                inputNum.error = "Your phone number is not valid"
                return false
            }

            if(phoneNumber.startsWith("0")&& phoneNumber.length!=11){

                inputNum.error = "Your phone number is not valid"
                return false
            }

            if(phoneNumber.startsWith("2") && phoneNumber.length!=13){

                inputNum.error = "Your phone number is not valid"

                return false
            }

            return true
        }

        // validation function ends here


        var spinnerResult: String = ""
        //creating array which the spinner view is going to work with
        val sex = arrayOf("male","female")
        val options = view.findViewById<Spinner>(R.id.gender_options)
        options.adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_dropdown_item, sex) as SpinnerAdapter?

        options.onItemSelectedListener = object :  AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long){
                spinnerResult = parent?.getItemAtPosition(position).toString()
                //Toast.makeText(context,"you selected ${parent?.getItemAtPosition(position).toString()}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        if(activity is MainActivity){
            communicator = activity as MainActivity
        }
//        communicator = activity as Communicator

        val sendBtn = view.findViewById<Button>(R.id.register_button)

        // In the button click listener, I initialized the function variables to the outputs of the
        // edit text views
        sendBtn.setOnClickListener {
            if(registrationValidation(
                    name = inputName.text,
                    email = inputEmail.text,
                    phoneNumber = inputNum.text, sex = spinnerResult )){

            communicator.passData(inputName.text.toString(), inputEmail.text.toString(), inputNum.text.toString(), spinnerResult)
            }
            //12else{}
        }
        return view
    }

}

