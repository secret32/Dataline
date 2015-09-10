package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class AccessFlags {

    public static final int ACC_PUBLIC = 0X0001;
    public static final int ACC_FINAL = 0x0010;
    public static final int ACC_SUPER = 0x0020;
    public static final int ACC_INTERFACE = 0x0200;
    public static final int ACC_ABSTRACT = 0x0400;
    public static final int ACC_SYNTHETIC = 0x1000;
    public static final int ACC_ANNOTATION = 0x2000;
    public static final int ACC_ENUM = 0x4000;

    // Field Access Flags
    public static final int ACC_PRIVATE = 0X0002;
    public static final int ACC_PROTECTED = 0X0004;
    public static final int ACC_STATIC = 0X0008;
    public static final int ACC_VOLATILE = 0X0040;
    public static final int ACC_TRANSIENT = 0X0080;

}
