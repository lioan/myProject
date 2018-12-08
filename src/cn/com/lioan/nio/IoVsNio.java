package cn.com.lioan.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IoVsNio {

    public static void main(String[] args) {
//        ioFile();
        nioFile();
    }

    public static void ioFile() {
        int r = 0;
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("files/nio.txt"));
            byte[] buf = new byte[1024];
            int len;
            for (;(len = in.read(buf)) != -1;) {
                for (int i = 0; i <  len; i++) {
//                    System.out.println(buf[i]);
                    System.out.println((char) buf[i]);
                }
                r++;
                System.out.println(r + ",len=" + len);
            }
            System.out.println("cycle times:" + r);
            System.out.println("last len:" + len);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                 e.printStackTrace();
            }
        }
    }

    public static void nioFile() {
        int r = 0;
        RandomAccessFile rFile = null;
        try {
            rFile = new RandomAccessFile("files/nio.txt", "rw");
            FileChannel fileChannel = rFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead;
            for (;(bytesRead = fileChannel.read(buf)) != -1;) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.println((char)buf.get());
                }
                buf.compact();
                r++;
                System.out.println(r + ",len=" + bytesRead);
            }
            System.out.println("cycle times:" + r);
            System.out.println("last len:" + bytesRead);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rFile != null) {
                    rFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
