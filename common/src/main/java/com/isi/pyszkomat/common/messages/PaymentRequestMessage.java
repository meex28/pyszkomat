package com.isi.pyszkomat.common.messages;

// TODO: add client details
public record PaymentRequestMessage(
    String orderId,
    Long amount,
    Long timestamp
) {}
