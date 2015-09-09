package org.sec.dataline.classfile.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class Class {

    private int magic;
    private int minor;
    private int major;
    private int constantPoolCount;
    private ConstantPool constantPool;
    private int accessFlags;
    private int thisClass;
    private int superClass;
    private int interfacesCount;
    private int[] interfaces;
    private int fieldsCount;
    private Field[] fields;
    private int methodsCount;
    private Method[] methods;
    private int attributesCount;
    private Attribute[] attributes;

    private List<Integer> lengthList;
    private Integer position;

    public Class() {
        lengthList = new ArrayList<>(16);
        position = 0;
    }

    public int getNextLength() {
        return lengthList.get(position++);
    }

    public boolean hasNextLength() {
        return lengthList.size() > position;
    }

    public void setValue(int position, byte[] bytes) {
        switch (position) {
            case 0:
                break;
        }
    }

}
