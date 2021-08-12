

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;


public class ConnectorTest {

    private static Connection connection = null;
    public String actualUrl;
    public String actualUsername;
    public String actualPassword;

    @Test
    public void testGetConnection() {

        ResourceBundle bundle = ResourceBundle.getBundle("com/troymorrow/sqlconnector/dbConfig");
        actualUrl = bundle.getString("url");
        actualUsername = bundle.getString("username");
        actualPassword = bundle.getString("password");


        String expectedUrl = "jdbc:mysql://localhost:3306/project0";
        String expectedUsername = "root";
        String expectedPassword = "RevPr0-21";

        assertEquals(expectedUrl,actualUrl);
        assertEquals(expectedUsername, actualUsername);
        assertEquals(expectedPassword,actualPassword);

    }




}
