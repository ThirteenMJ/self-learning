package com.msb.client;

import com.msb.utils.FastDFSClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author: thirteenmj
 * @date: 2022-07-10 15:13
 */
public class MyClient {

    public static void main(String[] args) {

        try {
            String pictureAddress = "/Users/thirteenmj/Pictures/截图/iShot2022-05-24 10.40.56.png";
            File file = new File(pictureAddress);
            InputStream inputStream = new FileInputStream(file);
            String fileName = UUID.randomUUID().toString() + ".png";
            String[] result = FastDFSClient.uploadFile(inputStream, fileName);
            System.out.println(Arrays.toString(result));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
