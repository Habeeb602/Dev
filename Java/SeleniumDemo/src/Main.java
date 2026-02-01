import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    WebDriver driver;

    public void launchBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
    }

    public void searchProduct() throws InterruptedException {
        driver.findElement(By.id("gh-ac")).sendKeys("Sony wireless headphone");
        driver.findElement(By.id("gh-btn")).click();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Daily Deals")).click();
    }

    public void navigate() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().to("https://www.simplilearn.com/");
        Thread.sleep(1000);
        driver.navigate().to("https://www.ebay.com/");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        Main obj = new Main();

        obj.launchBrowser();
        obj.searchProduct();
        obj.navigate();
    }
}