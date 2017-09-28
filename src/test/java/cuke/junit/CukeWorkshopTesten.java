package cuke.junit;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Created on 23-1-2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        format = {"pretty", "html:target/cuke", "json:target/cuke/cuke.json"},
        features = "classpath:features/",
        tags={"@CukeWorkshop", "~@Ignore"},
        glue = {"cuke.common.steps"})
public class CukeWorkshopTesten {
    @BeforeClass
    public static void setUp() throws InterruptedException {
        System.out.println("setUp");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("tearDown");
    }
}
