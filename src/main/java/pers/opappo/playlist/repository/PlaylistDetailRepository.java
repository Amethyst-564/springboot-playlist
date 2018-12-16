package pers.opappo.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.opappo.playlist.dataobject.PlaylistDetail;

import java.util.List;

public interface PlaylistDetailRepository extends JpaRepository<PlaylistDetail, Integer> {

    // 根据playlistId查看歌单详情
    List<PlaylistDetail> findListByPlaylistId(Integer playlistId);
}
