#include <jni.h>
#include <string>
#include <iostream>

extern "C" JNIEXPORT jstring JNICALL
Java_com_tth_mynativeapplication_MainActivity_stringFromJNI(JNIEnv *env, jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_com_tth_mynativeapplication_MainActivity_jniDelay(JNIEnv *env, jobject) {
    return 0;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_tth_mynativeapplication_MainActivity_sortNative(JNIEnv *env, jobject /* this */) {
    int a[10000], dem = 10000, temp;
    for (int i = 0; i < 10000; ++i) {
        a[i] = dem--;
    }
    for (int i = 0; i < 10000; ++i) {
        for (int j = i + 1; j < 10000; ++j) {
            if (a[j] < a[i]) {
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
    }
    return 0;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_tth_mynativeapplication_MainActivity_fibonaciNative(JNIEnv *env, jobject /* this */,
                                                             jint n) {
    for (int i = 0; i < 1000; ++i) {
        long a, b, c;
        a = b = 1;
        c = 0;
        if (n < 3) continue;
        else {
            while (n-- > 2) {
                c = a + b;
                a = b;
                b = c;
            }
            continue;
        }
    }
    return 0;
}
extern "C" JNIEXPORT jfloat JNICALL
Java_com_tth_mynativeapplication_MainActivity_dtht(JNIEnv *env, jobject /* this */,
                                                   jfloat n) {
    float a = 0;
    for (int i = 0; i < 100000; ++i) {
        float kq = n;
        kq *= kq;
        kq = 3.14159265358979f;
        a = kq;
    }
    return a;
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_tth_mynativeapplication_MainActivity_testStringNative(JNIEnv *env, jobject /* this */) {
    std::string a = "hello";
    std::string b = "it's me";
    std::string c = " ";
    a += c;
    a += b;
    return env->NewStringUTF(a.c_str());
}


