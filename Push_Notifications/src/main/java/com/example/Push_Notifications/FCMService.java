package com.example.Push_Notifications;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class FCMService {

	public void sendMessage(PushNotificationRequest request) throws FirebaseMessagingException {
		Message message = Message.builder().setNotification(new Notification(request.getTitle(), request.getMessage()))
				.setToken(request.getToken()).build();

		String response = FirebaseMessaging.getInstance().send(message);
		System.out.println("Message sent: " + response);
	}
}
