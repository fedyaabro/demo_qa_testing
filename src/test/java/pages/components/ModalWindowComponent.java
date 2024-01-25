package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowComponent {
  
  
  private final SelenideElement userInformationTable = $(".table-responsive"),
    tableTitle = $("#example-modal-sizes-title-lg"),
    userFullName = $("tbody td", 1),
    userEmail = $("tbody td", 3),
    userGender = $("tbody td", 5),
    userPhone = $("tbody td", 7),
    userBirthDate = $("tbody td", 9),
    userSubjects = $("tbody td", 11),
    userHobbies = $("tbody td", 13),
    userPictureName = $("tbody td", 15),
    userAddress = $("tbody td", 17),
    userStateAndCity = $("tbody td", 19);
  
  
  public void checkModalWindowTitle(String value) {
    tableTitle.shouldHave(text(value));
  }
  
  public void checkShortUserData(String rowName, String rowValue) {
    userInformationTable.$(byText(rowName)).parent().shouldHave(text(rowValue));
  }
  
  public ModalWindowComponent userInformationTableShouldNotBeVisible() {
    userInformationTable.shouldNotBe(visible);
    return this;
  }
  
  public ModalWindowComponent checkFullUserData(String studentName,
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
    userFullName.shouldHave(text("%s %s".formatted(studentName, studentLastName)));
    userEmail.shouldHave(text("%s".formatted(studentEmail)));
    userGender.shouldHave(text("%s".formatted(gender)));
    userPhone.shouldHave(text("%s".formatted(mobilePhone)));
    userBirthDate.shouldHave(text("%s".formatted(dateOfBirth)));
    userSubjects.shouldHave(text("%s".formatted(subjects)));
    userHobbies.shouldHave(text("%s".formatted(hobbies)));
    userPictureName.shouldHave(text("%s".formatted(pictureName)));
    userAddress.shouldHave(text("%s".formatted(address)));
    userStateAndCity.shouldHave(text("%s".formatted(stateAndCity)));
    return this;
  }
}

