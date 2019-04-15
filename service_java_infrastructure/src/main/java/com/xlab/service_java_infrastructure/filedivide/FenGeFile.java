/*
 * module: fundermental
 * file: FenGeFile.java
 * date: 4/12/19 10:15 AM
 * author: VectorJu
 */

/**
 * @create 2019-04-12 10:15
 * @desc test of file divided
 **/
package com.xlab.service_java_infrastructure.filedivide;

import java.io.*;

public class FenGeFile {

    public static final String SUFFIX = ".mov";// 分割后的文件名后缀
    // 将指定的文件按着给定的文件的字节数进行分割文件，其中name指的是需要进行分割的文件名，size指的是指定的小文件的大小

    public static String[] divide(String name, long size) throws Exception {
        File file = new File(name);
        if (!file.exists() || (!file.isFile())) {
            throw new Exception("指定文件不存在");
        }
        // 获得被分割文件父文件，将来被分割成的小文件便存在这个目录下
        File parentFile = file.getParentFile();
        // 取得文件的大小
        long fileLength = file.length();
        System.out.println("文件大小:" + fileLength + "字节");
        if (size <= 0) {
            size = fileLength / 2;
        }
        // 取得被分割后的小文件的数目
        int num = (fileLength % size != 0) ? (int) (fileLength / size + 1)
                : (int) (fileLength / size);
        // 存放被分割后的小文件名
        String[] fileNames = new String[num];
        // 输入文件流，即被分割的文件
        FileInputStream in = new FileInputStream(file);
        // 读输入文件流的开始和结束下标
        long end = 0;
        int begin = 0;
        // 根据要分割的数目输出文件
        for (int i = 0; i < num; i++) {
            // 对于前num – 1个小文件，大小都为指定的size
            File outFile = new File(parentFile, file.getName() + i + SUFFIX);
            // 构建小文件的输出流
            FileOutputStream out = new FileOutputStream(outFile);
            // 将结束下标后移size
            end += size;
            end = (end > fileLength) ? fileLength : end;
            // 从输入流中读取字节存储到输出流中
            for (; begin < end; begin++) {
                out.write(in.read());
            }
            out.close();
            fileNames[i] = outFile.getAbsolutePath();
        }
        in.close();
        return fileNames;
    }


    public static final String combine(String[] fileName) throws Exception {

        if (fileName.length == 0) throw new Exception("no file");
//        File finalFile = new File("/Users/juhongtao/ipfs/Screen Recording001.mov");
        String destination = "/Users/juhongtao/ipfs/Screen Recording001.mov";

//        if (!finalFile.exists()){
//            finalFile.createNewFile();
//        }
        int haveRead = 0; // 已读取字节数
        int readSize = -1; // 记录每次实际读取字节数
        int bufferSize = 4096; // 设置缓冲区大小
        byte buffer[] = new byte[bufferSize]; // 缓冲区字节数组
        OutputStream fos = new FileOutputStream(destination);
        BufferedOutputStream bos = new BufferedOutputStream(fos, bufferSize);

        for (int i=0;i<fileName.length;i++) {
            System.out.println(fileName.length);
            File sourceFile = new File(fileName[i]);
            InputStream fileInputStream = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fileInputStream, bufferSize);
            long fileSize = sourceFile.length();

            while (null != bis && (readSize = bis.read(buffer)) != -1)
            {
                haveRead += readSize;
                bos.write(buffer, 0, readSize);
                //System.out.println("已经复制：  " + haveRead + " Byte       完成" + haveRead * 100 / fileSize + "%     单次读取：" + readSize + " Byte");
            }
            bis.close();
            System.out.println("复制完成： " + haveRead);
        }

        bos.flush();
        bos.close();

        return destination;

    }

    public static void readFileMessage(String fileName) {// 将分割成的小文件中的内容读出
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String string = null;
            // 按行读取内容，直到读入null则表示读取文件结束
            while ((string = reader.readLine()) != null) {
                System.out.println(string);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static void main(String[] args) {
       /* String name = "/Users/juhongtao/Downloads/Screen Recording001.mov";
        long size = 1024*1024*4;//1K=1024b(字节)
        String[] fileNames = new String[0];
        try {
            fileNames = FenGeFile.divide(name, size);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("文件" + name + "分割的结果如下:");
        for (int i = 0; i < fileNames.length; i++) {
            System.out.println(fileNames[i] + "的内容如下");
            //FenGeFile.readFileMessage(fileNames[i]);
            System.out.println();
        }*/
       String[] files = new String[]{"/Users/juhongtao/ipfs/Screen Recording001.mov0.mov","/Users/juhongtao/ipfs/Screen Recording001.mov1.mov"
               ,"/Users/juhongtao/ipfs/Screen Recording001.mov2.mov","/Users/juhongtao/ipfs/Screen Recording001.mov3.mov"
               ,"/Users/juhongtao/ipfs/Screen Recording001.mov4.mov","/Users/juhongtao/ipfs/Screen Recording001.mov5.mov","/Users/juhongtao/ipfs/Screen Recording001.mov6.mov","/Users/juhongtao/ipfs/Screen Recording001.mov7.mov"
               ,"/Users/juhongtao/ipfs/Screen Recording001.mov8.mov","/Users/juhongtao/ipfs/Screen Recording001.mov9.mov","/Users/juhongtao/ipfs/Screen Recording001.mov10.mov","/Users/juhongtao/ipfs/Screen Recording001.mov11.mov"
               ,"/Users/juhongtao/ipfs/Screen Recording001.mov12.mov","/Users/juhongtao/ipfs/Screen Recording001.mov13.mov","/Users/juhongtao/ipfs/Screen Recording001.mov14.mov","/Users/juhongtao/ipfs/Screen Recording001.mov15.mov"
               ,"/Users/juhongtao/ipfs/Screen Recording001.mov16.mov","/Users/juhongtao/ipfs/Screen Recording001.mov17.mov","/Users/juhongtao/ipfs/Screen Recording001.mov18.mov"};

        try {
            combine(files);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

