package vn.thanhhai.repository.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.thanhhai.model.users.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * @param detailAddress,town,district,city,country
     * Function: to create address
     * @return Address
     */
    @Modifying
    @Query(value = "insert into " +
            "address(detail_address," +
            "town," +
            "district," +
            "city," +
            "country" +
            " values(:detailAddress," +
                    ":town," +
                    ":district," +
                    ":city," +
                    ":country)",
            nativeQuery = true)
    Address createAddress(@Param("detailAddress") String detailAddress,
                          @Param("town") String town,
                          @Param("district") String district,
                          @Param("city") String city,
                          @Param("country") String country);

    /**
     * Create by: TruongLH
     * Date created: 13/12/2022
     * @param detailAddress,town,district,city,country
     * Function: to update address
     * @return Address
     */
    @Modifying
    @Query(value = " update `address` " +
                    "set `detail_address` = :detailAddress, " +
                       " `town` = :town,"+
                       " `district` = :district,"+
                       " `city` = :city,"+
                       " `country` = :country",
            nativeQuery = true)
    Address updateAddress(@Param("detailAddress") String detailAddress,
                          @Param("town") String town,
                          @Param("district") String district,
                          @Param("city") String city,
                          @Param("country") String country);

}
