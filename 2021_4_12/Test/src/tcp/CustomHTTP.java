package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 简易版HTTP
 */
public class CustomHTTP {
    private static final int port = 9004;
    public static void main(String[] args) throws IOException {
        //1.创建TCP服务器
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动~");
        //2.等待客户端连接
        Socket client = serverSocket.accept();
        //3.读写操作   得到两个读写对象
        try(
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(client.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(client.getOutputStream()))

        ){
            //读取首行信息【方法类型 URL HTTP版本号】
            String firstLine = bufferedReader.readLine();
            if(firstLine!=null&& !firstLine.equals("")){
                String[] fLine = firstLine.split(" ");
                String method = fLine[0];//读取请求方法类型
                String url = fLine[1];//读取URL
                String httpVersion = fLine[2];//读取版本号、
                System.out.println(String.format("读取到了客户端请求，方法类型：%s, URL：%s, 版本：%s",
                                                method,url,httpVersion));

                //4.业务逻辑处理
                String content = "<h1>未知</h1>";
                if(url.contains("404")){
                    content = "<h1>没有找到此页面</h1>";
                }else if(url.contains("200")){
                    content = "<h1>你好，世界</h1>";
                }

                //5.将结果返回给客户端--》打印到浏览器
                //写入首行
                bufferedWriter.write(httpVersion+" 200 ok\n");
                //写入head【Content-Type,Content_Length】
                bufferedWriter.write("Content-Type: text/html;charset=utf-8;\n");
                bufferedWriter.write("Content-Length: "+content.getBytes().length+"\n");
                //写入空行
                bufferedWriter.write("\n");
                //写入body
                bufferedWriter.write(content);
                //刷新缓存区
                bufferedWriter.flush();
            }
        }


    }
}
