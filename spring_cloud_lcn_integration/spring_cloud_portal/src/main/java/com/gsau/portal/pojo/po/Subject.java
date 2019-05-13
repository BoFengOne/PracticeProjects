package com.gsau.portal.pojo.po;


import java.beans.Transient;

/**
 * @author WangGuoQing
 * @date 2019/5/13 21:18
 * @Desc
 * 科目
 * 软件工程
 * 信息系统集成
 * 软件工程师
 */
@Entity
@Table(name="tb_subject")
public class Subject {
    @Id
    public String subjectid;
    public String subjectname;
    public String mstatus;
    public String parentid;
    public long ctime;
    public int mlevel;

    @Transient
    public boolean selected = false;

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }

    public long getCtime() {
        return ctime;
    }

    public void setCtime(long ctime) {
        this.ctime = ctime;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public int getMlevel() {
        return mlevel;
    }

    public void setMlevel(int mlevel) {
        this.mlevel = mlevel;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}