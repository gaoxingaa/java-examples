#This is the project  where I want to discover how the mockito is working.

1. setup
2. create an example
3. debug into it
4. find the flow to create a mock
   1. 
5. find the flow to create a spy

##Mockito

###Errors
```
org.mockito.exceptions.base.MockitoException:
Cannot mock/spy class java.lang.String
Mockito cannot mock/spy because :
- Cannot mock wrapper types, String.class or Class.class
- 
```

###TestNG
This command is executed by IntelliJ IDEA when you run a test, likely using TestNG, from the IDE. Here's a breakdown of the parameters:

```
C:\Users\Jane\.jdks\azul-17.0.11\bin\java.exe 
-ea 
-Didea.test.cyclic.buffer.size=1048576 
"-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.2\lib\idea_rt.jar=9257:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.2\bin" 
-Dfile.encoding=UTF-8 
-classpath 
"C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.2\lib\idea_rt.jar;C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2021.3.2\plugins\testng\lib\testng-rt.jar;D:\github\java-examples\test\target\test-classes;D:\github\java-examples\test\target\classes;C:\Users\Jane\.m2\repository\org\testng\testng\7.10.2\testng-7.10.2.jar;C:\Users\Jane\.m2\repository\org\slf4j\slf4j-api\1.7.36\slf4j-api-1.7.36.jar;C:\Users\Jane\.m2\repository\com\beust\jcommander\1.82\jcommander-1.82.jar;C:\Users\Jane\.m2\repository\org\webjars\jquery\3.7.1\jquery-3.7.1.jar;C:\Users\Jane\.m2\repository\org\mockito\mockito-core\5.12.0\mockito-core-5.12.0.jar;C:\Users\Jane\.m2\repository\net\bytebuddy\byte-buddy\1.14.15\byte-buddy-1.14.15.jar;C:\Users\Jane\.m2\repository\net\bytebuddy\byte-buddy-agent\1.14.15\byte-buddy-agent-1.14.15.jar;C:\Users\Jane\.m2\repository\org\objenesis\objenesis\3.3\objenesis-3.3.jar" 
com.intellij.rt.testng.RemoteTestNGStarter 
-usedefaultlisteners false 
-socket9256 
@w@C:\Users\Jane\AppData\Local\Temp\idea_working_dirs_testng.tmp 
-temp C:\Users\Jane\AppData\Local\Temp\idea_testng.tmp

```

``````
com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:109)