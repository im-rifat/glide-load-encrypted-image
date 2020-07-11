package com.decimg.glidetest.glide

import com.bumptech.glide.load.Options
import com.bumptech.glide.load.model.ModelLoader
import com.bumptech.glide.signature.ObjectKey
import java.nio.ByteBuffer

class EFileModelLoader(private val salt: Salt) : ModelLoader<EFile, ByteBuffer> {

    override fun handles(model: EFile): Boolean {
        return true
    }

    override fun buildLoadData(
        model: EFile,
        width: Int,
        height: Int,
        options: Options
    ): ModelLoader.LoadData<ByteBuffer>? {
        return ModelLoader.LoadData(ObjectKey(model.getUrl()), EFileDataFetcher(model, salt))
    }
}