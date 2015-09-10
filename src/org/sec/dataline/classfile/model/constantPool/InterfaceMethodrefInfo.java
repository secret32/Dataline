package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class InterfaceMethodrefInfo extends ConstantPoolInfo {

    private short classIndex;
    private short nameAndTypeIndex;

    public InterfaceMethodrefInfo() {
        super(ConstantPoolTag.CONSTANT_InterfaceMethodref.getValue());
    }

    public short getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(short classIndex) {
        this.classIndex = classIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(short nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}
