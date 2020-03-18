package webpages

import org.junit.internal.runners.statements.ExpectException
import org.openqa.selenium.ElementNotInteractableException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.ExpectedCondition
import util.UtilResources

class Resultspage(private val driver: WebDriver)
{
    @FindBy(id = "video-title")
    private val titleVideo: WebElement? = null

    @FindBy(xpath = "//*[@id=\"text\"]/a")
    private val channel: WebElement? = null

    @FindBy(xpath = "//*[@id=\"movie_player\"]/div[1]/video")
    private val videoPlayer: WebElement? = null

    init
    {
        PageFactory.initElements(driver, this)
    }

    fun isCorrectVideo(): Boolean
    {
        return (
            titleVideo?.text == UtilResources.getProperties("selectedVideo") &&
            channel?.text == UtilResources.getProperties("channel")
        )
    }

    fun isPlayerPresent(): Boolean
    {
        return videoPlayer != null
    }

    fun isVideoPlaying(): Boolean
    {
        return try
        {
            videoPlayer?.click()
            true
        }
        catch (e: ElementNotInteractableException)
        {
            e.printStackTrace()
            false
        }
    }
}