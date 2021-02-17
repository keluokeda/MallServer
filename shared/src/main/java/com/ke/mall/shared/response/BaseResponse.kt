package com.ke.mall.shared.response

import android.os.Parcelable
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize


@Parcelize
data class BaseResponse<out T : Parcelable>(
    val message: String? = null,
    val data: T? = null,
    val success: Boolean = true
) : Parcelable {
    fun toJson(): String {
        return Gson().toJson(this)
    }
}
