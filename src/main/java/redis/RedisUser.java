package redis;

import java.util.List;
import java.util.Map;

//@Data
//@Getter
//@Setter
class RedisUser {

    private RedisUser user;

    public RedisUser(String kc, String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<RedisUser> list;

    private Map<String, String> map;

    public RedisUser getUser() {
        return user;
    }

    public void setUser(RedisUser user) {
        this.user = user;
    }

    public List<RedisUser> getList() {
        return list;
    }

    public void setList(List<RedisUser> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}