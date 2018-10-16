package pers.opappo.playlist.service;

import pers.opappo.playlist.dataobject.PlaylistInfo;

import java.util.List;

public interface PlaylistService {

    PlaylistInfo save(PlaylistInfo playlistInfo);

    List<PlaylistInfo> findByUserId(Integer userId);
}
