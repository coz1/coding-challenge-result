package com.mhp.coding.challenges.dependency.notifications

import com.mhp.coding.challenges.dependency.inquiry.Inquiry
import com.mhp.coding.challenges.dependency.inquiry.InquiryHandler
import org.springframework.beans.factory.annotation.Autowired

class Adapter(
    @Autowired private val emailHandler: EmailHandler,
    @Autowired private val pushNotificationHandler: PushNotificationHandler,
): InquiryHandler {
    override fun handle(inquiry: Inquiry) {
        emailHandler.sendEmail(inquiry)
        pushNotificationHandler.sendNotification(inquiry)
    }
}