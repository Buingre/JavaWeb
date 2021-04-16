package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP
 */
public class TCPServer {
    //端口号
    private static final int port = 9002;
    public static void main(String[] args) throws IOException {
        //1.创建TCP服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器启动成功！");

        //2.等待客户端的连接.连接起来就可以进行交互
        Socket client =  serverSocket.accept();//会返回socket对象
        //连接起来就可以进行交互
        System.out.println(String.format("有客户端连接了，客户端IP:%s  端口：%d",
                    client.getInetAddress().getHostAddress(),client.getPort()));

        /*BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        //拿到读取对象
        bufferedReader = new BufferedReader(
                new InputStreamReader(client.getInputStream())//输出流
        );
        //接收服务器端的信息
        String msg = bufferedReader.readLine();

        //拿到写入对象
        bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream())
        );
        String serMsg = "我收到了";
        bufferedWriter.write(serMsg+"\n");//写入消息必须加\n，
        //刷新缓冲区
        bufferedWriter.flush();



        bufferedReader.close();//防止代码出错而没有关闭，所以写进finally
        bufferedWriter.close();*/


        //try-resource：JVM可以自动关闭资源
        try( BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(client.getInputStream())
        );
             BufferedWriter bufferedWriter = new BufferedWriter(
                     new OutputStreamWriter(client.getOutputStream())
             )
        ){
            while (true){//可能有多个消息
                //3.接收客户端的信息
                String msg = bufferedReader.readLine();
                if (msg != null && !msg.equals("")) {
                    System.out.println("收到客户端信息：" + msg);
                }
                //4.返回给客户端的响应信息
                String serMsg = "我收到了！";
                bufferedWriter.write(serMsg+"\n");//!!!!!!!!!!!!!!!!!!!!!!+\n
                //刷新缓冲区
                bufferedWriter.flush();
            }

        }
    }
}
