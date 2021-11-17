package com.example.week5_unit_and_instrumentaion_tests


import com.google.common.truth.Truth.assertThat
import org.junit.Test

// This is the generated test class
// Here we define functions that will use assertions to test our actual functions

class RegistrationTestTest{
    @Test
    fun `Empty user name is false`(){
        val result = RegistrationTest.registrationValidation(name = "", email = "miracle@gmail.com",phoneNumber = "08131248253", sex = "male", password = "wer")

        assertThat(result).isFalse()

    }
    @Test
    fun `Empty user email is false`(){
        val result = RegistrationTest.registrationValidation(name = "miracle", email = "",phoneNumber = "08131248253",sex = "male", password = "wer")

        assertThat(result).isFalse()

    }

    @Test
    fun `Empty user phone number is false`(){
        val result = RegistrationTest.registrationValidation(name = "miracle", email = "miracle@gmail.com",phoneNumber = "",sex = "male", password = "we3d")

        assertThat(result).isFalse()

    }

    @Test
    fun `Empty user gender is false`(){
        val result = RegistrationTest.registrationValidation(name = "miracle", email = "miracle@gmail.com",phoneNumber = "08131248253",sex = "", password = "wsd")

        assertThat(result).isFalse()

    }

    @Test
    fun `User email without "@" is false`(){
        val result = RegistrationTest.registrationValidation(name = "miracle", email = "miracle@gmail.com",phoneNumber = "08131248253",sex = "male", password = "wer")

        assertThat(result).isFalse()

    }

    @Test
    fun `User phone number not all digits  is false`(){
        val result = RegistrationTest.registrationValidation(name = "miracle", email = "miracle@gmail.com",phoneNumber = "0813124825r",sex = "male",password = "wer")

        assertThat(result).isFalse()

    }

    @Test
    fun `User phone number does not start with "0" or "2" is false`(){
        val result = RegistrationTest.registrationValidation(name = "miracle", email = "miracle@gmail.com",phoneNumber = "28131248253",sex = "male", password = "wer")

        assertThat(result).isFalse()

    }

    @Test
    fun `User phone number starts with "0" but length not equal to "11" is false`(){
        val result = RegistrationTest.registrationValidation(name = "miracle", email = "miracle@gmail.com",phoneNumber = "081237",sex = "male", password = "wer")

        assertThat(result).isFalse()

    }

    @Test
    fun `User phone number starts with "2" but length not equal to 13  is false`(){
        val result = RegistrationTest.registrationValidation(name = "miracle", email = "miracle@gmail.com",phoneNumber = "2348131248",sex = "male", "wer")

        assertThat(result).isFalse()

    }

    //password

    @Test
    fun `User password field being empty is false`(){
        val result = RegistrationTest.registrationValidation(name = "miracle", email = "miracle@gmail.com",phoneNumber = "08131248253",sex = "male", "")

        assertThat(result).isFalse()

    }


}



