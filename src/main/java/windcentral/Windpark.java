package windcentral;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Windpark {

    @Id
    public String id;

    public int ownId;
    public Map<Integer, List<WindengineData>> windengines;

    public Windpark() {
        this.windengines = new HashMap<>();
    };

    public Windpark(int ownId) {
        this();
        this.ownId = ownId;
    }

    public void addWindengine(Integer id) {
        this.windengines.put(id, new ArrayList<>());
    }

    public void addWindengineData(int windengineId, WindengineData wed) {
        this.windengines.get(windengineId).add(wed);
    }

    @Override
    public String toString() {
        return "Windpark{" +
                "id='" + id + '\'' +
                ", ownId=" + ownId +
                ", windParkList=" + windengines +
                '}';
    }
}
