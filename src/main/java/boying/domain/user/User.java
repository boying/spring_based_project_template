package boying.domain.user;

import boying.domain.BaseModel;
import lombok.Data;

/**
 * Created by boying on 2017/7/4.
 */
@Data
public class User extends BaseModel{
    private long id;
    private String name;
    private String password;
    private String phone_number;
}
