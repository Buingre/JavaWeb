package tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 沾包、半包问题
 * 【解决方法3  客户端代码】
 */
public class TCPClientError {
    private static final String ip="127.0.0.1";
    private static final int port = 9005;
    public static void main(String[] args) throws IOException {
        //创建客户端并连接服务器
        Socket socket = new Socket(ip,port);

        //发送的消息
        String msg = "Hi,Java.\n";
        //构建发送对象
        try(OutputStream outputStream = socket.getOutputStream()){

            for (int i = 0;i<10;i++){
                //以字节方式传输
                outputStream.write(msg.getBytes(),0,msg.getBytes().length);
            }

        }
    }
}
