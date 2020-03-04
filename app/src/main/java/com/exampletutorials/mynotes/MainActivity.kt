package com.exampletutorials.mynotes

import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var position =0
 /*   var imagesList = arrayOf(R.drawable.budhha_small, R.drawable.ganesh_small,
        R.drawable.shiv_small, R.drawable.shivlinga_small, R.drawable.krishna_small,R.drawable.maa_small, R.drawable.ram_small, R.drawable.yellowgod_small)
 */   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        img.setImageResource(R.drawable.london_img)

    }

    fun selectSwatch(view:View) {
        Palette.from((img.drawable as BitmapDrawable).bitmap).generate {
            var allSwatches = it?.swatches
            it?.let {
                when (view.id) {
                    R.id.darkMuted -> {
                        var title = it.darkMutedSwatch?.titleTextColor
                        var bodyClr = it.darkMutedSwatch?.bodyTextColor

                        imgtitle.setBackgroundColor(it.darkMutedSwatch?.rgb ?: Color.CYAN)
                        imgtitle.setTextColor(title?:R.color.colorAccent)
                        imgdesc.setTextColor(bodyClr ?: R.color.colorAccent)
                    }
                    R.id.darkVibrant -> {
                        var title = it.darkVibrantSwatch?.titleTextColor
                        var bodyClr = it.darkVibrantSwatch?.bodyTextColor
                        imgtitle.setBackgroundColor(it.darkVibrantSwatch?.rgb ?: Color.CYAN)

                        imgtitle.setBackgroundColor(title?:R.color.colorAccent)
                        imgdesc.setBackgroundColor(bodyClr ?: R.color.colorAccent)
                    }
                    R.id.lightMuted -> {
                        var title = it.lightMutedSwatch?.titleTextColor
                        var bodyClr = it.lightMutedSwatch?.bodyTextColor
                        imgtitle.setBackgroundColor(it.lightMutedSwatch?.rgb ?: Color.CYAN)

                        imgtitle.setBackgroundColor(title?:R.color.colorAccent)
                        imgdesc.setBackgroundColor(bodyClr ?: R.color.colorAccent)
                    }
                    R.id.muted -> {
                        var title = it.mutedSwatch?.titleTextColor
                        var bodyClr = it.mutedSwatch?.bodyTextColor
                        imgtitle.setBackgroundColor(it.mutedSwatch?.rgb ?: Color.CYAN)

                        imgtitle.setBackgroundColor(title?:R.color.colorAccent)
                        imgdesc.setBackgroundColor(bodyClr ?: R.color.colorAccent)
                    }
                    R.id.lightVibrant -> {
                        var title = it.lightVibrantSwatch?.titleTextColor
                        var bodyClr = it.lightVibrantSwatch?.bodyTextColor
                        imgtitle.setBackgroundColor(it.lightVibrantSwatch?.rgb ?: Color.CYAN)

                        imgtitle.setBackgroundColor(title?:R.color.colorAccent)
                        imgdesc.setBackgroundColor(bodyClr ?: R.color.colorAccent)
                    }
                }
            }
        }
    }
}
