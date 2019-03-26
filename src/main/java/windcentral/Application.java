package windcentral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private WindparkRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Windpark> parkSave = repository.findAll();
        for(Windpark wp : parkSave) {
            wp.resetWindengines();
        }

        repository.deleteAll();

        repository.saveAll(parkSave);

        /*Windpark p = new Windpark();
        p.jsonDataUrl = "http://localhost:8080/windengine/data/json";
        repository.save(p);*/


        while(true) {
            List<Windpark> parks = repository.findAll();
            for (Windpark park : parks) {
                System.out.println("Request: " + park.jsonDataUrl);
                try {
                    RestTemplate restTemplate = new RestTemplate();
                    WindengineDataRest dataList = restTemplate.getForObject(park.jsonDataUrl, WindengineDataRest.class);
                    for (WindengineData data : dataList.getWindengine()) {
                        park.addWindengineData(data);
                    }
                    repository.save(park);
                } catch (Exception e) {
                    System.out.println("Error occurred while requesting '" + park.jsonDataUrl + "': " + e.getMessage());
                    //e.printStackTrace();
                }
            }
            System.out.println("Waiting 5 seconds");
            Thread.sleep(5000);
        }

    }

}