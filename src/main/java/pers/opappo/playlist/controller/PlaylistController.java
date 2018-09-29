package pers.opappo.playlist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by minghli on 2018/9/19.
 */
@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    @GetMapping("/detail")
    public String getDetail() {
        return null;
    }
}
