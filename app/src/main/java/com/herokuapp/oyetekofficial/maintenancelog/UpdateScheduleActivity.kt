package com.herokuapp.oyetekofficial.maintenancelog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_update_schedule.*
import java.nio.Buffer

class UpdateScheduleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_schedule)
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
                return false
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

    fun onUpdate(view: View) {
        val name = edtName2.text.toString()
        val date = edtMaintenanceDate2.text.toString()
        val dbHelper = DatabaseHelper(this)

        val result = dbHelper.updateData(name, date)

        when {
            result -> Toast.makeText(applicationContext, "Data Update Successfully...", Toast.LENGTH_LONG).show()
            else -> Toast.makeText(applicationContext, "Failed to Update Data...", Toast.LENGTH_LONG).show()
        }
    }

    fun onFetch(view: View) {
        val dbHelper = DatabaseHelper(this)
        val data = dbHelper.fetchData()
        val stringBuffer = StringBuffer()

        if(data != null && data.count > 0) {
            while (data.moveToNext()) {
                stringBuffer.append("${data.getString(1)}, " +
                        "${data.getString(2)}, " +
                        "${data.getString(3)}, " +
                        "${data.getString(4)}\n")
            }
            tvListView.text = stringBuffer.toString()
            Toast.makeText(applicationContext, "Data Fetched Successfully...", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(applicationContext, "No Data Available...", Toast.LENGTH_LONG).show()
        }
    }
}