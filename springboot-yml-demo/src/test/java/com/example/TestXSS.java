package com.example;

/**
 * Java程序中，每个线程都有自己的Stack Space。这个Stack Space不是来自Heap的分配。
 所以Stack Space的大小不会受到-Xmx和-Xms的影响，这2个JVM参数仅仅是影响Heap的大小。
 Stack Space用来做方法的递归调用时压入Stack Frame。所以当递归调用太深的时候，
 就有可能耗尽Stack Space，爆出StackOverflow的错误。Stack Space的大小随着OS，
 JVM以及环境变量的大小而发生变化。一般说来默认的大小是512K。在64位的系统中，
 这个Stack Space值会更大。一般说来，Stack Space为128K是够用的。
 这时你说需要做的就是观察。如果你的程序没有爆出StackOverflow的错误，
 可以使用-Xss来调整Stack Space的大小为128K。（eg：-Xss128K)
 * Created by mypos on 2017/3/9.
 */
public class TestXSS {
    private static long count = 0;

     static {}
    public static void main(String[] args) {
        infinitelyRecursiveMethod(1);

    }

    public static void infinitelyRecursiveMethod(long a){
        System.out.println(count++);
        infinitelyRecursiveMethod(a);
    }
}
