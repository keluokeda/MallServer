// IConsumerAidlInterface.aidl
package com.ke.mall.shared;

// Declare any non-default types here with import statements
import com.ke.mall.shared.response.BaseResponse;
interface IConsumerAidlInterface {


     BaseResponse register(String account,String password);
}