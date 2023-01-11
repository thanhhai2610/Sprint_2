package vn.thanhhai.service.users;

import vn.thanhhai.model.users.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> listUser();

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    User save(User user);
}
