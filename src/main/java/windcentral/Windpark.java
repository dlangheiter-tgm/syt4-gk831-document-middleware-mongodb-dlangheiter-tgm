package windcentral;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Windpark {

    @Id
    public String id;

    public String jsonDataUrl;

    public int ownId;
    public Map<Integer, Map<String, WindengineData>> windengines;

    public Windpark() {
        this.windengines = new HashMap<>();
    };

    public Windpark(int ownId) {
        this();
        this.ownId = ownId;
    }

    public void addWindengine(Integer id) {
        this.windengines.put(id, new HashMap<>());
    }

    public void addWindengineData(WindengineData wed) {
        if(!this.windengines.containsKey(wed.getWindengineID())) {
            this.addWindengine(wed.getWindengineID());
        }
        this.windengines.get(wed.getWindengineID()).put(wed.getTimestamp().replace('.', ':'), wed);
    }

    @Override
    public String toString() {
        return "Windpark{" +
                "id='" + id + '\'' +
                ", jsonDataUrl='" + jsonDataUrl + '\'' +
                ", ownId=" + ownId +
                ", windengines=" + windengines +
                '}';
    }
}
