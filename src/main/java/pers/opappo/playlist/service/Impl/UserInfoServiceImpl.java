package pers.opappo.playlist.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.opappo.playlist.dataobject.UserInfo;
import pers.opappo.playlist.repository.UserInfoRepository;
import pers.opappo.playlist.service.UserInfoService;

/**
 * Created by minghli on 2018/9/27.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    public UserInfo findUserInfoByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public UserInfo save(UserInfo userInfo) {
        return repository.save(userInfo);
    }
}
