package pers.opappo.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.opappo.playlist.dataobject.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    // 根据用户名查询记录
    UserInfo findByUsername(String username);

}
