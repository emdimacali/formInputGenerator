# formInputGenerator
This program asks an input text file from a user which contains a list. The user wants to generate a form input (checkboxes) from that list. This program generates a text file which contains the list formatted for form input use.

How to Build
1. Compile
    javac -Xlint:unchecked *.java
2. Create jar file
    jar -cvfm formInputGen.jar manifest.txt *.java *.class
3. Double-Click the program or use the command :
  java -jar formInputGen.jar to run the program.
