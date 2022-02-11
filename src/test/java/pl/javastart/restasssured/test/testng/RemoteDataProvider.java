package pl.javastart.restasssured.test.testng;

import org.testng.annotations.DataProvider;

public class RemoteDataProvider {

    @DataProvider
    public Object[][] remoteDataProvider() {
        return new Object[][] {
                {"0","Pet not found"},
                {"aaa", "java.lang.NumberFormatException: For input string:"},
                {"!!!", "java.lang.NumberFormatException: For input string:"}
        };
    }
}
