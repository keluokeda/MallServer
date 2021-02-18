package com.ke.mall.server.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.ke.mall.model.shared.response.BaseResponse
import com.ke.mall.model.shared.response.LoginResponse
import com.ke.mall.server.db.Consumer
import com.ke.mall.server.db.MallServerDatabase
import com.ke.mall.server.manager.ConsumerTokenManager
import com.ke.mall.server.md5
import com.ke.mall.shared.IConsumerAidlInterface


class ConsumerService : Service() {

    private val consumerDao by lazy {
        MallServerDatabase.getInstance(applicationContext).consumerDao()
    }

    private val tokenManager = ConsumerTokenManager.instance

    private val binder = object : IConsumerAidlInterface.Stub() {
        override fun register(
            phone: String,
            code: String,
            password: String
        ): BaseResponse<LoginResponse> {

            if (phone.length <= 6 || phone.length >= 18) {
                return BaseResponse(message = "账号必须大于六位小于十八位", success = false)
            }

            if (password.length <= 6 || password.length >= 18) {
                return BaseResponse(message = "账密码必须大于六位小于十八位", success = false)
            }


            val target = consumerDao.findByPhone(phone)

            if (target != null) {
                return BaseResponse(message = "账号 $phone 已经存在", success = false)
            }

            val userId = consumerDao.insert(
                Consumer(
                    phone = phone,
                    password = password.md5()
                )
            )

            return BaseResponse(data = LoginResponse(userId, tokenManager.createToken(userId)))
        }

    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder {

        return binder
    }
}