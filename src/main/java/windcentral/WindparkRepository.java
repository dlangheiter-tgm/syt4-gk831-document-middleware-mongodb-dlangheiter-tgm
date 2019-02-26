package windcentral;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface WindparkRepository extends MongoRepository<Windpark, String> {

    public Windpark findByOwnId(int ownId);

}
