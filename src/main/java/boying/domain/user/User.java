package boying.domain.user;

import boying.domain.BaseModel;

/**
 * Created by boying on 2017/7/4.
 */
public class User extends BaseModel{
    private long id;
    private String name;
    private String password;
    private String phone_number;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
