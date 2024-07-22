public class Main {
    public static void main(String[] args) {
        NativeLib nativeLib = new NativeLib();

        if(args.length == 0){
            System.out.print("No args");
        }

        else if(args[0].equals("allocate")) {
            long beforeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.println("Used memory before allocation: " + beforeMemory);

            nativeLib.allocateOneKB();


            long afterMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            System.out.println("Used memory after allocation: " + afterMemory);

            System.out.println("Difference: " + (afterMemory - beforeMemory) + " bytes");
        }

        else if(args[0].equals("memoryEater")) {
            nativeLib.memoryEater();
        }

        else if(args[0].equals("crash")) {
            nativeLib.crashWithStackTrace();
        }

        else if(args[0].equals("structure")) {
            long structure = nativeLib.allocateStructure();
            nativeLib.getStructureField(structure);
            nativeLib.freeMemory(structure);

        }

        else if(args[0].equals("testClass")) {
            System.out.println("\"string\" length is: " + nativeLib.getStringLength("string"));

            TestClass testClass = new TestClass();
            nativeLib.callObjectMethod(testClass);

            System.out.println("Before age was changed: " + testClass.testField);
            nativeLib.changeObjectField(testClass,  1);
            System.out.println("After age was changed: " + testClass.testField);
        }

    }

}