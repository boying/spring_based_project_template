package boying.domain.book;

import boying.domain.enums.BoolType;
import java.util.Date;

public class Pic {
    private Long id;

    private String name;

    private String phoneNumber;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
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