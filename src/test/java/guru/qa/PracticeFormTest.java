package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
  
  @BeforeAll
  static void beforeAll(){
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.holdBrowserOpen = false;
    Configuration.timeout = 5000;
  }
  @Test
  void fillPracticeForm(){
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    
    $("#firstName").setValue("firstName");
    $("#lastName").setValue("lastName");
    $("#userEmail").setValue("userEmail@userEmail.com");
    $("#genterWrapper").$(byText("Male")).click();
    $("#userNumber").setValue("9955947011");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(3);
    $(".react-datepicker__year-select").selectOption(94);
    $(".react-datepicker__day--021").click();
    $("#subjectsInput").setValue("Math").pressEnter();
    $("#hobbiesWrapper").$(byText("Sports")).click();
    $("#uploadPicture").uploadFromClasspath("Screenshot at Aug 28 13-08-24.png");
    $("#currentAddress").setValue("currentAddress");
    $("#state").scrollIntoView(true);
    $("#stateCity-wrapper").find(byText("Select State")).click();
    $(byText("Uttar Pradesh")).click();
    $("#stateCity-wrapper").find(byText("Select City")).click();
    $(byText("Lucknow")).click();
    $("#submit").click();
    
    //check
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(By.tagName("tbody")).shouldHave(text("firstName"));
    $(By.tagName("tbody")).shouldHave(text("lastName"));
    $(By.tagName("tbody")).shouldHave(text("9955947011"));
    $(By.tagName("tbody")).shouldHave(text("21 April,1994"));
    $(By.tagName("tbody")).shouldHave(text("Maths"));
    $(By.tagName("tbody")).shouldHave(text("Sports"));
    $(By.tagName("tbody")).shouldHave(text("Screenshot at Aug 28 13-08-24.png"));
    $(By.tagName("tbody")).shouldHave(text("currentAddress"));
    $(By.tagName("tbody")).shouldHave(text("Uttar Pradesh Lucknow"));
    
  }
}
