package windcentral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class RestInterface {

    @Autowired
    private WindparkRepository repository;

    @RequestMapping(value = "/windpark/data/json", produces = "application/json")
    public List<Windpark> windparkJson() {
        return repository.findAll();
    }

    @RequestMapping(value = "/windpark/{windparkID}/data/json", produces = "application/json")
    public Windpark windenginesJson(@PathVariable int windparkID) {
        return repository.findByOwnId(windparkID);
    }

}
