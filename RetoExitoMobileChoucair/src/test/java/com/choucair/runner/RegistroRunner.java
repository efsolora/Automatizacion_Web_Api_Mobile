package com.choucair.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/registro.feature",
        glue = "com.choucair.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RegistroRunner {
}
