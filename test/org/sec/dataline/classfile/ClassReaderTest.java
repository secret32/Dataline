package org.sec.dataline.classfile;

import org.junit.Test;
import org.sec.dataline.classfile.model.Klass;

import java.nio.ByteBuffer;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class ClassReaderTest {

    @Test
    public void testRead() {
        ClassReader classReader = new ClassReader();
        Klass klass = classReader.read("C:\\Users\\Administrator\\Desktop\\Test.class");
        System.out.println(klass.getMagic() == 0XCAFEBABE);
        System.out.println(klass.getMinorVersion());
        System.out.println(klass.getMajorVersion());
    }

    @Test
    public void testByteBuffer() {
        byte[] bytes = new byte[10];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) i;
        }
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        int pos = 0;
        System.out.println(buffer.get(pos));
        System.out.println(buffer.get(pos+=2));
        System.out.println(buffer.get(pos));
    }

}
