package org.example.mynative;

public class NativeExample {
    // Declare a native method called nativeMethod
    public native void nativeMethod();

    // Load the native library
    static {
        System.loadLibrary("NativeLib"); // Load the native library (NativeLib.dll or NativeLib.so)
    }

    public static void main(String[] args) {
        // Create an instance of the class
        NativeExample example = new NativeExample();

        // Call the native method
        example.nativeMethod();
    }
}
