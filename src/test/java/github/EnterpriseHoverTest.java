package github;


import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class EnterpriseHoverTest {
    @BeforeAll
    static void settingsForBrowser() {
        Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    @DisplayName("Тест на наличие страницы \"Enterprise\" ")
    public void checkForEnterprisePage() {
        open("https://github.com/");
        $$("div.HeaderMenu button").findBy(text("Solutions")).hover();
        $$("div.HeaderMenu a").findBy(text("Enterprises")).click();
        $$("div.application-main h1").shouldHave(texts("The AI-powered developer platform"));
    }
}
