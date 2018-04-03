package com.tydic.study.reflect;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
public class DynamicInvokerGenerator implements Opcodes {

    public byte[] generate(String dynamicInvokeClassName, String dynamicLinkageClassName, String bootstrapMethodName, String methodDescriptor)
            throws Exception {

        ClassWriter cw = new ClassWriter(0);
        MethodVisitor mv;

        cw.visit(V1_7, ACC_PUBLIC + ACC_SUPER, dynamicInvokeClassName, null, "java/lang/Object", null);
        {
            mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            MethodType mt = MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class,
                    MethodType.class);
            Handle bootstrap = new Handle(Opcodes.H_INVOKESTATIC, dynamicLinkageClassName, bootstrapMethodName,
                    mt.toMethodDescriptorString());
            mv.visitInvokeDynamicInsn("dynamicInvoke", methodDescriptor, bootstrap);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 1);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    public static void main(String[] args) throws IOException, Exception {
        String dynamicClass = "com/tydic/study/reflect/DynamicInvoker";
        FileOutputStream fos = new FileOutputStream(new File("D:/workspace2/dop-action/target/classes/"+dynamicClass + ".class"));
        fos.write(new DynamicInvokerGenerator().generate(dynamicClass, "com/tydic/study/reflect/BootStrap", "bootstrap", "()V"));
    }

}