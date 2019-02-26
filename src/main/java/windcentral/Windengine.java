package windcentral;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Windengine {

    @Id
    public String id;
    public List<WindengineData> dataList;

    public Windengine() {
        this.dataList = new ArrayList<>();
    }

    public void addData(WindengineData wed) {
        this.dataList.add(wed);
    }

    @Override
    public String toString() {
        return "Windengine{" +
                "id='" + id + '\'' +
                ", dataList=" + dataList +
                '}';
    }
}
