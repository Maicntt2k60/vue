package vn.utc.edu.nagabackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import vn.utc.edu.nagabackend.entity.SubjectEntity;

@Component
public interface SubjectRepository extends MongoRepository<SubjectEntity, String> {
}
