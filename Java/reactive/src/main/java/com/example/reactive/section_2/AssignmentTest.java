package com.example.reactive.section_2;

import com.example.reactive.section_2.assignment.FileService;
import com.example.reactive.section_2.assignment.impl.FileServiceImpl;
import com.example.reactive.common.DefaultSubscriber;
import com.example.reactive.common.Util;

public class AssignmentTest {
    public static void main(String[] args) {
        FileService fs = new FileServiceImpl();

        DefaultSubscriber<String> readSub =  Util.subscriber("Read");
        DefaultSubscriber<Void> writeSub =  Util.subscriber("Write");

        fs.read("C:\\Habeeb\\Dev\\Java\\reactive\\src\\main\\resources\\sample.txt")
                        .subscribe(readSub);

        fs.write("C:\\Habeeb\\Dev\\Java\\reactive\\src\\main\\resources\\sample.txt", "how good you are?")
                        .subscribe(writeSub);

        fs.read("C:\\Habeeb\\Dev\\Java\\reactive\\src\\main\\resources\\sample.txt")
                .subscribe(readSub);

//        Util.sleep(3);


        fs.delete("C:\\Habeeb\\Dev\\Java\\reactive\\src\\main\\resources\\sample.txt")
                .subscribe(Util.subscriber("Delete"));
    }
}
