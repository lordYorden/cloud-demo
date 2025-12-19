package clouddemo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DemoService {
    public List<MessageBoundary> getMessages(int page, int size);
    public MessageBoundary getSpecificMessage(String id);
    public void updateMessage(String id, MessageBoundary update);
    public MessageBoundary createMessage(MessageBoundary msg);
    public void deleteMessages();
}
