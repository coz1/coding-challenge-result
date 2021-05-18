package com.mhp.coding.challenges.mapping

import netscape.javascript.JSObject
import org.assertj.core.api.Assertions.assertThat
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpStatus


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArticleControllerTest(@Autowired val restTemplate: TestRestTemplate) {
    @LocalServerPort
    private val port = 0

    private val URI = "/article"


    @Test
    fun `Testing statuscode when ResponseStatusCode - should return 202`() {
        val entity = restTemplate.getForEntity<String>("$URI/1001")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun `Testing statuscode when ResponseStatusCode - should return 404`() {
        val entity = restTemplate.getForEntity<String>("$URI/1")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.NOT_FOUND)
        //assertThat(entity.body).contains("")
    }

    @Test
    fun `Testing statuscode when ResponseStatusCode - should return 400`() {
        val entity = restTemplate.getForEntity<String>("$URI/10.01")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.BAD_REQUEST)
    }

    @Test
    fun `Testing content when Response contains correct properties`() {
        val id = "1001"
        val author = "Max Mustermann"
        val description = "Article Description 1001"
        val title = "Article Nr.: 1001"

        val entity = restTemplate.getForEntity<String>("$URI/1001")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains(id,author,title,description)
    }

}