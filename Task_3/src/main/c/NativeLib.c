#include <jni.h>
#include "NativeLib.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

JNIEXPORT void JNICALL Java_NativeLib_memoryEater (JNIEnv *env, jobject obj){
    while (1) {
        size_t blockSize = sizeof(int) * INT_MAX;
        void* memory = malloc(blockSize);
        if (memory != NULL) {
             memset(memory, 0, blockSize);
        } else {
            jclass exceptionClass = (*env)->FindClass(env, "java/lang/Exception");
            (*env)->ThrowNew(env, exceptionClass, "C: Problem with alloc memory");
            (*env)->ExceptionDescribe(env);
             break;
        }
    }
};

JNIEXPORT void JNICALL Java_NativeLib_allocateOneKB (JNIEnv *env, jobject obj){
    void* memory = malloc(1024);
    if (memory != NULL) {
        memset(memory, 0, 1024);
    }
};

JNIEXPORT void JNICALL Java_NativeLib_crashWithStackTrace (JNIEnv *env, jobject obj){
    method1(env);
};

void method1(JNIEnv *env) {
    method2(env);
}

void method2(JNIEnv *env) {
    method3(env);
}

void method3(JNIEnv *env) {
    jclass exceptionClass = (*env)->FindClass(env, "java/lang/Exception");

    if (exceptionClass == NULL) {
        return;
    }

    int res = (*env)->ThrowNew(env, exceptionClass, "C: Problem in method3");
    if (res >= 0) {
        printf("Exception was throwed\n");
        (*env)->ExceptionDescribe(env);
    }
    return;
}


JNIEXPORT jint JNICALL Java_NativeLib_getStringLength (JNIEnv *env, jobject obj, jstring string){
    const char *str = (*env)->GetStringUTFChars(env, string, 0);
    if (str == NULL) {
       return 0;
    }
    jint length = (*env)->GetStringUTFLength(env, string);
    (*env)->ReleaseStringUTFChars(env, string, str);
    return length;
};

JNIEXPORT void JNICALL Java_NativeLib_callObjectMethod (JNIEnv *env, jobject obj, jobject object){

    jclass testClass = (*env)->GetObjectClass(env, object);
    jmethodID id = (*env)->GetMethodID(env, testClass, "testMethod", "(Ljava/lang/String;)V");
    if (id == NULL) {
        return;
    }
    char* string = "hello";
    jstring js = (*env)->NewStringUTF(env, string);
    (*env)->CallVoidMethod(env, object, id, js);
};

JNIEXPORT void JNICALL Java_NativeLib_changeObjectField (JNIEnv *env, jobject obj, jobject object, jint value){
    jclass cls = (*env)->GetObjectClass(env, object);
    jfieldID id = (*env)->GetFieldID(env, cls, "testField", "I");
    if (id == 0) {
        return;
    }
    (*env)->SetIntField(env, object, id, value);
};

typedef struct {
    int field;
} TestStruct;

JNIEXPORT jlong JNICALL Java_NativeLib_allocateStructure (JNIEnv *env, jobject obj){
    TestStruct *val = (TestStruct*) malloc(sizeof(TestStruct));
    val->field = 111;
    return (jlong) val;
};

JNIEXPORT jint JNICALL Java_NativeLib_getStructureField (JNIEnv *env, jobject obj, jlong structure){
    if ((void *)structure == NULL) {
        return -1;
    }
    TestStruct *val = (TestStruct*) structure;
    printf("Value of struct from C: %d\n", val->field);
    return val->field;
};

JNIEXPORT void JNICALL Java_NativeLib_freeMemory (JNIEnv *env, jobject obj, jlong structure){
    void *s = (void *)structure;
    if (s == NULL) {
            return;
        }
    free(s);
};