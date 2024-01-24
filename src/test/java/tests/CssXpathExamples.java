package tests;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
  
  void cssXpathExamples() {
    //<input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
    $("[data-testid = email]").setValue("some text");
    $(by("data-testid","value")).setValue("some text");
    $x("//*[@data-testid=email]").setValue("sometext");
    
    //<input type="email" class="inputtext login_form_input_box" name="email">
    $("[id = email]").setValue("some text");
    $(by("id","value")).setValue("some text");
    $x("//*[@id=email]").setValue("sometext");
    $(byId("email")).setValue("SomeText");
    $(By.id("email")).setValue("SomeText");
    $("[id=email]").setValue("SomeText");
    $("#email").setValue("SomeText");
    
    //<input type="email" class="inputtext login_form_input_box" name="email">
    $("[name = email]").setValue("some text");
    $(by("name","value")).setValue("some text");
    $x("//*[@name=email]").setValue("sometext");
    $(byName("email")).setValue("SomeText");
    $(By.name("email")).setValue("SomeText");
    
    //<input type="email" class="inputtext login_form_input_box"
    $("[class = login_form_input_box]").setValue("some text");
    $(by("class","login_form_input_box")).setValue("some text");
    $x("//*[@class=login_form_input_box]").setValue("sometext");
    $(byClassName("login_form_input_box")).setValue("SomeText");
    $(By.className("login_form_input_box")).setValue("SomeText");
    $(".login_form_input_box").setValue("SomeText");
    
    $("[class=inputtext][class=login_form_input_box]").setValue("sometetx");
    $("input[class=login_form_input_box]").setValue("sometetx");
    $x("//input[@class='input text']").setValue("sometetx");
    $("input.login_form_input_box").setValue("sometetx");
    $("input.inputtext.login_form_input_box").setValue("sometetx");
    
    
    //поиск вложенных элементов
    //<div class="inputtext">
    //      <input type="email" class="inputtext login_form_input_box">
    //</div>
    $(".login_form_input_box").setValue("sometext");
    $(".inputtext .login_form_input_box").setValue("sometext");
    $(".inputtext").$(".login_form_input_box\"").setValue("sometext");
    $("div.iputtext").$("inpup.login_form_input_box").setValue("sometext");
    
    //<div>HEllo</div>
    $(byText("Hello"));
    $(withText("Hel"));
    $x(("//"));
    
    
    
    
    
    
    
    
    
  }
}
