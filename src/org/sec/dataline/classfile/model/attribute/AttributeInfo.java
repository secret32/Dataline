package org.sec.dataline.classfile.model.attribute;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class AttributeInfo {

    private short attributeNameIndex;
    private int attributeLength;
    private Attribute[] attributes;

    public short getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public void setAttributeNameIndex(short attributeNameIndex) {
        this.attributeNameIndex = attributeNameIndex;
    }

    public int getAttributeLength() {
        return attributeLength;
    }

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

    public Attribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }
}
