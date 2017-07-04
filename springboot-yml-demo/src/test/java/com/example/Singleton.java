package com.example;

/**
 * Created by mypos on 2017/3/7.
 */

    public class Singleton
    {

        private static Singleton instance = new Singleton();
        private static int a;

        private  int b = 0;

        private Singleton()
        {
            a++;
            b++;
        }
static {
            a=9;

}
        public static Singleton getInstance()
        {
            return instance;
        }

        public static void main(String[] args)
        {
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton.a);
            System.out.println(singleton.b);
        }
}
