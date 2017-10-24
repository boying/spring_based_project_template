package boying.domain.book;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Video {
    private long id;
    private String name;
    private String publisherName;
    private VideoType type;
    private StateCode stateCode;
    private Timestamp updatedAt;
    private Timestamp createdAt;
}

