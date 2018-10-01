package boying.domain.book;

import boying.domain.enums.BoolType;
import java.util.Date;

public class Book {
    private Long id;

    private String name;

    private String isbn;

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
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