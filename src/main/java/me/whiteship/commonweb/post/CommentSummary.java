package me.whiteship.commonweb.post;

import org.springframework.beans.factory.annotation.Value;

public interface CommentSummary {
    String getComment();

    int getUp();

    int getDown();

    @Value("#{target.up + ' ' + target.down}")
    String getVotes();
}
