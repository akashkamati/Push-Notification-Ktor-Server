package com.akash.firebase

import com.akash.model.NotificationDetail
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun sendMessaging(notificationDetail: NotificationDetail): String {

    return withContext(Dispatchers.IO) {
        val dataMessage = Message.builder()
            .putData("title", notificationDetail.title)
            .putData("body", notificationDetail.body)



        if (notificationDetail.imageUrl != null) {
            dataMessage.putData("imageUrl", notificationDetail.imageUrl)
        }
        if (notificationDetail.deepLink != null) {
            dataMessage.putData("deepLink", notificationDetail.deepLink)
        }
        if (notificationDetail.token != null) {
            dataMessage.setToken(notificationDetail.token)
        }
        if (notificationDetail.topic != null && notificationDetail.token == null) {
            dataMessage.setTopic(notificationDetail.topic)
        }

        try {
            FirebaseMessaging.getInstance().send(dataMessage.build())
            "success"
        } catch (e: Exception) {
            "failed"
        }
    }
}



suspend fun subscribeToTopic(tokens:List<String>,topic:String){

    withContext(Dispatchers.IO){
        FirebaseMessaging.getInstance().subscribeToTopic(tokens,topic)
    }


}