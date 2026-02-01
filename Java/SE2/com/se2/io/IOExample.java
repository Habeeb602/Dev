package com.se2.io;

import java.io.*;

public class IOExample {

    public static void main(String[] args) {

        IOExample ioExample = new IOExample();

//        ioExample.copyTextFile(true);
//        ioExample.copyTextFile(false);
//        ioExample.copyBinaryFile(true);
        ioExample.copyBinaryFile(false);
    }

    private void copyTextFile(boolean buffering){
        File sourceFile = new File("C:\\Habeeb\\Dev\\Java\\SE2\\com\\se2\\io\\source.txt");
        File destFile = new File("C:\\Habeeb\\Dev\\Java\\SE2\\com\\se2\\io\\destination.txt");

        try(
                BufferedReader rdr = new BufferedReader(new FileReader(sourceFile));
                BufferedWriter wtr = new BufferedWriter(new FileWriter(destFile))
                ){

            if(buffering){
                String line = null;

                /**
                 * rdr.readLine() returns null, if it reached EOF.
                 * So, we are using it here as the exit loop condition
                 */

                while((line = rdr.readLine()) != null){
                    wtr.write(line);
                    wtr.newLine();

                }
            }
            else{

                int c = -1;

                /**
                 * rdr.read() returns a byte in the form of integer
                 * why?
                 * because, read() returns '-1' to mark the end of file
                 */

                while((c = rdr.read()) != -1){
                    wtr.write(c);
                }
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void copyBinaryFile(boolean buffering){


        // Using relative path to the program file
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        File src = new File("./com/se2/io/source.txt");
        File dest = new File("./com/se2/io/destination.txt");


        try(
                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(src));
                BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(dest))
                ){

            if(buffering){
                byte[] buffer = new byte[1024];
                int numOfBytesRead = 0;
                while((numOfBytesRead = inputStream.read(buffer)) > 0){

                    /**
                     * we are using numOfBytesRead to get track of actual number of bytes read
                     * Since, it won't be same as 1024 for the whole file
                     * Think, if it reaches the last iteration to fetch the bytes
                     * Most probably, it won't be as exact as 1024
                     * e.g. byte size of a file is 2058 = 1024 + 1024 + 10
                     * So, in the last iteration, it would get 10 in the numOfBytesRead as write accordingly
                     */

                    outputStream.write(buffer, 0, numOfBytesRead);
                    /**
                     * outputStream.flush() -> flushes all the output to hard disk / underlying output stream.
                     */
                    outputStream.flush();
                }

            }
            else{
                int c = -1;

                while((c = inputStream.read()) != -1){
                    outputStream.write(c);
                    outputStream.flush();
                }

            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
