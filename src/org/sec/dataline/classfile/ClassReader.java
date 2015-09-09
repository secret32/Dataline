package org.sec.dataline.classfile;

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

    public org.sec.dataline.classfile.model.Class read(String filepath) {
        if (filepath.endsWith(".class")) {
            Path path = Paths.get(filepath);
            if (!Files.isDirectory(path) || Files.isReadable(path)) {
                try (SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ)) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int len = -1;
                    while ((len = channel.read(buffer)) != -1) {
                        System.out.println(len);
                    }
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                throw ErrorCode.INVALID_FILE.toException();
            }
        }
        throw ErrorCode.ERROR_FILE.toException();
    }

}
