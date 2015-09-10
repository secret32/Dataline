package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class MethodHandleInfo extends ConstantPoolInfo {

    private byte referenceKind;
    private short referenceIndex;

    public MethodHandleInfo() {
        super(ConstantPoolTag.CONSTANT_MethodHandle.getValue());
    }

    public byte getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(byte referenceKind) {
        this.referenceKind = referenceKind;
    }

    public short getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(short referenceIndex) {
        this.referenceIndex = referenceIndex;
    }
}
