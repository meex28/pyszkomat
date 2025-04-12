package com.isi.pyszkomat.service.payment.service;

import com.isi.pyszkomat.common.PyszkomatQueues;
import com.isi.pyszkomat.common.messages.PaymentRequestMessage;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentRequestConsumer {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @SqsListener(PyszkomatQueues.PAYMENT_REQUEST)
    public void receiveMessage(PaymentRequestMessage message) {
        logger.info("Payment request message received: {}", message);
    }
}
