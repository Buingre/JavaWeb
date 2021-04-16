package tcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
public class TCPServerByCN {
    private static final int port = 9003;

    //定义翻译字典
    static HashMap<String,String> dirMap = new HashMap<>();
    //在项目运行之后
    static {
        dirMap.put("hello","你好");
        dirMap.put("cat","猫");
        dirMap.put("dog","狗");
    }

    public static void main(String[] args) throws IOException {
        //1.创建TCP服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("英译汉服务器已启动~");

        //2.等待客户端连接
        Socket client = serverSocket.accept();
        System.out.println(String.format("有客户端连接了，客户端IP:%s  端口：%d",
                client.getInetAddress().getHostAddress(),client.getPort()));



        try(
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(client.getOutputStream()))

        ) {
            while (true){//循环接收
                //3.得到客户端的英文单词
                String en = bufferedReader.readLine();

                if(en!=null && !en.equals("")){
                    //4.英译汉的结果处理方法
                    String cn =  processData2(en);
                    //5.将结果返回给客户端
                    bufferedWriter.write(cn+"\n");
                    //刷新
                    bufferedWriter.flush();
                }


            }

        }
    }

    /**【方式1】
     * 穷举法---实现英译汉
     * @param en
     * @return
     */
    private static String processData(String en) {
        String cn ="未知";
        switch (en){
            case "hello":
                cn = "你好";
                break;
            case "cat":
                cn = "猫";
                break;
            case "dog":
                cn = "狗";
                break;
            default:

                break;
        }

        return cn;
    }

    /**【方式1】
     * HashMap---实现英译汉
     * @param en
     * @return
     */
    private static String processData2(String en){
        //todo:扩展英译汉项目2021.4.14：数据库➕爬虫
        String cn ="未知";
        cn=dirMap.get(en);
        return cn;
    }
}
