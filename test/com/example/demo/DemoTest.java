package com.example.demo;

import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.LabelElement;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * This class contains JUnit tests, which are run using Vaadin TestBench 4.
 *
 * To run this, first get an evaluation license from
 * https://vaadin.com/addon/vaadin-testbench and follow the instructions at
 * https://vaadin.com/directory/help/installing-cval-license to install it.
 *
 * Once the license is installed, you can run this class as a JUnit test.
 */
public class DemoTest extends TestBenchTestCase {
    @Rule
    public ScreenshotOnFailureRule screenshotOnFailureRule =
            new ScreenshotOnFailureRule(this, true);

    @Before
    public void setUp() throws Exception {
        setDriver(new FirefoxDriver()); // Firefox

        // To use Chrome, first install chromedriver.exe from
        // http://chromedriver.storage.googleapis.com/index.html
        // on your system path (e.g. C:\Windows\System32\)
        //   setDriver(new ChromeDriver()); // Chrome

        // To use Internet Explorer, first install iedriverserver.exe from
        // http://selenium-release.storage.googleapis.com/index.html?path=2.43/
        // on your system path (e.g. C:\Windows\System32\)
        //   setDriver(new InternetExplorerDriver()); // IE

        // To test headlessly (without a browser), first install phantomjs.exe
        // from http://phantomjs.org/download.html on your system path
        // (e.g. C:\Windows\System32\)
        //   setDriver(new PhantomJSDriver()); // PhantomJS headless browser
    }

    /**
     * Opens the URL where the application is deployed.
     */
    private void openTestUrl() {
        getDriver().get("http://localhost:8080/Demo");
    }

    @Test
    public void testClickButton() throws Exception {
        openTestUrl();

        // At first there should be no labels
        assertFalse($(LabelElement.class).exists());

        // Click the button
        ButtonElement clickMeButton = $(ButtonElement.class).
                caption("Click Me").first();
        clickMeButton.click();

        // There should now be one label
        assertEquals(1, $(LabelElement.class).all().size());
        // ... with the specified text
        assertEquals("Thank you for clicking",
                $(LabelElement.class).first().getText());

        // Click the button again
        clickMeButton.click();

        // There should now be two labels
        List<LabelElement> allLabels = $(LabelElement.class).all();
        assertEquals(2, allLabels.size());
        // ... and the last label should have the correct text
        LabelElement lastLabel = allLabels.get(1);
        assertEquals("Thank you for clicking", lastLabel.getText());
    }
}