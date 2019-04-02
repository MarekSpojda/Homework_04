<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

### Zadania.

Stwórz projekt `Homework_04`. Rozwiązania zadań powinny znajdować się w tym projekcie.

#### Zadanie 1

W projekcie stwórz stronę jsp `index1.jsp`. Następnie:
1. Pobierz wartość parametru GET o nazwie `author`.
2. Sprawdź czy parametr istnieje oraz czy nie jest pusty.
3. Wyświetl informacje w postaci:
    ```html
    <p>Wybrany autor <Pobrana wartość></p>
    ```

#### Zadanie 2

W projekcie stwórz stronę jsp `index2.jsp`. Za pomocą pętli forEach wyświetl na stronie liczby w taki sposób by uzyskać poniższy wynik. Wykorzystaj dodatkowe atrybuty pętli `begin` oraz `step`.    
```html
2 
4 
6 
8 
10 
```

#### Zadanie 3

W projekcie stwórz stronę jsp `index3.jsp`. Następnie:
1. Za pomocą odpowiedniej funkcji jstl sprawdź czy ustawiony za pomocą poniższego tagu ciąg znaków zawiera napis `coderslab`:
    ```html
    <c:set var="someName" value="Witaj w coderslab."/>  
    ```
2. Jeżeli napis zawiera `coderslab` w instrukcji sterującej wypisz na stronie `<p>OK</p>`.

#### Zadanie 4

W projekcie stwórz servlet `Servlet_01_1` oraz `Servlet_01_2`. Następnie:
1. Na pierwszej stronie (`Servlet_01_1`) stwórz formularz z elementem `select` oraz opcjami wyboru zgodnymi z kluczami poniższej mapy:
   ```java
   Map<String, String> lang = new  HashMap<>();
   lang.put("en", "Hello");
   lang.put("pl", "Cześć");
   lang.put("de", "Ehre");
   lang.put("es", "Hola");
   lang.put("fr", "Bienvenue");
   ```
2. Strona ma przesyłać dane za pomocą `POST` do drugiej strony (`Servlet_01_2`), która ma ustawić ciasteczko `language` na wartość wybraną przez użytkownika.
3. Po ponownym wejściu na pierwszą powinna być wyświetlana informacja powitalna w wybranym przez użytkownika języku.
4. Gdy ciasteczko nie istnieje, wiadomość powitalna powinna być wyświetlana w języku polskim.

Hint: Odpowiednie dane przekaż i przetwórz w pliku widoku.

#### Zadanie 5

Zapoznaj się z wzorcem DAO - [Wikipedia] [dao-wiki].

Jest to wzorzec podobny do znanego już nam ActiveRecords z tą różnicą, że wszystkie metody związane z operacjami na obiekcie są wydzielone do oddzielnej klasy np. ProductDao.

Klasy DAO powinny implementować przynajmniej zestaw operacji CRUD.

Skrót ten oznacza:
- Create  
- Read
- Update
- Delete


W projekcie stwórz servlet, a w nim servlet `Servlet_02` z obsługą metod `doGet` i `doPost`. Celem zadania jest stworzenie formularza do zamawiania biletu lotniczego. W tym celu:
1. Stwórz klasę `Airport` z następującymi polami:
    * Nazwa `name`.
    * Kod `code`.
    * Strefa czasową `timezone`.
2. Stwórz klasę `AirportDao` - a w niej metodę o sygnaturze `List <Airport> getList()`- metoda wczyta z pliku `airports.txt` dane w postaci CSV,
utworzy na ich podstawie obiekty klasy `Airport`, które następnie doda do ArrayListy.
3. Stwórz, w pliku jsp, formularz, który przesyła dane metodą `POST`. Formularz powinien zawierać:  
  * Lotnisko wylotu - pole `select` (dane pobrane przez dao).
  * Lotnisko przylotu - pole `select`(dane pobrane przez dao).
  * Czas startu - pole `datetime-local` (będzie to czas wylotu w czasie lokalnym lotniska).
  * Długość lotu w godzinach - pole `number` `min="0"`, `step="1"`.
  * Cenę lotu - pole `number` `min="0"`, `step="0.01"`.
4. Dodaj obsługę tego formularza w metodzie `doPost`. Obsługa powinna polegać tylko na wyświetleniu przesłanych danych. 

Hint: Pamiętaj żeby dane z DAO pobierać tylko raz!. Każdy odczyt z pliku (a potem z bazy danych) może długo trwać. 

#### Zadanie 6

