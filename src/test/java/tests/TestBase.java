package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class TestBase {
  
  @BeforeAll
  static void beforeAll() {
    
    System.setProperty("environment", System.getProperty("environment", "prod"));
//    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.browser = System.getProperty("browser", "chrome");
    Configuration.browserVersion = System.getProperty("browserVersion", "113.0");
    Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
//    Configuration.remote = System.getProperty("browserRemoteUrl");
    SelenideLogger.addListener("allure", new AllureSelenide());
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
      "enableVNC", true,
      "enableVideo", true));
    Configuration.browserCapabilities = capabilities;
  }
  
  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
    
  }
}
