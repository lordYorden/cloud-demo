package clouddemo;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class MessageBoundary {

    private String id;
    private String message;
    private ZonedDateTime createdAt;

    public MessageBoundary() {
    }

    public MessageBoundary(MessageEntity entity) {
        this.setId(entity.getId());
        this.setMessage(entity.getMessage());
        this.setCreatedAt(
                ZonedDateTime.ofInstant(
                        entity.getCreatedAt().toInstant(),
                        ZoneId.systemDefault()
                )
        );
    }

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

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public MessageEntity toEntity() {
        MessageEntity rv = new MessageEntity();

        rv.setId(this.getId());
        rv.setMessage(this.getMessage());
        rv.setCreatedAt(
                Date.from(
                        this.getCreatedAt()
                                .toInstant()));

        return rv;
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
