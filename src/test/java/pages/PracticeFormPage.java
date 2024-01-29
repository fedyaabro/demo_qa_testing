package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalWindowComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage {
  
  private final SelenideElement
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    emailInput = $("#userEmail"),
    phoneInput = $("#userNumber"),
    currentAddressInput = $("#currentAddress"),
    genderRadioButton = $("#genterWrapper"),
    subjectInput = $("#subjectsInput"),
    hobbiesInput = $("#hobbiesWrapper"),
    stateSelect = $("#stateCity-wrapper").find(byText("Select State")),
    citySelect = $("#stateCity-wrapper").find(byText("Select City")),
    uploadFile = $("#uploadPicture"),
    submitButton = $("#submit");
  
  
  CalendarComponent calendarComponent = new CalendarComponent();
  ModalWindowComponent modalWindowComponent = new ModalWindowComponent();
  
  //fake data
  
  public PracticeFormPage openPracticeFormPage() {
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    return this;
  }
  
  public PracticeFormPage setFirstName(String firstName) {
    firstNameInput.setValue(firstName);
    return this;
    
  }
  
  public PracticeFormPage setFirstNameTD(String firstName) {
    firstNameInput.setValue(firstName);
    return this;
    
  }
  
  public PracticeFormPage setLastName(String lastName) {
    lastNameInput.setValue(lastName);
    return this;
  }
  
  public PracticeFormPage setEmail(String email) {
    emailInput.setValue(email);
    return this;
  }
  
  public PracticeFormPage setGender(String value) {
    genderRadioButton.$(byText(value)).click();
    return this;
  }
  
  public PracticeFormPage setUserNumber(String phone) {
    phoneInput.setValue(phone);
    return this;
  }
  
  public PracticeFormPage setBirthDate(String month, Integer year, Integer day) {
    calendarComponent.setBirthDate(month, year, day);
    return this;
  }
  
  public PracticeFormPage setSubject(String value) {
    subjectInput.setValue(value).pressEnter();
    return this;
  }
  
  public PracticeFormPage setHobbies(String value) {
    hobbiesInput.$(byText(value)).click();
    ;
    return this;
  }
  
  public PracticeFormPage uploadFile(String fileName) {
    uploadFile.uploadFromClasspath(fileName);
    return this;
  }
  
  public PracticeFormPage setCurrentAddress(String currentAddress) {
    currentAddressInput.setValue(currentAddress);
    return this;
  }
  
  public PracticeFormPage setStateAndCity(String state, String city) {
    stateSelect.click();
    $(byText(state)).click();
    citySelect.click();
    $(byText(city)).click();
    return this;
  }
  
  public PracticeFormPage clickSubmitButton() {
    submitButton.click();
    return this;
  }
  
  public PracticeFormPage checkModalWindowTitle(String value) {
    modalWindowComponent.checkModalWindowTitle(value);
    return this;
  }
  
  public PracticeFormPage checkShortUserData(String rowName, String rowValue) {
    modalWindowComponent.checkShortUserData(rowName, rowValue);
    return this;
  }
  
  public PracticeFormPage userInformationTableShouldNotBeVisible() {
    modalWindowComponent.userInformationTableShouldNotBeVisible();
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
                                            String stateAndCity) {
    modalWindowComponent.checkFullUserData(
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
