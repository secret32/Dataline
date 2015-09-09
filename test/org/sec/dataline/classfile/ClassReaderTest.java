package org.sec.dataline.classfile;

import org.junit.Test;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class ClassReaderTest {

    @Test
    public void read() {
        ClassReader classReader = new ClassReader();
        classReader.read("C:\\Users\\Administrator\\Desktop\\Test.class");
    }

}
