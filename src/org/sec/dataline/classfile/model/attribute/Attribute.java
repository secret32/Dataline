package org.sec.dataline.classfile.model.attribute;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class Attribute {

    private short majorVersion;
    private short minorVersion;

    public Attribute(int majorVersion, int minorVersion) {
        this.majorVersion = (short) majorVersion;
        this.minorVersion = (short) minorVersion;
    }

    public short getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(short majorVersion) {
        this.majorVersion = majorVersion;
    }

    public short getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(short minorVersion) {
        this.minorVersion = minorVersion;
    }
}
