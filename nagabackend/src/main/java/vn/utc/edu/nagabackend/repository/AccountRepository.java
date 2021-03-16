package vn.utc.edu.nagabackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import vn.utc.edu.nagabackend.entity.AccountEntity;

import java.util.Optional;
@Component
public interface AccountRepository  extends MongoRepository<AccountEntity, String> {
    Optional<AccountEntity> findById(String id);
}
