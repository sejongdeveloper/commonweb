package me.whiteship.commonweb.post;

import org.springframework.data.jpa.domain.Specification;

public class CommentSpecs {
    public static Specification<Comment> isBest() {
        return (root, query, builder) -> builder.isTrue(root.get(Comment_.best));
    }

    public static Specification<Comment> isGood() {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Comment_.up), 10);
    }
}
