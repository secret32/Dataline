package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class MethodTypeInfo extends ConstantPoolInfo {

    private short descriptorIndex;

    public MethodTypeInfo() {
        super(ConstantPoolTag.CONSTANT_MethodType.getValue());
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }
}
