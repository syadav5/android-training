package com.exampletutorials.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_catalogue.*

class CatalogueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogue)
        setupCatalogue()
    }
    fun setupCatalogue(){
        (mainActivity as NavigableButton)?.apply {
            componentNameToNavigateTo = MainActivity::class.qualifiedName
            activityFullName = MainActivity::class.qualifiedName
            displayName = "Palette API Example"
        }
        (animations as NavigableButton)?.apply {
            componentNameToNavigateTo = Animations::class.qualifiedName
            activityFullName = Animations::class.qualifiedName
            displayName = "Animations API Example"
        }
        (motionLayoutEx as NavigableButton)?.apply {
            componentNameToNavigateTo = MotionLayoutAnimationEx::class.qualifiedName
            activityFullName = MotionLayoutAnimationEx::class.qualifiedName
            displayName = "Motion Layout Animations Example"
        }
        (biometrics as NavigableButton)?.apply {
            componentNameToNavigateTo = Authenticator::class.qualifiedName
            activityFullName = Authenticator::class.qualifiedName
            displayName = "Biometrics API Example"
        }
        (biometrics as NavigableButton)?.apply {
            componentNameToNavigateTo = Authenticator::class.qualifiedName
            activityFullName = Authenticator::class.qualifiedName
            displayName = "Biometrics API Example"
        }
        (pdfViewer as NavigableButton)?.apply {
            componentNameToNavigateTo = PdfViewerActivity::class.qualifiedName
            activityFullName = PdfViewerActivity::class.qualifiedName
            displayName = "PDF Viewer Example"
        }

        }

    }
