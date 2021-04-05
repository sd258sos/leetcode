package baseline.design.singleTon;


/**
 * 懒汉式(线程安全，同步代码块) 实际上是起不到我们想要的同步创建单例对象的作用的
 * 优缺点说明：
        1) 这种方式本意是想对第四种实现方式进行改进，因为使用同步方法的方式效率太低了
        改为同步产生实例化的代码块。
        2) 但是这种同步并不能起到线程同步的作用。这种方式和第三种实现方式遇到的情形一致，
        假如一个线程进入了if (sgt == null) 判断语句块，CPU的时间片就切换到另一个线程了，然后
        另一个线程也通过了这个判断语句，这时就会产生多个实例。
        3) 结论：在实际开发中， 不能使用这种方式
 * @author Peter
 */
public class SingletonType5 {

    private SingletonType5() {

    }

    private static SingletonType5 sgt;

    /**
     * 提供一个静态公有方法，加入同步处理的代码，解决线程安全问题。 即懒汉式
     * 
     * @return
     */
    public static SingletonType5 getInstance() {
        if (sgt == null) {
            synchronized (SingletonType5.class) {
                sgt = new SingletonType5();
            }
        }
        return sgt;
    }
}
