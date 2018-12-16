package pers.opappo.playlist.service;

import pers.opappo.playlist.dataobject.PlaylistDetail;

import java.util.List;

public interface PlaylistDetailService {

    PlaylistDetail save(PlaylistDetail playlistDetail);

    List<PlaylistDetail> findByPlaylistId(Integer playlistId);
}
