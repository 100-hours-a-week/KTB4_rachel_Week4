package kr.adadpterz.springboot_project.repository;

import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class LikeRepository {

    // (postId, 좋아요를 누른 userId) Set -> 중복제거를 위해서
    private static final Map<Long, Set<Long>> database = new HashMap<>(); // 자료구조 선택 뭐 해야할지 몰랐음..

    public void addLike(Long postId, Long userId) {
        if (!database.containsKey(postId)) {
            Set<Long> newUserSet = new HashSet<>();
            database.put(postId, newUserSet);
        }

        Set<Long> userSet = database.get(postId);

        userSet.add(userId);
    }

    public void removeLike(Long postId, Long userId) {
        if (database.containsKey(postId)) {
            database.get(postId).remove(userId);
        }
    }

    public int getLikeCount(Long postId) {
        if (!database.containsKey(postId)) {
            return 0;
        }
        return database.get(postId).size();
    }
}