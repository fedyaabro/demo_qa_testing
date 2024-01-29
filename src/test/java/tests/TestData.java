package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.getRandomInt;

public class TestData {
  
  public Faker testData = new Faker(new Locale("en"));
  
  
  public String
    firstName = testData.name().firstName(),
    lastName = testData.name().lastName(),
    email = testData.internet().emailAddress(),
    gender = getUserGender(),
    phoneNumber = testData.number().digits(10),
    subjects = getSubjects(),
    hobbies = getHobbies(),
    file = "Screenshot at Aug 28 13-08-24.png",
    currentAddress = testData.address().streetAddress(),
    state = getState(),
    city = getCity(state),
    monthOfBirth = getMonthOfBirth();
  
  public Integer
    dayOfBirth = getDayOfBirth(),
    yearOfBirth = getYearOfBirth();
  
//  public String getPhoneNumber() {
//    return "%s%s".formatted(getRandomInt(1, 9), getRandomInt(100000000, 999999999));
//  }
//
  
  public String getUserGender() {
    return testData.options().option("Male", "Female", "Other");
  }
  
  public Integer getDayOfBirth() {
    return getRandomInt(1, 28);
  }
  
  public Integer getYearOfBirth() {
    return getRandomInt(1900, 2012);
  }
  
  public String getMonthOfBirth() {
    return testData.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September",
      "October", "November", "December");
  }
  
  public String getSubjects() {
    return testData.options().option("English", "Arts", "History", "Chemistry", "Math", "Hindi");
  }
  
  public String getHobbies() {
    return testData.options().option("Sports", "Reading", "Music");
  }
  
  public String getState() {
    return testData.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
  }
  
  public String getCity(String usersState) {
    
    return switch (usersState) {
      case "NCR" -> testData.options().option("Delhi", "Gurgaon", "Noida");
      case "Uttar Pradesh" -> testData.options().option("Agra", "Lucknow", "Merrut");
      case "Haryana" -> testData.options().option("Karnal", "Panipat");
      case "Rajasthan" -> testData.options().option("Jaipur", "Jaiselmer");
      default -> null;
    };
  }
  
}


