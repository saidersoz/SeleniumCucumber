@GoogleSearch
Feature: US002_Google_Search

  Background: kullanici_Google_Anasayfaya_gider
    Given kullanici_Google_Anasayfaya_gider

  Scenario:TC01_Java_Search
    When kullanici Googleda "Java" aratir
    Then title'in "Java" icerdigini dogrula
    And sayfayi_kapatir

  Scenario:TC02_Sql_Search
    When kullanici Googleda "Sql" aratir
    Then title'in "Sql" icerdigini dogrula
    And sayfayi_kapatir

  Scenario:TC02_Galatasaray_Search
    When kullanici Googleda "Galatasaray" aratir
    Then title'in "Galatasaray" icerdigini dogrula
    And sayfayi_kapatir