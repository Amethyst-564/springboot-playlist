package pers.opappo.playlist.service;

import pers.opappo.playlist.dataobject.UserInfo;

public interface UserInfoService {

    UserInfo findUserInfoByUsername(String username);

    UserInfo save(UserInfo userInfo);

    UserInfo updateVisit(UserInfo userInfo);
}
