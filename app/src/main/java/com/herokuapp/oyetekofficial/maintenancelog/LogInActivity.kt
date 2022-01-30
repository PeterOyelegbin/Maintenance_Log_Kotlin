package com.herokuapp.oyetekofficial.maintenancelog

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_log_in.*

class LogInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
    }

    fun onLogIn(view: View) {
        val username = edtName.text.toString()
        val password = edtPassword.text.toString()
        when{
            username == "oyetek" && password == "oyetek@65" -> startActivity(Intent(this, AddScheduleActivity::class.java))
            else -> Toast.makeText(applicationContext, "UserName or Password Incorrect", Toast.LENGTH_LONG).show()
        }
    }
}