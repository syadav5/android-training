package com.exampletutorials.mynotes

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

interface Navigable {
    var componentNameToNavigateTo:String?
    var displayName: String
    fun setActivtiyName(fullQualifiedActivityname:String)
}
class NavigableButton @JvmOverloads constructor(context: Context, attrs:AttributeSet? = null):Button(context,attrs) , Navigable {
    init {
        this.setOnClickListener {
            try {
                this.componentNameToNavigateTo?.let {
                    var activityName: Class<Activity> = Class.forName(it) as Class<Activity>
                    context.startActivity(Intent(context, activityName))
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }

    var activityFullName:String? = null
    override var componentNameToNavigateTo: String?
        get() {
            return activityFullName
        }
        set(value) {
            Log.d("KKKK",value)
        }


    override var displayName: String = ""
        set(value) {
            text = value
        }
    override fun setActivtiyName(fullQualifiedActivityname: String) {
        this.componentNameToNavigateTo = fullQualifiedActivityname
    }
}