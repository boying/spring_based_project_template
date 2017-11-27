package boying.domain.book;

import boying.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by boying on 2017/7/4.
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode
public class Book extends BaseModel{
    private String name;
    private String isbn;
    private String phoneNumber;
}
