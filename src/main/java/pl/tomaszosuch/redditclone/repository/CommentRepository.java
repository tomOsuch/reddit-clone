package pl.tomaszosuch.redditclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tomaszosuch.redditclone.model.Comment;
import pl.tomaszosuch.redditclone.model.Post;
import pl.tomaszosuch.redditclone.model.User;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPost(Post post);

    List<Comment> findAllByUser(User user);
}
