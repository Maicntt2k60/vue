package vn.utc.edu.nagabackend.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("subject")
@Data
public class SubjectEntity {
    @Id
    private String ID;
    @Field("subject_color")
    private String color;
    @Field("subject_content")
    private String content;
    @Field("subject_tag")
    private String tag;
}
