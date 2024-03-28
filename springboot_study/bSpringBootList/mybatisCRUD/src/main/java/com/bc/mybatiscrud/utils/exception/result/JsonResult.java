package com.bc.mybatiscrud.utils.exception.result;

public class JsonResult {
    //响应状态
    private Integer status;
    //响应消息
    private String massage;
    //响应数据(ok返回前端)
    private Object data;

    public JsonResult(Integer status, String massage) {
        this.status = status;
        this.massage = massage;
    }

    public JsonResult(Integer status, String massage, Object data) {
        this.status = status;
        this.massage = massage;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static JsonResult ok(Object data){
        return new JsonResult(200, "ok", data);
    }
    public static JsonResult dbOk(Object data){
        return new JsonResult(200, "数据库操作ok", data);
    }
    public static JsonResult normalError(Object data){
        return new JsonResult(500, "normalError",data);
    }
    public static JsonResult repeatIdError(Integer id){
        return new JsonResult(501, "id重复");
    }
    public static JsonResult errorMap(Object data){
        return new JsonResult(501, "error map", data);
    }
}
