package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class MethodrefInfo extends ConstantPoolInfo {
    private short classIndex;
    private short nameAndTypeIndex;

    public MethodrefInfo() {
        super(ConstantPoolTag.CONSTANT_Methodref.getValue());
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(short nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public short getClassIndex() {
        return classIndex;
    }

    public void setClassIndex(short classIndex) {
        this.classIndex = classIndex;
    }
}
