package tests.githubTestsHw12;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.githubTestsHw12.steps.GithubStep;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class IssuesNameChecks {
  
  String issueName = "Test issues";
  String requestText = "fedyaabro/demo_qa_testing";
  
  @Test
  @Feature("Проверяем наличие заведенного инцидента на странице issues")
  @Story("Простой отчет с Allure listener")
  @Severity(SeverityLevel.MINOR)
  void issuesPageShouldHaveTestIssues() {
    SelenideLogger.addListener("allure", new AllureSelenide());
    open("https://github.com");
    $("[placeholder='Search or jump to...']").click();
    $("#query-builder-test").setValue(requestText).pressEnter();
    $$("[data-testid='results-list']").first().$("a").click();
    $("#issues-tab").click();
    $(byText("Test issues")).shouldBe(visible);
  }
  
  @Test
  @Feature("Проверяем наличие заведенного инцидента на странице issues")
  @Story("Простой отчет с lambda")
  @Severity(SeverityLevel.MINOR)
  void issuesPageShouldHaveTestIssuesLambdas() {
    
    step("Открываем страницу github", () -> {
      open("https://github.com");
    });
    step("Кликаем на поиск", () -> {
      $("[placeholder='Search or jump to...']").click();
    });
    step("Вводии название репы и жмем  enter", () -> {
      $("#query-builder-test").setValue(requestText).pressEnter();
    });
    step("Находим первый элемент списка и кликаем на него", () -> {
      $$("[data-testid='results-list']").first().$("a").click();
    });
    step("Переходим на таб issues", () -> {
      $("#issues-tab").click();
    });
    step("Проверяем наличие инцидента", () -> {
      $(byText("Test issues")).shouldBe(visible);
    });
  }
  
  @Test
  @Feature("Проверяем наличие заведенного инцидента на странице issues")
  @Story("Простой отчет со Steps")
  @Severity(SeverityLevel.MINOR)
  @DisplayName("Вот так вот")
  void issuesPageShouldHaveTestIssuesSteps() {
    
    SelenideLogger.addListener("allure", new AllureSelenide());
    GithubStep step = new GithubStep();
    
    step.openGithub();
    step.typeRequestAndPressEnter(requestText);
    step.clickOnFirstElementInList();
    step.goToIssueTab();
    step.findIssueByName(issueName);
    
  }
  
}
