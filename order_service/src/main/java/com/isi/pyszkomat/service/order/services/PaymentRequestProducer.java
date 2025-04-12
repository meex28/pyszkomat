package com.isi.pyszkomat.service.order.services;

import com.isi.pyszkomat.common.PyszkomatQueues;
import com.isi.pyszkomat.common.messages.PaymentRequestMessage;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
// TODO: Add interface?
public class PaymentRequestProducer {
    private final SqsTemplate sqsTemplate;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendMessage(PaymentRequestMessage message) {
        logger.info("Sending payment request message: {}", message);
        sqsTemplate.send(PyszkomatQueues.PAYMENT_REQUEST, message);
    }
}
