package pl.tomaszosuch.redditclone.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.tomaszosuch.redditclone.model.Post;
import pl.tomaszosuch.redditclone.model.Subreddit;
import pl.tomaszosuch.redditclone.model.User;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubredditRepository subredditRepository;

    @Test
    public void testFindAll() {
        //given
        Post post = new Post(1L, "postName", "url", "description", 1);
        postRepository.save(post);
        User user = new User(1L, "username", "password", "email", Instant.now(), true);
        userRepository.save(user);
        Subreddit subreddit = new Subreddit(1L, "name", "description", List.of(post), Instant.now(), user);
        subredditRepository.save(subreddit);
        //when
        List<Post> resultFindAll = postRepository.findAll();
        //then
        assertEquals(1, resultFindAll.size());
        //clean up
        postRepository.deleteAll();
    }


}
