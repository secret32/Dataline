package org.sec.dataline.classfile.model.attribute;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class CodeAttribute extends Attribute {

    private short attributeNameIndex;
    private int attributeLength;
    private short maxStack;
    private short maxLocals;
    private int codeLength;
    private byte[] codes;
    private short exceptionTableLength;
    private ExceptionTable[] exceptionTables;
    private short attributes_count;
    private AttributeInfo[] attributes;

    public CodeAttribute() {
        super(45, 3);
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

    public void setAttributeLength(int attributeLength) {
        this.attributeLength = attributeLength;
    }

    public short getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(short maxStack) {
        this.maxStack = maxStack;
    }

    public short getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(short maxLocals) {
        this.maxLocals = maxLocals;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public byte[] getCodes() {
        return codes;
    }

    public void setCodes(byte[] codes) {
        this.codes = codes;
    }

    public short getExceptionTableLength() {
        return exceptionTableLength;
    }

    public void setExceptionTableLength(short exceptionTableLength) {
        this.exceptionTableLength = exceptionTableLength;
    }

    public ExceptionTable[] getExceptionTables() {
        return exceptionTables;
    }

    public void setExceptionTables(ExceptionTable[] exceptionTables) {
        this.exceptionTables = exceptionTables;
    }

    public short getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(short attributes_count) {
        this.attributes_count = attributes_count;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }

    private class ExceptionTable {

        private short startPc;
        private short endPc;
        private short handlerPc;
        private short catchType;

        public short getStartPc() {
            return startPc;
        }

        public void setStartPc(short startPc) {
            this.startPc = startPc;
        }

        public short getEndPc() {
            return endPc;
        }

        public void setEndPc(short endPc) {
            this.endPc = endPc;
        }

        public short getHandlerPc() {
            return handlerPc;
        }

        public void setHandlerPc(short handlerPc) {
            this.handlerPc = handlerPc;
        }

        public short getCatchType() {
            return catchType;
        }

        public void setCatchType(short catchType) {
            this.catchType = catchType;
        }
    }

}
