package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
  
  @BeforeAll
  static void beforeAll(){
    Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.holdBrowserOpen = true;
    Configuration.timeout = 5000;
  }
  @Test
  void fillPracticeForm(){
    File test = new File("src/test/resources/Screenshot at Aug 28 13-08-24.png");
    open("/automation-practice-form");
    $("#firstName").setValue("firstName");
    $("#lastName").setValue("lastName");
    $("#userEmail").setValue("userEmail@userEmail.com");
    $("#gender-radio-1").parent().click();
    $("#userNumber").setValue("79955947011");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(3);
    $(".react-datepicker__year-select").selectOption(94);
    $(".react-datepicker__day--021").click();
    $("#subjectsInput").setValue("Math").pressEnter();
    $("#hobbies-checkbox-1").parent().click();
    $("#uploadPicture").uploadFile(test);
    $("#currentAddress").setValue("currentAddress");
    $("#state").click();
    $("#react-select-3-input").setValue("Uttar").pressEnter();
    $("#city").click();
    $("#react-select-4-input").setValue("Merrut").pressEnter();
    $("#submit").click();
    $(".table-responsive" ).click();
    
    //check
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    
  }
}
