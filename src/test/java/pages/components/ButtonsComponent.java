package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ButtonsComponent {
  
  private final static SelenideElement submitButton = $("#submit");
  
  
  public static void clickSubmitButton(){
    submitButton.click();
  }
}
