package com.lzwing.testcode.enumtest;
public enum  ReturnCodeEnum {

    OK ("200"),
    FEATURE_NOT_SUPPORT("100"), FEATURE_NOT_SUPPORT_DESC("功能暂不提供"),

    LOGIN_ERROR("201"), LOGIN_ERROR_DESC("登录错误"),
    LOGOUT_ERROR("202"), LGOOUT_ERROR_DESC("注销错误"),
    USER_INFO_ERROR("203"), USER_INFO_ERROR_DESC("用户信息获取错误"),
    USER_PREPASSWORD_ERROR("204"), USER_PREPASSWORD_ERROR_DESC("当前密码错误"),
    USER_CONFIRMPASSWORD_ERROR("205"), USER_CONFIRMPASSWORD_ERROR_DESC("新密码两次输入不一致"),

    RESULTSET_IS_ENPTY ("210"), RESULTSET_IS_ENPTY_DESC ("未找到结果"),
    DATE_FORMATE_ERROR("211"), DATE_FORMATE_ERROR_DESC("日期格式不正确"),
    DATE_CONVERT_ERROR("212"), DATE_CONVERT_ERROR_DESC("日期转换错误"),
    FILE_CREATE_ERROR("213"), FILE_CREATE_ERROR_DESC("文件创建错误"),
    FILE_WRITE_ERROR("214"), FILE_WRITE_ERROR_DESC("文件写入错误"),
    JSON_CONVERT_ERROR("215"), JSON_CONVERT_ERROR_DESC("JSON转换错误"),
    DOWNLOAD_FILE_ERROR("216"), DOWNLOAD_FILE_ERROR_DESC("文件下载错误"),
    DATA_CONVERT_ERROR("217"), DATA_CONVERT_ERROR_DESC("数据转换错误"),
    SORT_SIZE_ERROR("218"), SORT_SIZE_ERROR_DESC("结果集超过排序限制"),
    COMPARE_SIZE_ERROR("219"), COMPARE_SIZE_ERROR_DESC("对比配置不正确或对比项无结果"),

    CALLREASON_TYPE_ERROR("220"), CALLREASON_TYPE_ERROR_DESC("来电原因类型不存在"),
    INPUT_PARAMETER_ERROR("221"),INPUT_PARAMETER_ERROR_DESC("原因类别参数错误"),
    GOT_LISTEE_ERROR("222"),GOT_LISTEE_ERROR_DESC("获取列名错误"),
    GOT_INVALID_RESULT("223"),GOT_INVALID_RESULT_DESC("无效查询"),
    GOT_USER_ROLE_LIST_ERROR("224"),GOT_USER_ROLE_LIST_ERROR_DESC("获取角色列表错误"),
    MULTI_VALUE_CONFIG_ERROR("225"),MULTI_VALUE_CONFIG_ERROR_DESC("多值配置错误"),
    DUPLICATE_CALL_EMPTY_ERROR("226"),DUPLICATE_CALL_EMPTY_ERROR_DESC("无对应的重复来电信息"),

    WORKFLOW_SAVE_ERROR("230"),WORKFLOW_SAVE_ERROR_DESC("保存错误"),
    WORKFLOW_DELTET_ERROR("231"),WORKFLOW_DELTET_ERROR_DESC("删除错误"),
    WORKFLOW_GET_ERROR("232"),WORKFLOW_GET_ERROR_DESC("无法获取对应工作流"),
    WORKFLOWRESULT_GET_ERROR("232"),WORKFLOWRESULT_GET_ERROR_DESC("无法获取对应工作流结果"),
    WORKFLOWRESULT_RUNNING("233"),WORKFLOWRESULT_RUNNING_DESC("计算进行中，请稍候"),
    WORKFLOWRESULT_LOCK_ERROR("234"), WORKFLOWRESULT_LOCK_ERROR_DESC("工作流锁定错误"),
    OUTOF_DOWNLOAD_FILE_SIZE("235"), OUTOF_DOWNLOAD_FILE_SIZE_DESC("结果条数过多，不提供下载"),

    DEFAULT_ERROR ("400"), DEFAULT_ERROR_DESC ("定义错误"),
    UNAUTHORIZED_ERROR ("401"), UNAUTHORIZED_ERROR_DESC ("未授权，请登录"),
    FORBIDDEN_ERROR("403"), FORBIDDEN_ERROR_DESC("禁止访问"),
    ;

    private String nCode ;

    private ReturnCodeEnum( String _nCode) {
        this . nCode = _nCode;
    }

    @Override
    public String toString() {
        return String.valueOf ( this . nCode );
    }
}