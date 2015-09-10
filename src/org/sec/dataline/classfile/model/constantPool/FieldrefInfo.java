package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class FieldrefInfo extends ConstantPoolInfo {

    private short classIndex;
    private short nameAndTypeIndex;

    public FieldrefInfo() {
        super(ConstantPoolTag.CONSTANT_Fieldref.getValue());
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
