package org.sec.dataline.classfile.model.constantPool;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class ClassInfo extends ConstantPoolInfo {

    private short nameIndex;

    public ClassInfo() {
        super(ConstantPoolTag.CONSTANT_Class.getValue());
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

}
