package com.mhp.coding.challenges.dependency.notifications

import org.springframework.beans.factory.annotation.Autowired

class Adapter(
    @Autowired private val emailHandler: EmailHandler,
    @Autowired private val pushNotificationHandler: PushNotificationHandler
) {
}