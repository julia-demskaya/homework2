package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test
    void successfulFillTest() {
        open("https://demoqa.com/automation-practice-form");
     $("#firstName").setValue("Ivan");
     $("#lastName").setValue("Ivanov");
     $("#userEmail").setValue("qwerty@mail.ru");
     $(byText("Female")).click();
     $("#userNumber").setValue("1231258591");
     $("#dateOfBirthInput").click();
     $(byText("February")).click();
     $(byText("1997")).click();
     $(byText("8")).click();
     $(byText("Music")).click();
     $("#uploadPicture").click();
     $("#subjectsInput").setValue("Math");
     $("[placeholder='Current Address']").setValue("qwerty");
     $(byText("Select State")).click();
     $(byText("NCR")).click();
     $("#city").click();
     $(byText("Gurgaon")).click();
     $("#submit").click();

    }
}
