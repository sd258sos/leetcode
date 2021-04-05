package baseline.design.singleTon;


/**
 * 饿汉式（静态代码块）
 * 
 * 优缺点说明：
        1) 这种方式和上面的方式其实类似，只不过将类实例化的过程放在了静态代码块中，
        也是在类装载的时候，就执行静态代码块中的代码，初始化类的实例。
        优缺点和静态变量是一样的。
        2) 结论：这种单例模式可用，但是可能造成内存浪费
 * @author Peter
 */
class SingletonType2 {

    // 1、私有化构造器：为了让外部不能创建该类的对象（不能 new）
    private SingletonType2() {

    }

    // 2、本类内部创建一个该类实例
    private static  SingletonType2 sgt;
    
    static{//在静态代码块中，创建单例对象
        sgt=new SingletonType2();
    }

    // 3、对外提供一个公有的静态方法，返回实例对象
    public static SingletonType2 getInstance() {
        return sgt;
    }

}
