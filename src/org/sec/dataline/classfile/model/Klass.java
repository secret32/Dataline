package org.sec.dataline.classfile.model;

import org.sec.dataline.classfile.model.attribute.AttributeInfo;
import org.sec.dataline.classfile.model.constantPool.ConstantPoolInfo;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class Klass {

    private int magic;
    private short minorVersion;
    private short majorVersion;
    private short constantPoolCount;
    private ConstantPoolInfo[] constantPool;
    private short accessFlags;
    private short thisClass;
    private short superClass;
    private short interfacesCount;
    private short[] interfaces;
    private short fieldsCount;
    private Field[] fields;
    private short methodsCount;
    private Method[] methods;
    private short attributesCount;
    private AttributeInfo[] attributes;

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public short getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(short minorVersion) {
        this.minorVersion = minorVersion;
    }

    public short getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(short majorVersion) {
        this.majorVersion = majorVersion;
    }

    public short getConstantPoolCount() {
        return constantPoolCount;
    }

    public void setConstantPoolCount(short constantPoolCount) {
        this.constantPoolCount = constantPoolCount;
    }

    public ConstantPoolInfo[] getConstantPool() {
        return constantPool;
    }

    public void setConstantPool(ConstantPoolInfo[] constantPool) {
        this.constantPool = constantPool;
    }

    public short getAccessFlags() {
        return accessFlags;
    }

    public void setAccessFlags(short accessFlags) {
        this.accessFlags = accessFlags;
    }

    public short getThisClass() {
        return thisClass;
    }

    public void setThisClass(short thisClass) {
        this.thisClass = thisClass;
    }

    public short getSuperClass() {
        return superClass;
    }

    public void setSuperClass(short superClass) {
        this.superClass = superClass;
    }

    public short getInterfacesCount() {
        return interfacesCount;
    }

    public void setInterfacesCount(short interfacesCount) {
        this.interfacesCount = interfacesCount;
    }

    public short[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(short[] interfaces) {
        this.interfaces = interfaces;
    }

    public short getFieldsCount() {
        return fieldsCount;
    }

    public void setFieldsCount(short fieldsCount) {
        this.fieldsCount = fieldsCount;
    }

    public Field[] getFields() {
        return fields;
    }

    public void setFields(Field[] fields) {
        this.fields = fields;
    }

    public short getMethodsCount() {
        return methodsCount;
    }

    public void setMethodsCount(short methodsCount) {
        this.methodsCount = methodsCount;
    }

    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public short getAttributesCount() {
        return attributesCount;
    }

    public void setAttributesCount(short attributesCount) {
        this.attributesCount = attributesCount;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }
}
