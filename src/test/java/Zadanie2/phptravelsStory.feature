Feature: Zakup biletów na stronie https://www.phptravels.net/ .

  Scenario Outline: Zakup biletów z Warszawy do Nowego Yorku oraz wykonanie zrzutu ekranu z fakturą zakupu.
    Given Przegladarka otwarta na stronie https://www.phptravels.net/
    When Przyciskam przycisk 'FLIGHTS' widoczny na stronie
    When Wybieram opcje 'Round Trip'
    When Naciskam pierwsze pole 'Enter Location'
    And  Wpisuje WAW oraz wybieram lotnisko z listy wyboru
    When Naciskam drugie pole 'Enter Location'
    And  Wpisuje JFK oraz wybieram lotnisko z listy wyboru
    When Wpisuje date wylotu oraz przylotu w pola do tego wyznaczone
    And  Wybieram ilość pasażerów z okna wyboru
    And  Naciskam przycisk 'Search'
    Then Czekam aż załaduje się przycisk 'BOOK NOW' oraz naciskam go
    When Naciskam przycisk 'Guest Booking'
    And  Wypełniam pola danymi "<Name>" "<Surname>" "<Email>" "<Phone>" "<Birthday>" "<CardNumber1>" "<Expiration>"
    And  Wybieram 'POLAND' w polu Nationality
    And  W polu 'Card Type' wybieram 'Visa'
    And  Wpisuje dane karty płatniczej danymi "<CardNumber>" "<CardCVV>"
    And  W polu 'Expiration Date' wyberam 'Sep09' oraz '2023'
    Then Naciskam przycisk 'COMPLETE BOOKING'

    Examples:
    |Name|Surname |Email           |Phone    |Birthday   |CardNumber1|Expiration|CardNumber      |CardCVV|
    |Jan |Kowalski|Jan@kowalski.com|530960430|1985-05-25 |ABT978167  |2025-01-10|4090056998504240|684    |