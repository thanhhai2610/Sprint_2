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
import vn.thanhhai.model.product.ImgUrlProduct;
import vn.thanhhai.model.product.Watch;
import vn.thanhhai.service.IImgProductService;
import vn.thanhhai.service.IWatchService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/images")
public class ImgProductController {
    @Autowired
    private IWatchService watchService;

    @Autowired
    private IImgProductService imgProductService;

    @PostMapping("/create")
    public ResponseEntity<List<FieldError>> saveImgWatch(@Validated @RequestBody ImgUrlProductDto imgUrlProductDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        ImgUrlProduct imgUrlProduct = new ImgUrlProduct();
        BeanUtils.copyProperties(imgUrlProductDto, imgUrlProduct);
        Watch watch = watchService.getWatch(imgUrlProductDto.getWatch());
        imgUrlProduct.setWatch(watch);
        imgProductService.saveImgProduct(imgUrlProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
