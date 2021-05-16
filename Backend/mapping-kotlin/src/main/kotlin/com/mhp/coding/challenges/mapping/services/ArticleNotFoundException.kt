package com.mhp.coding.challenges.mapping.services

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.server.ResponseStatusException

@ResponseStatus()
class ArticleNotFoundException(message: String?) : ResponseStatusException(HttpStatus.NOT_FOUND, message)