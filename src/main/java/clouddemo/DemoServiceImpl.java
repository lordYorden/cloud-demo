package clouddemo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class DemoServiceImpl implements DemoService{

    private final DemoMongoCrud crud;

    public DemoServiceImpl(DemoMongoCrud crud) {
        this.crud = crud;
    }

    @Override
    public List<MessageBoundary> getMessages(int page, int size) {
        return crud.findAllByIdNotNull(PageRequest.of(page, size, Sort.Direction.DESC, "createdAt", "id"))
                .stream()
                .map(MessageBoundary::new)
                .toList();
    }

    @Override
    public MessageBoundary getSpecificMessage(String id) {
        return crud.findById(id)
                .map(MessageBoundary::new)
                .orElseThrow(MessageNotFoundException::new);
    }

    @Override
    public void updateMessage(String id, MessageBoundary update) {
        MessageEntity entity = crud.findById(id)
                .orElseThrow(MessageNotFoundException::new);

        if(!Objects.equals(update.getMessage(), entity.getMessage())) {
            entity.setMessage(update.getMessage());
            crud.save(entity);
        }
    }

    @Override
    public MessageBoundary createMessage(MessageBoundary msg) {
        msg.setId(null);
        msg.setCreatedAt(ZonedDateTime.now());
        MessageEntity entity = msg.toEntity();

        entity = crud.save(entity);
        return new MessageBoundary(entity);
    }

    @Override
    public void deleteMessages() {
        crud.deleteAll();
    }
}
