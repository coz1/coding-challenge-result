package com.mhp.coding.challenges.mapping.services

import com.mhp.coding.challenges.mapping.mappers.ICustomMapper
import com.mhp.coding.challenges.mapping.mappers.ICustomMapperImpl
import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository
import io.mockk.impl.annotations.MockK
import org.junit.jupiter.api.Test


import org.springframework.beans.factory.annotation.Autowired

internal class ArticleServiceTest{

    @MockK
    private val articleService = ArticleService()

    @Autowired
    lateinit var customMapper: ICustomMapper


    @Test
    fun bl() {
        val article = ArticleRepository.findBy(1001L)
        val articles  = article?.let { customMapper.toArticleDto(it) }


    }


}