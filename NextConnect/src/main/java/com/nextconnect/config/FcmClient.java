package com.nextconnect.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;

@Component
public class FcmClient {
	
	private FirebaseApp myApp;
	public FcmClient(FCMConfig settings) {

		/*
		 * Path currentPath=Paths.get("src\\main\\resources");
		 * System.out.println(currentPath.toAbsolutePath());
		 */
		System.out.println("a");
		Path p=Paths.get("src\\main\\resources", settings.getServiceAccountFile());
		try (InputStream serviceAccount = Files.newInputStream(p)) {
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

			myApp=FirebaseApp.initializeApp(options, "myApp");
		} catch (IOException e) {
			System.out.println("fcm client catch block");
			System.out.println(e);
		}

	}

	public void send(Map<String, String> data) throws InterruptedException, ExecutionException {

		Message message = Message.builder().putAllData(data).setToken("erspNo3uzcRw3R_buAGTyj:APA91bGdXZesa-3hO02KNeP8gaMw4rNEGFDpBob6YOIXawm4poHuAlAsk-s-5Y3iznjfwwJIGHVkOvy8bhwDbNXcoqa_9ZtV8IghsjZMd5bSM8YtBRaA8hWpyn70nVsL4ZKIbz3uno66")
				.setWebpushConfig(WebpushConfig.builder().putHeader("ttl", "300")
						.setNotification(
								new WebpushNotification("Background Title (server)", "Background Body (server)"))
						.build())
				.build();

		String response = FirebaseMessaging.getInstance(myApp).sendAsync(message).get();
		System.out.println("Sent message: " + response);
	}
}
