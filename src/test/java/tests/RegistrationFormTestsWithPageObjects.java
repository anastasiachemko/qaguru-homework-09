package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTestsWithPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
    }

    @Test
    void main() {
        open("https://demoqa.com/automation-practice-form");

        registrationPage
                .typeFirstName("Anastasia")
                .typeLastName("Chemko")
                .typeEmail("nast.chemko@gmail.com")
                .setGender()
                .typeNumber("1117508498");

        CalendarComponent calendarComponent = new CalendarComponent();
        calendarComponent.setDate("10", "October", "2000");

        registrationPage
                .setSubject("English")
                .setHobbiesSports()
                .uploadFile("rafting.jpg")
                .typeAddress("Minsk")
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmit();

        registrationPage
                .checkResultsValue("Student Name", "Anastasia Chemko")
                .checkResultsValue("Student Email", "nast.chemko@gmail.com")
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", "1117508498")
                .checkResultsValue("Date of Birth","10 October,2000")
                .checkResultsValue("Subjects", "English")
                .checkResultsValue("Hobbies", "Sports")
                .checkResultsValue("Picture", "rafting.jpg")
                .checkResultsValue("Address", "Minsk")
                .checkResultsValue("State and City", "Haryana Karnal");
    }
}
