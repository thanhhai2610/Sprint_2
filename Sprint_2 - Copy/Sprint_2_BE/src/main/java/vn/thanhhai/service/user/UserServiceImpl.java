package vn.thanhhai.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.users.User;
//import vn.thanhhai.repository.IUserRepository;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

//    @Autowired
//    private IUserRepository userRepository;
//
//    @Override
//    public Iterable<User> findAll() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public Optional<User> findById(Integer id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public User save(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public void remove(Integer id) {
//
//    }
//
//    @Override
//    public User getUserByEmail(String email) {
//        return userRepository.getUserByEmail(email);
//    }
}