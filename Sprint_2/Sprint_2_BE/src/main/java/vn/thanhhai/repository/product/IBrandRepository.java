package vn.thanhhai.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.thanhhai.model.product.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {
}
