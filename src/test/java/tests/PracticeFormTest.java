package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;


public class PracticeFormTest extends TestBase {
  
  
  PracticeFormPage practiceFormPage = new PracticeFormPage();
  TestData useTestData = new TestData();
  
  
  @Test
  @DisplayName("Проверка полной формы")
  void fillAndCheckFullPracticeForm() {
    practiceFormPage
      .openPracticeFormPage()
      .setFirstName(useTestData.firstName)
      .setLastName(useTestData.lastName)
      .setEmail(useTestData.email)
      .setGender(useTestData.gender)
      .setUserNumber(useTestData.phoneNumber)
      .setBirthDate(useTestData.monthOfBirth, useTestData.yearOfBirth, useTestData.dayOfBirth)
      .setSubject(useTestData.subjects)
      .setHobbies(useTestData.hobbies)
      .uploadFile(useTestData.file)
      .setCurrentAddress(useTestData.currentAddress)
      .setStateAndCity(useTestData.state, useTestData.city)
      .clickSubmitButton()
      
      //check
      .checkModalWindowTitle("Thanks for submitting the form")
      .checkFullUserData(
        useTestData.firstName,
        useTestData.lastName,
        useTestData.email,
        useTestData.gender,
        useTestData.phoneNumber,
        "%s %s,%s".formatted(useTestData.dayOfBirth, useTestData.monthOfBirth, useTestData.yearOfBirth),
        useTestData.subjects,
        useTestData.hobbies,
        useTestData.file,
        useTestData.currentAddress,
        "%s %s".formatted(useTestData.state, useTestData.city));
  }
  
  @Test
  @DisplayName("Проверка минимального колличества данных")
  void fillAndCheckShortPracticeForm() {
    practiceFormPage
      .openPracticeFormPage()
      .setFirstName(useTestData.firstName)
      .setLastName(useTestData.lastName)
      .setEmail(useTestData.email)
      .setUserNumber(useTestData.phoneNumber)
      .setGender(useTestData.gender)
      .setBirthDate(useTestData.monthOfBirth, useTestData.yearOfBirth, useTestData.dayOfBirth)
      .clickSubmitButton()
      
      //check
      .checkShortUserData("Student Name", useTestData.firstName + " " + useTestData.lastName)
      .checkShortUserData("Student Email", useTestData.email)
      .checkShortUserData("Gender", useTestData.gender)
      .checkShortUserData("Mobile", useTestData.phoneNumber)
      .checkShortUserData("Date of Birth", useTestData.dayOfBirth + " " +
        useTestData.monthOfBirth + "," + useTestData.yearOfBirth);
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
