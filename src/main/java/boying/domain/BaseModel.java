package boying.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.http.annotation.ThreadSafe;

import java.sql.Timestamp;

/**
 * Created by boying on 2017/7/5.
 */
@Data
@ToString
@EqualsAndHashCode
public class BaseModel {
    private long id;
    private int isDelete;
    private Timestamp updatedAt;
    private Timestamp createdAt;

    public boolean isDeleted(){
        return this.isDelete != 0;
    }
}
