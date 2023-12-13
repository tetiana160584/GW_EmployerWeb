package parameterizedTestData;

import org.testng.annotations.DataProvider;

import java.util.List;

public class EmailOptions {

    @DataProvider
    public static Object[] getEmailVariablePositive(){
        return new Object[][]{
                {"tetiana.kostyhina+9173@gmail.com"},
                {"tetiana.kostyhina+119@gmail.com"},
                {"tetiana.kostyhina+64300@gmail.com"},
                {"tetiana.kostyhina+91777@gmail.com"},
                {"tetiana.kostyhina+91397@gmail.com"},

        };
    }
}
