Feature: Rejestracja użytkownika na stronie CodersGuru

  Scenario Outline: Poprawna rejestracja użytkownika
    Given Otwarta przegladarka na stronie https://tester.codersguru.pl/
    When Przyciskam przycisk załuz konto
    Then Otwiera sie okno z formularzem rejestracji
    When Rejestruje uzytkownika danymi "<E-mail>" "<Imie>" "<Nazwisko>" "<Haslo>" "<PowtorzHaslo>" "<Miasto>" "<KodPocztowy>" "<Ulica>" "<NumerDomu/Lokalu>"
    And Naciskam przycisk akceptacji regulaminu
    And Naciskam przycisk rejestracji
    Then Uzytkownik zostaje zarejestrowany na stronie
    And Użytkownik zostaje przeniesiony na strone glowna CodersGuru

    Examples:
      |E-mail               |Imie    |Nazwisko|Haslo   |PowtorzHaslo|Miasto  |KodPocztowy|Ulica     |NumerDomu/Lokalu|
      |Jan@kowalski.com     |Jan     |Kowalski|1q2w3e4r|1q2w3e4r    |Warszawa|80-022     |Gdańska   |15              |
      |Pawel@nowak.com      |Paweł   |Nowak   |1q2w3e4r|1q2w3e4r    |Gdańsk  |00-018     |Warszawska|51              |
