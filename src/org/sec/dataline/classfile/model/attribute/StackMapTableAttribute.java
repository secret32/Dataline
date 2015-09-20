package org.sec.dataline.classfile.model.attribute;

/**
 * @author zhou_wei
 * @since v0.1
 */
public class StackMapTableAttribute extends Attribute {

    private short attributeNameIndex;
    private int attributeLength;
    private short numberOfEntries;
    private StackMapFrame[] entries;

    public StackMapTableAttribute() {
        super(50, 0);
    }

    private enum StackMapFrame {
        SAME_FRAME(SameFrame.class),
        SAME_LOCALS_1_STACK_ITEM_FRAME(SameLocals1StackItemFrame.class),
        SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED(SameLocals1StackItemFrameExtended.class),
        CHOP_FRAME(ChopFrame.class),
        SAME_FRAME_EXTENDED(SameFrameExtended.class),
        APPEND_FRAME(AppendFrame.class),
        FULL_FRAME(FullFrame.class);

        private Class<? extends Frame> clazz;

        StackMapFrame(Class<? extends Frame> clazz) {
            this.clazz = clazz;
        }

        public Frame getInstance() {
            try {
                return this.clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private class Frame {
        protected short frameType;
        protected short minFrameType;
        protected short maxFrameType;
    }

    private class SameFrame extends Frame {
        public SameFrame() {
            this.minFrameType = 0;
            this.maxFrameType = 63;
        }
    }

    private class SameLocals1StackItemFrame extends Frame {
        // TODO private verification_type_info stack[1];
        public SameLocals1StackItemFrame() {
            this.minFrameType = 64;
            this.maxFrameType = 127;
        }
    }

    private class SameLocals1StackItemFrameExtended extends Frame {
        // TODO verification_type_info stack[1];
        // TODO u2 offset_delta;
        public SameLocals1StackItemFrameExtended() {
            this.frameType = 247;
            this.minFrameType = 247;
            this.maxFrameType = 247;
        }
    }

    private class ChopFrame extends Frame {
        // TODO u2 offset_delta;
        public ChopFrame() {
            this.minFrameType = 248;
            this.maxFrameType = 250;
        }
    }

    private class SameFrameExtended extends Frame {
        // u2 offset_delta;
        public SameFrameExtended() {
            this.frameType = 251;
            this.minFrameType = 251;
            this.maxFrameType = 251;
        }
    }

    private class AppendFrame extends Frame {
        //u2 offset_delta;
        //verification_type_info locals[frame_type - 251];
        public AppendFrame() {
            this.minFrameType = 252;
            this.maxFrameType = 254;
        }
    }

    private class FullFrame extends Frame {
//        u2 offset_delta;
//        u2 number_of_locals;
//        verification_type_info locals[number_of_locals];
//        u2 number_of_stack_items;
//        verification_type_info stack[number_of_stack_items];
        public FullFrame() {
            this.frameType = 255;
            this.minFrameType = 255;
            this.maxFrameType = 255;
        }
    }
}
