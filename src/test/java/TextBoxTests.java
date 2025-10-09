import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Alex");
        $("#userEmail").setValue("alex@egorov.com");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@egorov.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
    @Test
    void fillPracticeForm () {
        open("/automation-practice-form");
        $("#firstName").setValue("Vitaliy");
        $("#lastName").setValue("Arthas");
        $("#userEmail").setValue("vitaliyarthasovich@mail.ru");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8999999999");
        $("#dateOfBirthInput").click();
        $("[aria-label = 'Choose Sunday, September 28th, 2025']").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("label[for='hobbies-checkbox-2']").click();
        $("#currentAddress").setValue("Venèsia");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        $("#uploadPicture").uploadFromClasspath("Locators_table.pdf");



        //setTimeout(function(){debugger;}, 5000)


        //$("#gender-radio-1").shouldHave(attribute("checked"));
    }
}