Celem zadania jest obsługa i przetworzenie danych pobranych z formularza, który zrobiliśmy w poprzednim zadaniu.
W tym celu zmodyfikuj metodę `doPost` servletu z poprzedniego pytania w następujący sposób:
1. Sprawdź czy użytkownik nie wybrał takiego samego lotniska wylotu i przylotu.
2. Sprawdź czy data i czas lotu zostały podane.
3. Sprawdź czy cena lotu jest większa od `0`.
4. Pobierz strefę czasową lotniska wylotu i zapisz ją do zmiennej.
5. Pobierz strefę czasową lotniska przylotu i zapisz ją do zmiennej.
6. Stwórz obiekt z datą lotniska wylotu w jego strefie czasowej i zapisz  czas  do zmiennej 
7. Dodaj do daty czas lotu i zmień strefę czasową na lotnisko przylotu i zapisz  czas  do zmiennej.
8. Stwórz klasę `Flight` z następującymi polami:
    * Lotnisko wylotu `departure`.
    * Lotnisko przylotu `arrival`.
    * Czas przylotu `arrivalTime`
    * Cena lotu `price`

11. Utwórz obiekt klasy z odpowiednimi danymi.

Hint: Żeby poprawnie pracować z strefami czasowymi skorzystaj z [ZonedDateTime][zone-date-time] lub joda-time.
Tutaj znajdziesz przykłady: [przykład1][date-example1] , [przykład2][date-example2]


#### Zadanie 7

Celem zadania jest wyświetlenie danych przetworzonych w poprzednim zadaniu.  W tym celu:
1. Przekaż do widoku utworzony uprzednio obiekt klasy `Flight`.
2. Stwórz w html tabelę zawierającą dane (wygląd tabeli nie ma znaczenia):  
   * lotnisko wylotu z czasem wylotu i kodem lotniska
   * lotnisko przylotu z czasem przylotu i kodem lotniska
   * czas lotu
   * cenę lotu
   
#### Zadanie 8

1. Umieść na stronie dostępnej pod adresem **/newsletter** dowolny tekst, możesz skorzystać z generatora: [lorem-ipsum].
2. Umieść na stronie formularz z możliwością zapisu użytkownika na newsletter.
Formularz musi mieć następujące pola:
  * email (Adres email),
  * name (Imię i nazwisko).
3. Formularz powinien wyświetlać się dla użytkownika raz na 24 godziny - wykorzystaj w tym celu ciasteczka.
4. Napisz obsługę formularza - dane zapisz do bazy.
5. Zapytania tworzące tabele w bazie danych umieść w pliku `query.sql`.
 
 
#### Zadanie 9

Celem zadania jest udostępnienie funkcjonalności księgi gości.

1. Utwórz servlet wyświetlający listę wpisów z księgi gości. Ma być dostępny pod adresem **/guest-book**
2. Wyświetlane mają być wpisy w kolejności od najnowszego do najstarszego.
3. Informacje o wpisach mają być pobierane z bazy danych.
4. Zapytania tworzące tabele w bazie danych umieść w pliku `query.sql`.
5. Dane dostępowe do bazy danych umieść w parametrach inicjalizacji dla całej aplikacji - sprawdź snippety aby dowiedzieć się jak zapisać i odczytać parametry.
6. Na stronie nad wpisami umieść formularz umożliwiający dodawanie nowego wpisu (nazwa oraz opis). 


#### Zadanie 10

1. Utwórz 5 stron, każda ze stron ma posiadać linki nawigacyjne do pozostałych.    
  Np.:
    *   strona 1 będzie posiadać linki do stron 2,3,4.
    *   strona 2 będzie posiadać linki do stron 1,3,4.
  itd.

  Mają również wyświetlać informacje o aktualnie odwiedzanej stronie w postaci:
  ```html
  Witaj na stronie 1
  ```
2. Strona 5 powinna być dostępna pod adresem **/history**, ma wyświetlać historię odwiedzanych stron oraz link z możliwością wyczyszczenia historii.
3. Dane o odwiedzonych stronach przechowuj w sesji.

Przykład wyświetlanej historii:
```
Odwiedzałeś:
Strona 1
Strona 2
Strona 3
Strona 2
Strona 4
```
<!-- Links -->
[zone-date-time]:https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html 
[date-example1]:https://www.mkyong.com/java/java-convert-date-and-time-between-timezone/
[date-example2]:https://dzone.com/articles/deeper-look-java-8-date-and
[dao-wiki]:https://pl.wikipedia.org/wiki/Data_Access_Object
[lorem-ipsum]:http://pl.lipsum.com/



