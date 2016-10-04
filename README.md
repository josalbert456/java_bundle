# java_bundle
Below is what I've gotten when I read a great book about Java, thus I think it is not unsafe to share it with others. And if you read it maybe you'll get more.

Sometimes, or often, encapulation is not simply to bundle up some detailed functions together, but also to create new functions on the top of the detailed functions: KeyMap.java. 

Most basic files to use gradle: build.gradle & Test.java. Command: gradle (-q) build; gradle (-q) run

CharSeqImp.java, OutOfCharBoundException.java: CharSequence simple implementation

Factory.java, FactoryTest.java: is it factory pattern? 

FreeMemory.java: check for free memory, Runtime class in JDK is a good tool to debug and 
if you know java better, you may probably know javap, the cmd tool for debugging, or disassembly

NewLoader.java NewLoaderTest.java: a Java version of dofile in Lua or loadLib in c/c++, maybe more powerful, is it the base for RMI (Remote Method Invocation)?
