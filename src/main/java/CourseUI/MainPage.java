package CourseUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
// for PR
public class MainPage {

    private final WebDriver webDriver;
    private final WebDriverWait driverWait;
    private final String URI = "https://yandex.ru/pogoda/";
    private final int TIMEOUT = 10;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.manage().window().maximize();
        webDriver.get(URI);
        driverWait = new WebDriverWait(webDriver, TIMEOUT, 50);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[contains(@class, 'forecast-briefly card')]//*[contains(text(), 'Подробный прогноз на 10 дней')]")
    public WebElement forecastForTenDaysButton;


    public void clickTenDayWeather() {
        forecastForTenDaysButton.click();
    }

    public void getWhatIsDay(String whatIsDay) {
        String pizza = (webDriver.findElement(By.xpath(whatIsDay)).getText().toString());
        System.out.println(pizza);
    }

    public void getFindTemp(String morningTemp, String dayTemp, String eveningTemp, String nightTemp) {

        String morning = (webDriver.findElement(By.xpath(morningTemp)).getText());
        String day = (webDriver.findElement(By.xpath(dayTemp)).getText());
        String evening = (webDriver.findElement(By.xpath(eveningTemp)).getText());
        String night = (webDriver.findElement(By.xpath(nightTemp)).getText());

        System.out.println(morning + "\n" + day + "\n" + evening + "\n" + night + "\n");


    }

}
