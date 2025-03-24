package com.luismi.itx.ecommerce.cucumber;

import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Get price by application date, product and brand suite")
@SelectClasspathResource("features")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.luismi.itx.ecommerce.cucumber.e2e") // Ruta del paquete con las Step Definitions
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports.html") // Configuración de plugins
public class CucumberTest {
}
