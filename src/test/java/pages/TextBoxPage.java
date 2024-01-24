package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.ButtonsComponent;
import pages.components.SimpleFieldComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
  
  private final SelenideElement name = $("#output #name"),
                                email = $("#output #email"),
                                currentAddress = $("#output #currentAddress"),
                                permanentAddress = $("#output #permanentAddress");
  
  
  public TextBoxPage openTextBoxPage(){
    open("/text-box");
    return this;
  }
  
public TextBoxPage setUserName(String userName){
    SimpleFieldComponent.setUserName(userName);
    return this;
  }
public TextBoxPage setUserEmail(String userEmail){
    SimpleFieldComponent.setEmail(userEmail);
    return this;
  }
public TextBoxPage setCurrentAddress(String currentAddress){
    SimpleFieldComponent.setCurrentAddress(currentAddress);
    return this;
  }
public TextBoxPage setPermanentAddress(String permanentAddress){
    SimpleFieldComponent.setPermanentAddress(permanentAddress);
    return this;
  }
public TextBoxPage submitForm(){
    ButtonsComponent.clickSubmitButton();
    return this;
  }
  
  public TextBoxPage checkResult(String userName,
                                 String userEmail,
                                 String userCurrentAddress,
                                 String userPermanentAddress){
    name.shouldHave(text(userName));
    email.shouldHave(text(userEmail));
    currentAddress.shouldHave(text(userCurrentAddress));
    permanentAddress.shouldHave(text(userPermanentAddress));
    return this;
  }
  
}
