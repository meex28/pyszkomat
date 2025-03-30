package com.isi.pyszkomat.service.payment;

import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.PaymentIntent;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.PaymentIntentConfirmParams;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentMethodCreateParams;
import com.stripe.param.TokenCreateParams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws StripeException {
//		var stripeSecretToken = "fill_in";
//		StripeClient client = new StripeClient(stripeSecretToken);
//		PaymentIntentCreateParams paymentIntentParam = PaymentIntentCreateParams.builder()
//				.setAmount(300L) // = 3.00 PLN
//				.setCurrency("pln")
//				.setPaymentMethod("pm_card_visa")
//				.addPaymentMethodType("card")
//				.build();
//		var paymentIntent = client.paymentIntents().create(paymentIntentParam);
//
//		client.paymentIntents().confirm(paymentIntent.getId());

		SpringApplication.run(Application.class, args);
	}
}
