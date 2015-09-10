package org.sec.dataline.classfile;

import org.sec.dataline.classfile.model.ByteCode;
import org.sec.dataline.classfile.model.Klass;
import org.sec.dataline.classfile.model.constantPool.ClassInfo;
import org.sec.dataline.classfile.model.constantPool.ConstantPoolInfo;
import org.sec.dataline.classfile.model.constantPool.ConstantPoolTag;
import org.sec.dataline.classfile.model.constantPool.DoubleInfo;
import org.sec.dataline.classfile.model.constantPool.FieldrefInfo;
import org.sec.dataline.classfile.model.constantPool.FloatInfo;
import org.sec.dataline.classfile.model.constantPool.IntegerInfo;
import org.sec.dataline.classfile.model.constantPool.InterfaceMethodrefInfo;
import org.sec.dataline.classfile.model.constantPool.InvokeDynamicInfo;
import org.sec.dataline.classfile.model.constantPool.LongInfo;
import org.sec.dataline.classfile.model.constantPool.MethodHandleInfo;
import org.sec.dataline.classfile.model.constantPool.MethodTypeInfo;
import org.sec.dataline.classfile.model.constantPool.MethodrefInfo;
import org.sec.dataline.classfile.model.constantPool.NameAndTypeInfo;
import org.sec.dataline.classfile.model.constantPool.StringInfo;
import org.sec.dataline.classfile.model.constantPool.Utf8Info;
import org.sec.dataline.exception.ErrorCode;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class ClassReader {

    private enum ReadStatus {
        READY,
        // ------------------
        MAGIC,
        MINOR_VERSION,
        MAJOR_VERSION,
        CONSTANT_POOL_COUNT,
        CONSTANT_POOL,
        ACCESS_FLAGS,
        THIS_CLASS,
        SUPER_CLASS,
        INTERFACES_COUNT,
        INTERFACES,
        FIELDS_COUNT,
        FIELDS,
        METHODS_COUNT,
        METHODS,
        ATTRIBUTES_COUNT,
        ATTRIBUTES,
        // ------------------
        OVER;
    }

    private ReadStatus readStatus;
    private int position = 0;
    private int readLength = 0;

    public Klass read(String filepath) {
        if (filepath.endsWith(".class")) {
            Path path = Paths.get(filepath);
            if (!Files.isDirectory(path) || Files.isReadable(path)) {
                try (SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ)) {
                    Klass klass = new Klass();
                    readStatus = ReadStatus.READY;
                    // Now read all bytes of the class file at once. Actually, the ReadStatus is not necessary.
                    // The size of a class file should be less than Integer.MAX at all time.
                    ByteBuffer buffer = ByteBuffer.allocate((int) Files.size(path));
                    while (channel.read(buffer) != -1) {
                        if (readStatus == ReadStatus.READY) {
                            klass.setMagic(buffer.getInt(position));
                            position += ByteCode.BYTES_MAGIC;
                            readStatus = ReadStatus.MAGIC;
                        }
                        if (readStatus == ReadStatus.MAGIC) {
                            klass.setMinorVersion(buffer.getShort(position));
                            position += ByteCode.BYTES_MINOR_VERSION;
                            readStatus = ReadStatus.MINOR_VERSION;
                        }
                        if (readStatus == ReadStatus.MINOR_VERSION) {
                            klass.setMajorVersion(buffer.getShort(position));
                            position += ByteCode.BYTES_MAJOR_VERSION;
                            readStatus = ReadStatus.MAJOR_VERSION;
                        }
                        if (readStatus == ReadStatus.MAJOR_VERSION) {
                            klass.setConstantPoolCount(buffer.getShort(position));
                            position += ByteCode.BYTES_CONSTANT_POOL_COUNT;
                            readStatus = ReadStatus.CONSTANT_POOL_COUNT;
                        }
                        if (readStatus == ReadStatus.CONSTANT_POOL_COUNT) {
                            ConstantPoolInfo[] infos = readConstantPool(buffer, klass.getConstantPoolCount() - 1);
                            klass.setConstantPool(infos);
                            readStatus = ReadStatus.CONSTANT_POOL;
                        }
                        if (readStatus == ReadStatus.CONSTANT_POOL) {
                            klass.setAccessFlags(buffer.getShort(position));
                            position += ByteCode.BYTES_ACCESS_FLAGS;
                            readStatus = ReadStatus.ACCESS_FLAGS;
                        }
                        if (readStatus == ReadStatus.ACCESS_FLAGS) {
                            klass.setThisClass(buffer.getShort(position));
                            position += ByteCode.BYTES_THIS_CLASS;
                            readStatus = ReadStatus.THIS_CLASS;
                        }
                        if (readStatus == ReadStatus.THIS_CLASS) {
                            klass.setSuperClass(buffer.getShort(position));
                            position += ByteCode.BYTES_SUPER_CLASS;
                            readStatus = ReadStatus.SUPER_CLASS;
                        }
                        if (readStatus == ReadStatus.THIS_CLASS) {
                            klass.setInterfacesCount(buffer.getShort(position));
                            position += ByteCode.BYTES_INTERFACES_COUNT;
                            readStatus = ReadStatus.INTERFACES_COUNT;
                        }
                        if (readStatus == ReadStatus.INTERFACES_COUNT) {
                            int count = klass.getInterfacesCount();
                            short[] interfaces = new short[count];
                            for (int i = 0; i < count; i++) {
                                interfaces[i] = buffer.get(position);
                                position += 2;
                            }
                            klass.setInterfaces(interfaces);
                            readStatus = ReadStatus.INTERFACES;
                        }
                        if (readStatus == ReadStatus.INTERFACES) {
                            klass.setFieldsCount(buffer.getShort(position));
                            position += ByteCode.BYTES_FIELDS_COUNT;
                            readStatus = ReadStatus.FIELDS_COUNT;
                        }
                        if (readStatus == ReadStatus.FIELDS_COUNT) {
                            // TODO read fields
                            readStatus = ReadStatus.FIELDS;
                        }
                        if (readStatus == ReadStatus.FIELDS) {
                            klass.setMethodsCount(buffer.getShort(position));
                            position += ByteCode.BYTES_METHODS_COUNT;
                            readStatus = ReadStatus.METHODS_COUNT;
                        }
                        if (readStatus == ReadStatus.METHODS_COUNT) {
                            // TODO read methods
                            readStatus = ReadStatus.METHODS;
                        }
                        if (readStatus == ReadStatus.METHODS) {
                            klass.setAttributesCount(buffer.getShort(position));
                            position += ByteCode.BYTES_ATTRIBUTES_COUNT;
                            readStatus = ReadStatus.ATTRIBUTES_COUNT;
                        }
                        if (readStatus == ReadStatus.ATTRIBUTES_COUNT) {
                            // TODO read attributes
                            readStatus = ReadStatus.ATTRIBUTES;
                        }
                        readStatus = ReadStatus.OVER;
                        if (buffer.hasRemaining()) {
                            System.err.println("remain byte code");
                        }
                    }
                    return klass;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw ErrorCode.INVALID_FILE.toException();
            }
        }
        throw ErrorCode.ERROR_FILE.toException();
    }

    private ConstantPoolInfo[] readConstantPool(ByteBuffer buffer, int constantPoolCount) {
        ConstantPoolInfo[] infos = new ConstantPoolInfo[constantPoolCount];
        int length = 0;
        if (constantPoolCount > 0) {
            while (length < constantPoolCount) {
                byte tag = buffer.get(position);
                position += 1;
                if (tag == ConstantPoolTag.CONSTANT_Class.getValue()) {
                    ClassInfo info = new ClassInfo();
                    info.setNameIndex(buffer.getShort(position));
                    position += 2;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_Double.getValue()) {
                    DoubleInfo info = new DoubleInfo();
                    info.setHighBytes(buffer.getInt(position));
                    position += 4;
                    info.setLowBytes(buffer.getInt(position));
                    position += 4;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_Fieldref.getValue()) {
                    FieldrefInfo info = new FieldrefInfo();
                    info.setClassIndex(buffer.getShort(position));
                    position += 2;
                    info.setNameAndTypeIndex(buffer.getShort(position));
                    position += 2;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_Float.getValue()) {
                    FloatInfo info = new FloatInfo();
                    info.setBytes(buffer.getInt(position));
                    position += 4;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_Integer.getValue()) {
                    IntegerInfo info = new IntegerInfo();
                    info.setBytes(buffer.getInt(position));
                    position += 4;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_InterfaceMethodref.getValue()) {
                    InterfaceMethodrefInfo info = new InterfaceMethodrefInfo();
                    info.setClassIndex(buffer.getShort(position));
                    position += 2;
                    info.setNameAndTypeIndex(buffer.getShort(position));
                    position += 2;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_InvokeDynamic.getValue()) {
                    InvokeDynamicInfo info = new InvokeDynamicInfo();
                    info.setBootstrapMethodAttrIndex(buffer.getShort(position));
                    position += 2;
                    info.setNameAndTypeIndex(buffer.getShort(position));
                    position += 2;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_Long.getValue()) {
                    LongInfo info = new LongInfo();
                    info.setHighBytes(buffer.getInt(position));
                    position += 4;
                    info.setLowBytes(buffer.getInt(position));
                    position += 4;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_MethodHandle.getValue()) {
                    MethodHandleInfo info = new MethodHandleInfo();
                    info.setReferenceKind(buffer.get(position));
                    position += 1;
                    info.setReferenceIndex(buffer.getShort(position));
                    position += 2;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_Methodref.getValue()) {
                    MethodrefInfo info = new MethodrefInfo();
                    info.setClassIndex(buffer.getShort(position));
                    position += 2;
                    info.setNameAndTypeIndex(buffer.getShort(position));
                    position += 2;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_MethodType.getValue()) {
                    MethodTypeInfo info = new MethodTypeInfo();
                    info.setDescriptorIndex(buffer.getShort(position));
                    position += 2;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_NameAndType.getValue()) {
                    NameAndTypeInfo info = new NameAndTypeInfo();
                    info.setNameIndex(buffer.getShort(position));
                    position += 2;
                    info.setDescriptorIndex(buffer.getShort(position));
                    position += 2;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_String.getValue()) {
                    StringInfo info = new StringInfo();
                    info.setStringIndex(buffer.getShort(position));
                    position += 2;
                    infos[length++] = info;
                } else if (tag == ConstantPoolTag.CONSTANT_Utf8.getValue()) {
                    Utf8Info info = new Utf8Info();
                    short len = buffer.getShort(position);
                    position += 2;
                    info.setLength(len);
                    byte[] bytes = new byte[len];
                    for (int i = 0; i < len; i++) {
                        bytes[i] = buffer.get(position++);
                    }
                    info.setBytes(bytes);
                    infos[length++] = info;
                }
            }
        }
        return infos;
    }

}
