package peacsoft.repositories;

import peacsoft.entity.Post;
import peacsoft.entity.User;

import java.util.List;

public interface UserRepositories {
    String saveUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();

    String updateUser(Long userId, User user);

    String deleteUserById(Long userId);

    boolean existByEmail(String email);
}
