package me.whiteship.commonweb.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleStartingWith(String title);

    @Query("select p from Post as p where p.title = :title")
    List<Post> findByTitle(@Param("title") String keyword, Sort sort);
}
