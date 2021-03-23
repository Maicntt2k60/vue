package vn.utc.edu.nagabackend.entity;

import com.mongodb.lang.Nullable;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.ElementCollection;
import java.util.Date;
import java.util.List;

@Data
public class CommentEntity {
    public CommentEntity() {
    }

    @Field(name = "comment_id")
    private String commentID;
    @Field(name = "date_create")
    private Date dateCreate;
    @Field(name = "status")
    private Integer status;
    @Field("user_own")
    private String userOwn;
    @Field("content_comment")
    @ElementCollection
    private List<ContentCommentEntity> commentEntityList;

    @Data
    public class ContentCommentEntity {
        public ContentCommentEntity() {
        }

        @Field("date_create")
        private Date dateCreate;
        @Field("create_by")
        private String createBy;
        @Nullable
        @Field("content")
        private String content;
        @Field("action")
        private Integer action;
    }
}
