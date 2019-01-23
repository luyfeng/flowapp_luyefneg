package bishe.lu.pojo;


import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @Title: LeeJSONResult.java
 * @Package com.lee.utils
 * @Description: 自定义响应数据结构
 * 				这个类是提供给门户，ios，安卓，微信商城用的
 * 				门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 				其他自行处理
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 *
 * @author leechenxiang
 * @date 2019年01月23日 下午4:09:36
 * @version V1.0
 */
public class LuJSONResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    private String ok;	// 不使用

    public static LuJSONResult build(Integer status, String msg, Object data) {
        return new LuJSONResult(status, msg, data);
    }

    public static LuJSONResult ok(Object data) {
        return new LuJSONResult(data);
    }

    public static LuJSONResult ok() {
        return new LuJSONResult(null);
    }

    public static LuJSONResult errorMsg(String msg) {
        return new LuJSONResult(500, msg, null);
    }

    public static LuJSONResult errorMap(Object data) {
        return new LuJSONResult(501, "error", data);
    }

    public static LuJSONResult errorTokenMsg(String msg) {
        return new LuJSONResult(502, msg, null);
    }

    public static LuJSONResult errorException(String msg) {
        return new LuJSONResult(555, msg, null);
    }

    public LuJSONResult() {

    }

//    public static LeeJSONResult build(Integer status, String msg) {
//        return new LeeJSONResult(status, msg, null);
//    }

    public LuJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public LuJSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     *
     * @Description: 将json结果集转化为LeeJSONResult对象
     * 				需要转换的对象是一个类
     * @param jsonData
     * @param clazz
     * @return
     *
     * @author leechenxiang
     * @date 2019年01月23日
     */
    public static LuJSONResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, LuJSONResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     *
     * @Description: 没有object对象的转化
     * @param json
     * @return
     *
     * @author leechenxiang
     * @date 2019年01月23日
     */
    public static LuJSONResult format(String json) {
        try {
            return MAPPER.readValue(json, LuJSONResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @Description: Object是集合转化
     * 				需要转换的对象是一个list
     * @param jsonData
     * @param clazz
     * @return
     *
     * @author leechenxiang
     * @date 2019年01月23日
     */
    public static LuJSONResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}