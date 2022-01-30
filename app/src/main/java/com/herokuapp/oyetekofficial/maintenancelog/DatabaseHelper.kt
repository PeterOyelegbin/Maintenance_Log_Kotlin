package com.herokuapp.oyetekofficial.maintenancelog

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.herokuapp.oyetekofficial.maintenancelog.DatabaseContainer.User.Companion.ADDRESS_COLUMN
import com.herokuapp.oyetekofficial.maintenancelog.DatabaseContainer.User.Companion.DATE_COLUMN
import com.herokuapp.oyetekofficial.maintenancelog.DatabaseContainer.User.Companion.NAME_COLUMN
import com.herokuapp.oyetekofficial.maintenancelog.DatabaseContainer.User.Companion.PHONE_COLUMN
import com.herokuapp.oyetekofficial.maintenancelog.DatabaseContainer.User.Companion.TABLE_NAME

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " ( " +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME_COLUMN + " VARCHAR, " +
                PHONE_COLUMN + " INTEGER, " +
                ADDRESS_COLUMN + " VARCHAR, " +
                DATE_COLUMN + " VARCHAR " + " ) "
        db!!.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
    }

    // SQL Insert Data Function
    fun insertData (name:String, phone:Int, address:String, date:String) : Boolean{
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(NAME_COLUMN, name)
        cv.put(PHONE_COLUMN, phone)
        cv.put(ADDRESS_COLUMN, address)
        cv.put(DATE_COLUMN, date)
        val insert = db.insert(TABLE_NAME, null, cv)
        db.close()
        return insert > -1
    }

    // SQL Update Data Function
    fun updateData (name:String, date:String) : Boolean{
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(DATE_COLUMN, date)
        val update = db.update(TABLE_NAME, cv, "$name=?", arrayOf(name))
        db.close()
        return update != -1
    }

    // SQL Fetch Data Function
    fun fetchData () : Cursor{
        val db = this.writableDatabase
        val fetch = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        return fetch
    }

    // SQL Delete Function
    fun deleteData (name:String, phone:Int) : Boolean{
        val db = this.writableDatabase
        val delete = db.delete(TABLE_NAME, "$name=?", arrayOf(name))
        return delete != -1
    }

    companion object{
        private const val DATABASE_NAME = "Catalog.db"
        private const val DATABASE_VERSION = 2
    }
}