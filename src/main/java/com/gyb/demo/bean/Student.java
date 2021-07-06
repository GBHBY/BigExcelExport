package com.gyb.demo.bean;

import java.io.Serializable;

/**
 * student
 * @author 
 */
public class Student implements Serializable {
    private Integer sId;

    private String sName;

    private String sBirth;

    private String sSex;

    private String sAddress;

    private String sMessage;

    private String sTest1;

    private String sTest2;

    private String sTest3;

    private static final long serialVersionUID = 1L;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsBirth() {
        return sBirth;
    }

    public void setsBirth(String sBirth) {
        this.sBirth = sBirth;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsMessage() {
        return sMessage;
    }

    public void setsMessage(String sMessage) {
        this.sMessage = sMessage;
    }

    public String getsTest1() {
        return sTest1;
    }

    public void setsTest1(String sTest1) {
        this.sTest1 = sTest1;
    }

    public String getsTest2() {
        return sTest2;
    }

    public void setsTest2(String sTest2) {
        this.sTest2 = sTest2;
    }

    public String getsTest3() {
        return sTest3;
    }

    public void setsTest3(String sTest3) {
        this.sTest3 = sTest3;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Student other = (Student) that;
        return (this.getsId() == null ? other.getsId() == null : this.getsId().equals(other.getsId()))
            && (this.getsName() == null ? other.getsName() == null : this.getsName().equals(other.getsName()))
            && (this.getsBirth() == null ? other.getsBirth() == null : this.getsBirth().equals(other.getsBirth()))
            && (this.getsSex() == null ? other.getsSex() == null : this.getsSex().equals(other.getsSex()))
            && (this.getsAddress() == null ? other.getsAddress() == null : this.getsAddress().equals(other.getsAddress()))
            && (this.getsMessage() == null ? other.getsMessage() == null : this.getsMessage().equals(other.getsMessage()))
            && (this.getsTest1() == null ? other.getsTest1() == null : this.getsTest1().equals(other.getsTest1()))
            && (this.getsTest2() == null ? other.getsTest2() == null : this.getsTest2().equals(other.getsTest2()))
            && (this.getsTest3() == null ? other.getsTest3() == null : this.getsTest3().equals(other.getsTest3()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getsName() == null) ? 0 : getsName().hashCode());
        result = prime * result + ((getsBirth() == null) ? 0 : getsBirth().hashCode());
        result = prime * result + ((getsSex() == null) ? 0 : getsSex().hashCode());
        result = prime * result + ((getsAddress() == null) ? 0 : getsAddress().hashCode());
        result = prime * result + ((getsMessage() == null) ? 0 : getsMessage().hashCode());
        result = prime * result + ((getsTest1() == null) ? 0 : getsTest1().hashCode());
        result = prime * result + ((getsTest2() == null) ? 0 : getsTest2().hashCode());
        result = prime * result + ((getsTest3() == null) ? 0 : getsTest3().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sId=").append(sId);
        sb.append(", sName=").append(sName);
        sb.append(", sBirth=").append(sBirth);
        sb.append(", sSex=").append(sSex);
        sb.append(", sAddress=").append(sAddress);
        sb.append(", sMessage=").append(sMessage);
        sb.append(", sTest1=").append(sTest1);
        sb.append(", sTest2=").append(sTest2);
        sb.append(", sTest3=").append(sTest3);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}