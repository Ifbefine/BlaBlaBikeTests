# 🚲 BlaBlaBike Automation Project

**BlaBlaBike** — сервис для поиска, выбора и быстрого бронирования велосипедов (школьная практика).

---

### 👥 Команда проекта

| Роль | Участники |
| :--- | :--- |
| **Developers** | Dumitru Gangan, Vladyslav Kravchenko, Dmitrii Evdokimov, Kateryna Matvieieva, Stepan Serbin |
| **QA Engineers** | Dariia Boiko, Daryna Suk, Vladimir Dinu, Hanna Kozlianska |

---

### 🛠 Стек технологий (Tech Stack)

* **Core:** Java 21 + Maven
* **UI:** Selenium WebDriver + WebDriverManager
* **API:** Rest-Assured
* **DB:** PostgreSQL (JDBC)
* **Testing:** JUnit 5 + AssertJ
* **Logging:** Custom EventFiringDecorator (MyListener)

---

### 📏 Правила разработки (Best Practices)

1.  **DRY & Clean Code:** Все общие действия (клики, ожидания) инкапсулированы в `BasePage`.
2.  **Explicit Waits:** Только динамические ожидания `WebDriverWait`. Никаких `Thread.sleep()`.
3.  **Fluent Interface:** Реализация цепочек действий (Chain of Pages) для читаемости тестов.
4.  **Git Flow:** Разработка функционала и тестов ведется в отдельных ветках.

---

### 📂 Структура проекта

* `src/main/java/core` — Ядро фреймворка (BasePage, конфигурации, слушатели).
* `src/test/java/pages` — Page Object Repository (локаторы и бизнес-логика).
* `src/test/java/tests` — Автоматизированные тест-кейсы.

---

### 🚀 Быстрый запуск

1. **Backend/Frontend:** `npm install` && `npm run dev` (доступно на `http://localhost:3000`)
2. **Конфигурация:** Проверьте `baseUrl` в `src/main/resources/config.properties`.


