package com.example.Push_Notifications;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessagingException;

@RestController
public class NotificationController {

	@Autowired
	private FCMService fcmService;

	@PostMapping("/send-notification")
	public Map<String, Object> sendNotification(@RequestBody PushNotificationRequest request)
			throws FirebaseMessagingException {
		fcmService.sendMessage(request);
		Map<String, Object> map = new HashMap<>();
		try {

		map.put("Status", "1");
		map.put("Message", "Notification sent Successfully");
		
		}
		catch(Exception e) {
			e.printStackTrace();
			map.put("Status", "0");
			map.put("Message", "Failed to send Notification");
		}
		return map;
		
	}
}
