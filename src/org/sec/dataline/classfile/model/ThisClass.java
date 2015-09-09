package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
@Deprecated
public class ThisClass extends ByteCodeInteger {
    public ThisClass() {
        super(BYTES_THIS_CLASS);
    }

    @Override
    public void visit(Integer value) {

    }
}
