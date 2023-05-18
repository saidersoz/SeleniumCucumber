@DataTableTest
Feature: Data Table Test

  Scenario: Google Search
    Given kullanici_Google_Anasayfaya_gider
    When kullanici verilen bilgileri aratir
      | Bilgiler |
      | Java     |
      | SQL      |
      | Lambda   |
      | Python   |
    Then sayfayi_kapatir

@BlueRentalCarDataTableTest
  Scenario: BlueRentalCar Login
    Given kullanici blue rental car sayfasina gider
    When  login olur
      | emailadress                   | password  |
      | jack@gmail.com                | 12345     |
      | sam.walker@bluerentalcars.com | c!fas_art |
    Then sayfayi_kapatir

  @BlueRentalCarDataTableMap
  Scenario: BlueRentalCar Login Map
    Given kullanici blue rental car sayfasina gider
    When login olur map
      | emailadress                   | password  |
      | jack@gmail.com                | 12345     |
      | sam.walker@bluerentalcars.com | c!fas_art |
    Then sayfayi_kapatir

