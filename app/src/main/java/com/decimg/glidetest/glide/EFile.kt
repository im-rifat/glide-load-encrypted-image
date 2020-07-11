package com.decimg.glidetest.glide

class EFile(private val imgUrl: String, private val fileStream: FileStream) {

    fun getUrl(): String = imgUrl

    fun getFileStream(): FileStream = fileStream
}