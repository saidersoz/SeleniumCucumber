@GoogleSearchScenarioOutline
Feature: Google Search

  Background:
    Given kullanici_Google_Anasayfaya_gider

  Scenario Outline: Google_aramalari
    When kullanici Googleda "<Aranacak_Kelime>" aratir
    Then title'in "<Aranacak_Kelime>" icerdigini dogrula
    And sayfayi_kapatir
    Examples:
      | Aranacak_Kelime |
      | Java            |
      | Selenium        |
      | JDBC            |
      | Sql             |
      | Lambda          |

