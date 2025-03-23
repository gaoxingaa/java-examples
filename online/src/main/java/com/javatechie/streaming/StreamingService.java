package com.javatechie.streaming;

import com.javatechie.streaming.model.Series;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.RandomAccessFile;

@Service
public class StreamingService {

    private static final String FORMAT="classpath:videos/%s.mp4";
    private String videoPath = "D:\\BaiduNetdiskDownload\\";

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String series, Integer episodes) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(Series.getByName(series).getResource(episodes)));
    }


    public Mono<Resource> getPoster(String series) {
        return Mono.fromSupplier(() -> resourceLoader.getResource(Series.getByName(series).getPoster()));
    }

    public Mono<ResponseEntity<Resource>> getVideo(String series, Integer episodes, String range) {
        String filePath = Series.getByName(series).getFilePath(episodes);
        try {
            // Check if Range header is present and parse the range
            if (range != null && range.startsWith("bytes=")) {
                String[] ranges = range.substring(6).split("-");
                long start = Long.parseLong(ranges[0]);
                long end = (ranges.length > 1) ? Long.parseLong(ranges[1]) : -1;

                RandomAccessFile file = new RandomAccessFile(filePath, "r");
                long fileSize = file.length();

                // Handle the range requested by the client
                if (end == -1 || end >= fileSize) {
                    end = fileSize - 1;
                }

                // Set the file pointer to the start of the requested range
                file.seek(start);

                // Create a resource for the requested byte range
                byte[] content = new byte[(int) (end - start + 1)];
                file.readFully(content);
                file.close();

                // Return a ResponseEntity with the content and the proper Content-Range header
                return Mono.just(ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                        .header(HttpHeaders.CONTENT_RANGE, "bytes " + start + "-" + end + "/" + fileSize)
                        .body(new FileSystemResource(filePath)));
            }
        } catch (IOException e) {
            // Handle exception, probably return a 500 response
            return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
        }
        return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

}
