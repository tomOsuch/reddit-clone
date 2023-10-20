package pl.tomaszosuch.redditclone.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszosuch.redditclone.model.User;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindAll() {
        //given
        User user = new User(1L, "username", "password", "email", Instant.now(), true);
        userRepository.save(user);
        //when
        List<User> resultFindAll = userRepository.findAll();
        //then
        assertEquals(1, resultFindAll.size());
        //clean up
        userRepository.deleteAll();
    }

    @Test
    public void testFindUserById() {
        //given
        User user = new User(1L, "username", "password", "email", Instant.now(), true);
        userRepository.save(user);
        Long userId = user.getUserid();
        //when
        User resultFindUserById = userRepository.findById(userId).orElseThrow();
        //then

    }

    @Test
    public void testFindByUsername() {
        //given
        User user = new User(1L, "username", "password", "email", Instant.now(), true);
        userRepository.save(user);
        //when
        User resultFindByUsername = userRepository.findByUsername(user.getUsername()).orElseThrow();
        //then
        assertEquals(user.getUsername(), resultFindByUsername.getUsername());
        //Clean up
        userRepository.deleteAll();
    }
}
