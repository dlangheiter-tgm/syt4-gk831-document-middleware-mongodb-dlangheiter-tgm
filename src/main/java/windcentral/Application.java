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

        WindengineSimulation wes = new WindengineSimulation();

        Windpark wl = new Windpark(1);

        for(int i = 0; i < 2; i++) {
            /*Windengine we = new Windengine();
            we.addData(wes.getData(i));
            we.addData(wes.getData(i));
            we.addData(wes.getData(i));*/

            wl.addWindengine(i);
            wl.addWindengineData(i, wes.getData(i));
            wl.addWindengineData(i, wes.getData(i));
        }

        repository.save(wl);

        for(Windpark wp : repository.findAll()) {
            System.out.println(wp);
        }
        System.out.println();

    }

}