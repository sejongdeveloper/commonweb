package me.whiteship.commonweb.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void crud() {
        Post savedPost = savePost("jpa");

        savedPost.setTitle("whiteship");

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitleStartingWith() {
        savePost("Spring Data Jpa");

        List<Post> all = postRepository.findByTitleStartingWith("Spring");
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void findByTitle() {
        savePost("Spring");
        List<Post> all = postRepository.findByTitle("Spring", Sort.by("title"));
        assertThat(all.size()).isEqualTo(1);
    }

    private Post savePost(String title) {
        Post post = new Post();
        post.setTitle(title);
        return postRepository.save(post);//persist
    }

}