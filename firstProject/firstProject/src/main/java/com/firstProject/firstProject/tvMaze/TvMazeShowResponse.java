package com.firstProject.firstProject.tvMaze;

public class TvMazeShowResponse {
    private Long id;
    private String url;
    private String name;

    public TvMazeShowResponse(){}

    public TvMazeShowResponse(Long id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setName(String name) {
        this.name = name;
    }
}
