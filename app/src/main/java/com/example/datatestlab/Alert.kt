package com.example.datatestlab

import android.app.Activity
import android.app.AlertDialog

class Alert {
    companion object{
        fun show(title: String, message: String, activity: Activity){
            val alert = AlertDialog.Builder(activity)
            alert.setTitle(title)
            alert.setMessage(message)
            alert.show()
        }
    }
}