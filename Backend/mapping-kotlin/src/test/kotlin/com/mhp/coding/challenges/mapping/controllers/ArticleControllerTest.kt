package com.mhp.coding.challenges.mapping.controllers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArticleControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    private val URI = "/article"

    @Test
    fun `should return 200`() {
        val entity = restTemplate.getForEntity<String>("$URI/1001")

        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun `should return 404`() {
        val entity = restTemplate.getForEntity<String>("$URI/1")

        assertThat(entity.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
    }

    @Test
    fun `should return 400`() {
        val entity = restTemplate.getForEntity<String>("$URI/10.01")

        assertThat(entity.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
    }

    @Test
    fun `response should be correct`() {
        val id = "1001"
        val author = "Max Mustermann"
        val description = "Article Description 1001"
        val title = "Article Nr.: 1001"
        val entity = restTemplate.getForEntity<String>("$URI/1001")

        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains(id,author,title,description)
    }

}