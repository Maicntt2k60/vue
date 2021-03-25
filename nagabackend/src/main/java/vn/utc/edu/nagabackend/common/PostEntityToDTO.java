package vn.utc.edu.nagabackend.common;

import vn.utc.edu.nagabackend.dto.PostDTO;
import vn.utc.edu.nagabackend.entity.PostEntity;
import vn.utc.edu.nagabackend.entity.SubjectEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostEntityToDTO {
    public static PostEntity entityToDTO(PostDTO dto) {
        PostEntity entity = new PostEntity();
        if (dto.getAction() == 1) {
            entity.setID(null);
            entity.setDateCreate(new Date());
            entity.setStatus(0);
            entity.setHashTag(dto.getHashTag());
            entity.setSubjectId(dto.getSubject());
            entity.setUserOwn(dto.getUserCreate());
            if (dto.getTitle() != null) {
                entity.setTitle(dto.getTitle());
            }
            PostEntity.ContentPostEntity contentPostEntity = new PostEntity.ContentPostEntity();
            contentPostEntity.setAction(dto.getAction());
            contentPostEntity.setCreateBy(dto.getUserCreate());
            contentPostEntity.setContent(dto.getContent());
            contentPostEntity.setDateCreate(new Date());
            List<PostEntity.ContentPostEntity> contentPostEntityList = new ArrayList<>();
            contentPostEntityList.add(contentPostEntity);
            entity.setContentPostEntityList(contentPostEntityList);
            return entity;
        }
        return entity;
    }

    public static PostDTO shortPostEntityToDTO(PostEntity entity, SubjectEntity subjectEntity) {
        PostDTO dto = new PostDTO();
        dto.setID(entity.getID());
        dto.setTitle(entity.getTitle());
        dto.setSubjectDTO(SubjectEntityToDTO.entityToDTO(subjectEntity));
        dto.setHashTag(entity.getHashTag());
        return dto;

    }
}
