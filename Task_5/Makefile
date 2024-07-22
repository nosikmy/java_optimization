.PHONY: byteCode1
byteCode1:
	javac ./src/main/java/*.java
	javap -c -v src/main/java/Methods > bytecode1.txt

.PHONY: byteCode2
byteCode2:
	javac ./src/main/java/*.java
	javap -c -v src/main/java/Main src/main/java/ClassValue > bytecode2.txt

.PHONY: recaf
recaf:
	java -jar recaf-2.21.14-J8-jar-with-dependencies.jar

.PHONY: run1
run1:
	java -cp src/main/java Main methods

.PHONY: run2
run2:
	java -cp src/main/java Main sortValue