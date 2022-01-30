package com.herokuapp.oyetekofficial.maintenancelog

import android.provider.BaseColumns

object DatabaseContainer {
    class User : BaseColumns{
        companion object{
            const val TABLE_NAME = "Schedule"
            const val NAME_COLUMN = "Name"
            const val PHONE_COLUMN = "Phone"
            const val ADDRESS_COLUMN = "Address"
            const val DATE_COLUMN = "Date"
        }
    }
}