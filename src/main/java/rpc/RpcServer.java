package rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 屏蔽了网络访问的细节
 * Created by Chenjf on 2018/11/30.
 * 进行服务发布工作
 */
public class RpcServer {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    public void publisher(final Object service , int port){
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);//启动一个监听

            while (true){
                Socket socket = serverSocket.accept();
                //把封装成线程任务的  socket及需要对应的服务  提交到线程池中
                executorService.submit(new ProcessorHandler(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket!= null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
