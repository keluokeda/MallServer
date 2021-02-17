package com.ke.mall.server

import java.security.MessageDigest

fun String.md5(): String {
    val digest = MessageDigest.getInstance("MD5")
    return toHex(digest.digest(this.toByteArray()))
}

private fun toHex(byteArray: ByteArray): String {

    //高阶函数


    return with(StringBuilder()) {
        //转成16进制
        byteArray.forEach {
            val value = it
            val hex = value.toInt() and (0xFF)
            val hexStr = Integer.toHexString(hex)
            //println(hexStr)
            if (hexStr.length == 1) {
                append("0").append(hexStr)
            } else {
                append(hexStr)
            }
        }
        toString()
    }
}