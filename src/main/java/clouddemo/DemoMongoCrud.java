package clouddemo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DemoMongoCrud extends MongoRepository<MessageEntity, String> {

    public List<MessageEntity> findAllByIdNotNull(Pageable pageable);
}
