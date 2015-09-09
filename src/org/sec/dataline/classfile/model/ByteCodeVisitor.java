package org.sec.dataline.classfile.model;

/**
 * @author zhou_wei
 * @since v0.1
 */
@FunctionalInterface
public interface ByteCodeVisitor<T> {

    public void visit(T value);

}
