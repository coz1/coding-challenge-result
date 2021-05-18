package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.db.blocks.*
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.models.dto.blocks.ArticleBlockDto
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface ICustomMapper {

    fun toArticle(articleDto: ArticleDto): Article
    fun toArticleDto(article: Article): ArticleDto

    @JvmDefault
    fun toArticleBlockDto(articleBlock: ArticleBlock?): ArticleBlockDto? {
        if (articleBlock is TextBlock) {
            return toTextBlockDto(articleBlock as TextBlock?)
        } else if (articleBlock is GalleryBlock) {
            return toGalleryBlockDto(articleBlock as GalleryBlock?)
        } else if (articleBlock is VideoBlock) {
            return toVideoBlockDto(articleBlock as VideoBlock?)
        } else if (articleBlock is ImageBlock) {
            return toImageBlockDto(articleBlock as ImageBlock?)
        }
        return null
    }

    @JvmDefault
    fun toArticleBlock(articleBlockDto: ArticleBlockDto?): ArticleBlock? {
        if (articleBlockDto is com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock) {
            return toTextBlock(articleBlockDto as com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock?)
        } else if (articleBlockDto is GalleryBlockDto) {
            toGalleryBlock(articleBlockDto as GalleryBlockDto?)
        } else if (articleBlockDto is com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock) {
            toVideoBlock(articleBlockDto as com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock?)
        } else if (articleBlockDto is com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock) {
            toImageBlock(articleBlockDto as com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock?)
        }
        return null
    }

    @JvmDefault
    fun articleBlockSetToArticleBlockDtoCollection(set: Set<ArticleBlock?>?): Collection<ArticleBlockDto?>? {
        if (set == null) {
            return null
        }
        val collection = ArrayList<ArticleBlockDto?>(set.size)
        for (articleBlock in set) {
            collection.add(toArticleBlockDto(articleBlock))
        }
        collection.sortBy { it?.sortIndex }

        return collection
    }

    fun toTextBlockDto(textBlock: TextBlock?): com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock?
    fun toTextBlock(textBlockDto: com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock?): TextBlock?

    fun toGalleryBlockDto(galleryBlock: GalleryBlock?): GalleryBlockDto?
    fun toGalleryBlock(galleryBlockDto: GalleryBlockDto?): GalleryBlock?

    fun toVideoBlockDto(videoBlock: VideoBlock?): com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock?
    fun toVideoBlock(videoBlockDto: com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock?): VideoBlock?

    fun toImageBlockDto(imageBlock: ImageBlock?): com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock?
    fun toImageBlock(imageBlockDto: com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock?): ImageBlock?
}


