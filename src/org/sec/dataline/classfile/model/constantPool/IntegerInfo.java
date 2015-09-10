package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class IntegerInfo extends ConstantPoolInfo {

    private int bytes;

    public IntegerInfo() {
        super(ConstantPoolTag.CONSTANT_Integer.getValue());
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
}
