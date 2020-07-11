package com.decimg.glidetest

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.decimg.glidetest.glide.EFile
import com.decimg.glidetest.glide.EFileModelLoaderFactory
import java.nio.ByteBuffer

@GlideModule
class MyAppGlideModule : AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.prepend(EFile::class.java, ByteBuffer::class.java, EFileModelLoaderFactory(SimpleDecryption()))
    }
}