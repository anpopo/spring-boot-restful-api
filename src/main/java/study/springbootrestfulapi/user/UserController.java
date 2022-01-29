package study.springbootrestfulapi.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    private final UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable(name = "id") int id) {
        User findUser = service.findOne(id);

        if (Objects.isNull(findUser)) throw new UserNotFoundException(String.format("ID[%s] not found", id));
        return findUser;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public User deleteUser(@PathVariable(name = "id") int id) {
        User user = service.deleteById(id);

        if (Objects.isNull(user)) throw new UserNotFoundException(String.format("ID[%s] not found", id));
        return user;
    }

    @PutMapping("/users")
    public User updateUser(@Valid @RequestBody User  user) {
        User updateUser = service.updateUser(user);
        if (Objects.isNull(updateUser)) throw new UserNotFoundException(String.format("ID[%s] not found", user.getId()));
        return updateUser;
    }


}
