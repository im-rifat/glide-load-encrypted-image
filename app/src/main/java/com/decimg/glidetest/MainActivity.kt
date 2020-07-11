package com.decimg.glidetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.decimg.glidetest.glide.EFile
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            GlideApp.with(this).load(EFile("sample_enc.jpg", AssetFileStream(assets.openFd("sample_enc.jpg"))))
                .into(findViewById(R.id.img))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}