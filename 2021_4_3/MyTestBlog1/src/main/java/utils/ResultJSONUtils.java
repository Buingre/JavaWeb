package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 统一的信息类：公共的返回方法
 * 设置encoding contenttype
 * 打印
 */
public class ResultJSONUtils {
    /**
     * 此方法时注册使用的
     * @param response
     * @param jsonStr  传入的json字符串
     * @throws IOException
     */
    public static void write(HttpServletResponse response, String jsonStr) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("appliction/text");
        PrintWriter writer = response.getWriter();
        writer.println(jsonStr);

    }

    /**
     * 此方法是在登录时使用的
     * @param response
     * @param map
     * @throws IOException
     */
    public static void writeMap(HttpServletResponse response, HashMap<String,Object> map) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("appliction/json");
        PrintWriter writer = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();
        writer.println(mapper.writeValueAsString(map));
    }
}
