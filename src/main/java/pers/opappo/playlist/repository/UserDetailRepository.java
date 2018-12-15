package pers.opappo.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.opappo.playlist.dataobject.UserDetail;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {

    // 根据id查询用户详情
    UserDetail findByUserId(Integer userId);
}
