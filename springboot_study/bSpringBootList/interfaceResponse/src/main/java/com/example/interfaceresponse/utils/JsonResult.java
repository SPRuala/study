package com.example.interfaceresponse.utils;

//相应工具类,回馈响应状态给前端(前端接受后根据不同反馈执行不同操作)
/**
 * 200:成功
 * 500: 错误,错误信息在massage字段中(广泛错误)
 * 501: bean验证错误,错误集以map形式返回
 * 502: 拦截器拦截用户token出错
 * 555: 抛出异常
 * 556: 用户qq校验异常
 * 557: 校验用户是否在CAS登录,用户门票校验
 */
public class JsonResult {
    //相应业务状态
    private Integer status;
    //响应消息
    private String massage;
    //响应数据(返回到前端)
    private Object data;

    public JsonResult(Object data) {
        this.data = data;
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

    public static JsonResult build(Integer status, String massage, Object data){
        return new JsonResult(status,massage,data);
    }
    public static JsonResult ok(Object data){
        return new JsonResult(200, "ok", data);
    }
    public static JsonResult ok(){
        return new JsonResult(200, "ok", null);
    }
    public static JsonResult normalError(String massage){
        return new JsonResult(500, massage, null);
    }
    public static JsonResult errorMap(Object data){
        return new JsonResult(501, "error map", data);
    }
    public static JsonResult errorToken(String massage){
        return new JsonResult(502, massage, null);
    }
}
