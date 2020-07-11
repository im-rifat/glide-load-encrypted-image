package com.decimg.glidetest.glide

import com.bumptech.glide.Priority
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.data.DataFetcher
import java.io.InputStream
import java.nio.ByteBuffer

import com.google.common.io.ByteStreams
import java.io.IOException
import java.lang.Exception
import java.lang.NullPointerException

class EFileDataFetcher(private val eFile: EFile, private val salt: Salt) : DataFetcher<ByteBuffer> {

    private var inputStream : InputStream? = null

    override fun getDataClass(): Class<ByteBuffer> {
        return ByteBuffer::class.java
    }

    override fun cleanup() {
        try {
            inputStream?.close()
            inputStream = null
        } catch (e: IOException) {
        }
    }

    override fun getDataSource(): DataSource {
        return DataSource.LOCAL
    }

    override fun cancel() {
    }

    override fun loadData(priority: Priority, callback: DataFetcher.DataCallback<in ByteBuffer>) {
        try {
            inputStream = salt.apply(eFile.getFileStream().getInputStream())

            val byteArray = ByteStreams.toByteArray(inputStream)
            callback.onDataReady(ByteBuffer.wrap(byteArray))
        } catch (ioe : IOException) {
        } catch (npe: NullPointerException) {
        } catch (e: Exception) {
        }
    }
}