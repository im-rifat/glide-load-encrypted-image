package com.decimg.glidetest.glide

import java.io.InputStream

interface Salt {

    fun apply(inputStream: InputStream): InputStream
}