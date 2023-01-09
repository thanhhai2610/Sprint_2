package vn.thanhhai.service;


import vn.thanhhai.model.product.Watch;

import java.util.List;

public interface IWatchService {
    List<Watch> sonProduct();

    Watch getWatch(Integer id);
}
