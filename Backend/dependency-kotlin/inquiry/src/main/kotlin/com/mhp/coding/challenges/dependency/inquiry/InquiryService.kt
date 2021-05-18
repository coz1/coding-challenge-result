package com.mhp.coding.challenges.dependency.inquiry

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger {}

@Component
class InquiryService(
    @Autowired var handlers: List<InquiryHandler>,
){
    fun create(inquiry: Inquiry) {
        logger.info {
            "User sent inquiry: $inquiry"
        }
        handlers.forEach { it.handle(inquiry) }
    }
}

data class Inquiry(
    var username: String,
    var recipient: String,
    var text: String,
)