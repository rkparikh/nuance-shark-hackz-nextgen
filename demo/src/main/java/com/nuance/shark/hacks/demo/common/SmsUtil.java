package com.nuance.shark.hacks.demo.common;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsUtil {
	 // Find your Account Sid and Auth Token at twilio.com/console
	 public static final String ACCOUNT_SID =
	         "***********************";
	 public static final String AUTH_TOKEN =
	         "*******************************";

	 public static void sendSms() {
	     Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

	     Message message = Message
	             .creator(new PhoneNumber("*******************"), // to
	                     new PhoneNumber("***************"), // from
	                     "Test ***********")
	             .create();

	     System.out.println("Sms Sent Sucessfully : " + message.getSid());
	 }

}
