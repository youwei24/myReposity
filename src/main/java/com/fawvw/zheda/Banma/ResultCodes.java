package com.fawvw.zheda.Banma;

public class ResultCodes {
    public static final ResultCode SUCCESS = new ResultCode(200,"success","成功");
    public static final ResultCode REQUEST_PARAM_ERROR = new ResultCode(460,"request parameter error","请求参数错误");;

    private ResultCodes(){}
    public static boolean isSuccess(int code){
        return 200 == code;
    }
}
