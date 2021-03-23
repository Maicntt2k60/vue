package vn.utc.edu.nagabackend.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private String ID;
    private String userCreate;
    private Integer action;
    private String postId;
    private String content;
}
