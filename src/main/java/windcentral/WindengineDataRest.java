package windcentral;

import java.util.ArrayList;
import java.util.List;

public class WindengineDataRest {

    private List<WindengineData> windengine;

    public WindengineDataRest() {
        this.windengine = new ArrayList<>();
    }

    public WindengineDataRest(List<WindengineData> windengine) {
        this.windengine = windengine;
    }

    public List<WindengineData> getWindengine() {
        return windengine;
    }

    public void setWindengine(List<WindengineData> windengine) {
        this.windengine = windengine;
    }

    @Override
    public String toString() {
        return "WindengineDataRest{" +
                "windengine=" + windengine +
                '}';
    }
}
