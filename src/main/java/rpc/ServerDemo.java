package rpc;

/**
 * Created by Chenjf on 2018/11/30.
 */
public class ServerDemo {
    public static void main(String[] args) {
        IGpHello iGpHello = new GpHelloImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.publisher(iGpHello,8888);
    }
}
