package IThub.kotlin.KotlinFromScratch.MyFirstKotlinScratch.app.base

import android.net.ParseException
import android.util.Log
import org.json.JSONException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 异常抛出帮助类
 * @author yyx
 */

 class ExceptionHelper {

     inner class ApiException : RuntimeException {

         private var code: Int = 0


         constructor(throwable: Throwable, code: Int) : super(throwable) {
             this.code = code
         }

         constructor(message: String) : super(Throwable(message)) {

         }
     }

     companion object {

         fun handleException(e: Throwable): String {
             e.printStackTrace()
             val error: String
             if (e is SocketTimeoutException) {//网络超时
                 Log.e("TAG", "网络连接异常: " + e.message)
                 error = "网络连接异常"
             } else if (e is ConnectException) { //�?�视为网络错误
                 Log.e("TAG", "网络连接异常: " + e.message)

                 error = "网络连接异常"
             } else if (
             //                e instanceof JsonParseException ||
             e is JSONException || e is ParseException) {   //�?�视为解�?错误
                 Log.e("TAG", "数�?�解�?异常: " + e.message)
                 error = "数�?�解�?异常"
             } else if (e is ApiException) {//�?务器返回的错误信�?�
                 error = e.cause?.message!!
             } else if (e is UnknownHostException) {
                 Log.e("TAG", "网络连接异常: " + e.message)
                 error = "网络连接异常"
             } else if (e is IllegalArgumentException) {
                 Log.e("TAG", "下载文件已存在: " + e.message)
                 error = "下载文件已存在"
             } else {//未知错误
                 try {
                     Log.e("TAG", "错误: " + e.message)
                 } catch (e1: Exception) {
                     Log.e("TAG", "未知错误Debug调试 ")
                 }

                 error = "错误"
             }
             return error
         }
     }

 }