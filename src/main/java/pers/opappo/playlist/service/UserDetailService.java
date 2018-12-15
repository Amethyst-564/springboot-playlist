package pers.opappo.playlist.service;

import pers.opappo.playlist.dataobject.UserDetail;

public interface UserDetailService {

    UserDetail save(UserDetail userDetail);

    UserDetail findByUserId(Integer userId);
}
