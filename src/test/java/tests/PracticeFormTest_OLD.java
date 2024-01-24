package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;


import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest_OLD extends TestBase{
  
  
  public SelenideElement daySelector(Integer day){
    return $(".react-datepicker__day--0" + day);
  }
  
  @Test
  void fillPracticeForm(){
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    
//    $("#firstName").setValue("firstName");
//    $("#lastName").setValue("lastName");
//    $("#userEmail").setValue("userEmail@userEmail.com");
//    $("#genterWrapper").$(byText("Male")).click();
//    $("#userNumber").setValue("9955947011");
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(Month.MAY.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    $(".react-datepicker__year-select").selectOption(Year.now().toString());
    daySelector(18).click();
    
    //$(".react-datepicker__day--selected").setValue("1");
//    $("#subjectsInput").setValue("Math").pressEnter();
//    $("#hobbiesWrapper").$(byText("Sports")).click();
//    $("#uploadPicture").uploadFromClasspath("Screenshot at Aug 28 13-08-24.png");
//    $("#currentAddress").setValue("currentAddress");
//    $("#state").scrollIntoView(true);
//    $("#stateCity-wrapper").find(byText("Select State")).click();
//    $(byText("Uttar Pradesh")).click();
//    $("#stateCity-wrapper").find(byText("Select City")).click();
//    $(byText("Lucknow")).click();
//    $("#submit").click();
//
//    //check
//    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
//    $(By.tagName("tbody")).shouldHave(text("firstName"));
//    $(By.tagName("tbody")).shouldHave(text("lastName"));
//    $(By.tagName("tbody")).shouldHave(text("9955947011"));
//    $(By.tagName("tbody")).shouldHave(text("21 April,1994"));
//    $(By.tagName("tbody")).shouldHave(text("Maths"));
//    $(By.tagName("tbody")).shouldHave(text("Sports"));
//    $(By.tagName("tbody")).shouldHave(text("Screenshot at Aug 28 13-08-24.png"));
//    $(By.tagName("tbody")).shouldHave(text("currentAddress"));
//    $(By.tagName("tbody")).shouldHave(text("Uttar Pradesh Lucknow"));
    
  }
}
