package vn.thanhhai.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.thanhhai.dto.ImgUrlProductDto;
import vn.thanhhai.model.product.Brand;
import vn.thanhhai.model.product.Category;
import vn.thanhhai.model.product.ImgUrlProduct;
import vn.thanhhai.model.product.Watch;
import vn.thanhhai.service.IBrandService;
import vn.thanhhai.service.ICategoryService;
import vn.thanhhai.service.ImgUrlProductService;
import vn.thanhhai.service.IWatchService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/watches")
public class ProductController {
    @Autowired
    private IWatchService watchService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private ImgUrlProductService imgUrlProductService;

    @GetMapping("")
    public ResponseEntity<List<Watch>> findAllProduct() {
        List<Watch> productList = watchService.sonProduct();
        if (productList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Watch>>(productList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> saveImgProduct(@Validated @RequestBody ImgUrlProductDto imgUrlProductDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        ImgUrlProduct imgUrlProduct = new ImgUrlProduct();
        BeanUtils.copyProperties(imgUrlProductDTO, imgUrlProduct);
        Watch watch = watchService.getWatch(imgUrlProductDTO.getWatch());
        imgUrlProduct.setWatch(watch);
        imgUrlProductService.saveImgProduct(imgUrlProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> findAllCategory() {
        List<Category> categoryList = categoryService.listCategory();
        if(categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> findAllBrand() {
        List<Brand> brandList = brandService.listBrand();
        if (brandList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Brand>>(brandList, HttpStatus.OK);
    }
}
