package pers.opappo.playlist.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.opappo.playlist.dataobject.UserDetail;
import pers.opappo.playlist.repository.UserDetailRepository;
import pers.opappo.playlist.service.UserDetailService;

/**
 * Created by minghli on 2018/12/15.
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailRepository repository;

    @Override
    public UserDetail save(UserDetail userDetail) {
        return repository.save(userDetail);
    }

    @Override
    public UserDetail findByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }
}
