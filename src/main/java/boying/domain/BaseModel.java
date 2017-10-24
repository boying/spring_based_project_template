package boying.domain;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by boying on 2017/7/5.
 */
@Data
public class BaseModel {
    private long id;
    private int is_delete;
    private Timestamp updated_at;
    private Timestamp created_at;
}
