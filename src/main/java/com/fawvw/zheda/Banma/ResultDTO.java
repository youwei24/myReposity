package com.fawvw.zheda.Banma;

public class ResultDTO<T> {
    private static final long serialVersionUID = 11010010101001l;
    protected boolean success;
    protected int errorCode;
    protected String errorMsg;
    protected String localizedMsg;
    protected T result;
    protected String traceId;

    protected ResultDTO(){

    }

    public static final <T> ResultDTO<T> getResult(T v, ResultCode resultCode){
        ResultDTO<T> result = new ResultDTO<T>();
        if (resultCode == null){
            resultCode = ResultCodes.SUCCESS;
        }
        result.setSuccess(resultCode.isSuccess());
        result.setErrorCode(resultCode.getCode());
        result.setErrorMsg(resultCode.getMessage());
        result.setLocalizedMsg(resultCode.getLocalizedMsg());
        result.setResult(v);
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getLocalizedMsg() {
        return localizedMsg;
    }

    public void setLocalizedMsg(String localizedMsg) {
        this.localizedMsg = localizedMsg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }
}
