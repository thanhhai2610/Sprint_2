package vn.thanhhai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.product.ImgUrlProduct;
import vn.thanhhai.model.product.Watch;
import vn.thanhhai.repository.product.IImgUrlProductRepository;

@Service
public class ImgUrlProductService implements IImgProductService {
    @Autowired
    private IImgUrlProductRepository imgUrlProductRepository;


    @Override
    public void saveImgProduct(ImgUrlProduct imgUrlProduct) {
        imgUrlProductRepository.createImgProduct(imgUrlProduct.getUrl(), imgUrlProduct.getWatch().getId());
    }
}
