# 🚲 BlaBlaBikeTests Test Bench Application

**BlaBlaBike** - a service for finding, selecting, and quickly booking bicycles.

---

### 👥 Project team

| Role | Participants |
| :--- | :--- |
| **Developers** | Dumitru Gangan, Vladyslav Kravchenko, Dmitrii Evdokimov, Kateryna Matvieieva, Stepan Serbin |
| **QA Engineers** | Dariia Boiko, Daryna Suk, Vladimir Dinu, Hanna Kozlianska |

---

### 🛠 Tech Stack

* **Core:** Java 21 + Maven
* **UI:** Selenium WebDriver + WebDriverManager
* **API:** Rest-Assured
* **DB:** PostgreSQL (JDBC)
* **Testing:** JUnit 5 + AssertJ
* **Logging:** Custom EventFiringDecorator (MyListener)

---

### 📏 Best Practices

1.  DRY & Clean Code: All common actions (clicks, waits) are encapsulated in BasePage.
2.  Explicit Waits: Only dynamic WebDriverWait is used. No Thread.sleep().
3.  Fluent Interface: Implementation of action chains (Chain of Pages) for test readability.
4.  Git Flow: Feature and test development is conducted in separate branches.

---

### 📂 Структура проекта

* `src/main/java/core`  - Framework core (BasePage, configurations, listeners).
* `src/test/java/pages` - Page Object Repository (locators and business logic).
* `src/test/java/tests` - Automated test cases.

---

🚀 Launch Instructions

To run the tests, you must first launch the local version of the website and then the automated testing project.

Step 1: Launch Frontend (Developer Website)
1. Clone the repository: git clone https://github.com/vkadi-budetak/blablabike.git
2. Install dependencies: npm install
3. Launch locally: npm run dev
4. Open in browser: http://localhost:3000

#### Шаг 2: Запуск QA Automation (Этот проект)
1. Clone the test repository: git clone https://github.com/Ifbefine/BlaBlaBikeTests.git
2. Configuration: Ensure that the correct baseUrl=http://localhost:3000 is specified in the src/test/resources/config.properties file.
3. Launch: Open the project in IntelliJ IDEA and run the tests from the src/test/java/com/blablaBike/Tests/ folder.
4. Logs: All actions (clicks, element searches) are displayed in real-time in the console (Run tab).


