package SecurityAdminTests;

import Pages.Dashboard;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.*;

public class TC_05_VerifyDashboard {
    // Object of Connection from the Database
    Connection conn = null;

    // Object of Statement. It is used to create a Statement to execute the query
    Statement stmt = null;

    //Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
    ResultSet expectedCheck = null;
    ResultSet expectedACH = null;
    ResultSet expectedCard = null;


    @Test(enabled = true, groups = {"Dashboard"})
    public void TC_005_VerifyDashboard() throws ClassNotFoundException, SQLException {
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
        homePage.homePageIsDisplayed();


        Class.forName("com.mysql.jdbc.Driver"); // Register JDBC driver (JDBC driver name and Database URL)

        // Open a connection
        conn = DriverManager.getConnection("Database URL", "root", "root");

        stmt = conn.createStatement();
        expectedCheck = stmt.executeQuery("select * from sampletable where type = check");
        expectedACH = stmt.executeQuery("select * from sampletable where type = ACH");
        expectedCard = stmt.executeQuery("select * from sampletable where type = card");

        Dashboard dashboard = new Dashboard();
        dashboard.navigateToDashboard();
        dashboard.dashboardPageIsDisplayed();
        String actualCheckValue = dashboard.getCheckValue();
        String actualACHValue = dashboard.getACH();
        String actualCardValue = dashboard.getCardValue();
        Assert.assertEquals(actualCheckValue, expectedCheck);
        Assert.assertEquals(actualACHValue, expectedACH);
        Assert.assertEquals(actualCardValue, expectedCard);
    }
}

