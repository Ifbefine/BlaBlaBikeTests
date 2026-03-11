# 🚲 BlaBlaBikeTests Test Bench Application

**BlaBlaBike** — сервис для поиска, выбора и быстрого бронирования велосипедов

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

### 🚀 Инструкция по запуску

Для работы тестов необходимо сначала запустить локальную версию сайта, а затем проект с автотестами.

#### Шаг 1: Запуск Frontend (Сайт разработчиков)
1. **Склонировать репозиторий:** `git clone https://github.com/vkadi-budetak/blablabike.git`
2. **Установить зависимости:** `npm install`
3. **Запустить локально:** `npm run dev`
4. **Открыть в браузере:** [http://localhost:3000](http://localhost:3000)

#### Шаг 2: Запуск QA Automation (Этот проект)
1. **Склонировать репозиторий с тестами:** `git clone https://github.com/Ifbefine/BlaBlaBikeTests.git`
2. **Настройка:** Убедитесь, что в файле `src/test/resources/config.properties` указан верный `baseUrl=http://localhost:3000`.
3. **Запуск:** Откройте проект в IntelliJ IDEA и запустите тесты из папки `src/test/java/com/blablaBike/Tests/`.
4. **Логи:** Все действия (клики, поиск элементов) отображаются в реальном времени в консоли (вкладка **Run**).


