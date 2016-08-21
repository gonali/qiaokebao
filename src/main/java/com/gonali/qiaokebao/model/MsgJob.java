package com.gonali.qiaokebao.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by TianyuanPan on 8/15/16.
 */
public class MsgJob implements Serializable{

    private long msgId;
    private String creatorId;
    private long crsId;
    private String crsDefName;
    private String crsDefLocation;
    private Date crsDatetime;
    private String jobName;
    private String jobLocation;
    private String jobDescribe;
    private Date jobSDate;
    private Date jobEDate;
    private int credit;
    private int msgType;
    private String geterSex;
    private String msgStatus;
    private boolean isGeter;
    private Date createDate;
    private Date getDate;
    private boolean isValid;


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

    public long getCrsId() {
        return crsId;
    }

    public void setCrsId(long crsId) {
        this.crsId = crsId;
    }

    public String getCrsDefName() {
        return crsDefName;
    }

    public void setCrsDefName(String crsDefName) {
        this.crsDefName = crsDefName;
    }

    public String getCrsDefLocation() {
        return crsDefLocation;
    }

    public void setCrsDefLocation(String crsDefLocation) {
        this.crsDefLocation = crsDefLocation;
    }

    public Date getCrsDatetime() {
        return crsDatetime;
    }

    public void setCrsDatetime(Date crsDatetime) {
        this.crsDatetime = crsDatetime;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobDescribe() {
        return jobDescribe;
    }

    public void setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe;
    }

    public Date getJobSDate() {
        return jobSDate;
    }

    public void setJobSDate(Date jobSDate) {
        this.jobSDate = jobSDate;
    }

    public Date getJobEDate() {
        return jobEDate;
    }

    public void setJobEDate(Date jobEDate) {
        this.jobEDate = jobEDate;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getGeterSex() {
        return geterSex;
    }

    public void setGeterSex(String geterSex) {
        this.geterSex = geterSex;
    }

    public String getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(String msgStatus) {
        this.msgStatus = msgStatus;
    }

    public boolean isGeter() {
        return isGeter;
    }

    public void setGeter(boolean geter) {
        isGeter = geter;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
