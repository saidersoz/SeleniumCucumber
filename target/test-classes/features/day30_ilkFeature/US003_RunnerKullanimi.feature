@All
Feature: US003_TechProEducation_Testi

  @gr3
  Scenario: TC01_TechProEducation_Sayfasi_Testi
    Given kullanici_techpro_sayfasina_gider
    And arama_kutusunda_qa_aratir
    And sayfa_basliginin_qa_icerdigini_test_eder
    And sayfayi_kapatir

    @gr2
  Scenario: TC02_Amazon_Sayfasinda_Java_Aratma
    Given kullanici_amazon_sayfasina_gider
    And arama_kutusunda_Java_aratir
    And sayfayi_kapatir

    @gr1 @sql
  Scenario: TC03_Amazon_Sayfasinda_SQL_Aratma
    Given kullanici_amazon_sayfasina_gider
    And arama_kutusunda_sql_aratir
    And sayfayi_kapatir