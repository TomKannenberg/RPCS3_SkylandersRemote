#include <jni.h>
#include <string>


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_rpcs3_1skylandersremote_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello World!";
    return env->NewStringUTF(hello.c_str());
}