package vn.thanhhai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.thanhhai.model.users.User;

//public interface IUserRepository extends JpaRepository<User, Integer> {
//
//    @Query(
//            value = " select * from user where email = :email ", nativeQuery = true
//    )
//    User getUserByEmail(@Param("email") String email);
//
//    boolean existsByEmail(String email);
//
//}