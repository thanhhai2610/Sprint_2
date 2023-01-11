package vn.thanhhai.service.users.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.users.Notification;
import vn.thanhhai.repository.users.INoficationRepository;
import vn.thanhhai.service.users.INoficationService;

import java.util.List;

@Service
public class NoficationService implements INoficationService {

    @Autowired
    private INoficationRepository iNoficationRepository;
    @Override
    public void save(Notification notification) {
        iNoficationRepository.save(notification);
    }

    @Override
    public List<Notification> getAllByUserId(Integer userId) {
        return iNoficationRepository.getAllByUserId(userId);
    }

    @Override
    public List<Notification> getAllNoficationByAdmin() {
        return iNoficationRepository.getAllNoficationByAdmin();
    }

    @Override
    public Notification finById(Integer id) {
        return iNoficationRepository.findById(id).get();
    }
}
