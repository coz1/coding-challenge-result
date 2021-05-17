package com.mhp.coding.challenges.mapping

import com.mhp.coding.challenges.mapping.mappers.ICustomMapper
import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.db.Image
import com.mhp.coding.challenges.mapping.models.db.ImageSize
import com.mhp.coding.challenges.mapping.models.db.blocks.*
import com.mhp.coding.challenges.mapping.models.dto.ArticleDto
import com.mhp.coding.challenges.mapping.models.dto.ImageDto
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto
import com.mhp.coding.challenges.mapping.repositories.ArticleRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.junit.jupiter.api.Test
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest
class CustomMapperTest {

    @Autowired
    lateinit var customMapper: ICustomMapper

    @Test
    fun contextLoads() {
    }

    @Test
    fun articleToArticleDto_mapping(){
        val article = Article("Article Nr.:1001","Article Description 1001","Max Mustermann", emptySet(),1001L, Date())
        val toArticleDto = customMapper.toArticleDto(article)

        assertEquals(article.id, toArticleDto.id)
        assertEquals(article.author, toArticleDto.author)
        assertEquals(article.description, toArticleDto.description)
        assertEquals(article.title, toArticleDto.title)
    }

    @Test
    fun articleDtoToArticle_whenMapping_correct(){
        val articleDto = ArticleDto(1001L,"Article Nr.:1001","Article Description 1001","Max Mustermann", emptyList())
        val articleDto2 = ArticleRepository.all()
        val toArticle = customMapper.toArticle(articleDto)

        assertEquals(articleDto2[0].id, toArticle.id)
        assertEquals(articleDto2[0].author, toArticle.author)
        assertEquals(articleDto2[0].description, toArticle.description)
        assertEquals(articleDto2[0].title, toArticle.title)
    }

    @Test
    fun textBlockToTextBlockDto_whenMapping_(){
        val textBlock = TextBlock("Some Text for 1001",0)
        val toTextBlockDto = customMapper.toTextBlockDto(textBlock)

        assertNotNull(toTextBlockDto)
        assertEquals(textBlock.sortIndex, toTextBlockDto!!.sortIndex)
        assertEquals(textBlock.text, toTextBlockDto.text)
    }

    @Test
    fun textBlockDtoToTextBlock_whenMapping_(){
        val textBlockDto = com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock("Some Text for 1001",0)
        val toTextBlock = customMapper.toTextBlock(textBlockDto)

        assertNotNull(textBlockDto)
        assertEquals(textBlockDto.text,toTextBlock!!.text)
        assertEquals(textBlockDto.sortIndex,toTextBlock.sortIndex)
    }

    @Test
    fun galleryBlockDtoToGalleryBlock_whenMapping_(){
        val imageList: List<Image> = emptyList()
        val galleryBlockDto = GalleryBlock(imageList,0)
        val toGalleryBlockDto = customMapper.toGalleryBlockDto(galleryBlockDto)

        assertNotNull(galleryBlockDto)
        assertNotNull(toGalleryBlockDto)
        assertEquals(galleryBlockDto.images,toGalleryBlockDto!!.images)
        assertEquals(galleryBlockDto.sortIndex,toGalleryBlockDto.sortIndex)
    }

    @Test
    fun galleryBlockToGalleryBlockDto_whenMapping_(){
        val imageList: List<ImageDto> = emptyList()
        val galleryBlock = GalleryBlockDto(imageList,0)
        val toGalleryBlockDto = customMapper.toGalleryBlock(galleryBlock)

        assertNotNull(galleryBlock)
        assertNotNull(toGalleryBlockDto)
        assertEquals(galleryBlock.images,toGalleryBlockDto!!.images)
        assertEquals(galleryBlock.sortIndex,toGalleryBlockDto.sortIndex)
    }

    @Test
    fun imageBlockToImageBlockDto_whenMapping_(){
        val image = Image("https://someurl.com/image/1", ImageSize.LARGE,1001L, Date())
        val imageBlock = ImageBlock(image,0)

        val toImageBlockDto = customMapper.toImageBlockDto(imageBlock)

        assertNotNull(imageBlock)
        assertNotNull(toImageBlockDto)
        assertEquals(imageBlock.image,toImageBlockDto!!.image)
        assertEquals(imageBlock.sortIndex,toImageBlockDto.sortIndex)
    }

    @Test
    fun imageBlockDtoToImageBlock_whenMapping_(){
        val imageDto = ImageDto(1001L,"https://someurl.com/image/1",ImageSize.LARGE)
        val imageBlockDto = com.mhp.coding.challenges.mapping.models.dto.blocks.ImageBlock(imageDto, 0)
        val toImageBlock = customMapper.toImageBlock(imageBlockDto)

        assertEquals(imageBlockDto.image, toImageBlock!!.image)
        assertEquals(imageBlockDto.sortIndex, toImageBlock.sortIndex)
    }

    @Test
    fun videoBlockToVideBlockDto_whenMapping_(){
        val videoBlock = VideoBlock("https://youtu.be/myvideo", VideoBlockType.YOUTUBE,0)
        val toVideBlockDto = customMapper.toVideoBlockDto(videoBlock)

        assertEquals(videoBlock.url, toVideBlockDto!!.url)
        assertEquals(videoBlock.type,toVideBlockDto.type)
        assertEquals(videoBlock.sortIndex,toVideBlockDto.sortIndex)
    }

    @Test
    fun videoBlockDtoToVideBlock_whenMapping_(){
        val videoBlockDto = com.mhp.coding.challenges.mapping.models.dto.blocks.VideoBlock("https://youtu.be/myvideo",VideoBlockType.YOUTUBE,0)
        val toVideBlock = customMapper.toVideoBlock(videoBlockDto)

        assertEquals(videoBlockDto.url, toVideBlock!!.url)
        assertEquals(videoBlockDto.type,toVideBlock.type)
        assertEquals(videoBlockDto.sortIndex,toVideBlock.sortIndex)
    }

    /*
    private fun imagesDummy(): List<Image> {
        val image1 = Image("https://someurl.com/image/1",ImageSize.MEDIUM,1001L, Date())
        val image2 = Image("https://someurl.com/image/3",ImageSize.MEDIUM,3003L,Date())
        val imageList: MutableList<Image> = ArrayList()
        imageList.add(image1)
        imageList.add(image2)
        return imageList
    }
     */
}