Selenium ProductsTest — Automated UI Testing Framework

Acest proiect reprezintă un framework complet de Test Automation pentru aplicația web  https://www.saucedemo.com/
Framework-ul este construit folosind:
•	Java
•	Selenium WebDriver
•	TestNG
•	Page Object Model (POM)
•	Allure Reports
•	WebDriverManager
•	Maven
•	GitHub Actions (CI/CD Pipeline)
•	IntelliJ IDEA
Proiectul acoperă scenarii esențiale precum login, sortări, verificarea prețurilor și adăugarea produselor în coș.

 Scenarii testate
•	✔️ Login valid – acces la pagina Products
•	✔️ Login invalid – afișarea mesajului de eroare
•	✔️ Sortarea produselor A → Z
•	✔️ Sortarea produselor Z → A
•	✔️ Sortarea produselor după preț (low → high)
•	✔️ Adăugarea unui produs în coș

Structura proiectului:

src/
 ├── main/java/org.example
 │     ├── BasePage.java
 │     ├── LoginPage.java
 │     └── ProductsPage.java
 └── test/java/org.example
       ├── BaseTest.java
       └── ProductsTest.java

BasePage
Metode comune:
•	waitForVisible
•	click
•	type
•	getText
🔹 LoginPage
Acțiuni specifice paginii de login:
•	introducerea username-ului
•	introducerea parolei
•	click pe Login
•	verificarea mesajului de eroare
🔹 ProductsPage
Funcționalități:
•	sortare după nume și preț
•	obținerea listelor de titluri și prețuri
•	add to cart
🔹 BaseTest
Configurarea WebDriver + WebDriverWait + ChromeOptions.
🔹 ProductsTest
Conține toate scenariile de testare.

Tehnologii folosite:
Tehnologie	Rol
Java	Limbajul principal
Selenium WebDriver	Automatizarea browserului
TestNG	Framework de testare
WebDriverManager	Gestionarea driverelor
Maven	Build & dependency management
Allure Reports	Raportare avansată
GitHub Actions	CI/CD pipeline
IntelliJ IDEA	IDE folosit

Rulare proiect:
1.	Clonezi repository-ul
git clone <repository-url>
2.	Deschizi proiectul în IntelliJ IDEA
3.	Rulezi testele
Poți rula direct clasa ProductsTest sau întregul pachet.
(Chrome trebuie să fie instalat pe sistem.)

Generarea raportului Allure:
După rularea testelor, se generează automat folderul:
allure-results
Pentru a genera raportul:
allure serve allure-results
Raportul se va deschide automat în browser.

CI/CD Pipeline — GitHub Actions
Proiectul include un pipeline configurat în GitHub Actions, care rulează automat testele Selenium la fiecare push pe branch-ul master.
Pipeline-ul:
•	instalează Java și Maven
•	instalează Google Chrome
•	rulează testele TestNG
•	generează artefactele allure-results
•	marchează build-ul ca success sau failed
•	permite vizualizarea execuțiilor în tab-ul Actions
Workflow-ul se află în:
.github/workflows/selenium-tests.yml

Exemple de scenarii de testare
✔️ Login valid
•	Deschid pagina de login
•	Introduc username și parolă valide
•	Verific redirecționarea către pagina Products
•	Verific afișarea celor 6 produse
✔️ Login invalid
•	Introduc username valid + parolă greșită
•	Apăs Login
•	Verific mesajul de eroare
✔️ Sortarea A → Z
•	Selectez sortarea Name (A to Z)
•	Verific ordinea alfabetică
✔️ Sortarea Z → A
•	Selectez sortarea Name (Z to A)
•	Verific ordinea descrescătoare
✔️ Sortarea după preț (low → high)
•	Selectez sortarea Price (low to high)
•	Verific ordonarea crescătoare
✔️ Adăugarea unui produs în coș
•	Selectez Sauce Labs Backpack
•	Apăs Add to cart
•	Verific că butonul devine „Remove”
