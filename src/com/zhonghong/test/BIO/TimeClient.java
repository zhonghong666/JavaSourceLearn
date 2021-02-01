package com.zhonghong.test.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author: zhonghong
 * @description: 同步时间客户端
 * @date: 2021/1/9
 */
public class TimeClient {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        Socket socket = new Socket("127.0.0.1", port);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("query time");
        String rsp = in.readLine();
        System.out.println("Now is " + rsp);
        out.close();
        in.close();
        socket.close();
    }
}
