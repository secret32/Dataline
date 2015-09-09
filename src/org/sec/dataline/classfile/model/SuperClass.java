package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
@Deprecated
public class SuperClass extends ByteCodeInteger {
    public SuperClass() {
        super(BYTES_SUPER_CLASS);
    }

    @Override
    public void visit(Integer value) {

    }
}
