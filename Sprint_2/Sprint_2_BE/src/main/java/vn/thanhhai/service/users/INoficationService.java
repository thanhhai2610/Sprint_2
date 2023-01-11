package vn.thanhhai.service.users;

import vn.thanhhai.model.users.Notification;

import java.util.List;

public interface INoficationService {
    void save(Notification notification);

    List<Notification> getAllByUserId(Integer userId);

    List<Notification> getAllNoficationByAdmin();

    Notification finById(Integer id);
}
