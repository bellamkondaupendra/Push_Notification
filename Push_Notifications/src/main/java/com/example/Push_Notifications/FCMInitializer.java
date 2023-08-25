package com.example.Push_Notifications;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FCMInitializer {

    @Bean
    public void initialize() throws IOException {
    	FileInputStream serviceAccount = new FileInputStream(
    		    getClass().getResource("/viva-ad97b-firebase-adminsdk-iofze-f6b91a3952.json").getFile()
    		);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        FirebaseApp.initializeApp(options);
    }
}

