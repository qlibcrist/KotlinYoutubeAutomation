package tests

import org.testng.Assert
import org.testng.annotations.Test
import util.UtilResources
import webpages.Homepage
import webpages.Resultspage

class SearchVideoTest() : TestBase()
{
    @Test
    fun playVideo()
    {
        val homePage = Homepage(driver)

        homePage.searchVideo(UtilResources.getProperties("nameVideo"))

        val resultsPage = Resultspage(driver)
        if(resultsPage.isCorrectVideo())
        {
            Assert.assertTrue(resultsPage.isVideoPlaying())
        }
    }
}