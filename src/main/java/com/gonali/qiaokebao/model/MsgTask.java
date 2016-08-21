package com.gonali.qiaokebao.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by TianyuanPan on 8/16/16.
 */
public class MsgTask implements Serializable {

    private long mtId;
    private long msgId;
    private String creatorId;
    private String geterId;
    private boolean isGeterFinish;
    private boolean isCreatorConfirm;
    private String mtStatus;
    private boolean isValid;
    private Date createDate;
    private Date finishDate;
    private Date confirmDate;


    public long getMtId() {
        return mtId;
    }

    public void setMtId(long mtId) {
        this.mtId = mtId;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getGeterId() {
        return geterId;
    }

    public void setGeterId(String geterId) {
        this.geterId = geterId;
    }

    public boolean isGeterFinish() {
        return isGeterFinish;
    }

    public void setGeterFinish(boolean geterFinish) {
        isGeterFinish = geterFinish;
    }

    public boolean isCreatorConfirm() {
        return isCreatorConfirm;
    }

    public void setCreatorConfirm(boolean creatorConfirm) {
        isCreatorConfirm = creatorConfirm;
    }

    public String getMtStatus() {
        return mtStatus;
    }

    public void setMtStatus(String mtStatus) {
        this.mtStatus = mtStatus;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }
}
