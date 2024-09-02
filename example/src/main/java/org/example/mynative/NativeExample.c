#include <jni.h>
#include "org_example_mynative_NativeExample.h"
#include <stdio.h>

// Implementation of the native method
JNIEXPORT void JNICALL Java_NativeExample_nativeMethod(JNIEnv *env, jobject obj) {
    printf("Hello from C!\n");
}
