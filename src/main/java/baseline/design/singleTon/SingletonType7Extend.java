package baseline.design.singleTon;

import java.io.Serializable;

/**
 * 静态内部类（线程安全，延迟加载）
 * 优缺点说明：
        1) 这种方式采用了类装载的机制来保证初始化实例时只有一个线程。
        2) 静态内部类方式在 Singleton 类被装载时并不会立即实例化，而是在需要实例化时，调用 getInstance 方法，才
        会装载 SingletonInside 类，从而完成 Singleton 的实例化。
        3) 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM 帮助我们保证了线程的安全性，在类进行
        初始化时，别的线程是无法进入的。
        4) 优点： 避免了线程不安全，利用 静态内部类特点实现延迟加载，效率高
        5) 结论： 推荐使用.
        
        这里是利用了静态内部类的两个特点：
        1、外部类加载的时候，不会导致内部类的加载，只有在使用到内部类的时候才会加载内部类；
        使用到内部类可以指的是：调用内部类的方法、访问内部类的变量、调用内部类的构造器；
        在本例中是在外部类Singleton被加载的时候，内部类SingletonInside不会被加载，从而实现了
        懒加载。
        2、在加载静态内部类的时候，是JVM去加载的，是线程安全的，别的线程无法进入；
        在本例中在加载静态内部类SingletonInside的时候，我们去实例化Singleton，这样就实现了
        线程安全。
 * @author Peter
 */
public class SingletonType7Extend implements Serializable{

    private SingletonType7Extend() {
        //这样可以禁用反射，就是一次反射调用都不允许
        if (SingletonInside.SGT != null) {
            throw new RuntimeException("小样！想通过反射来调用私有构造器创建多个对象，"
            		+ "想都别想！赏你一个异常！");
        }
    }

    //写一个静态内部类，该类中有一个静态属性Singleton
    private static class SingletonInside {
        private static final SingletonType7Extend SGT = new SingletonType7Extend();
    }

    /**
     * 提供一个静态公有方法，直接返回SingletonInside.SGT    解决线程安全问题，
     * 同时解决懒加载问题。 
     * 同时解决了效率问题，推荐使用
     * @return
     */
    public static SingletonType7Extend getInstance() {
        return SingletonInside.SGT;
    }
    
    /**
     * 此方法作用是在反序列化时直接返回该方法的返回对象，
     * 而无需再去创建新的对象。
     * @return
     */
    private Object readResolve(){
        return SingletonInside.SGT;
    }
}
