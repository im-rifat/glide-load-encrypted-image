package com.decimg.glidetest.glide

import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.load.model.ModelLoaderFactory
import com.bumptech.glide.load.model.MultiModelLoaderFactory
import java.nio.ByteBuffer

class EFileModelLoaderFactory(private val salt: Salt) : ModelLoaderFactory<EFile, ByteBuffer> {

    override fun build(multiFactory: MultiModelLoaderFactory): ModelLoader<EFile, ByteBuffer> {
        return EFileModelLoader(salt)
    }

    override fun teardown() {
    }
}