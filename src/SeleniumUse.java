import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class SeleniumUse {

    private static WebDriver browser;

    public static void main(String[] args){
        String link = getLink("headphones");
        getDescription(link);
    }

    public static String getLink(String product) {
        System.setProperty("webdriver.chrome.driver", "/Users/shane/Documents/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        browser = new ChromeDriver();
        browser.get("https://www.staples.ca/search?query=" + product);


        WebElement element = browser.findElement(By.className("ais-hits--item"));
        String link = element.findElement(By.tagName("a")).getAttribute("href");
        return link;
    }

    public static void getDescription(String link) {
        browser.get(link);

        WebElement element = browser.findElement(By.className("product-details__content"));
        String realInfo = element.findElement(By.tagName("p")).getText();
        System.out.println(realInfo);
    }
}
