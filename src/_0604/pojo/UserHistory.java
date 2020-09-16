package _0604.pojo;

import java.util.Date;

/**
 * @author sunyong
 * @date 2020/06/04
 * @description
 */
public class UserHistory {
    private int hid;
    private int uid;
    private String editType;
    private String editMsg;
    private Date editDate;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getEditType() {
        return editType;
    }

    public void setEditType(String editType) {
        this.editType = editType;
    }

    public String getEditMsg() {
        return editMsg;
    }

    public void setEditMsg(String editMsg) {
        this.editMsg = editMsg;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }
}
