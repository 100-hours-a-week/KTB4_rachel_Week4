package kr.adadpterz.springboot_project.repository;

import kr.adadpterz.springboot_project.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private static final Map<Long, User> database = new HashMap<>();

    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(database.get(userId));
    }


    // TODO: 이메일, 닉네임 Get을 해서 중복 검사해주기(중복 검사는 service에서?)
    public Optional<User> findByEmail(String email) {
        return database.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst(); // 없으면 안전하게 Optional.empty() 반환 // 이거는 One to One이랑 가능한건데 아니라면? 어떻게 해야하지
    }


    public Optional<User> findByNickname(String nickname) {
        return database.values().stream()
                .filter(user -> user.getNickname().equals(nickname))
                .findFirst(); // 없으면 안전하게 Optional.empty() 반환
    }



    public User save(User user) {
        Long nextId = (long) (database.size() + 1);
        user.setId(nextId);
        database.put(nextId, user);
        return user;
    }

    public Optional<User> deleteUser(Long userId)
    {
        return Optional.ofNullable(database.remove(userId));
    }


}
