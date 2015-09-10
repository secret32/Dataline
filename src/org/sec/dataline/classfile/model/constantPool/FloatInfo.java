package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class FloatInfo extends ConstantPoolInfo {

    private int bytes;

    public FloatInfo() {
        super(ConstantPoolTag.CONSTANT_Float.getValue());
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
}
