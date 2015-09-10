package org.sec.dataline.classfile.model.attribute;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class StackMapTableAttribute extends Attribute {

    private short attributeNameIndex;
    private int attributeLength;
    private short numberOfEntries;
    private StackMapFrame[] entries;

    public StackMapTableAttribute() {
        super(50, 0);
    }

    private class StackMapFrame {
        // TODO
    }
}
