package com.fawvw.zheda.Banma;

import java.io.Serializable;

public class ResultCode implements Serializable {
    private static final long serialVersionUID = 22229929L;
    private final int code;
    private final String message;
    private final String localizedMsg;

    public ResultCode(int code, String message, String localizedMsg) {
        this.code = code;
        this.message = message;
        this.localizedMsg = localizedMsg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getLocalizedMsg() {
        return localizedMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }else if (o != null && this.getClass() == o.getClass()){
            ResultCode that = (ResultCode) o;
            return this.code == that.code;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.code;
    }
    public boolean isSuccess(){
        return 200 == this.code;
    }
}
