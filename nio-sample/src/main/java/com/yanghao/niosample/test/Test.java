package com.yanghao.niosample.test;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

/**
 * @program: websocket
 * @description:
 * @author: yanghao
 * @create: 2018-10-29 08:46
 **/
public class Test {
    //线程发令枪
    static CountDownLatch cd1 = new CountDownLatch(20);

    static class ClientThread implements Runnable {

        @Override
        public void run() {

            //将创建的io放单try的括号中不用在finally中手动释放，会自动释放资源
            try {
                System.out.println();
                cd1.await();
                //ServerSocket 服务器端  socket 客户端
                Socket socket = new Socket("localhost", 8080);
                System.out.println(Thread.currentThread().getName() + "working.....");
                Thread.sleep(60 * 60 * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            ClientThread ct = new ClientThread();
            new Thread(ct).start();
            cd1.countDown();
        }
    }
}
