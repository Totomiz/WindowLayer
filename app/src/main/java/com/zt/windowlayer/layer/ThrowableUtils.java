
package com.zt.windowlayer.layer;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/**
 * 常用异常 <br />
 * <p style="color:red;">
 * 1. java.lang.NullPointerException <br />
 * 2. Java.lang.ClassNotFoundexcEption <br />
 * 3. Java.lang.ArithmeticException <br />
 * 4. Java.lang.ArrayIndexOutOfBoundsexception <br />
 * 5. Java.lang.IllegalArgumentException <br />
 * 6. java.lang.IllegalAccessException   <br />
 * </p>
 * <p style="color:red;">
 * <b>1. java.lang.NullPointerException</b>
 * </p>
 * <p>
 * 空指针异常，异常的解释是"程序遇上了空指针"，简单地说就是调用了未经初始化的对象或者是不存在的对象，这个错误经常出现在创建图片，调用数组这些操作中，
 * 比如图片未经初始化
 * ，或者图片创建时的路径错误等等。对数组操作中出现空指针，很多情况下是一些刚开始学习编程的朋友常犯的错误，即把数组的初始化和数组元素的初始化混淆起来了
 * 。数组的初始化是对数组分配需要的空间 ，而初始化后的数组，其中的元素并没有实例化，依然是空的，所以还需要对每个元素都进行初始化（如果要调用的话)
 * </p>
 *  
 * <p style="color:red;">
 * <b>2. java .lang.ClassNotFoundexcEption</b>
 * </p>
 * <p>
 *   这个异常是很多原本在jb等开发环境中开发的程序员，把jb下的程序包放在wtk下编译经常出现的问题
 * ，异常的解释是"指定的类不存在"，这里主要考虑一下类的名称和路径是否正确即可
 * ，如果是在jb下做的程序包，一般都是默认加上package的，所以转到wtk下后要注意把package的路径加上
 * </p>
 * <p style="color:red;">
 * <b>3. java.lang.ArithmeticException</b>
 * </p>
 * <p>
 * 这个异常的解释是"数学运算异常"，比如程序中出现了除以零这样的运算就会出这样的异常
 * ，对这种异常，大家就要好好检查一下自己程序中涉及到数学运算的地方，公式是不是有不妥了.
 * </p>
 * <p style="color:red;">
 * <b>4. java.lang.ArrayIndexOutOfBoundsexception</b>
 * </p>
 * <p>
 * 这个异常相信很多朋友也经常遇到过，异常的解释是 "数组下标越界"
 * ，现在程序中大多都有对数组的操作，因此在调用数组的时候一定要认真检查，看自己调用的下标是不是超出了数组的范围，一般来说，显示（即直接用常数当下标
 * ）调用不太容易出这样的错
 * ，但隐式（即用变量表示下标）调用就经常出错了，还有一种情况，是程序中定义的数组的长度是通过某些特定方法决定的，不是事先声明的，这个时候
 * ，最好先查看一下数组的length，以免出现这个异常。
 * </p>
 * <p style="color:red;">
 * <b>5. java.lang.IllegalArgumentException</b>
 * </p>
 * <p>
 * 这个异常的解释是"方法的参数错误"，很多j2me的类库中的方法在一些情况下都会引发这样的错误 ，比如音量调节方法中的音量参数如果写成负数就会出现这个异常，
 * 再比如g.setcolor(int red,int green,int blue)这个方法中的三个值
 * ，如果有超过255的也会出现这个异常，因此一旦发现这个异常，我们要做的，就是赶紧去检查一下方法调用中的参数传递是不是出现了错误。
 * </p>
 * <p style="color:red;">
 * <b>6. java.lang.IllegalAccessException</b>
 * </p>
 * <p>
 * 这个异常的解释是"没有访问权限"，当应用程序要调用一个类， 但当前的方法即没有对该类的访问权限便会出现这个异常
 * 。对程序中用了package的情况下要注意这个异常。    其他还有很多异常，我就不一一列举了，我要说明的是
 * ，一个合格的程序员，需要对程序中常见的问题有相当的了解和相应的解决办法
 * ，否则仅仅停留在写程序而不会改程序的话，会极大影响到自己的开发的。关于异常的全部说明，在api里都可以查阅。
 * </p>
 *
 * @author iooly
 */

