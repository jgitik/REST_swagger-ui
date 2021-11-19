package rest.repository;


import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import rest.entity.UserEntity;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository {

    HashMap<String, UserEntity> database = new HashMap<>();

    @PostConstruct
    public void onInit() {
        database.put("user@email.com", new UserEntity("user@email.com", "qwerty", "John Smith", 30));
        database.put("user1@email.com", new UserEntity("user1@email.com", "qwerty", "Vasya Pupkin", 20));
    }


    public ArrayList<UserEntity> getAllEntity() {
        return new ArrayList<>(database.values());

    }

    public Optional<UserEntity> findUserByEmail(String email) {

        return Optional.ofNullable(database.get(email));
    }

    public UserEntity createEntity(UserEntity newUser) {
        database.put(newUser.getEmail(), newUser);
        return database.get(newUser.getEmail());
    }

}
