package windcentral;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface WindparkRepository extends MongoRepository<Windpark, String> {

    public Windpark findByOwnId(int ownId);

}
