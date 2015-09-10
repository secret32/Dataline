package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class Utf8Info extends ConstantPoolInfo {

    private short length;
    private byte[] bytes;

    public Utf8Info() {
        super(ConstantPoolTag.CONSTANT_Utf8.getValue());
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
