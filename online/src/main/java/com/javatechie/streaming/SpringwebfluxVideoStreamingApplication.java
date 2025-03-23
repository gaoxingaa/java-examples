package com.javatechie.streaming;

import com.javatechie.streaming.model.Series;
import com.javatechie.streaming.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringwebfluxVideoStreamingApplication {

    @Autowired
    private StreamingService service;

    @GetMapping("/videos/{name}")
    public List<Video> videos(@PathVariable String name) {
        return Series.getByName(name).getVideos();
    }

    @GetMapping(value = "video/{series}/{episodes}", produces = "video/webm")
    public Mono<Resource> getVideo(@PathVariable String series, @PathVariable Integer episodes, @RequestHeader("Range") String range) {
//        return service.getVideo(series, episodes, range);
        return service.getVideo(series, episodes);
    }

    @GetMapping(value = "poster/{fileName}", produces = "image/jpeg")
    public Mono<Resource> generatePoster(@PathVariable String fileName) {
        return service.getPoster(fileName);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringwebfluxVideoStreamingApplication.class, args);
    }


}
