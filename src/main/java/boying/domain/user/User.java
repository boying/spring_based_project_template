package boying.domain.user;

import boying.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by boying on 2017/7/4.
 */
@Data
@ToString
@EqualsAndHashCode
public class User extends BaseModel{
    private long id;
    private String name;
    private String password;
}
