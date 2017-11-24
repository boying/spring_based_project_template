package boying.domain.book;

import boying.domain.BaseModel;
import lombok.Data;
import lombok.ToString;

/**
 * Created by boying on 2017/7/4.
 */
@Data
@ToString(callSuper = true)
public class Pic extends BaseModel{
    private String name;
}
