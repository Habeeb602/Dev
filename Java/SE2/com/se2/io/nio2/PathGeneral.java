package com.se2.io.nio2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathGeneral {

    public static void main(String[] args) {

        System.out.println("Current Directory: " + System.getProperty("user.dir"));

        /**
         * Path doesn't need to exist
         * It's logical one
         */


        /**
         * Path.of("path");
         */
        // Relative Path
        Path p1 = Path.of("./com/se2/io/source.txt");
        // Absolute Path
        Path p2 = Path.of("C:\\Habeeb\\Dev\\Java\\SE2\\com\\se2\\io\\source.txt");

        /**
         * Path.get("path");
         */
        Path p3 = Paths.get("./com/se2/io/source.txt");
        Path p4 = Paths.get("C:\\Habeeb\\Dev\\Java\\SE2\\com\\se2\\io\\source.txt");

        /**
         * Path.of(var_args);
         */

        Path p5 = Path.of("com","se2", "io", "source.txt");
        Path p6 = Path.of("C:","Habeeb","Dev","Java","SE2","com","se2","io","source.txt");

        /**
         * Paths.get(var_args);
         */

        Path p7 = Paths.get("com","se2", "io", "source.txt");
        Path p8 = Paths.get("C:","Habeeb","Dev","Java","SE2","com","se2","io","source.txt");

    }
}
