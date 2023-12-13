package parameterizedTestData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import pages.LoginPage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class PasswordOptions {


@DataProvider
    public static Object[] getPasswordVariable(){
    return new Object[][]{
            {"123", List.of("Invalid username or password.")},
            {"w123W@", List.of("Invalid username or password.")},
            {"+-23//Qw", List.of("Invalid username or password.")},
            {"    ", List.of("Invalid username or password.")},
            {"", List.of("Please enter your password")},

    };

}


}
