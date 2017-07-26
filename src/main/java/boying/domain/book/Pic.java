package boying.domain.book;

import boying.domain.BaseModel;

/**
 * Created by boying on 2017/7/4.
 */
public class Pic extends BaseModel{
    private String name;

    @Override
    public String toString() {
        return "Pic{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
