package pers.opappo.playlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.opappo.playlist.dataobject.PlaylistInfo;

import java.util.List;

public interface PlaylistInfoRepository extends JpaRepository<PlaylistInfo, Integer> {

    // 根据id查询歌单列表
    List<PlaylistInfo> findByUserId(Integer userId);
}
