package pl.tomaszosuch.redditclone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.time.Instant;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long postId;
    @NotBlank(message = "Post name cannot be empty")
    private String postName;
    private String url;
    private String description;
    private Integer voteCount;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userid")
    private User user;
    private Instant createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "subredditId", referencedColumnName = "subredditId")
    private Subreddit subreddit;

    public Post(Long postId, String postName, String url, String description, Integer voteCount) {
        this.postId = postId;
        this.postName = postName;
        this.url = url;
        this.description = description;
        this.voteCount = voteCount;
    }
}
