package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * 统一的信息类
 * 设置encoding contenttype
 * 打印
 */
public class ResultJSONUtils {
    /**
     * 此方法时注册使用的
     * @param response
     * @param jsonStr
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
        response.setContentType("appliction/text");
        PrintWriter writer = response.getWriter();

        //todo:不懂，查找ObjectMapper mapper
        ObjectMapper mapper = new ObjectMapper();
        writer.println(mapper.writeValueAsString(map));
    }
}
