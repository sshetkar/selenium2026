# Selenium 2026

## Project Overview

Selenium 2026 is a Selenium WebDriver automation repository developed using Java and Maven.

The purpose of this repository is to:

* Learn Selenium WebDriver concepts
* Practice web automation scenarios
* Build reusable automation scripts
* Maintain a structured collection of Selenium examples
* Gradually evolve toward a complete automation framework

---

## Technology Stack

| Technology         | Version |
| ------------------ | ------- |
| Java               | 11      |
| Maven              | 3.x     |
| Selenium WebDriver | 4.44.0  |

---

## Project Structure

```text
webautomation
│
├── src
│   └── test
│       ├── java
│       └── resources
│
├── pom.xml
│
└── README.md
```

Currently all automation scripts are maintained under:

```text
src/test/java
```

Future test data, configuration files, and resources will be maintained under:

```text
src/test/resources
```

---

## Maven Configuration

The project is configured to compile using Java 11.

```xml
<properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>
```

### Benefits

* Consistent Java version across environments
* Prevents Java compatibility issues
* Ensures Maven builds use Java 11
* Simplifies project setup on new machines

---

## Dependencies

### Selenium WebDriver

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.44.0</version>
</dependency>
```

---

## Automated Scripts

| Package | Class Name                   | Website                   | Description                                                                                          |
| ------- | ---------------------------- | ------------------------- | ---------------------------------------------------------------------------------------------------- |
| basics  | DemoBlazeTitleValidationTest | https://www.demoblaze.com | Launch browser, navigate to DemoBlaze, capture page title, and validate expected title using if-else |
| forms  | RegistrationFormTest | http://uiplayground.techwithjatin.com | Automate registration form by entering user details and submitting the form |
| dynamiccontent  | MenuItemLoadingTest | http://uiplayground.techwithjatin.com | Load menu items dynamically, print item names and prices, validate live counter, verify menu hide functionality, and synchronize elements using explicit waits |
| waits  | VisibilityOfElementLocatedTest | http://uiplayground.techwithjatin.com | Demonstrate visibilityOfElementLocated() by waiting for a delayed element, capturing elapsed time, and printing the visible text |
| waits  | ElementToBeClickableTest | http://uiplayground.techwithjatin.com | Demonstrate elementToBeClickable() by validating a disabled button, triggering its activation, and verifying attribute changes |
| waits  | TextToBePresentInElementLocatedTest | http://uiplayground.techwithjatin.com | Demonstrate textToBePresentInElementLocated() by triggering dynamic text injection and validating the updated content |
| waits  | InvisibilityOfElementLocatedTest | http://uiplayground.techwithjatin.com | Demonstrate invisibilityOfElementLocated() by waiting for a loading spinner to disappear after triggering the action |
| waits  | StalenessOfTest | http://uiplayground.techwithjatin.com | Demonstrate stalenessOf() by detecting element re-rendering and validating the updated data-render-key attribute |

---

## Package Structure

```text
src/test/java
│
├── basics
│   └── DemoBlazeTitleValidationTest.java
│
├── forms
│   └── RegistrationFormTest.java
│
├── dynamiccontent
│   └── MenuItemLoadingTest.java
│
└── waits
    ├── VisibilityOfElementLocatedTest.java
    ├── ElementToBeClickableTest.java
    ├── TextToBePresentInElementLocatedTest.java
    ├── InvisibilityOfElementLocatedTest.java
    └── StalenessOfTest.java
```

---

## How To Execute

### Using Eclipse

1. Open Project
2. Open Java Class
3. Run As → Java Application

### Using Maven

```bash
mvn clean test
```

---

## Git Commit Convention

Recommended commit format:

```text
feat      -> New script/scenario added
fix       -> Bug fixed
refactor  -> Code improved without changing behavior
build     -> pom.xml/dependency changes
docs      -> README updates
```

Examples:

```text
feat: automate DemoBlaze title validation using if-else

build: configure Maven compiler source and target version to Java 11

docs: add initial project README documentation
```

---

## Author

Shashank Shetkar

Repository created for Selenium WebDriver learning, practice, and framework development.
