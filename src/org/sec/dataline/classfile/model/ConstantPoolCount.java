package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
@Deprecated
public class ConstantPoolCount extends ByteCodeInteger {

    public ConstantPoolCount() {
        super(BYTES_CONSTANT_POOL_COUNT);
    }

    @Override
    public void visit(Integer value) {

    }
}
