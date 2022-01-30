package com.herokuapp.oyetekofficial.maintenancelog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_schedule.*

class AddScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_schedule)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuAddSchedule -> {
                return false
            }
            R.id.menuUpdateSchedule -> {
                val intent = Intent(this, UpdateScheduleActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuDeleteSchedule -> {
                val intent = Intent(this, DeleteScheduleActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuAbout -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuLogOut -> {
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuExit -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun onAdd(view: View) {
        val name = edtName.text.toString()
        val phone = edtPhoneNumber.text.toString().toInt()
        val address = edtAddress.text.toString()
        val date = edtMaintenanceDate.text.toString()
        val dbHelper = DatabaseHelper(this)

        val result = dbHelper.insertData(name, phone, address, date)

        when {
            result -> Toast.makeText(applicationContext, "Data Inserted Successfully...", Toast.LENGTH_LONG).show()
            else -> Toast.makeText(applicationContext, "Failed to Inserted Data...", Toast.LENGTH_LONG).show()
        }
    }
}