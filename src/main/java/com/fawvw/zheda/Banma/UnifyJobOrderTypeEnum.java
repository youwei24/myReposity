package com.fawvw.zheda.Banma;

import org.springframework.util.CollectionUtils;

/**
 * 枚举类型与抽象方法相结合
 */

public enum  UnifyJobOrderTypeEnum {
    /**
     * 获取日志
     */
    LOG_OBTAIN("log_obtain"){
        @Override
        public ResultDTO<Boolean> validTaskOrderContent(TaskOrderInfoDTO taskOrderInfoDTO){
            if (taskOrderInfoDTO.getTaskId() == null || CollectionUtils.isEmpty(taskOrderInfoDTO.getVins())){
                ResultDTO.getResult(Boolean.FALSE,ResultCodes.REQUEST_PARAM_ERROR);
            }
            return ResultDTO.getResult(Boolean.TRUE,ResultCodes.SUCCESS);
        }

    },
    //Enum类中 各个参数之间用逗号间隔，需注意

    /**
     * 获取日志
     */
    STATUS_DIAGNOSIS("status_diagnosis"){
        @Override
        public ResultDTO<Boolean> validTaskOrderContent(TaskOrderInfoDTO taskOrderInfoDTO){
            if (taskOrderInfoDTO.getTaskId() == null || CollectionUtils.isEmpty(taskOrderInfoDTO.getVins())){
                ResultDTO.getResult(Boolean.FALSE,ResultCodes.REQUEST_PARAM_ERROR);
            }
            return ResultDTO.getResult(Boolean.TRUE,ResultCodes.SUCCESS);
        }

    };
    //Enum类中 最后一个需用分号表示结束，需注意

    private String type;

    UnifyJobOrderTypeEnum(String type) {
        this.type = type;
    }

    public static UnifyJobOrderTypeEnum getEnumByType(String type){
        for (UnifyJobOrderTypeEnum e:UnifyJobOrderTypeEnum.values()){
            if (e.getType().equals(type)){
                return e;
            }
        }
        return null;
    }
    public String getType(){return type;}
    /**
     * 校验每个指令类型入参的准确性
     */
    public abstract ResultDTO<Boolean> validTaskOrderContent(TaskOrderInfoDTO taskOrderInfoDTO);

}
