package pages;

import com.codeborne.selenide.SelenideElement;
import config.ProjectConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import pages.components.CalendarComponent;
import pages.components.ModalWindowComponent;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage extends TestBase {
  
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
  
  @Step("Открываем форму для регистрации")
  public RegistrationFormPage openPracticeFormPage() {
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()");
    executeJavaScript("$('footer').remove()");
    return this;
  }
  
  @Step("Заполняем имя")
  public RegistrationFormPage setFirstName(String firstName) {
    firstNameInput.setValue(firstName);
    return this;
    
  }
  
  @Step("Заполняем фамилию")
  public RegistrationFormPage setLastName(String lastName) {
    lastNameInput.setValue(lastName);
    return this;
  }
  
  @Step("Заполняем email")
  public RegistrationFormPage setEmail(String email) {
    emailInput.setValue(email);
    return this;
  }
  
  @Step("Заполняем пол")
  public RegistrationFormPage setGender(String value) {
    genderRadioButton.$(byText(value)).click();
    return this;
  }
  
  @Step("Заполняем телефон")
  public RegistrationFormPage setUserNumber(String phone) {
    phoneInput.setValue(phone);
    return this;
  }
  
  @Step("Заполняем дату рождения")
  public RegistrationFormPage setBirthDate(String month, Integer year, Integer day) {
    calendarComponent.setBirthDate(month, year, day);
    return this;
  }
  
  @Step("Выбирпем предметы")
  public RegistrationFormPage setSubject(String value) {
    subjectInput.setValue(value).pressEnter();
    return this;
  }
  
  @Step("Выбираем хобби")
  public RegistrationFormPage setHobbies(String value) {
    hobbiesInput.$(byText(value)).click();
    return this;
  }
  @Step("Загружаем файл")
  public RegistrationFormPage uploadFile(String fileName) {
    uploadFile.uploadFromClasspath(fileName);
    return this;
  }
  
  @Step("Заполняем адрес")
  public RegistrationFormPage setCurrentAddress(String currentAddress) {
    currentAddressInput.setValue(currentAddress);
    return this;
  }
  @Step("Заполняем город")
  public RegistrationFormPage setStateAndCity(String state, String city) {
    stateSelect.click();
    $(byText(state)).click();
    citySelect.click();
    $(byText(city)).click();
    return this;
  }
  @Step("Подтверждаем")
  public RegistrationFormPage clickSubmitButton() {
    submitButton.click();
    return this;
  }
  @Step("Открылось модальное окно")
  public RegistrationFormPage checkModalWindowTitle(String value) {
    modalWindowComponent.checkModalWindowTitle(value);
    return this;
  }
  
  public RegistrationFormPage checkShortUserData(String rowName, String rowValue) {
    modalWindowComponent.checkShortUserData(rowName, rowValue);
    return this;
  }
  
  public RegistrationFormPage userInformationTableShouldNotBeVisible() {
    modalWindowComponent.userInformationTableShouldNotBeVisible();
    return this;
  }
  
  @Step("Проверяем таблицу")
  public RegistrationFormPage checkFullUserData(String studentName,
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
