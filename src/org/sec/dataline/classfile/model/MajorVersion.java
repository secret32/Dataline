package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
@Deprecated
public class MajorVersion extends ByteCodeInteger {

    public MajorVersion() {
        super(BYTES_MAJOR_VERSION);
    }

    @Override
    public void visit(Integer value) {

    }
}
