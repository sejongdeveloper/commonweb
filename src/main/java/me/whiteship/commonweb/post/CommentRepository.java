package me.whiteship.commonweb.post;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @EntityGraph(attributePaths = "post")
    Optional<Comment> getById(Long id);

    List<Comment> findByPost_Id(Long id);
}
