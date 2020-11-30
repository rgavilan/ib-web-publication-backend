package es.um.asio.back.test.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber", "summary" }, features = { "src/test/features" }, glue = {
		"es.um.asio.back.test.runners.stepdefs" })
public class WebApplicationRunner {

}
