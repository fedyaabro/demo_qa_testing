package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SimpleFieldComponent {
  
  private final static SelenideElement
                                userName = $("#userName"),
                                firstNameInput = $("#firstName"),
                                lastNameInput = $("#lastName"),
                                emailInput = $("#userEmail"),
                                phoneInput =$("#userNumber"),
                                currentAddress = $("#currentAddress"),
                                permanentAddress = $("#permanentAddress");
  
  
  public static void setFirstName(String name){
    firstNameInput.setValue(name);
  }
  public static void setLastName(String lastName){
    lastNameInput.setValue(lastName);
  }
  public static void setEmail(String email){
    emailInput.setValue(email);
  }
  public static void setPhone(String phone){
    phoneInput.setValue(phone);
  }
  public static void setCurrentAddress(String address){
    currentAddress.setValue(address);
  }
  public static void setPermanentAddress(String address){
    permanentAddress.setValue(address);
  }
  public static void setUserName(String name){
    userName.setValue(name);
  }
  
}
