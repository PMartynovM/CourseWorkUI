import CourseUI.MainPage;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class BaseTest {
    WebDriver webDriver;
    MainPage mainPage;
// for PR
    /**
     * сегодня
     */

    private final static String todayIsDay = "//span[contains(text(), 'сегодня')]";
    private final static String morningTempToday = "//span[contains(text(), 'сегодня')]/ancestor::article/child::div[contains(@style, 'temperature-morning')]";
    private final static String dayTempToday = "//span[contains(text(), 'сегодня')]/ancestor::article/child::div[contains(@style, 'temperature-day')]";
    private final static String eveningTempToday = "//span[contains(text(), 'сегодня')]/ancestor::article/child::div[contains(@style, 'temperature-evening')]";
    private final static String nightTempToday = "//span[contains(text(), 'сегодня')]/ancestor::article/child::div[contains(@style, 'temperature-night')]";
    /**
     * Завтра
     */
    private final static String tomorrowIsDay = "//span[contains(text(), 'завтра')]";
    private final static String morningTempTomorrow = "//span[contains(text(), 'завтра')]/ancestor::article/child::div[contains(@style, 'temperature-morning')]";
    private final static String dayTempTomorrow = "//span[contains(text(), 'завтра')]/ancestor::article/child::div[contains(@style, 'temperature-day')]";
    private final static String eveningTempTomorrow = "//span[contains(text(), 'завтра')]/ancestor::article/child::div[contains(@style, 'temperature-evening')]";
    private final static String nightTempTomorrow = "//span[contains(text(), 'завтра')]/ancestor::article/child::div[contains(@style, 'temperature-night')]";

    /**
     * Послезавтра
     */

    private final static String thirdIsDay = "//*[@id=\"__next\"]//article[3]/p";
    private final static String morningTempThird = "//*[@id=\"__next\"]//article[3]/child::div[contains(@style, 'temperature-morning')]";
    private final static String dayTempThird = "//*[@id=\"__next\"]//article[3]/child::div[contains(@style, 'temperature-day')]";
    private final static String eveningTempThird = "//*[@id=\"__next\"]//article[3]/child::div[contains(@style, 'temperature-evening')]";
    private final static String nightTempTwhird = "//*[@id=\"__next\"]//article[3]/child::div[contains(@style, 'temperature-night')]";
    public String UrlNext = "https://yandex.ru/pogoda/ru-RU/details/today?lat=55.755863&lon=37.6177&lang=ru&lang=ru&via=ms";


    @Test
    public void weatherTest() {
        webDriver = new ChromeDriver();
        mainPage = new MainPage(webDriver);

        mainPage.clickTenDayWeather();
/**
 * Выведем погоду на сегодня
 * */
        mainPage.getWhatIsDay(todayIsDay);
        mainPage.getFindTemp(morningTempToday, dayTempToday, eveningTempToday, nightTempToday);
//        mainPage.getFindTemp(dayTempToday);
//        mainPage.getFindTemp(eveningTempToday);
//        mainPage.getFindTemp(nightTempToday);
        /**
         * Выведем погоду на завтра
         * */
        mainPage.getWhatIsDay(tomorrowIsDay);
        mainPage.getFindTemp(morningTempTomorrow, dayTempTomorrow, eveningTempTomorrow, nightTempTomorrow);

        /**
         * Выведем погоду на послезавтра
         * */
        mainPage.getWhatIsDay(thirdIsDay);
        mainPage.getFindTemp(morningTempThird, dayTempThird, eveningTempThird, nightTempTwhird);

    }

    @After
    public void closePage() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}