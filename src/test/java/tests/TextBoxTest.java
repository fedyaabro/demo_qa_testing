package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest extends TestBase {
  
  TextBoxPage textBoxPage = new TextBoxPage();
  
  @Test
  void fillFormTest(){
     //filling form
    textBoxPage
      .openTextBoxPage()
      .setUserName("userName0")
      .setUserEmail("userEmail@email.com")
      .setCurrentAddress("currentAddress")
      .setPermanentAddress("permanentAddress")
      .submitForm()
    //check
      .checkResult(
        "userName0",
        "userEmail@email.com",
        "currentAddress",
        "permanentAddress");
  }
}
