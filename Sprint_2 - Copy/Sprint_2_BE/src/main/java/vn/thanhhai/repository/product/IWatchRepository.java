package vn.thanhhai.repository.product;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.thanhhai.dto.ProductSearchDto;
import vn.thanhhai.model.product.Watch;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IWatchRepository extends JpaRepository<Watch, Integer> {

    /**
     * Create by: HungNV
     * Date created: 14/12/2022
     * Function: create new product
     *
     * @param name, initialPrice,  id,  category,  description,  stepPrice,  startTime,  endTime, registerDay
     * @return Optional<Product>
     */
    @Modifying
    @Query(value = "insert into product (name,initial_price,user_id,category_id, description, price_step_id,start_time, end_time, register_day, auction_status_id, review_status_id) " +
            "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,1,1)", nativeQuery = true)
    void saveProduct(String name, Double initialPrice, Integer user, Integer category, String description, Integer stepPrice, String startTime, String endTime, String registerDay);


    /**
     * Create by: HungNV
     * Date created: 16/12/2022
     * Function: get last id
     *
     * @return Optional<Product>
     */
    @Query(value = "select last_insert_id()", nativeQuery = true)
    Integer getLastId();

    /**
     * Create by: HungNV
     * Date created: 14/12/2022
     * Function: update product
     *
     * @param name, initialPrice, id,  category,  description,  stepPrice,  startTime,  endTime, registerDay, productId
     * @return Optional<Product>
     */
    @Modifying
    @Query(value = "update product set name = ?1,initial_price =?2,user_id=?3,category_id=?4, description=?5, price_step_id=?6,start_time=?7, end_time=?8, register_day=?9 where id=?10 ", nativeQuery = true)
    void updateProduct(String name, Double initialPrice, Integer id, Integer category, String description, Integer stepPrice, String startTime, String endTime, String registerDay, int productId);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     *
     * @param: description, end_time, initial_price, name, register_day, start_time, category_id, price_step_id, user_id
     * Function: create Product
     */
    @Modifying
    @Query(value = "INSERT INTO product " +
            "(`description`, `end_time`, `initial_price`, `name`, `start_time`, `category_id`, `price_step_id`, `user_id`) VALUES " +
            "( :description, :end_time, :initial_price, :name, :start_time, :category_id, :price_step_id, :user_id);",
            nativeQuery = true)
    void createProduct(@Param("description") String description, @Param("end_time") String endTime,
                       @Param("initial_price") Double initialPrice, @Param("name") String name,
                       @Param("start_time") String startTime, @Param("category_id") Integer categoryId,
                       @Param("price_step_id") Integer priceStepId, @Param("user_id") Integer user_id);


    /**
     * Created by: TienBM,
     * Date created: 13/12/2022
     * Function: find product by id
     *
     * @param productId
     * @return HttpStatus.NOT_FOUND if result is not present or HttpStatus.OK if result is present
     */
    @Query(value = "select p.id,p.delete_status,p.description,p.end_time,p.initial_price,p.name,p.register_day,p.start_time,p.auction_status_id,p.category_id,p.price_step_id,p.review_status_id,p.user_id " +
            "from product p\n " +
            "where p.id = :productId and p.delete_status = 0 and p.auction_status_id < 4", nativeQuery = true)
    Optional<Watch> findProductById(@Param("productId") Integer productId);


    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to delete product by List ids
     *
     * @param idList
     */
    @Modifying
    @Query(value = "update product set delete_status = 1 where id in :idList", nativeQuery = true)
    void removeByListId(@Param("idList") List<Integer> idList);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to review product
     *
     * @param id
     */
    @Modifying
    @Query(value = "update product set review_status_id = 2 where id = :id ", nativeQuery = true)
    void reviewProduct(@Param("id") Integer id);

    /**
     * Create by: GiangLBH
     * Date created: 13/12/2022
     * Function: to don't review product
     *
     * @param id
     */
    @Modifying
    @Query(value = "update product set review_status_id = 3 where id = :id ", nativeQuery = true)
    void doNotReviewProduct(@Param("id") Integer id);


    /**
     * Created HaiNT
     * Date created 13/12/2022
     * Function: search and filter product by name, rangePrice, categoryID productAuctionStatus
     * order DESC start day
     *
     * @param productSearchDto
     * @param pageable
     * @return Page<Product>
     */
    @Query(value = "SELECT * " +
            "FROM product " +
            "WHERE product.review_status_id = 2 " +
            "    AND product.delete_status = 0 " +
            "    AND product.auction_status_id < 4 " +
            "    AND product.category_id like %:#{#productSearchDto.categoryID}%" +
            "    AND product.auction_status_id like %:#{#productSearchDto.productAuctionStatus}%" +
            "    AND product.name like %:#{#productSearchDto.name}%" +
            "    AND (product.initial_price < :#{#productSearchDto.rangePrice} " +
            "         OR product.initial_price = :#{#productSearchDto.rangePrice}) " +
            "ORDER BY product.start_time DESC",
            nativeQuery = true)
    Page<Watch> getAllAndSearch(@Param("productSearchDto") ProductSearchDto productSearchDto, Pageable pageable);

    @Query(value = "select * from product join watch on product.id = watch.product_id", nativeQuery = true)
    List<Watch> listHomeProduct();
}
