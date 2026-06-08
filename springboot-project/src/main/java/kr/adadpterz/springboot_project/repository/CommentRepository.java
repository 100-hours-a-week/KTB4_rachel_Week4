package kr.adadpterz.springboot_project.repository;

import kr.adadpterz.springboot_project.entity.Comment;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CommentRepository {

    private static final Map<Long, List<Comment>> database = new HashMap<>();

    private static Long sequence = 0L;

    public Comment save(Long postId, Comment comment) {

        if (comment.getCommentId() == null) {
            sequence++;
            comment.setCommentId(sequence);
        }


        if (!database.containsKey(postId)) {
            List<Comment> newList = new ArrayList<>();
            database.put(postId, newList);
        }

        List<Comment> list = database.get(postId);
        list.add(comment);
        return comment;
    }

    public Optional<List<Comment>> findAll(Long postId) {
        return Optional.ofNullable(database.get(postId));
    }


    public Optional<Comment> findById(Long postId, Long commentId) {

        return Optional.ofNullable(database.get(postId))
                .stream() // 자바 9부터 Optional을 스트림으로 바꿀 수 있습니다.
                .flatMap(Collection::stream) // List<Comment>를 Comment 스트림으로 평탄화
                .filter(c -> c.getCommentId().equals(commentId))
                .findFirst(); // Optional<Comment>를 반환
    }


    public Optional<Comment> deleteComment(Long postId, Long commentId) {

        Optional<Comment> targetComment = findById(postId, commentId);


        if (targetComment.isPresent()) {
            List<Comment> comments = database.get(postId);
            comments.removeIf(c -> c.getCommentId().equals(commentId));
        }

        return targetComment; // 삭제된 댓글 객체를 반환 (없었으면 Optional.empty 반환)
    }

}