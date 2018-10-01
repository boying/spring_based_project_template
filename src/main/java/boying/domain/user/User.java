package boying.domain.user;

import boying.domain.enums.BoolType;
import java.util.Date;

public class User {
    private Long id;

    private String name;

    private String password;

    private Date updatedAt;

    private Date createdAt;

    private BoolType isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BoolType getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(BoolType isDelete) {
        this.isDelete = isDelete;
    }
}