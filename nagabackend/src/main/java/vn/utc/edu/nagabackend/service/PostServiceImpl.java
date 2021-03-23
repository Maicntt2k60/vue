package vn.utc.edu.nagabackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.utc.edu.nagabackend.common.PostEntityToDTO;
import vn.utc.edu.nagabackend.dto.PostDTO;
import vn.utc.edu.nagabackend.entity.PostEntity;
import vn.utc.edu.nagabackend.repository.PostRepository;


@Service("postServiceImpl")
public class PostServiceImpl {
    @Autowired
    private PostRepository repository;

    public String insertData(PostDTO dto) {
        PostEntity entity = PostEntityToDTO.entityToDTO(dto);
        repository.save(entity);
        return entity.getID();
    }

    public void updateData(String id) {

    }

    public void deleteData(String id) {

    }

    public PostEntity getData(String id) {
        return repository.findById(id).get();

    }
}
