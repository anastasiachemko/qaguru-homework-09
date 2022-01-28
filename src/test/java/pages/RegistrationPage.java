package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("[for='gender-radio-2']"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInputSports = $("[for=hobbies-checkbox-1]"),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitClick = $("#submit"),
            resultsTable = $(".table-responsive");


    public CalendarComponent calendarComponent = new CalendarComponent();

    @Step("Открываем страницу с формой регистрации; проверяем, что она открылась")
    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        return this;
    }

    @Step("Вводим имя")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Вводим фамилию")
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Вводим email")
    public RegistrationPage typeEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Выбираем пол")
    public RegistrationPage setGender() {
        genderInput.click();

        return this;
    }

    @Step("Вводим номер телефона")
    public RegistrationPage typeNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    @Step("Вводим предет")
    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Вводим хобби")
    public RegistrationPage setHobbiesSports() {
        hobbiesInputSports.click();

        return this;
    }

    @Step("Загружаем изображение")
    public RegistrationPage uploadFile(String value) {
        pictureUpload.uploadFromClasspath(value);

        return this;
    }

    @Step("Вводим адрес")
    public RegistrationPage typeAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Выбираем штат")
    public RegistrationPage setState(String value) {
        stateInput.scrollTo().setValue(value).pressEnter();

        return this;
    }

    @Step("Выбираем город")
    public RegistrationPage setCity(String value) {
        cityInput.setValue(value).pressEnter();

        return this;
    }

    @Step("Утверждаем заполнение формы")
    public void clickSubmit() {
        submitClick.click();

    }

    @Step("Проверяем введённые данные")
    public RegistrationPage checkResultsValue(String key, String value){
        resultsTable.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
