package boying.domain.user;

import boying.domain.BaseModel;

/**
 * Created by boying on 2017/7/4.
 */
public class User extends BaseModel{
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
