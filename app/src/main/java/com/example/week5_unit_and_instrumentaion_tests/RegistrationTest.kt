package com.example.week5_unit_and_instrumentaion_tests

import androidx.core.text.isDigitsOnly

object RegistrationTest {
    // This is the singleton object for that holds the test function

    /**
     * The input is not valid if ...
     * ...the name or email or phone number is empty
     * ...the email does not contain the symbol "@"
     * ...the phoneNumber are not all digits
     * ...the phoneNumber does not start with 0 or +234
     * ...the phoneNumber starts with 0 and length not equal to 11
     * ...the phoneNumber starts with +234 and length not equal to 13
     * ...the gender is empty
     */

    fun registrationValidation(name: String, email: String, phoneNumber: String, sex: String, password: String):Boolean{

        if(name.isEmpty()|| email.isEmpty()||phoneNumber.isEmpty()|| sex.isEmpty()){
            return false
        }
        if(email.contains("@")){
            return false
        }



        if(!phoneNumber.isDigitsOnly()){
            return false
        }

        if(!(phoneNumber.startsWith("0")||phoneNumber.startsWith("+"))){
            return false
        }



        if(phoneNumber.startsWith("0")&& phoneNumber.length!=11){
            return false
        }

        if(phoneNumber.startsWith("+234") && phoneNumber.length!=14){
            return false
        }

        //password
        if(password.isEmpty()){
            return false
        }

        return true
    }
}