package pers.opappo.playlist.service.Impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.opappo.playlist.dataobject.PlaylistDetail;
import pers.opappo.playlist.service.PlaylistDetailService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaylistDetailServiceImplTest {

    @Autowired
    private PlaylistDetailService service;

    @Test
    public void deleteList() {

        Integer toBeDeleted = 22;

        service.deleteList(toBeDeleted);
        List<PlaylistDetail> result =  service.findByPlaylistId(toBeDeleted);
        Assert.assertEquals(0, result.size());
    }
}