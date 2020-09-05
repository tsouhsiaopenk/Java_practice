package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    // 查询学生住宿信息，需要响应的数据
    private boolean success;
    private String code;
    private String message;
    private Integer total;
    private Object data;
    private String stackTrace;
}
