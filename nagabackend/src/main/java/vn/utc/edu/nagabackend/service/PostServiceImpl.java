package vn.utc.edu.nagabackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.utc.edu.nagabackend.common.PostEntityToDTO;
import vn.utc.edu.nagabackend.dto.PostDTO;
import vn.utc.edu.nagabackend.entity.PostEntity;
import vn.utc.edu.nagabackend.entity.SubjectEntity;
import vn.utc.edu.nagabackend.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;


@Service("postServiceImpl")
public class PostServiceImpl {
    @Autowired
    private PostRepository repository;
    @Autowired
    private SubjectServiceImpl service;

    public String insertData(PostDTO dto) {
        PostEntity entity = PostEntityToDTO.entityToDTO(dto);
        repository.save(entity);
        return entity.getID();
    }

    public void updateData(String id) {

    }

    public void deleteData(String id) {

    }

    public PostDTO getData(String id) {
        PostEntity entity = repository.findById(id).get();
        return PostEntityToDTO.PostEntityToDTO(entity, service.getOneEntity(entity.getSubjectId()));

    }

    public List<PostDTO> getAllByPage(Integer page) {
        Page<PostEntity> all = repository.findAll(PageRequest.of(page, 10));
        List<PostDTO> lists = new ArrayList<>();
        for (PostEntity entity : all) {
            SubjectEntity subjectEntity = service.getOneEntity(entity.getSubjectId());
            lists.add(PostEntityToDTO.shortPostEntityToDTO(entity, subjectEntity));
        }
        return lists;
    }

}
