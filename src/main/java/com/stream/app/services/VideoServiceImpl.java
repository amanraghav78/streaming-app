package com.stream.app.services;

import ch.qos.logback.core.util.StringUtil;
import com.stream.app.entities.Video;
import com.stream.app.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Value("${files.video}")
    String DIR;

    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video save(Video video, MultipartFile file) {
        try{
            String filename= file.getOriginalFilename();
            String contentType= file.getContentType();
            InputStream inputStream= file.getInputStream();

            String cleanFileName= StringUtils.cleanPath(filename);
            String cleanFolder= StringUtils.cleanPath(DIR);

            Path path= Paths.get(cleanFolder, cleanFileName);

            System.out.println(path);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Video get(String videoId) {
        return null;
    }

    @Override
    public Video getByTitle(String title) {
        return null;
    }

    @Override
    public List<Video> getAll() {
        return List.of();
    }
}
