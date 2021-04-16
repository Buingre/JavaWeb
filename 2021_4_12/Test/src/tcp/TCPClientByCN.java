package tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 英译汉客户端
 */
public class TCPClientByCN {
    //服务器端的IP
    private static final String ip = "82.156.227.58";
    //服务器端口号
    private static final int port = 9003;

    public static void main(String[] args) throws IOException {

        //1.创建TCP客户端--》同时连接到服务器端
        Socket socket = new Socket(ip,port);

        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);
        ){
            while (true){//不停的进行信息写入
                System.out.print("输入英文吧->");
                String msg = scanner.nextLine();
                //2.发送信息
                bufferedWriter.write(msg+"\n");
                bufferedWriter.flush();
                //3.接收服务端返回的信息
                String serMsg = bufferedReader.readLine();
                System.out.println("服务器端反馈-中文："+serMsg);

                //刷新缓冲区
                bufferedWriter.flush();
            }
        }




    }
}
