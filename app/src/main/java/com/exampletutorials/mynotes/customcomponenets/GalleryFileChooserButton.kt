package com.exampletutorials.mynotes.customcomponenets

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.AttributeSet
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

/*interface DataHandler{
    fun continueWithPermissionsResult(result: Boolean)
}*/
class GalleryFileChooserButton @JvmOverloads constructor(context:Context, attrs:AttributeSet? ): Button(context,attrs)  {
    var dataType:String ="application/pdf"
     var requestCode: Int = -1
    var permissionReqCode: Int = -1
    init {
        this.setOnClickListener {
            startGallery()
        }
    }

    private fun startGallery() {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (context is Activity)
                ActivityCompat.requestPermissions(
                    context as Activity,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    permissionReqCode
                )
        }
        var intent=Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.setType(dataType)
        if (context is Activity) {
            (context as Activity).startActivityForResult(intent, requestCode)
        }
    }

     fun continueWithPermissionsResult(result: Boolean) {
        if (result) {
            startGallery()
        } else {
            Toast.makeText(
                context,
                "Please grant necessary permissions to the app in order to continue",
                Toast.LENGTH_LONG
            ).show()
        }
    }

}