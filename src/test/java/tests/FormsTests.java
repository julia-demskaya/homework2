package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormsTests {

    String
            firstName = "Julia",
            lastName = "Demskaya",
            userEmail = "qwerty@mail.ru",
            gender = "Female",
            mobile = "1234567890",
            birht = "8 February,1997",
            subjects = "Maths",
            hobby = "Music",
            address = "Minsk",
            fullName = "Julia Demskaya",
            stateAndCity = "NCR Gurgaon",
            acceptFormText = "Thanks for submitting the form";


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulFillTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText("Female")).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(byText("February")).click();
        $(byText("1997")).click();
        $(byText("8")).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo.jpg"));
        $("#currentAddress").setValue(address);
        actions().moveToElement($(byText("Select State"))).click();
        $("#state").scrollIntoView(true).click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();


        $(".modal-content").shouldHave(text(acceptFormText),
                text(fullName),
                text(userEmail),
                text(mobile),
                text(gender),
                text(birht),
                text(subjects),
                text(hobby),
                text("photo.jpg"),
                text(address),
                text(stateAndCity));


    }
}
