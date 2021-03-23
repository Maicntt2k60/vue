package vn.utc.edu.nagabackend.dto;

import lombok.Data;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
public class PostDTO {
    private String ID;
    private String userCreate;
    private Integer action;
    private String subject;
//    @Nullable
    private List<String> hashTag;
    private String content;
}
