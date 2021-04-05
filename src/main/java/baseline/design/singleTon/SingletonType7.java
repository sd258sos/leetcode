package baseline.design.singleTon;

import java.io.Serializable;


/**
 * 静态内部类（线程安全，延迟加载）
 * 优缺点说明：
        1) 这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
        2) 静态内部类方式在 SingletonType7 类被装载时并不会立即实例化，而是在需要实例化时，调用 getInstance 方法，才
        会装载 SingletonInside 类，从而完成 SingletonType7 的实例化。
        3) 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM 帮助我们保证了线程的安全性，在类进行
        初始化时，别的线程是无法进入的。
        4) 优点： 避免了线程不安全，利用 静态内部类特点实现延迟加载，效率高
        5) 结论： 推荐使用.
        
        这里是利用了静态内部类的两个特点：
        1、外部类加载的时候，不会导致内部类的加载，只有在使用到内部类的时候才会加载内部类；
        使用到内部类可以指的是：调用内部类的方法、访问内部类的变量、调用内部类的构造器；
        在本例中是在外部类SingletonType7被加载的时候，内部类SingletonInside不会被加载，从而实现了
        懒加载。
        2、在加载静态内部类的时候，是JVM去加载的，是线程安全的，别的线程无法进入；
        在本例中在加载静态内部类SingletonInside的时候，我们去实例化SingletonType7，这样就实现了
        线程安全。
 * @author Peter
 */
public class SingletonType7 implements Serializable {

    private SingletonType7() {

    }
    
    //写一个静态内部类，该类中有一个静态属性Singleton
    private static class SingletonInside{
        private static final SingletonType7 SGT=new SingletonType7();
    }

    /**
     * 提供一个静态公有方法，直接返回SingletonInside.SGT    解决线程安全问题，
     * 同时解决懒加载问题。 
     * 同时解决了效率问题，推荐使用
     * @return
     */
    public static SingletonType7 getInstance() {
        return SingletonInside.SGT;
    }
}
