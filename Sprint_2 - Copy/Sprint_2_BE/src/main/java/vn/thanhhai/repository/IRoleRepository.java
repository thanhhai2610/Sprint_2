package vn.thanhhai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.thanhhai.model.account.Role;

import java.util.List;

public interface IRoleRepository extends JpaRepository<Role, Integer> {


    @Query(
            value = " select role.id, role.name from role " +
                    " join account_role on role.id = account_role.role_id " +
                    " where account_id = :accountId ", nativeQuery = true
    )
    List<Role> getListRoleByAccountId(@Param("accountId") Integer accountId);

}