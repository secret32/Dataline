package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
@Deprecated
public class MinorVersion extends ByteCodeInteger {

    public MinorVersion() {
        super(BYTES_MINOR_VERSION);
    }

    @Override
    public void visit(Integer value) {

    }
}
