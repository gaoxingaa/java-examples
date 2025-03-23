package com.javatechie.streaming.model;

import java.util.ArrayList;
import java.util.List;

public enum Series {
    //no space for name in url
    SHELDON("YoungSheldon", "C:\\Users\\Jane\\Downloads\\7709DB20\\S01\\", "S01.", 22, "._new.mp4"),
    CHINATOWN("InteriorChinatown", "D:\\BaiduNetdiskDownload\\", "interior.chinatown.s01e", 10, ".mp4"),
    ;

    private String name;
    private String location;
    private String prefix;
    private int episodes;
    private String format;

    Series(String name, String location, String prefix, int episodes, String format) {
        this.name = name;
        this.location = location;
        this.prefix = prefix;
        this.episodes = episodes;
        this.format = format;
    }

    public static Series getByName(String name) {
        for (Series category : Series.values()) {
            if (category.getName().equalsIgnoreCase(name)) {
                return category;
            }
        }
        throw new IllegalArgumentException("No enum constant found with name: " + name);
    }

    private String getName() {
        return this.name;
    }

    public String getResource(Integer episodes) {
        return String.format("file:%s%s%02d%s", location, prefix, episodes, format);
    }

    public String getFilePath(Integer episodes) {
        return String.format("%s%s%02d%s", location, prefix, episodes, format);
    }

    public String getPoster() {
        return String.format("file:%s%s%s", location, name, ".jpg");
    }

    public List<Video> getVideos() {
        List<Video> videos = new ArrayList<>();
        for (int i = 1; i <= episodes; i++) {
            videos.add(new Video(name, i));
        }
        return videos;
    }
}
