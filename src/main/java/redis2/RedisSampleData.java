package redis2;

import java.util.List;
import java.util.Map;

//@Data
//@Getter
//@Setter
class RedisSampleData {

    private RedisSampleData string;

    private List<RedisSampleData> list;

    private Map<String, String> map;

    public RedisSampleData getString() {
        return string;
    }

    public void setString(RedisSampleData string) {
        this.string = string;
    }

    public List<RedisSampleData> getList() {
        return list;
    }

    public void setList(List<RedisSampleData> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}