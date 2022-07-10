package com.msb.client;

import com.msb.utils.FastDFSClient;

import java.io.*;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author: thirteenmj
 * @date: 2022-07-10 15:13
 */
public class MyClient {

    public static void main(String[] args) {
        try {
            String pictureAddress = "/Users/thirteenmj/Pictures/截图/iShot_2022-06-02_16.01.19.png";
            String targetAddress = "/Users/thirteenmj/Downloads/iShot_2022-06-02_16.01.19.png";
            String[] result = uploadFile(pictureAddress);
            downLoadFile(result[0], result[1], targetAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void downLoadFile(String groupName, String fileUrl, String fileTargetFileAddress) throws Exception {
        InputStream is = FastDFSClient.downloadFile(groupName, fileUrl);
        OutputStream os = new FileOutputStream(fileTargetFileAddress);
        int index = 0;
        while ((index = is.read()) != -1) {
            os.write(index);
        }
        os.flush();
        os.close();
        is.close();
    }

    private static String[] uploadFile(String fileAddress) throws FileNotFoundException {
        File file = new File(fileAddress);
        InputStream inputStream = new FileInputStream(file);
        String fileName = UUID.randomUUID().toString() + ".png";
        String[] result = FastDFSClient.uploadFile(inputStream, fileName);
        System.out.println(Arrays.toString(result));
        return result;
    }
}
