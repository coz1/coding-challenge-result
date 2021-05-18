package com.mhp.coding.challenges.mapping.mappers

import com.mhp.coding.challenges.mapping.mappers.ICustomMapper
import com.mhp.coding.challenges.mapping.models.db.Article
import com.mhp.coding.challenges.mapping.models.db.Image
import com.mhp.coding.challenges.mapping.models.db.ImageSize
import com.mhp.coding.challenges.mapping.models.db.blocks.*
import com.mhp.coding.challenges.mapping.models.dto.ImageDto
import com.mhp.coding.challenges.mapping.models.dto.blocks.GalleryBlockDto
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
    fun `can map article to articleDto`() {
        val article =
            Article("Article Nr.:1001", "Article Description 1001", "Max Mustermann", emptySet(), 1001L, Date())
        val articleDto = customMapper.toArticleDto(article)

        assertNotNull(article)
        assertNotNull(articleDto)
        assertEquals(article.id, articleDto.id)
        assertEquals(article.author, articleDto.author)
        assertEquals(article.description, articleDto.description)
        assertEquals(article.title, articleDto.title)
    }

    @Test
    fun `can map textBlock to textBlockDto`() {
        val textBlockDto = com.mhp.coding.challenges.mapping.models.dto.blocks.TextBlock("Some Text for 1001", 0)
        val textBlock = customMapper.toTextBlock(textBlockDto)

        assertNotNull(textBlock)
        assertNotNull(textBlockDto)
        assertEquals(textBlockDto.text, textBlock!!.text)
        assertEquals(textBlockDto.sortIndex, textBlock.sortIndex)
    }

    @Test
    fun `can map galleryBlock to galleryBlockDto`() {
        val imageList: List<ImageDto> = emptyList()
        val galleryBlock = GalleryBlockDto(imageList, 0)
        val galleryBlockDto = customMapper.toGalleryBlock(galleryBlock)

        assertNotNull(galleryBlock)
        assertNotNull(galleryBlockDto)
        assertEquals(galleryBlock.images, galleryBlockDto!!.images)
        assertEquals(galleryBlock.sortIndex, galleryBlockDto.sortIndex)
    }

    @Test
    fun `can map imageBlock to imageBlockDto`() {
        val image = Image("https://someurl.com/image/1", ImageSize.LARGE, 1001L, Date())
        val imageBlock = ImageBlock(image, 0)
        val imageBlockDto = customMapper.toImageBlockDto(imageBlock)

        assertNotNull(imageBlock)
        assertNotNull(imageBlockDto)
        assertEquals(imageBlock.image!!.id, imageBlockDto!!.image.id)
        assertEquals(imageBlock.image!!.url, imageBlockDto!!.image.url)
        assertEquals(imageBlock.image!!.imageSize, imageBlockDto!!.image.imageSize)
        assertEquals(imageBlock.sortIndex, imageBlockDto.sortIndex)
    }


    @Test
    fun `can map videoBlock to videoBlockDto`() {
        val videoBlock = VideoBlock("https://youtu.be/myvideo", VideoBlockType.YOUTUBE, 0)
        val videBlockDto = customMapper.toVideoBlockDto(videoBlock)

        assertNotNull(videoBlock)
        assertNotNull(videBlockDto)
        assertEquals(videoBlock.url, videBlockDto!!.url)
        assertEquals(videoBlock.type, videBlockDto.type)
        assertEquals(videoBlock.sortIndex, videBlockDto.sortIndex)
    }
}