package pers.opappo.playlist.service;

import pers.opappo.playlist.dataobject.PlaylistDetail;

import java.util.List;

public interface PlaylistDetailService {

    PlaylistDetail save(PlaylistDetail playlistDetail);

    PlaylistDetail findOne(Integer playlistDetailId);

    List<PlaylistDetail> findByPlaylistId(Integer playlistId);

    void deleteOne(Integer playlistDetailId);

    void deleteList(Integer playlistId);
}
