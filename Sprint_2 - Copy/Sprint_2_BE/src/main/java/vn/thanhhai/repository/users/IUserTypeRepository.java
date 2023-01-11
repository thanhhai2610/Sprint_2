package vn.thanhhai.repository.users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.thanhhai.model.users.UserType;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IUserTypeRepository extends JpaRepository<UserType, Integer> {

    @Modifying
    @Transactional
    @Query(value = "SELECT * FROM user_type ", nativeQuery = true)
    List<UserType> myFindAll();

}
