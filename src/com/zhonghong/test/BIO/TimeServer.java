package com.zhonghong.test.BIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * @author: zhonghong
 * @description: 时间服务器
 * @date: 2021/1/9
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        if (args != null && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {

            }
        }
        ServerSocket server = new ServerSocket(port);
        System.out.println("时间服务器已经启动，端口号：" + port);

        Socket socket;
        try {
            while (true) {
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if (server != null) {
                server.close();
            }
        }

    }
}

class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String line;
            while ((line = in.readLine()) != null && line.length() > 0) {
                System.out.println("request body ==> " + line);
                out.println(LocalDateTime.now().toString());
            }

        } catch (IOException e) {
            if (out != null) {
                out.close();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioException) {
                    e.printStackTrace();
                }
            }
            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException exception) {
                    e.printStackTrace();
                }
            }
        }

    }
}
