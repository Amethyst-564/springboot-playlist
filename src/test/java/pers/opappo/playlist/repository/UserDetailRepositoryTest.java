package pers.opappo.playlist.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.opappo.playlist.dataobject.UserDetail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailRepositoryTest {

    @Autowired
    private UserDetailRepository repository;

    @Test
    public void save() {
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(10);
        userDetail.setUserAlias("爆炸即艺术");
        userDetail.setUserIcon("假装是图片.jpg");
        userDetail.setUserDescription("测试一下repo");

        UserDetail result = repository.save(userDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUserId() {
        UserDetail result = repository.findByUserId(10);
        System.out.println(result);
        Assert.assertNotNull(result);
    }
}