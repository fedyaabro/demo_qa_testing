package tests.practiceFormTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import tests.TestBase;


public class PracticeFormTest extends TestBase {
  
  
  PracticeFormPage practiceFormPage = new PracticeFormPage();
  RegistrationFormTestData registrationForm = new RegistrationFormTestData();
  
  
  @Test
  @Feature("Проверка полной форсы")
  @DisplayName("Проверка полной формы")
  
  void fillAndCheckFullPracticeForm() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    
    practiceFormPage
      .openPracticeFormPage()
      .setFirstName(registrationForm.firstName)
      .setLastName(registrationForm.lastName)
      .setEmail(registrationForm.email)
      .setGender(registrationForm.gender)
      .setUserNumber(registrationForm.phoneNumber)
      .setBirthDate(registrationForm.monthOfBirth,
        registrationForm.yearOfBirth, registrationForm.dayOfBirth)
      .setSubject(registrationForm.subjects)
      .setHobbies(registrationForm.hobbies)
      .uploadFile(registrationForm.file)
      .setCurrentAddress(registrationForm.currentAddress)
      .setStateAndCity(registrationForm.state, registrationForm.city)
      .clickSubmitButton()
      
      //check
      .checkModalWindowTitle("Thanks for submitting the form")
      .checkFullUserData(
        registrationForm.firstName,
        registrationForm.lastName,
        registrationForm.email,
        registrationForm.gender,
        registrationForm.phoneNumber,
        "%s %s,%s".formatted(registrationForm.dayOfBirth, registrationForm.monthOfBirth, registrationForm.yearOfBirth),
        registrationForm.subjects,
        registrationForm.hobbies,
        registrationForm.file,
        registrationForm.currentAddress,
        "%s %s".formatted(registrationForm.state, registrationForm.city));
  }
  
  @Test
  @DisplayName("Проверка минимального колличества данных")
  void fillAndCheckShortPracticeForm() {
    practiceFormPage
      .openPracticeFormPage()
      .setFirstName(registrationForm.firstName)
      .setLastName(registrationForm.lastName)
      .setEmail(registrationForm.email)
      .setUserNumber(registrationForm.phoneNumber)
      .setGender(registrationForm.gender)
      .setBirthDate(registrationForm.monthOfBirth, registrationForm.yearOfBirth, registrationForm.dayOfBirth)
      .clickSubmitButton()
      
      //check
      .checkShortUserData("Student Name", registrationForm.firstName + " " + registrationForm.lastName)
      .checkShortUserData("Student Email", registrationForm.email)
      .checkShortUserData("Gender", registrationForm.gender)
      .checkShortUserData("Mobile", registrationForm.phoneNumber)
      .checkShortUserData("Date of Birth", registrationForm.dayOfBirth + " " +
        registrationForm.monthOfBirth + "," + registrationForm.yearOfBirth);
  }
  
  @Test
  @DisplayName("Негативная проверка")
  void informationTableShouldNotBeOpen() {
    practiceFormPage
      .openPracticeFormPage()
      .clickSubmitButton()
      .userInformationTableShouldNotBeVisible();
  }
}
