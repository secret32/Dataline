package org.sec.dataline.classfile.model.attribute;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class ConstantValue extends Attribute {

    private short attributeNameIndex;
    private int attributeLength;
    private short constantValueIndex;

    public ConstantValue() {
        super(45, 3);
        attributeLength = 2;
    }

    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public short getConstantValueIndex() {
        return constantValueIndex;
    }

    public void setConstantValueIndex(short constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }
}
