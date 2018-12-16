package pers.opappo.playlist.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.opappo.playlist.dataobject.PlaylistInfo;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PlaylistInfoRepositoryTest {

    @Autowired
    PlaylistInfoRepository repository;

    @Test
    public void save() {
        PlaylistInfo playlistInfo = new PlaylistInfo();
        playlistInfo.setUserId(1);
        playlistInfo.setPlaylistName("test");
        playlistInfo.setPid("576465");

        PlaylistInfo result = repository.save(playlistInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByUserId() {
        List<PlaylistInfo> playlistInfo = repository.findByUserId(10);
        Assert.assertEquals(1, playlistInfo.size());


    }
}