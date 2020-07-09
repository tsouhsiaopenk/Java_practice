package zxp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtil {
    private static volatile ObjectMapper MAPPER;

    private static ObjectMapper getMAPPER() {
        if (MAPPER == null) {
            synchronized (JSONUtil.class) {
                if (MAPPER == null) {
                    MAPPER = new ObjectMapper();
                }
            }
        }
        return MAPPER;
    }

    /**
     * 对象序列化为json字符串
     */
    public static String serialize(Object o) {
        try {
            return getMAPPER().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("序列化出错:" + o, e);
        }
    }
    /**
     * 反序列化输入流中的json字符串为Java对象
     * http请求发送json数据，需要在请求头 Content-type=application/json
     *   HttpServletRequest 获取json字符串，只能通过输入流获取
     */
    public static <T> T deserialize(InputStream is, Class<T> valueType){
        try {
            return getMAPPER().readValue(is,valueType);
        } catch (IOException e) {
            throw new RuntimeException("反序列化json字符串出错", e);
        }
    }
}
