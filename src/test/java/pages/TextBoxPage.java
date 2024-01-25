package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
  
  private final SelenideElement nameInput = $("#userName"),
    emailInput = $("#userEmail"),
    currentAddressInput = $("#currentAddress"),
    permanentAddressInput = $("#permanentAddress"),
    submitButton = $("#submit"),
    output = $("#output");
  
  
  public TextBoxPage openTextBoxPage() {
    open("/text-box");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    return this;
  }
  
  public TextBoxPage setUserName(String userName) {
    nameInput.setValue(userName);
    return this;
  }
  
  public TextBoxPage setUserEmail(String userEmail) {
    emailInput.setValue(userEmail);
    return this;
  }
  
  public TextBoxPage setCurrentAddress(String currentAddress) {
    currentAddressInput.setValue(currentAddress);
    return this;
  }
  
  public TextBoxPage setPermanentAddress(String permanentAddress) {
    permanentAddressInput.setValue(permanentAddress);
    return this;
  }
  
  public TextBoxPage submitForm() {
    submitButton.click();
    return this;
  }
  
  public TextBoxPage checkResult(String userName,
                                 String userEmail,
                                 String userCurrentAddress,
                                 String userPermanentAddress) {
    output.$("#name").shouldHave(text(userName));
    output.$("#email").shouldHave(text(userEmail));
    output.$("#currentAddress").shouldHave(text(userCurrentAddress));
    output.$("#permanentAddress").shouldHave(text(userPermanentAddress));
    return this;
  }
  
}
