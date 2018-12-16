package pers.opappo.playlist.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.opappo.playlist.dataobject.PlaylistDetail;
import pers.opappo.playlist.repository.PlaylistDetailRepository;
import pers.opappo.playlist.service.PlaylistDetailService;

import java.util.List;

/**
 * Created by minghli on 2018/12/16.
 */
@Service
public class PlaylistDetailServiceImpl implements PlaylistDetailService {

    @Autowired
    private PlaylistDetailRepository repository;

    @Override
    public PlaylistDetail save(PlaylistDetail playlistDetail) {
        return repository.save(playlistDetail);
    }

    @Override
    public List<PlaylistDetail> findByPlaylistId(Integer playlistId) {
        return repository.findListByPlaylistId(playlistId);
    }
}
