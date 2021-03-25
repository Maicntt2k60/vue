package vn.utc.edu.nagabackend.entity;

import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.ElementCollection;
import java.util.Date;
import java.util.List;

@Document("post")
@Data
public class PostEntity {
    @Id
    private String ID;
    @Field(name = "date_create")
    private Date dateCreate;
    @Field(name = "status")
    private Integer status;
    @Field(name = "user_own")
    @NonNull
    private String userOwn;
    @Field(name = "subject")
    private String subjectId;
    @Field("title")
    @NonNull
    private String title;
    @Field("comment")
    @Nullable
    @ElementCollection
    List<CommentEntity> commentEntityList;
    @Field("hash_tag")
    @Nullable
    @ElementCollection
    List<String> hashTag;
    @Field("content_post")
    @ElementCollection
    List<ContentPostEntity> contentPostEntityList;

    @Data
    public static class ContentPostEntity {
        @Field(name = "create_by")
        private String createBy;
        @Field(name = "date_create")
        private Date dateCreate;
        @Field("content")
        private String content;
        @Field(name = "action")
        private Integer action;

        public ContentPostEntity() {

        }
    }

    public PostEntity() {

    }

}
