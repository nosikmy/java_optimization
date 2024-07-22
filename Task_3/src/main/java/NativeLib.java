public class NativeLib {
    static {
        System.loadLibrary("NativeLib");
    }

    public native void memoryEater();
    public native void allocateOneKB();
    public native void crashWithStackTrace();
    public native int getStringLength(String string);
    public native void callObjectMethod(TestClass object);
    public native void changeObjectField(TestClass object, int value);
    public native long allocateStructure();
    public native int getStructureField(long structure);
    public native void freeMemory(long structure);
}
