package vn.thanhhai.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.thanhhai.model.product.Category;

import java.util.List;

@Repository
@Transactional
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
