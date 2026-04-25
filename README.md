Selenium ProductsTest — Automated UI Testing Framework

Acest proiect conține teste automate scrise în Java + Selenium WebDriver + TestNG, care verifică funcționalitățile principale ale aplicației web: https://www.saucedemo.com/
Framework-ul este construit pe principiile Page Object Model (POM) și include integrare completă cu Allure Reports.

Scenarii testate:

•	Login valid – verifică accesul la pagina Products după autentificare
•	Login invalid – verifică afișarea mesajului de eroare pentru credențiale greșite
•	Sortarea produselor A → Z
•	Sortarea produselor Z → A
•	Sortarea produselor după preț (low → high)
•	Adăugarea unui produs în coș

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
Metode comune folosite în toate paginile:
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
Funcționalități pentru pagina de produse:
•	sortare după nume și preț
•	obținerea listelor de titluri și prețuri
•	adăugarea produselor în coș
🔹 BaseTest
Configurarea WebDriver + WebDriverWait + ChromeOptions.
🔹 ProductsTest
Conține toate scenariile de testare:
•	login valid/invalid
•	sortări
•	add to cart

Tehnologii folosite
•	Java – limbajul principal
•	Selenium WebDriver – automatizarea browserului
•	TestNG – structurarea și rularea testelor
•	WebDriverManager – gestionarea automată a driverelor
•	Maven – managementul dependențelor
•	IntelliJ IDEA – IDE folosit
•	Allure Reports – raportare avansată

Rulare proiect
1.Clonezi proiectul:
git clone <repository-url>
2.Deschizi proiectul în IntelliJ IDEA
3.Rulezi testele
Poți rula direct clasa ProductsTest sau întregul pachet de teste.
(Chrome trebuie să fie instalat pe sistem)

Generarea raportului Allure:
După rularea testelor, se generează automat folderul:
allure-results (in Terminal).
Pentru a genera raportul:
allure serve allure-results

Raportul se va deschide automat în browser și va include:
•	grafice
•	timeline
•	suite
•	severități
•	stories & features

Exemple de scenarii de testare:
1. Login valid
•	Deschid pagina de login
•	Introduc username și parolă valide
•	Verific redirecționarea către pagina Products
•	Verific că sunt afișate 6 produse
2. Login invalid
•	Deschid pagina de login
•	Introduc username valid + parolă greșită
•	Apăs Login
•	Verific afișarea mesajului de eroare
     3. Sortarea produselor A → Z
•	Mă autentific
•	Selectez sortarea Name (A to Z)
•	Preiau titlurile produselor
•	Verific ordinea alfabetică
4. Sortarea produselor Z → A
•	Mă autentific
•	Selectez sortarea Name (Z to A)
•	Preiau titlurile
•	Verific ordinea descrescătoare
 5. Sortarea produselor după preț (low → high)
•	Mă autentific
•	Selectez sortarea Price (low to high)
•	Preiau lista prețurilor
•	Verific ordonarea crescătoare
 6. Adăugarea unui produs în coș
•	Mă autentific
•	Selectez produsul Sauce Labs Backpack
•	Apăs Add to cart
•	Verific că butonul devine „Remove”

Concluzii:
Acest proiect demonstrează implementarea unui framework simplu, curat și eficient de automatizare folosind:
•	Java
•	Selenium WebDriver
•	TestNG
•	Page Object Model
•	Allure Reports
