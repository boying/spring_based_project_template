package boying.domain.book;

import boying.domain.enums.BoolType;
import boying.domain.enums.StateCode;
import boying.domain.enums.VideoType;
import java.util.Date;

public class Video {
    private Long id;

    private String name;

    private String publisherName;

    private StateCode stateCode;

    private VideoType type;

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

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName == null ? null : publisherName.trim();
    }

    public StateCode getStateCode() {
        return stateCode;
    }

    public void setStateCode(StateCode stateCode) {
        this.stateCode = stateCode;
    }

    public VideoType getType() {
        return type;
    }

    public void setType(VideoType type) {
        this.type = type;
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