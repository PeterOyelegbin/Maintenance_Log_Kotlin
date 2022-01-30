package com.herokuapp.oyetekofficial.maintenancelog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
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
                val intent = Intent(this, DeleteScheduleActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuAbout -> {
                return false
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
}