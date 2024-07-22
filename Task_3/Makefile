.PHONY: generateHeader
generateHeader:
	javac -h ./src/main/c ./src/main/java/Main.java ./src/main/java/NativeLib.java ./src/main/java/Bean.java ./src/main/java/TestClass.java

.PHONY: compileC
compileC:
	gcc ./src/main/c/NativeLib.c -shared -O3 -Wl,--add-stdcall-alias -o ./src/main/c/NativeLib.dll -I"C:\\Program Files\\Java\\jdk-19\\include" -I"C:\\Program Files\\Java\\jdk-19\\include\\win32"

.PHONY: runAllocate
runAllocate:
	javac ./src/main/java/*.java
	java -cp src/main/java -Djava.library.path="D:\Ucheba\java_optimization\Task_3\src\main\c" Main allocate

.PHONY: runMemoryEater
runMemoryEater:
	javac ./src/main/java/*.java
	java -cp src/main/java -Djava.library.path="D:\Ucheba\java_optimization\Task_3\src\main\c" Main memoryEater

.PHONY: runCrash
runCrash:
	javac ./src/main/java/*.java
	java -cp src/main/java -Djava.library.path="D:\Ucheba\java_optimization\Task_3\src\main\c" Main crash

.PHONY: runStructure
runStructure:
	javac ./src/main/java/*.java
	java -cp src/main/java -Djava.library.path="D:\Ucheba\java_optimization\Task_3\src\main\c" Main structure

.PHONY: runTestClass
runTestClass:
	javac ./src/main/java/*.java
	java -cp src/main/java -Djava.library.path="D:\Ucheba\java_optimization\Task_3\src\main\c" Main testClass
