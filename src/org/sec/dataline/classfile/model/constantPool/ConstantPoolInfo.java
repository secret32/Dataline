package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class ConstantPoolInfo {

    protected byte tag;

    public ConstantPoolInfo(byte tag) {
        this.tag = tag;
    }

    public byte getTag() {
        return tag;
    }

}
