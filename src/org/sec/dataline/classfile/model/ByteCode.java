package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
abstract class ByteCode<V> implements ByteCodeVisitor<V> {

    public static final int MAGIC = 0XCAFEBABE;
    public static final int BYTES_MAGIC = 4;
    public static final int BYTES_MINOR_VERSION = 2;
    public static final int BYTES_MAJOR_VERSION = 2;
    public static final int BYTES_CONSTANT_POOL_COUNT = 2;
    public static final int BYTES_ACCESS_FLAGS = 2;
    public static final int BYTES_THIS_CLASS = 2;
    public static final int BYTES_SUPER_CLASS = 2;
    public static final int BYTES_INTERFACES_COUNT = 2;
    public static final int BYTES_FIELDS_COUNT = 2;
    public static final int BYTES_METHODS_COUNT = 2;
    public static final int BYTES_ATTRIBUTES_COUNT = 2;

    private int length;

    private V value;

    protected ByteCode(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    protected void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

}
