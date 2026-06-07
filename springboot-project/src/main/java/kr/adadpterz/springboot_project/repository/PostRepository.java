package kr.adadpterz.springboot_project.repository;

import kr.adadpterz.springboot_project.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepository {

    private static final Map<Long, Post> database = new HashMap<>();

    // TODO: sequence 조사
    private static Long sequence = 0L;

    public Post save(Post post) {
        if (post.getPostId() == null) {
            sequence++;
            post.setPostId(sequence);
        }

        database.put(post.getPostId(), post);
        return post;
    }

    public Optional<Post> findById(Long postId) {
        return Optional.ofNullable(database.get(postId));
    }

    public List<Post> findAll() {
        return new ArrayList<>(database.values());
    }

    public Optional<Post> deletePost(Long postId) {
        return Optional.ofNullable(database.remove(postId));
    }
}