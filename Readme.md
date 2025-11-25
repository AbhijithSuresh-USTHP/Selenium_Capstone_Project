#  Project Title: Codecharge Automation Framework

## Overview

This repository hosts a robust **Automation Testing Framework** developed for the http://examples.codecharge.com/Portal/Default.php. The framework utilizes a powerful combination of industry-standard tools to implement a **Behavior-Driven Development (BDD)** approach, ensuring highly readable, maintainable, and scalable test automation.


## Folder Structure

<img width="580" height="758" alt="image" src="https://github.com/user-attachments/assets/c570b9b3-1e99-4ed8-a430-2ac1cb8816f8" /><img width="707" height="411" alt="image" src="https://github.com/user-attachments/assets/877e7a63-0a1b-403b-b9f2-364c0e5c042e" />





## Technology Stack

| Technology | Role in Framework |
| :--- | :--- |
| **Maven** | Build automation and dependency management. |
| **Selenium WebDriver** | Interacting with the web elements of the application. |
| **TestNG** | Test execution control, parallel testing, and reporting capabilities. |
| **Cucumber (BDD)** | Defining features and scenarios in plain language (Gherkin). |
| **Java** | Core programming language for the entire framework. |
| **[Reporting Tool, e.g., Extent Reports]** | Generating detailed, visually appealing test execution reports. |

## Framework Features

* **BDD Compliance:** Features and scenarios are written in Gherkin, promoting collaboration between technical and business teams.
* **Page Object Model (POM):** Designed for code reusability and maintainability by separating test logic from page locators.


## 📈 Reporting

Test execution reports are automatically generated upon completion.

* **Extent Report:** Found at `Report\report.html`

<img width="1919" height="1028" alt="image" src="https://github.com/user-attachments/assets/6ac2c0dd-b91b-4923-b095-6e5f7c9c2fe5" />

* **Allure Report:** Has to be generated using the command mvn:allure serve

<img width="1882" height="1026" alt="image" src="https://github.com/user-attachments/assets/22b972b5-640d-4612-8dd0-ee33b47aeb2b" />

  

  


