package vn.thanhhai.service.user;

import vn.thanhhai.model.users.User;
import vn.thanhhai.service.IGeneralService;

public interface IUserService extends IGeneralService<User> {

    User getUserByEmail(String email);

}