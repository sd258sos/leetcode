package baseline.design.singleTon;

/**
 *  懒汉式（同步方法，线程安全）
 * 优缺点说明：
        1) 解决了 线程安全问题
        2) 效率太低了，每个线程在想获得类的实例时候，执行 getInstance()方法都要进行同步。
        而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接 return 就行了。 
        方法进行同步效率太低
        3) 结论：在实际开发中， 不推荐使用这种方式
 * @author Peter
 */
public class SingletonType4 {

    private SingletonType4() {

    }

    private static SingletonType4 sgt;

    /**
     * 提供一个静态公有方法，加入同步处理的代码，解决线程安全问题。
     * 即懒汉式
     * @return
     */
    public static synchronized SingletonType4 getInstance() {
        if (sgt == null) {
            sgt = new SingletonType4();
        }
        return sgt;
    }
}
