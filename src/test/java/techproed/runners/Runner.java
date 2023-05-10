package techproed.runners;

/*
Runner class; testNG deki .xml file larda belirttiğimiz class'ları,packageları veya methodları nasıl
çalıştırıyorsak, Cucumber frameworkundede Runner class'ındaki tags parametresi ile belirttiğimiz
senaryoyu çalıştırabiliriz
 */
//Cucumber ile JUnit'in entegre olmasını sağlayan test çalıştırıcı notasyonudur

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//Seneryoların nerede ve nasıl çalışacağı, hangi raporu kullanacağıyla alakalı seçenekleri ayarlarız
@CucumberOptions(features = "src/test/resources/features/day30_ilkFeature",
        glue = {"techproed/stepDefinitions"},//Bu parametre ile kodlarımızı yazdığımız stepDefinition
        //class'ının packege'ını belirtiriz
        tags = "@gr1 and @sql"  )
/*
features ===> features'ların olduğu packega'ın yolunu ver(ContentRoot)
glue ====> stepDefinition'ların olduğu packega'ın yolunu ver(Source Root)
tags ====> çalıştırmak istediğin grubu yaz
 */


public class Runner {
}
