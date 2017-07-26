package boying.domain;

import java.sql.Timestamp;

/**
 * Created by boying on 2017/7/5.
 */
public class BaseModel {
    private long id;
    private int is_delete;
    private Timestamp updated_at;
    private Timestamp created_at;


    @Override
    public String toString() {
        return "BaseModel{" +
                "id=" + id +
                ", is_delete=" + is_delete +
                ", updated_at=" + updated_at +
                ", created_at=" + created_at +
                '}';
    }

    public int getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
