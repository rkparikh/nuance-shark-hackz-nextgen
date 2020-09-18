package com.nuance.shark.hacks.demo.common;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.nuance.shark.hackz.emailnotification.model.EmailRecipient;
import com.nuance.shark.hackz.emailnotification.model.EmailRequest;
import com.nuance.shark.hackz.emailnotification.model.From;
import com.nuance.shark.hackz.emailnotification.provider.model.Content;
import com.nuance.shark.hackz.emailnotification.provider.model.MailSettings;
import com.nuance.shark.hackz.emailnotification.provider.model.Personalization;
import com.nuance.shark.hackz.emailnotification.provider.model.SandBoxMode;
import com.nuance.shark.hackz.emailnotification.provider.model.SendGridEmailRequest;

public class EmailUtil {

	public static final String EMAIL_API = "v3/mail/send";
	public static final String EMAIL_BASE_URL = "https://api.sendgrid.com";
	public static final String AUTH_TOKEN = "Bearer ************************************";

	public static void sendEmail() {
		notify(getEmailVerificationRequest());
	}

	public static void notify(EmailRequest emailNotificationRequest) {
		SendGridEmailRequest sendGridEmailRequest = toSendGridEmailRequest(emailNotificationRequest);
		Response sendGridResponse = null;
		try {
			sendGridResponse = post(sendGridEmailRequest, AUTH_TOKEN, EMAIL_API, EMAIL_BASE_URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Email sent successfully. Send Grid Status : " + sendGridResponse.getStatus());
	}

	private static SendGridEmailRequest toSendGridEmailRequest(EmailRequest emailNotificationRequest) {
		List<Personalization> personalizations = new ArrayList<Personalization>();
		Personalization personalization = new Personalization.Builder().subject(emailNotificationRequest.getSubject())
				.to(emailNotificationRequest.getTo()).build();
		personalizations.add(personalization);
		List<Content> contentList = new ArrayList<Content>();
		Content content = new Content.Builder().type("text/html").value(emailNotificationRequest.getContent()).build();
		contentList.add(content);
		From from = emailNotificationRequest.getFrom();
		SendGridEmailRequest sendGridEmailRequest = new SendGridEmailRequest.Builder()
				.personalizations(personalizations).from(from).content(contentList)
				.mailSettings(
						new MailSettings.Builder().sandBoxMode(new SandBoxMode.Builder().enable(false).build()).build())
				.build();
		return sendGridEmailRequest;
	}

	public static <T> Response post(T request, String token, String api, String baseUrl) throws Exception {
		Response response = null;
		WebClient webClient = null;
		try {
			if (webClient == null) {
				List<JacksonJsonProvider> jsonProviders = new ArrayList<JacksonJsonProvider>();
				JacksonJsonProvider provider = new JacksonJsonProvider();
				jsonProviders.add(provider);
				webClient = WebClient.create(baseUrl, jsonProviders, true);
			}
			webClient.path(api).type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
					.header(HttpHeaders.AUTHORIZATION, token);
			response = webClient.post(request);
		} finally {
			if (webClient != null) {
				webClient.reset();
				webClient.close();
			}
		}
		return response;
	}

	private static EmailRequest getEmailVerificationRequest() {

		EmailRequest emailNotificationRequest = new EmailRequest();

		String userContactEmail = "*************";
		String firstName = "**";
		String lastName = "*****";
		String name = firstName + lastName;
		List<EmailRecipient> toList = new ArrayList<EmailRecipient>();
		toList.add(new EmailRecipient.Builder().email(userContactEmail).name(name).build());
		emailNotificationRequest.setTo(toList);
		emailNotificationRequest.setContent("This is test email ********************");
		From from = new From();
		from.setEmail("*****************");
		from.setName("********");
		emailNotificationRequest.setFrom(from);
		emailNotificationRequest.setSubject("********************");

		return emailNotificationRequest;
	}
}
