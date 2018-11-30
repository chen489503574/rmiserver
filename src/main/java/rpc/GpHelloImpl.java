package rpc;

/**
 * Created by Chenjf on 2018/11/30.
 */
public class GpHelloImpl implements IGpHello {
    public String sayHi(String name) {
        String msg = "Hello,friends"+name;
        return msg;
    }
}
