package com.mhp.coding.challenges.mapping

import com.mhp.coding.challenges.mapping.mappers.ICustomMapper
import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository
import com.mhp.coding.challenges.mapping.services.ArticleService
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest
class ApplicationTests {
    @Test
    fun contextLoads() {
    }

    @MockK
    private val articleRepoMock: ArticleRepository? = null

    @MockK
    private val mapper: ICustomMapper? = null

    @InjectMockKs
    private val articleService: ArticleService = TODO()

    private val article: Article? = null
    private val articleDto: ArticleDto? = null


    @Test
    fun givenServiceMock_whenCallingMockedMethod_thenCorrectlyVerified() {
        // given





       /*
        val getOneArticleDto = service.list()
        val list = service.articleForId(1001L)
        println("--------------->" + list)
        every { service.articleForId(1001L) } returns getOneArticleDto[0]

        // when
        val result = service.articleForId(1001L)

        // then
        verify { service.articleForId(1001L) }
        assertEquals("Expected Output", result)
*/

    }



}
