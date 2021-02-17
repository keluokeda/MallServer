package com.ke.mall.shared.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class BaseResponse<out T : Parcelable>(
    val message: String = "",
    val data: T? = null,
    val success: Boolean = true
) : Parcelable {

}
