package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UploadComponent {
  
  private final static SelenideElement uploadFile = $("#uploadPicture");
  
  public static void uploadFile(String fileName){
    uploadFile.uploadFromClasspath(fileName);
  }
}
