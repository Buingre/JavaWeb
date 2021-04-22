package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 沾包、半包问题
 * 【解决方法3  服务器代码】
 */
public class TCPSeverError {
    //端口号
    private static final int port = 9005;
    //数据传输的最大值
    private static final int leng = 1024;
    public static void main(String[] args) throws IOException {
        //1.创建TCP服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器启动成功！");

        //2.等待客户端的连接.连接起来就可以进行交互
        Socket clientSocket =  serverSocket.accept();//会返回socket对象
        //连接起来就可以进行交互
        System.out.println(String.format("有客户端连接了，客户端IP:%s  端口：%d",
                clientSocket.getInetAddress().getHostAddress(),clientSocket.getPort()));

        /*//得到读取对象
        try(InputStream inputStream = clientSocket.getInputStream()){

            while (true){//读取多条
                byte[] bytes = new byte[leng];
                int res = inputStream.read(bytes,0,bytes.length);
                if(res > 0){//表示读取成功
                    System.out.println("读取到客户端消息："+new String(bytes));
                }
            }
        }*/

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
            while (true){
                //按行定义边界
                String msg = reader.readLine();

                if(msg!=null && msg!=null){
                    System.out.println("读取到客户端消息："+msg);
                }

            }

        }
    }
}
