package someWierdoTests.Git;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import someWierdoTests.TestBase;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitDropListTest extends TestBase {


    static Stream<Arguments> whoYouDrop() {
        return Stream.of(
                Arguments.of("Pricing", new String[]{"Compare plans", "Contact Sales"}),
                Arguments.of("Explore", new String[]{"Topics", "Skills"})
        );
    }

    @MethodSource()
    @ParameterizedTest(name = "Проверяет наличие {1} в выпадающем списке {0} на странице Git")
    void whoYouDrop(String nameOfList, String[] nameOfFieldInList) {
        open("https://github.com");
        $("html").hover();
        $(".HeaderMenu").find(byText(nameOfList)).hover();
        for (String currentField : nameOfFieldInList) {
            $(".HeaderMenu").$(byText(nameOfList)).parent().shouldHave(text(currentField));
        }
    }
}
