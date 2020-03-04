package com.exampletutorials.mynotes

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Canvas
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.exampletutorials.mynotes.customcomponenets.GalleryFileChooserButton
import com.github.barteksc.pdfviewer.listener.OnDrawListener
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener
import kotlinx.android.synthetic.main.activity_pdf_viewer.*

class PdfViewerActivity : AppCompatActivity() {

    private val GALLERY_PERM_CODE: Int = 111
    private val PDF_LAUNCH_REQ_CODE: Int = 222
    private lateinit var galleryBtn: GalleryFileChooserButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)
        pdfView.fromAsset("mvi.pdf").load()
        galleryBtn = openBtn
        galleryBtn.permissionReqCode = GALLERY_PERM_CODE
        galleryBtn.dataType = "application/pdf"
        galleryBtn.requestCode = PDF_LAUNCH_REQ_CODE
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == GALLERY_PERM_CODE) {
            permissions.forEachIndexed { indx, permission ->
                if (permission == Manifest.permission.READ_EXTERNAL_STORAGE) {
                    galleryBtn.continueWithPermissionsResult(grantResults[indx] == PackageManager.PERMISSION_GRANTED)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK && requestCode == PDF_LAUNCH_REQ_CODE) {
            data?.data?.let {
                pdfView.fromUri(it)
                    .enableSwipe(true)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    .onDraw(object:OnDrawListener{
                        override fun onLayerDrawn(
                            canvas: Canvas?,
                            pageWidth: Float,
                            pageHeight: Float,
                            displayedPage: Int
                        ) {
                            Toast.makeText(this@PdfViewerActivity, "PDF DRAW LISTENER ${canvas},$pageWidth, $displayedPage,$pageHeight",Toast.LENGTH_LONG).show()
                        }
                    })
                    .onPageError(object : OnPageErrorListener {
                        override fun onPageError(page: Int, t: Throwable?) {
                            Toast.makeText(
                                this@PdfViewerActivity,
                                "ERROR LOADING THE PDF .. ",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    })
                    .load()
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}


