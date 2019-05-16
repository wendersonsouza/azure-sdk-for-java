// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.microsoft.azure.servicebus.primitives;

import org.apache.qpid.proton.message.Message;

import java.util.Arrays;

public class MessageWithDeliveryTag {
    private final Message message;
    private final byte[] deliveryTag;

    public MessageWithDeliveryTag(Message message, byte[] deliveryTag) {
        this.message = message;

        if (deliveryTag == null) {
            this.deliveryTag = null;
        } else {
            this.deliveryTag = Arrays.copyOf(deliveryTag, deliveryTag.length);
        }
    }

    public Message getMessage() {
        return message;
    }

    public byte[] getDeliveryTag() {
        if (this.deliveryTag == null) {
            return null;
        }
        return Arrays.copyOf(this.deliveryTag, this.deliveryTag.length);
    }
}
