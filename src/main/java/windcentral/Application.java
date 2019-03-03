package windcentral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private WindparkRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        for(int windparkId = 0; windparkId < 2; windparkId++) {
            Windpark windpark = new Windpark(windparkId);

            for (int windengineId = 0; windengineId < 2; windengineId++) {
                windpark.addWindengine(windengineId);
                WindengineSimulation windengineSimulation = new WindengineSimulation(windengineId);
                for (int i = 0; i < 100; i++) {
                    windpark.addWindengineData(windengineId, windengineSimulation.getData());
                }
            }

            repository.save(windpark);
        }

        for(Windpark wp : repository.findAll()) {
            System.out.println(wp);
        }
        System.out.println();

    }

}