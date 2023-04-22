package com.demoqa;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTest extends TestBase{
    @Test
    void smokeTest(){

        String firstName = "Test",
               lastName = "Testov",
               email = "Test@yandex.ru",
               subjects = "Math",
               mobile = "9998887766",
               pictureName = "smile.png",
               picturePath = "src/test/resources/images/" + pictureName,
               address = "Moscow, some address";

        open( "/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        // Hide footer and ads
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName); // input First name
        $("#lastName").setValue(lastName); // input Last name
        $("#userEmail").setValue(email); // input Email
        $("#genterWrapper .custom-control:nth-child(1)").click(); //choose Gender
        $("#userNumber").setValue(mobile); // input Mobile
        // choose Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month .react-datepicker__week:nth-child(5) .react-datepicker__day--031").click();

        $("#subjectsInput").setValue(subjects).pressEnter(); // input Subjects
        $("#hobbiesWrapper .col-md-9 .custom-control:nth-child(1)").click(); // choose Hobbies
        $("#uploadPicture").uploadFile(new File(picturePath)); // upload Picture
        $("#currentAddress").setValue(address); // input Current address
        // choose State and city
        $("#state").scrollTo().click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        $("#submit").click(); // click the submit button

        $(".table-responsive") // compare results
                .shouldHave(text(firstName))
                .shouldHave(text((lastName)))
                .shouldHave((text("Male"))) // test
                .shouldHave((text(mobile)))
                .shouldHave(text("31 October,1995"))
                .shouldHave(text(subjects))
                .shouldHave(text("Sports"))
                .shouldHave(text(pictureName))
                .shouldHave(text(address));

        $("#closeLargeModal").click(); // click the close button
    }
}
