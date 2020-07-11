package com.decimg.glidetest

import android.content.res.AssetFileDescriptor
import com.decimg.glidetest.glide.FileStream
import java.io.InputStream

class AssetFileStream(private val assetFile: AssetFileDescriptor) :
    FileStream {

    override fun getInputStream(): InputStream {
        return assetFile.createInputStream()
    }
}