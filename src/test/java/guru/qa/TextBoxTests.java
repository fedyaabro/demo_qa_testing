package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

  @BeforeAll
  static void beforeAll(){
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.holdBrowserOpen = true;
    Configuration.timeout = 5000;
  }
  
  @Test
  void fillFormTest(){
    open("/text-box");
  $("#userName").setValue("userName0");
  $("#userEmail").setValue("userEmail@mail.com");
  $("#currentAddress").setValue("currentAddress");
  $("#permanentAddress").setValue("permanentAddress");
  $("#submit").click();
  
  $("#output #name" ).shouldHave(text("userName0"));
  $("#output #email" ).shouldHave(text("userEmail@mail.com"));
  $("#output #currentAddress" ).shouldHave(text("currentAddress"));
  $("#output #permanentAddress" ).shouldHave(text("permanentAddress"));
  }
}
