# Myca Arcangel - Zwift Automation Test
Simple Java+Selenium UI tests on Zwift website 

[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

### Tools 
* Java version 14
* Maven
* JUnit 5

### Installation - IDE
1. `git clone https://github.com/yumeko/zwiftAutomationTest.git`
2. Open project in IDE (Intellij)
3. Run test/java in `FeatureScenarios` for required scenarios

### Installation - command line
1. Ensure you have Maven, Java, git working in command line
2. `git clone https://github.com/yumeko/zwiftAutomationTest.git`
3. In `/zwiftAutomationTest`, run `mvn package`
4. `mvn test`
5. `mvn -Dtest=FeatureScenarios test`  

### Notes
1. Written/tested on Windows 10, ChromeDriver 83 (driver is already included in `resources/chromedriver.exe`)
2. It won't fullscreen if your Windows toolbar is on the left/right for some reason 