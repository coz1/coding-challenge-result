package com.mhp.coding.challenges.mapping.services

import com.mhp.coding.challenges.mapping.repositories.ArticleRepository
import com.mhp.coding.challenges.mapping.mappers.ArticleMapper
import com.mhp.coding.challenges.mapping.mappers.ICustomMapper
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleService{

    @Autowired
    lateinit var customMapper: ICustomMapper


    fun list(): List<ArticleDto> {
        val articles = ArticleRepository.all()
        val list: ArrayList<ArticleDto> = ArrayList(articles.size)

        for(article in articles) {
            list.add(customMapper.toArticleDto(article))
        }

        return list()
    }

    fun articleForId(id: Long): ArticleDto {
        val article = ArticleRepository.findBy(id)
        //TODO
        return ArticleDto(0, "", "", "", emptyList())
    }

    fun create(articleDto: ArticleDto): ArticleDto {
        val article = customMapper.toArticle(articleDto)
        ArticleRepository.create(article)
        return customMapper.toArticleDto(article)
    }
}
