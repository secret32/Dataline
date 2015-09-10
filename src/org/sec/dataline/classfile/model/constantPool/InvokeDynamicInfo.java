package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class InvokeDynamicInfo extends ConstantPoolInfo {

    private short bootstrapMethodAttrIndex;
    private short nameAndTypeIndex;

    public InvokeDynamicInfo() {
        super(ConstantPoolTag.CONSTANT_InvokeDynamic.getValue());
    }

    public short getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public void setBootstrapMethodAttrIndex(short bootstrapMethodAttrIndex) {
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(short nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }
}