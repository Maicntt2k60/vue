package vn.utc.edu.nagabackend.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;

@Data
public class PostDTO {
    private String ID;
    private String userCreate;
    private Integer action;
    private String subject;
    private String title;
    //    @Nullable
    private List<String> hashTag;
    private SubjectDTO subjectDTO;
    private String content;
    private ContentPostDTO contentPostDTO;
    @Data
    public static class ContentPostDTO {
        private String createBy;
        private Date dateCreate;
        private String content;
        public ContentPostDTO() {
        }
    }
}
