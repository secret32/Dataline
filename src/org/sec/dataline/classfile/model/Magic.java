package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
@Deprecated
public class Magic extends ByteCodeInteger {

    public Magic() {
        super(BYTES_MAGIC);
    }

    @Override
    public void visit(Integer value) {
        if (value.equals(MAGIC)) {
            this.setValue(value);
        }
    }
}
