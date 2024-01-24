package pages.components;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
  
  private final SelenideElement calendarInput = $("#dateOfBirthInput"),
    monthSelector = $(".react-datepicker__month-select"),
    yearSelector = $(".react-datepicker__year-select");
  
  private String getReadableDate(Integer date) {
    String suffix = switch (date) {
      case 1, 21, 31 -> "st";
      case 2, 22 -> "nd";
      case 3, 23 -> "rd";
      default -> "th";
    };
    return date + suffix;
  }
  
  private SelenideElement daySelector(String month, Integer day, Integer year) {
    String checkDate = "%s %s, %s".formatted(month, getReadableDate(day), year);
    System.out.println(checkDate);
    return $(Selectors.byAttribute("aria-label*", checkDate));
  }
  
  public CalendarComponent setBirthDate(String month, Integer year, Integer day) {
    calendarInput.click();
    monthSelector.selectOption(month);
    yearSelector.selectOption(year.toString());
    daySelector(month, day, year).click();
    return this;
  }
}
