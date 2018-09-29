package pers.opappo.playlist.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.opappo.playlist.dataobject.UserInfo;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    UserInfoRepository repository;

    @Test
    @Transactional
    public void save() {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test");
        userInfo.setPassword("123");

        UserInfo result = repository.save(userInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUsername() {

        UserInfo userInfo = repository.findByUsername("admin");
        String password = userInfo.getPassword();
        Assert.assertEquals("123456", password);
    }
}