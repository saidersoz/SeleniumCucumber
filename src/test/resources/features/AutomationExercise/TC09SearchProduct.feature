#1. Launch browser
#2. Navigate to url 'http://automationexercise.com'
#3. Verify that home page is visible successfully
#4. Click on 'Products' button
#5. Verify user is navigated to ALL PRODUCTS page successfully
#6. Enter product name in search input and click search button
#7. Verify 'SEARCHED PRODUCTS' is visible
#8. Verify all the products related to search are visible

# 1. Tarayıcıyı başlatın
# 2. 'http://automationexercise.com' URL'sine gidin
# 3. Ana sayfanın başarıyla göründüğünü doğrulayın
# 4. 'Ürünler' düğmesine tıklayın
# 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
# 6. Arama girişine ürün adını girin ve ara düğmesine tıklayın
# 7. "ARALAN ÜRÜNLER"in görünür olduğunu doğrulayın
# 8. Arama ile ilgili tüm ürünlerin görünür olduğunu doğrulayın

  @TC09
Feature: Search Product
  Scenario: TC09 Search Product
    Given kullanici_"AutomationExerciseUrl"_sayfasina_gider
    And ana sayfanin basariyla goruntulendigini dogrular
    And Products butonuna tiklar
    And ALL PRODUCT sayfasina yonlendirildigini dogrular
    And arama butonuna urun adini girer ve ara butonuna tiklar
    And SEARCHED PRODUCTS yazisinin goruldugunu dogrular
    And arama ile ilgili tum urunlerin gorunur oldugunu dogrulayın