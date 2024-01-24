package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormTest extends TestBase {
  

  PracticeFormPage practiceFormPage = new PracticeFormPage();
  
  @Test
  @DisplayName("Проверка полной формы")
  void fillAndCheckFullPracticeForm(){
    practiceFormPage
      .openPracticeFormPage()
      .setFirstName("firstName")
      .setLastName("lastName")
      .setEmail("userEmail@userEmail.com")
      .setGender("Male")
      .setUserNumber("9955947011")
      .setBirthDate("May",1994,19)
      .setSubject("Math")
      .setHobbies("Sports")
      .uploadFile("Screenshot at Aug 28 13-08-24.png")
      .setCurrentAddress("currentAddress")
      .setStateAndCity("Uttar Pradesh", "Lucknow")
      .clickSubmitButton()

    //check
      .checkModalWindowTitle("Thanks for submitting the form")
      .checkFullUserData(
        "firstName",
        "lastName",
        "userEmail@userEmail.com",
        "Male",
        "9955947011",
        "19 May,1994",
        "Math",
        "Sports",
        "Screenshot at Aug 28 13-08-24.png",
        "currentAddress",
        "Uttar Pradesh Lucknow");
  }
  
  @Test
  @DisplayName("Проверка минимального колличества данных")
  void fillAndCheckShortPracticeForm(){
    practiceFormPage
      .openPracticeFormPage()
      .setFirstName("firstName")
      .setLastName("lastName")
      .setEmail("userEmail@userEmail.com")
      .setUserNumber("9955947011")
      .setGender("Male")
      .setBirthDate("May", 1994,19)
      .clickSubmitButton()
    
    //check
      .checkShortUserData("Student Name", "firstName lastName")
      .checkShortUserData("Student Email", "userEmail@userEmail.com")
      .checkShortUserData("Gender", "Male")
      .checkShortUserData("Mobile", "9955947011")
      .checkShortUserData("Date of Birth", "19 May,1994");
  }
  
  
  @Test
  @DisplayName("Негативная проверка")
  void informationTableShouldNotBeOpen(){
    practiceFormPage
      .openPracticeFormPage()
      .clickSubmitButton()
      .userInformationTableShouldNotBeVisible();
  }
  
  
}
