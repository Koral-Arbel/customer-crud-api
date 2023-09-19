package com.firstProject.firstProject.tvMaze;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "TvMazeService",
        url = "http://api.tvmaze.com"
)
public interface TvMazeService {

    @GetMapping("/show/{tvShowId}")
    TvMazeShowResponse getTvShoeById(@PathVariable Long tvShowId);
}
