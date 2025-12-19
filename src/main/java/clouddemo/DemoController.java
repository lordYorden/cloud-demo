package clouddemo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
class DemoController {

    private final DemoService demoService;



    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping
    String hello(){
        return "hello world";
    }

    @GetMapping(
        path = {"/messages"},
        produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public MessageBoundary[] getMessages(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return demoService.getMessages(page, size).toArray(new MessageBoundary[0]);
    }

    @GetMapping(
            path = {"/messages/{id}"},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public MessageBoundary getSpecificMessage(@PathVariable String id) {
        return demoService.getSpecificMessage(id);
    }

    @PutMapping(
            path = {"/messages/{id}"},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void updateMessage(@PathVariable String id, @RequestBody MessageBoundary update) {
        demoService.updateMessage(id, update);
    }

    @PostMapping(
            path = {"/messages"},
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public MessageBoundary createMessage(@RequestBody MessageBoundary msg) {
        return demoService.createMessage(msg);
    }

    @DeleteMapping(
            path = {"/messages"}
    )
    public void deleteMessage() {
        demoService.deleteMessages();
    }
}
