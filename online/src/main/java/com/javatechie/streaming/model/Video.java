package com.javatechie.streaming.model;

public class Video {
    private String id;
    private String src;
    private String poster;
    private String name;

    public Video(String name, int id) {
        this.id = String.valueOf(id);
        this.src = "video/" + name + "/" + this.id;
        this.poster = "poster/" + name;
        this.name = name + id;
    }

    public String getId() {
        return id;
    }

    public String getSrc() {
        return src;
    }

    public String getPoster() {
        return poster;
    }

    public String getName() {
        return name;
    }
}
