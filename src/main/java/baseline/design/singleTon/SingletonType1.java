package baseline.design.singleTon;

/**
 *饿汉式（静态变量）
 *  优缺点说明：
 *              1) 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
 *              2) 缺点：在类装载的时候就完成实例化，没有达到 Lazy Loading 的效果。
 *              如果从始至终从未使用过这个实例，则会造成内存的浪费
 *              3) 这种方式基于 classloder 机制避免了多线程的同步问题，不过，
 *              instance 在类装载时就实例化，在单例模式中大多数都是调用 getInstance 方法，
 *              但是导致类装载的原因有很多种，因此不能确定有其他的方式（或者其他的静
 *              态方法）导致类装载，这时候初始化 instance 就没有达到 lazy loading 的效果
 *              4) 结论：这种单例模式可用，可能造成内存浪费，注意考虑使用场景，
 *              如果是确定绝对会使用到的那么可以使用这种方式去实现单例模式。
 * @author Peter
 */
public class SingletonType1 {

    // 1、私有化构造器：为了让外部不能创建该类的对象（不能 new）
    private SingletonType1() {

    }

    // 2、本类内部创建一个该类实例
    private static final SingletonType1 sgt = new SingletonType1();

    // 3、对外提供一个公有的静态方法，返回实例对象
    public static SingletonType1 getInstance() {
        return sgt;
    }

}
