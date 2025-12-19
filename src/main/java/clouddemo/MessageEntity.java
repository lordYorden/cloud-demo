package clouddemo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "messages")
public class MessageEntity {

    @Id private String id;
    private String message;
    private Date createdAt;

    public MessageEntity() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "MessageBoundary{" +
                "id:'" + id + '\'' +
                ", message:'" + message + '\'' +
                ", date:" + createdAt +
                '}';
    }
}
