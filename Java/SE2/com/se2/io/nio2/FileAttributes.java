package com.se2.io.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.TimeUnit;

public class FileAttributes {

    public static void main(String[] args) {

        FileAttributes fileAttributes = new FileAttributes();


//        Path p1 = Path.of("C:\\Habeeb\\Dev\\Java\\SE2\\com\\se2\\io\\nio2\\text_files\\source.txt");
//        fileAttributes.checkAttributes(p1);
//
//        System.out.println();
//
//        Path p2 = Path.of("C:\\Habeeb\\Dev\\Java\\SE2\\com\\se2\\io\\nio2\\text_files");
//        fileAttributes.checkAttributes(p2);
        Path p1 = Path.of("C:\\Habeeb\\Dev\\Java\\SE2\\com\\se2\\io\\nio2\\text_files\\source.txt");
        fileAttributes.checkAttributeViews(p1);
    }

    private void checkAttributes(Path path){

        System.out.println("path = " + path);
        System.out.println("Files.isDirectory(path) = " + Files.isDirectory(path));
        System.out.println("Files.isRegularFile(path) = " + Files.isRegularFile(path));
        System.out.println("Files.isSymbolicLink(path) = " + Files.isSymbolicLink(path));
        System.out.println("Files.isReadable(path) = " + Files.isReadable(path));
        System.out.println("Files.isWritable(path) = " + Files.isWritable(path));
        System.out.println("Files.isExecutable(path) = " + Files.isExecutable(path));

        try{
            System.out.println("Files.isHidden(path) = " + Files.isHidden(path));
            System.out.println("Files.size(path) = " + Files.size(path));
            long ms = Files.getLastModifiedTime(path).toMillis();
            ZonedDateTime zdt = FileTime.fromMillis(ms).toInstant().atZone(ZoneId.of("Asia/Kolkata"));
            System.out.println("getLastModifiedTime = " + zdt);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    private void checkAttributeViews(Path path){

        System.out.println("path = " + path);

        try{
            BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
            System.out.println("basicFileAttributes.isDirectory() = " + basicFileAttributes.isDirectory());
            System.out.println("basicFileAttributes.isRegularFile() = " + basicFileAttributes.isRegularFile());
            System.out.println("basicFileAttributes.isSymbolicLink() = " + basicFileAttributes.isSymbolicLink());
            System.out.println("basicFileAttributes.size() = " + basicFileAttributes.size());
            System.out.println("basicFileAttributes.lastModifiedTime() = " + basicFileAttributes.lastModifiedTime());
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}
