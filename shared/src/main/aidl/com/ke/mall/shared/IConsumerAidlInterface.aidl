// IConsumerAidlInterface.aidl
package com.ke.mall.shared;

// Declare any non-default types here with import statements
import com.ke.mall.shared.response.BaseResponse;
import com.ke.mall.shared.response.LoginResponse;

interface IConsumerAidlInterface {


     BaseResponse register(String phone,String code,String password);
}