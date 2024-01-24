package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
  
  private final SelenideElement
                                genderRadioButton = $("#genterWrapper"),
                                subjectInput = $("#subjectsInput"),
                                hobbiesInput = $("#hobbiesWrapper"),
                                stateSelect = $("#stateCity-wrapper").find(byText("Select State")),
                                citySelect = $("#stateCity-wrapper").find(byText("Select City"));
                                
  
  
  CalendarComponent calendarComponent = new CalendarComponent();
  
  public PracticeFormPage openPracticeFormPage(){
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    return this;
  }
  
  public PracticeFormPage setFirstName(String firstName){
    SimpleFieldComponent.setFirstName(firstName);
    return this;
    
  }
  public PracticeFormPage setLastName(String lastName){
    SimpleFieldComponent.setLastName(lastName);
    return this;
  }
  public PracticeFormPage setEmail(String email){
    SimpleFieldComponent.setEmail(email);
    return this;
  }
  public PracticeFormPage setGender(String value){
    genderRadioButton.$(byText(value)).click();
    return this;
  }
  public PracticeFormPage setUserNumber(String phone){
    SimpleFieldComponent.setPhone(phone);
    return this;
  }
  public PracticeFormPage setBirthDate(String month, Integer year, Integer day){
    calendarComponent.setBirthDate(month, year, day);
    return this;
  }
  public PracticeFormPage setSubject(String value){
    subjectInput.setValue(value).pressEnter();
    return this;
  }
  public PracticeFormPage setHobbies(String value){
    hobbiesInput.$(byText(value)).click();;
    return this;
  }
  
  public PracticeFormPage uploadFile(String fileName){
    UploadComponent.uploadFile(fileName);
    return this;
  }
  public PracticeFormPage setCurrentAddress(String currentAddress){
    SimpleFieldComponent.setCurrentAddress(currentAddress);
    return this;
  }
  public PracticeFormPage setStateAndCity(String state, String city){
    stateSelect.click();
    $(byText(state)).click();
    citySelect.click();
    $(byText(city)).click();
    return this;
  }
  
  public PracticeFormPage clickSubmitButton(){
    ButtonsComponent.clickSubmitButton();
    return this;
  }
  
   public PracticeFormPage checkModalWindowTitle(String value){
     ModalWindowComponent.checkModalWindowTitle(value);
    return this;
  }
  
  public PracticeFormPage checkShortUserData(String rowName, String rowValue){
    ModalWindowComponent.checkShortUserData(rowName, rowValue);
    return this;
  }
  
  public PracticeFormPage userInformationTableShouldNotBeVisible(){
    ModalWindowComponent.userInformationTableShouldNotBeVisible();
    return this;
  }
  
  public PracticeFormPage checkFullUserData(String studentName,
                                            String studentLastName,
                                            String studentEmail,
                                            String gender,
                                            String mobilePhone,
                                            String dateOfBirth,
                                            String subjects,
                                            String hobbies,
                                            String pictureName,
                                            String address,
                                            String stateAndCity){
     ModalWindowComponent.checkFullUserData(
       studentName,
       studentLastName,
       studentEmail,
       gender,
       mobilePhone,
       dateOfBirth,
       subjects,
       hobbies,
       pictureName,
       address,
       stateAndCity);
    return this;
  }
}
