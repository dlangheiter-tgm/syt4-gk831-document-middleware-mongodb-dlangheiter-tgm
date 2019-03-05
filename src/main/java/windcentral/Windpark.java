package windcentral;

import org.springframework.data.annotation.Id;

import java.text.SimpleDateFormat;
import java.util.*;

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
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSSXXX");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.windengines.get(wed.getWindengineID()).put(sdf.format(wed.getTimestamp()), wed);
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
