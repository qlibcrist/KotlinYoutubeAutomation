package webpages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class Homepage(private val driver: WebDriver)
{
    @FindBy(id = "search")
    private val searchBox:  WebElement? = null

    @FindBy(id = "search-icon-legacy")
    private val searchButton: WebElement? = null

    init
    {
        PageFactory.initElements(driver, this)
    }

    fun searchVideo(videoName: String)
    {
        searchBox?.sendKeys(videoName)
        searchButton?.click()
    }
}
