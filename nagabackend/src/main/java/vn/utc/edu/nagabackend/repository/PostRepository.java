package vn.utc.edu.nagabackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import vn.utc.edu.nagabackend.entity.PostEntity;

@Component
public interface PostRepository extends MongoRepository<PostEntity, String> {
}
