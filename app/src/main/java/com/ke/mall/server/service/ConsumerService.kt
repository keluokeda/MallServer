package com.ke.mall.server.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.os.Parcelable
import com.ke.mall.server.db.Consumer
import com.ke.mall.server.db.MallServerDatabase
import com.ke.mall.server.manager.ConsumerTokenManager
import com.ke.mall.server.md5
import com.ke.mall.shared.IConsumerAidlInterface
import com.ke.mall.shared.response.BaseResponse
import com.ke.mall.shared.response.LoginResponse

class ConsumerService : Service() {

    private val consumerDao by lazy {
        MallServerDatabase.getInstance(applicationContext).consumerDao()
    }

    private val tokenManager = ConsumerTokenManager.instance

    private val binder = object : IConsumerAidlInterface.Stub() {
        override fun register(account: String, password: String): BaseResponse<LoginResponse> {

            if (account.length <= 6 || account.length >= 18) {
                return BaseResponse(message = "账号必须大于六位小于十八位", success = false)
            }

            if (password.length <= 6 || password.length >= 18) {
                return BaseResponse(message = "账密码必须大于六位小于十八位", success = false)
            }


            val target = consumerDao.findByAccount(account)

            if (target != null) {
                return BaseResponse(message = "账号 $account 已经存在", success = false)
            }

            val userId = consumerDao.insert(
                Consumer(
                    account = account,
                    password = password.md5(),
                    nickname = account,
                    plus = false,
                    avatarUrl = null,
                    score = 0,
                    enable = true,
                    ban = false,
                    banReason = null
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