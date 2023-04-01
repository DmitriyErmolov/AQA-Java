package com.demoqa;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationForm {

    @Test
    void smokeTest(){

        String firstName = "Test",
               lastName = "Testov",
               email = "Test@yandex.ru",
               subjects = "Math",
               mobile = "9998887766",
               pictureName = "IMG_3316.jpg",
               picture = "D:\\Java\\" + pictureName,
               address = "Moscow, some address";


        // Открыть сайт https://demoqa.com/automation-practice-form
        open("https://demoqa.com/automation-practice-form");
        // Скрыть футер
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName); // First name
        $("#lastName").setValue(lastName); // Last name
        $("#userEmail").setValue(email); // Email
        $("#genterWrapper .custom-control:nth-child(1)").click(); // Gender
        $("#userNumber").setValue(mobile); //Mobile
        // Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month .react-datepicker__week:nth-child(5) .react-datepicker__day--031").click();

        $("#subjectsInput").setValue(subjects).pressEnter(); // Subjects
        $("#hobbiesWrapper .col-md-9 .custom-control:nth-child(1)").click(); // Hobbies
        $("#uploadPicture").uploadFile(new File(picture)); // Picture
        $("#currentAddress").setValue(address); // Current address
        // State and city
        $("#state").scrollTo().click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();

        $("#submit").click(); // click the submit button

        $(".table-responsive")
                .shouldHave(text(firstName))
                .shouldHave(text((lastName)))
                .shouldHave((text("Male")))
                .shouldHave((text(mobile)))
                .shouldHave(text("31 October,1995"))
                .shouldHave(text(subjects))
                .shouldHave(text("Sports"))
                .shouldHave(text(pictureName))
                .shouldHave(text(address));

        $("#closeLargeModal").click(); // click the close button


    }
}
