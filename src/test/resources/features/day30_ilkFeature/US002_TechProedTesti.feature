Feature: US002_TechProEducation_Testi

  Scenario: TC01_TechProEducation_Sayfasi_Testi
    Given kullanici_techpro_sayfasina_gider
    And arama_kutusunda_qa_aratir
    And sayfa_basliginin_qa_icerdigini_test_eder
    And sayfayi_kapatir

  Scenario: TC02_Amazon_Sayfasinda_Java_Aratma
    Given kullanici_amazon_sayfasina_gider
    And arama_kutusunda_Java_aratir
    And sayfayi_kapatir

  Scenario: TC03_mazon_Sayfasinda_SQL_Aratma
    Given kullanici_amazon_sayfasina_gider
    And arama_kutusunda_sql_aratir
    And sayfayi_kapatir