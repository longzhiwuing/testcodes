package com.lzwing.testcode.pluginsDemo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/6
 * Time: 12:05
 */
public class GsonFormat {

    //快捷键 ALT+S

    public static void main(String[] args) {
        GsonFormat format = new GsonFormat();


    }

    /**
     * status : 500
     * msg : 商品id不能为空
     * data : null
     * ok : null
     */

    private int status;
    private String msg;
    private Object data;
    private Object ok;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public Object getOk() {
        return ok;
    }

    public void setOk(Object ok) {
        this.ok = ok;
    }
}
