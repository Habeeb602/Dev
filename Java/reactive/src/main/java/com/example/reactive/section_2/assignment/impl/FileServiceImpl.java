package com.example.reactive.section_2.assignment.impl;

import com.example.reactive.section_2.assignment.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileServiceImpl implements FileService {

    private final Logger log = LoggerFactory.getLogger(FileServiceImpl.class);

    private final Path basePath = Paths.get(System.getProperty("user.dir"));

    @Override
    public Mono<String> read(String fileName) {
        Path filePath = Paths.get(fileName);
        String content;

        try{
            content = Files.readString(filePath);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
        return Mono.fromSupplier(() -> content);
    }

    @Override
    public Mono<Void> write(String fileName, String content) {

        Path filePath = Paths.get(fileName);


        return Mono.fromRunnable(() -> {
            try {
                Files.writeString(filePath, content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public Mono<Void> delete(String fileName) {
        Path fullPath = Paths.get(fileName);

        return Mono.fromRunnable(() -> {
            log.info("Doing deletion, current path is {}", fullPath);
            try {
                Files.delete(fullPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
