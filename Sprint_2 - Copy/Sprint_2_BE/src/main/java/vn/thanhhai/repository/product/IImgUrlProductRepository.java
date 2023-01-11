package vn.thanhhai.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.thanhhai.model.product.ImgUrlProduct;

import java.util.List;

@Repository
@Transactional
public interface IImgUrlProductRepository extends JpaRepository<ImgUrlProduct, Integer> {

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     *
     * @return List<ImgUrlProduct>
     * @pathVariable: ID
     * Function: find image of product by ID
     */

    @Query(value = "SELECT * FROM img_url_product WHERE product_id=:id", nativeQuery = true)
    List<ImgUrlProduct> findImgByProductId(@Param("id") int id);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     *
     * @return ImgUrlProduct
     * @pathVariable: ID
     * Function: find image by ID
     */
    @Query(value = "SELECT img.* FROM img_url_product img where img.id=:id ", nativeQuery = true)
    ImgUrlProduct findImageById(int id);

    /**
     * Created by: SonPT
     * Date created: 13-12-2022
     *
     * @param: url, ID
     * Function: create Image of Product
     */
    @Modifying
    @Query(value = "INSERT INTO img_url_product (url,watch_id) VALUES (:url, :watch_id)", nativeQuery = true)
    void createImgProduct(@Param("url") String url,
                          @Param("watch_id") int id);

    /**
     * Created by: GiangLBH
     * Date created: 19-12-2022
     * Function: get img by product id
     *
     * @return imgs list
     * @param: id
     */
    @Query(value = "SELECT * FROM img_url_product where img_url_product.product_id =:id ", nativeQuery = true)
    List<ImgUrlProduct> getImgs(@Param("id") Integer id);

}
