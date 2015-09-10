package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class LongInfo extends ConstantPoolInfo {

    private int highBytes;
    private int lowBytes;

    public LongInfo() {
        super(ConstantPoolTag.CONSTANT_Long.getValue());
    }

    public int getHighBytes() {
        return highBytes;
    }

    public void setHighBytes(int highBytes) {
        this.highBytes = highBytes;
    }

    public int getLowBytes() {
        return lowBytes;
    }

    public void setLowBytes(int lowBytes) {
        this.lowBytes = lowBytes;
    }
}
