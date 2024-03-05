package tests.githubTestsHw12.steps;


import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubStep {
  
  @Step("Открываем github")
  public void openGithub() {
    open("https://github.com");
  }
  
  @Step("Вводим поисковой запрос и жмем Enter")
  public void typeRequestAndPressEnter(String requestText) {
    $("[placeholder='Search or jump to...']").click();
    $("#query-builder-test").setValue(requestText).pressEnter();
  }
  
  @Step("Выбираем первый элемент из списка и кликаем на него")
  public void clickOnFirstElementInList() {
    $$("[data-testid='results-list']").first().$("a").click();
  }
  @Step("Переходим на вкладку Issues")
  public void goToIssueTab() {
    $("#issues-tab").click();
  }
  
  @Step("Переходим на вкладку Issues")
  public void findIssueByName(String issueName) {
    $(byText(issueName)).shouldBe(visible);
  }
  
}
