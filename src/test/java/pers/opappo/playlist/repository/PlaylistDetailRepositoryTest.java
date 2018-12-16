package pers.opappo.playlist.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.opappo.playlist.dataobject.PlaylistDetail;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PlaylistDetailRepositoryTest {

    @Autowired
    private PlaylistDetailRepository repository;

    @Test
    public void save() {
        PlaylistDetail playlistDetail = new PlaylistDetail();
        playlistDetail.setPlaylistId(7);
        playlistDetail.setPlaylistCover("http://p2.music.126.net/ZJ3u8zdhqkiFW_Q8uyf5iw==/18689498651123966.jpg");
        playlistDetail.setPlaylistContent("test content");

        PlaylistDetail result = repository.save(playlistDetail);
        Assert.assertNotNull(result);

    }

    @Test
    public void findListByPlaylistId() {

        List<PlaylistDetail> playlistDetailList = repository.findListByPlaylistId(7);
        Assert.assertEquals(2, playlistDetailList.size());
    }
}