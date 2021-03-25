package vn.utc.edu.nagabackend.common;

import vn.utc.edu.nagabackend.dto.SubjectDTO;
import vn.utc.edu.nagabackend.entity.SubjectEntity;

public class SubjectEntityToDTO {
    public static SubjectDTO entityToDTO(SubjectEntity entity) {
        SubjectDTO dto = new SubjectDTO();
        if (entity.getID() != null) {
            dto.setID(entity.getID());
        }
        dto.setContent(entity.getContent());
        dto.setColor(entity.getColor());
        dto.setTag(entity.getTag());
        return dto;
    }
}
