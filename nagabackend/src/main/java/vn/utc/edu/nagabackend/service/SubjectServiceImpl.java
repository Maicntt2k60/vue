package vn.utc.edu.nagabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.utc.edu.nagabackend.common.SubjectEntityToDTO;
import vn.utc.edu.nagabackend.dto.SubjectDTO;
import vn.utc.edu.nagabackend.entity.SubjectEntity;
import vn.utc.edu.nagabackend.repository.SubjectRepository;

@Service("subjectServiceImpl")
public class SubjectServiceImpl {
    @Autowired
    private SubjectRepository subjectRepository;

    public SubjectDTO getOneDTO(String id) {
        SubjectEntity entity = subjectRepository.findById(id).get();
        return SubjectEntityToDTO.entityToDTO(entity);
    }

    public SubjectEntity getOneEntity(String id) {
        return subjectRepository.findById(id).get();
    }
}
