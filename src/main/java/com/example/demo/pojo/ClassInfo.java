package com.example.demo.pojo;

import java.io.Serializable;

/**
 * class_info
 * @author 
 */
public class ClassInfo implements Serializable {
    private Integer classId;

    private String className;

    /**
     * 注释
     */
    private String classDetial;

    private static final long serialVersionUID = 1L;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassDetial() {
        return classDetial;
    }

    public void setClassDetial(String classDetial) {
        this.classDetial = classDetial;
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
        ClassInfo other = (ClassInfo) that;
        return (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()))
            && (this.getClassDetial() == null ? other.getClassDetial() == null : this.getClassDetial().equals(other.getClassDetial()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        result = prime * result + ((getClassDetial() == null) ? 0 : getClassDetial().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classId=").append(classId);
        sb.append(", className=").append(className);
        sb.append(", classDetial=").append(classDetial);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}