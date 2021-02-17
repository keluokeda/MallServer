package com.ke.mall.server

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.provider.ContactsContract

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bindConsumerService()
    }

    private fun bindConsumerService() {
        val bindIntent = Intent("android.intent.action.ConsumerService")
        bindIntent.setPackage("com.ke.mall.server")
        bindService(bindIntent, object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName, service: IBinder?) {
                name.toString()
            }

            override fun onServiceDisconnected(name: ComponentName) {
                name.toString()

            }
        }, BIND_AUTO_CREATE)
    }
}