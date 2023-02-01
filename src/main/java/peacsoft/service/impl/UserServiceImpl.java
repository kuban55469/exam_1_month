package peacsoft.service.impl;

import peacsoft.entity.User;
import peacsoft.repositories.UserRepositories;
import peacsoft.repositories.impl.UserImpl;
import peacsoft.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepositories userRepositories = new UserImpl();
    @Override
    public String saveUser(User user) {
        return userRepositories.saveUser(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepositories.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositories.getAllUsers();
    }

    @Override
    public String updateUser(Long userId, User user) {
        return userRepositories.updateUser(userId,user);
    }

    @Override
    public String deleteUserById(Long userId) {
        return userRepositories.deleteUserById(userId);
    }

    @Override
    public boolean existByEmail(String email) {
        return userRepositories.existByEmail(email);
    }
}
