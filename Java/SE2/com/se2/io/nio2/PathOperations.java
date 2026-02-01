package com.se2.io.nio2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class PathOperations {

    public static void main(String[] args) {

        PathOperations operations = new PathOperations();


//        Path p1 = Path.of(System.getProperty("user.dir"));
////        operations.pathInfo(p1);
//
//        Path p2 = Path.of("abc", "def", "ghi", "jkl", "mno");
//        operations.pathInfo(p2);

//        operations.fileCreateCopyMoveDelete();

//        operations.resolvePath();
//        operations.relativizePath();
        operations.normalizePath();
    }

    private void pathInfo(Path path){

        System.out.println("path.toString() = " + path.toString());
        System.out.println("path.getNameCount() = " + path.getNameCount());

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println("path.getName(" + i + ") = " + path.getName(i));
        }

        System.out.println("path.getFileName() = " + path.getFileName());
        System.out.println("path.getParent() = " + path.getParent());
        System.out.println("path.getRoot() = " + path.getRoot());

        System.out.println("path.subpath(1,3) = " + path.subpath(0, 3));

        System.out.println("path.isAbsolute() = " + path.isAbsolute());
    }


    private void fileCreateCopyMoveDelete() {

        Path currDir = Path.of(System.getProperty("user.dir"));

        System.out.println(currDir);

        Path source = Path.of("com/se2/io/nio2/text_files/source.txt");
        Path target = Path.of("com/se2/io/nio2/text_files/target.txt");
        Path target2 = Path.of("com/se2/io/nio2/text_files/target2.txt");

        try{
            Files.createDirectories(Path.of("com/se2/io/nio2/text_files"));
            if(Files.exists(source)){

                writeSomething(source);

                Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
                Files.move(target, target2, StandardCopyOption.REPLACE_EXISTING);

            }
            else{
                Files.createFile(source);
                Files.copy(source,target);
                Files.move(target, target2);
                Files.delete(target2); // deletes target also, since it's moved from target to target2
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void resolvePath(){

        Path absPath = Path.of(System.getProperty("user.dir"));
        Path relPath = Path.of("somePath/leadsTo/someOtherPath");
        Path file = Path.of("text_file.txt");

        /**
         * path1.resolve(path2);
         * path1 is resolved with path2
         */
        System.out.println("absPath.resolve(relPath) = " + absPath.resolve(relPath));
        System.out.println("absPath.resolve(file) = " + absPath.resolve(file));

        System.out.println("relPath.resolve(file) = " + relPath.resolve(file));

        System.out.println();

        System.out.println("relPath.resolve(absPath) = " + relPath.resolve(absPath));
        System.out.println("file.resolve(absPath) = " + file.resolve(absPath));

        System.out.println("absPath.resolve(absPath) = " + absPath.resolve(absPath));

        System.out.println("file.resolve(relPath) = " + file.resolve(relPath));

    }

    private void relativizePath(){

        /**
         * Both paths should be either relative or absolute
         * No, one relative/one absolute and vice-versa is allowed.
         */

        // Two relative paths
        Path p1 = Path.of("stillness_speaks.epub");
        Path p2 = Path.of("books/atomic_habits.epub");

        /**
         * relativize means how to I get from one file to another
         * p1.relativize(p2) -> how do I get from p1 to p2
         */

        System.out.println("p1.relativize(p2) = " + p1.relativize(p2));
        System.out.println("p2.relativize(p1) = " + p2.relativize(p1));

        System.out.println();
        // Two absolute paths

        Path p3 = Path.of("C:/New_Books/When_The_Crawdad_Sings.mobi");
        Path p4 = Path.of("C:/Old_Books/2007/The_Girl_With_Dragon_Tattoo.epub");

        System.out.println("p3.relativize(p4) = " + p3.relativize(p4));
        System.out.println("p4.relativize(p3) = " + p4.relativize(p3));
    }

    private void normalizePath(){
        Path p1 = Path.of("./x/y/../Habeeb/newTextFile.txt");

        System.out.println( "\"" + p1 + "\"" + ".normalize() = \"" + p1.normalize() + "\"");

        Path p2 = Path.of("./x/y/../z");
        System.out.println( "\"" + p2 + "\"" + ".normalize() = \"" + p2.normalize() + "\"");


        Path p3 = Path.of("../cannotResolve/sinceThereIsNoDirectoryBeforeDots");
        System.out.println( "\"" + p3 + "\"" + ".normalize() = \"" + p3.normalize() + "\"");

    }


    private void writeSomething(Path path) throws IOException{

        String sampleText = """
                Hi There
                How is it going?
                Nice to meet you
                """;

        File file = path.toFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        writer.write(sampleText);
        writer.close();


    }

}
