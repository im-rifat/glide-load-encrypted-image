package com.decimg.glidetest

import com.decimg.glidetest.glide.Salt
import org.apache.commons.codec.binary.Base64
import java.io.InputStream
import javax.crypto.Cipher
import javax.crypto.SecretKey
import java.nio.charset.Charset
import java.security.MessageDigest
import java.util.*
import javax.crypto.spec.SecretKeySpec


class SimpleDecryption : Salt {

    private val secretKey: SecretKey

    init {
        var key: ByteArray
        val myKey = "Hello Glide"

        var sha: MessageDigest? = null
        key = myKey.toByteArray(Charset.forName("UTF-8"))
        sha = MessageDigest.getInstance("SHA-1")
        key = sha!!.digest(key)
        key = Arrays.copyOf(key, 16) // use only first 128 bit
        secretKey = SecretKeySpec(key, "AES")
    }

    override fun apply(inputStream: InputStream): InputStream {
        return decryptFile(secretKey, inputStream.readBytes())?.inputStream()!!
    }

    fun decryptFile(secretKey: SecretKey, arr: ByteArray): ByteArray? {
        val cipher: Cipher
        var decrypted: ByteArray? = null
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING")

            cipher.init(Cipher.DECRYPT_MODE, secretKey)
            decrypted = cipher.doFinal(Base64.decodeBase64(arr))

        } catch (e: Exception) {
            println("Error while decrypting: $e")
        }

        return decrypted
    }
}