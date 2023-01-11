package vn.thanhhai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.product.Watch;
import vn.thanhhai.repository.product.IWatchRepository;

import java.util.List;

@Service
public class WatchService implements IWatchService {
    @Autowired
    private IWatchRepository watchRepository;
    @Override
    public List<Watch> sonProduct() {
        return watchRepository.findAll();
    }

    @Override
    public Watch getWatch(Integer id) {
        return watchRepository.findById(id).orElse(null);
    }
}
