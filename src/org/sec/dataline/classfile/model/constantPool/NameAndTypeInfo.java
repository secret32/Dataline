package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class NameAndTypeInfo extends ConstantPoolInfo {

    private short nameIndex;
    private short descriptorIndex;

    public NameAndTypeInfo() {
        super(ConstantPoolTag.CONSTANT_NameAndType.getValue());
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }
}
