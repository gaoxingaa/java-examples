# This is the project  where I want to discover how the mockito is working.

1. setup
2. create an example
3. debug into it
4. find the flow to create a mock
   1. 
5. find the flow to create a spy

## Mockito

### Errors
```
org.mockito.exceptions.base.MockitoException:
Cannot mock/spy class java.lang.String
Mockito cannot mock/spy because :
- Cannot mock wrapper types, String.class or Class.class
- 
```

### Flow
By 

## TestNG
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
This is the main method for this test run
```
com.intellij.rt.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:109)
```

By ```@BeforeClass,@BeforeMethod,@AfterMethod,@AfterClass``` annotation, it will call the method in the following order by java reflection in the main method during TestNG test run.
``````
===============================================
setUp
setUpMethod
tearDownMethod
setUpMethod
tearDownMethod
tearDown
===============================================
``````
Here is how it works in the stack trace to process the annotations:

``````
setUp:22, MockitoExampleTest (org.example)
invoke0:-1, NativeMethodAccessorImpl (jdk.internal.reflect)
invoke:77, NativeMethodAccessorImpl (jdk.internal.reflect)
invoke:43, DelegatingMethodAccessorImpl (jdk.internal.reflect)
invoke:568, Method (java.lang.reflect)
invokeMethod:141, MethodInvocationHelper (org.testng.internal.invokers)
invokeMethodConsideringTimeout:71, MethodInvocationHelper (org.testng.internal.invokers)
invokeConfigurationMethod:400, ConfigInvoker (org.testng.internal.invokers)
invokeConfigurations:333, ConfigInvoker (org.testng.internal.invokers)
invokeBeforeClassMethods:188, TestMethodWorker (org.testng.internal.invokers)
run:128, TestMethodWorker (org.testng.internal.invokers)
accept:-1, TestRunner$$Lambda$216/0x00000169a40fecf8 (org.testng)
forEach:1511, ArrayList (java.util)
privateRun:739, TestRunner (org.testng)
run:614, TestRunner (org.testng)
runTest:421, SuiteRunner (org.testng)
runSequentially:413, SuiteRunner (org.testng)
privateRun:373, SuiteRunner (org.testng)
run:312, SuiteRunner (org.testng)
runSuite:52, SuiteRunnerWorker (org.testng)
run:95, SuiteRunnerWorker (org.testng)
runSuitesSequentially:1274, TestNG (org.testng)
runSuitesLocally:1208, TestNG (org.testng)
runSuites:1112, TestNG (org.testng)
run:1079, TestNG (org.testng)
run:66, IDEARemoteTestNG (com.intellij.rt.testng)
main:109, RemoteTestNGStarter (com.intellij.rt.testng)
``````

TestNG use java reflection to invoke configuration and method, here is the code of how it is implemented:

invoke:568, Method (java.lang.reflect)

invokeBeforeClassMethods
```
      IConfigurationAnnotation configuration =
          AnnotationHelper.findConfiguration(annotationFinder, m);
```