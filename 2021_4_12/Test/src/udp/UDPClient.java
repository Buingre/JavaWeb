package udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * UDP客户端
 */
public class UDPClient {
    //服务器端端口号
    private static final int port=9001;
    //服务器端IP
    private static final String ip = "82.156.227.58";
//    private static  final String ip = "127.0.0.1";
    //数据包大小
    private static final int bleng = 1024;

    public static void main(String[] args) throws IOException {
        //1.创建客户端
        //客户端不需要固定的端口号，不输的时候会自动生成
        DatagramSocket socket = new DatagramSocket();
        //让用户来输入发送的消息
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("->");
            //接收到用户输入的信息
            String msg = scanner.nextLine();
            //2、构建发送数据包
            DatagramPacket datagramPacket = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            //3、发送消息
            socket.send(datagramPacket);


            //4.接收服务器的消息
            DatagramPacket serPacket = new DatagramPacket(
                new byte[bleng],bleng
            );
            socket.receive(serPacket);//接收服务器的消息
            //System.out.println("收到服务器端信息："+new String(serPacket.getData()));
            System.out.println(new String(serPacket.getData()));

        }
    }
}
