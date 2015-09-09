package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class AccessFlags extends ByteCodeInteger {

    public static final int ACC_PUBLIC = 0X0001;
    public static final int ACC_FINAL = 0x0010;
    public static final int ACC_SUPER = 0x0020;
    public static final int ACC_INTERFACE = 0x0200;
    public static final int ACC_ABSTRACT = 0x0400;
    public static final int ACC_SYNTHETIC = 0x1000;
    public static final int ACC_ANNOTATION = 0x2000;
    public static final int ACC_ENUM = 0x4000;

    public AccessFlags() {
        super(BYTES_ACCESS_FLAGS);
    }

    @Override
    public void visit(Integer value) {

    }
}
