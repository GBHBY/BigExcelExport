package com.gyb.demo.bean;

import java.io.Serializable;

/**
 * student
 * @author 
 */
public class Student implements Serializable {
    private String sId;

    private String sName;

    private String sBirth;

    private String sSex;

    private static final long serialVersionUID = 1L;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
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
            && (this.getsSex() == null ? other.getsSex() == null : this.getsSex().equals(other.getsSex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getsId() == null) ? 0 : getsId().hashCode());
        result = prime * result + ((getsName() == null) ? 0 : getsName().hashCode());
        result = prime * result + ((getsBirth() == null) ? 0 : getsBirth().hashCode());
        result = prime * result + ((getsSex() == null) ? 0 : getsSex().hashCode());
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}