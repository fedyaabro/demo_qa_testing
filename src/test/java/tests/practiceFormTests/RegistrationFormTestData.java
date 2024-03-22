package tests.practiceFormTests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static java.lang.Integer.parseInt;

public class RegistrationFormTestData {
  
  Faker faker = new Faker(new Locale("en"));
  Date birthDate = faker.date().birthday();
  
  public String
    firstName = faker.name().firstName(),
    lastName = faker.name().lastName(),
    email = faker.internet().emailAddress(),
    gender = getUserGender(),
    phoneNumber = faker.number().digits(10),
    subjects = getSubjects(),
    hobbies = getHobbies(),
    file = "img/Screenshot at Aug 28 13-08-24.png",
    currentAddress = faker.address().streetAddress(),
    state = getState(),
    city = getCity(state),
    monthOfBirth = getMonthOfBirth();
  
  public Integer
    dayOfBirth = getDayOfBirth(),
    yearOfBirth = getYearOfBirth();
  
  public Integer getDayOfBirth() {
    return parseInt(new SimpleDateFormat("dd").format(birthDate));
  }
  
  public String getMonthOfBirth() {
    return new SimpleDateFormat("MMMM").format(birthDate);
  }
  
  public Integer getYearOfBirth() {
    return parseInt(new SimpleDateFormat("yyyy").format(birthDate));
  }
  
  public String getUserGender() {
    return faker.options().option("Male", "Female", "Other");
  }
  
  public String getSubjects() {
    return faker.options().option("English", "Arts", "History", "Chemistry", "Math", "Hindi");
  }
  
  public String getHobbies() {
    return faker.options().option("Sports", "Reading", "Music");
  }
  
  public String getState() {
    return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
  }
  
  public String getCity(String usersState) {
    
    return switch (usersState) {
      case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
      case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
      case "Haryana" -> faker.options().option("Karnal", "Panipat");
      case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
      default -> null;
    };
  }
  
}

