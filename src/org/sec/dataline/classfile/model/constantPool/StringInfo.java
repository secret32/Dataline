package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class StringInfo extends ConstantPoolInfo {
    private short stringIndex;

    public StringInfo() {
        super(ConstantPoolTag.CONSTANT_String.getValue());
    }

    public short getStringIndex() {
        return stringIndex;
    }

    public void setStringIndex(short stringIndex) {
        this.stringIndex = stringIndex;
    }
}