public class ThrowableUtils {

    public static void throwIndexOutOfBoundsException(int index, int size) {
        throw new IndexOutOfBoundsException("Invalid index " + index + ", size is " + size);
    }

    public static void throwIllegalAccessException(String info) throws IllegalAccessException {
        throw new IllegalAccessException(info);
    }

    public static void throwRuntimeException(String info) {
        throw new RuntimeException(info);
    }

    public static void throwNullPointerException(String info) {
        throw new NullPointerException(info);
    }

    /**
     * Handy function to get a loggable stack trace from a Throwable
     *
     * @param tr An exception to log
     */
    public static String getStackTraceString(Throwable tr) {
        if (tr == null) {
            return "";
        }

        // This is to reduce the amount of log spew that apps do in the non-error
        // condition of the network being unavailable.
        Throwable t = tr;
        while (t != null) {
            if (t instanceof UnknownHostException) {
                return "";
            }
            t = t.getCause();
        }

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        printStackTrace(tr, pw);
        pw.flush();
        return sw.toString();
    }

    /**
     * Writes a printable representation of this {@code Throwable}'s stack trace
     * to the specified print writer. If the {@code Throwable} contains a
     * {@link Throwable#getCause() cause}, the method will be invoked recursively for the
     * nested {@code Throwable}.
     *
     * @param err the writer to write the stack trace on.
     */
    public static void printStackTrace(Throwable tr, PrintWriter err) {
        try {
            printStackTrace(tr, err, "", null);
        } catch (IOException e) {
            // Appendable.append throws IOException, but PrintWriter.append doesn't.
            throw new AssertionError();
        }
    }

    /**
     * @param indent      additional indentation on each line of the stack trace.
     *                    This is the empty string for all but suppressed throwables.
     * @param parentStack the parent stack trace to suppress duplicates from, or
     *                    null if this stack trace has no parent.
     */
    private static void printStackTrace(Throwable tr, Appendable err, String indent, StackTraceElement[] parentStack)
            throws IOException {
        err.append(tr.toString());
        err.append("\n");

        StackTraceElement[] stack = tr.getStackTrace();
        if (stack != null) {
            int duplicates = parentStack != null ? countDuplicates(stack, parentStack) : 0;
            duplicates = 0;
            for (int i = 0; i < stack.length - duplicates; i++) {
                err.append(indent);
                err.append("\tat ");
                err.append(stack[i].toString());
                err.append("\n");
            }

            if (duplicates > 0) {
                err.append(indent);
                err.append("\t... ");
                err.append(Integer.toString(duplicates));
                err.append(" more\n");
            }
        }
        Throwable[] suppressedExceptions = tr.getSuppressed();
        // Print suppressed exceptions indented one level deeper.
        if (suppressedExceptions != null) {
            for (Throwable throwable : suppressedExceptions) {
                err.append(indent);
                err.append("\tSuppressed: ");
                printStackTrace(throwable, err, indent + "\t", stack);
            }
        }

        Throwable cause = tr.getCause();
        if (cause != null) {
            err.append(indent);
            err.append("Caused by: ");
            printStackTrace(cause, err, indent, stack);
        }
    }

    /**
     * Counts the number of duplicate stack frames, starting from the
     * end of the stack.
     */
    private static int countDuplicates(StackTraceElement[] currentStack,
                                       StackTraceElement[] parentStack) {
        int duplicates = 0;
        int parentIndex = parentStack.length;
        for (int i = currentStack.length; --i >= 0 && --parentIndex >= 0; ) {
            StackTraceElement parentFrame = parentStack[parentIndex];
            if (parentFrame.equals(currentStack[i])) {
                duplicates++;
            } else {
                break;
            }
        }
        return duplicates;
    }

}
