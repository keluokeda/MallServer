package com.ke.mall.server.manager

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.util.*

interface ConsumerTokenManager {

    fun createToken(id: Long): String

    fun parseToken(token: String): Long


    companion object {
        val instance: ConsumerTokenManager = ConsumerTokenManagerImpl
    }
}

private object ConsumerTokenManagerImpl : ConsumerTokenManager {
    private val key = Keys.secretKeyFor(SignatureAlgorithm.HS256)
    override fun createToken(id: Long): String {
        return Jwts.builder().setId(id.toString())
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 30))
            .signWith(key)
            .compact()
    }

    override fun parseToken(token: String): Long {
        return Jwts.parserBuilder().setSigningKey(key).build()
            .parseClaimsJws(token).body.id.toLong()
    }

}