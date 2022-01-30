package com.herokuapp.oyetekofficial.maintenancelog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_delete_schedule.*

class DeleteScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_schedule)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menuAddSchedule -> {
                val intent = Intent(this, AddScheduleActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuUpdateSchedule -> {
                val intent = Intent(this, UpdateScheduleActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuDeleteSchedule -> {
                return false
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

    fun onDelete(view: View) {
        // Alert Message Dialogue
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Delete")
        alertDialog.setIcon(R.drawable.maintenance_personnel)
        alertDialog.setMessage("Are you sure?")
        alertDialog.setCancelable(false)
        alertDialog.setPositiveButton("Yes") {_, _ ->
            val name = edtName3.text.toString()
            val phone = edtPhoneNumber2.text.toString().toInt()
            val dbHelper = DatabaseHelper(this)

            val result = dbHelper.deleteData(name, phone)

            when {
                result -> Toast.makeText(applicationContext, "Data Deleted Successfully...", Toast.LENGTH_LONG).show()
                else -> Toast.makeText(applicationContext, "Failed to Delete Data...", Toast.LENGTH_LONG).show()
            }
        }
        alertDialog.setNegativeButton("No") {_, _ ->
            Toast.makeText(applicationContext, "Delete Action Canceled", Toast.LENGTH_LONG).show()
        }
        val alert = alertDialog.create()
        alert.show()
    }
}