package tests.practiceFormTests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import pages.RegistrationFormPage;
import tests.TestBase;
import tests.TestBaseRemote;

import static io.qameta.allure.Allure.step;

@Tag("owner_tests")
@Feature("Проверка формы demoqa.com")
public class PracticeFormTest extends TestBaseRemote {
  
  RegistrationFormPage practiceFormPage = new RegistrationFormPage();
  RegistrationFormTestData registrationForm = new RegistrationFormTestData();
  
  @Test
  @DisplayName("Негативная проверка")
  @Story("Негативная проверка")
  void informationTableShouldNotBeOpen() {
    practiceFormPage
      .openPracticeFormPage()
      .clickSubmitButton()
      .userInformationTableShouldNotBeVisible()
      .negativeMarker();
  }
  
  @Test
  @Disabled
  @Feature("Проверка полной формы регистрации")
  @Story("Проверка полной формы регистрации")
  @DisplayName("Проверка полной формы")
  
  void fillAndCheckFullPracticeForm() {

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
  @Story("Проверка минимального колличества данных")
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
  

}
