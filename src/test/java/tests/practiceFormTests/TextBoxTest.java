package tests.practiceFormTests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import tests.TestBaseRemote;

public class TextBoxTest extends TestBaseRemote {
  
  TextBoxPage textBoxPage = new TextBoxPage();
  
  @Test
  void fillFormTest() {
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
