package baseline.design.singleTon;


/**
 * 懒汉式（线程不安全）
 * 优缺点说明：
        1) 起到了 Lazy Loading 的效果，但是只能在单线程下使用。
        2) 如果在多线程下，一个线程进入了 if (sgt == null)判断语句块，还未来得及往下执行，
        另一个线程也通过了这个判断语句，这时便会 产生多个实例。
        所以在多线程环境下不可使用这种方式
        3) 结论：在实际开发中， 不要使用这种方式.
 * @author Peter
 */
public class SingletonType3{
    
    private SingletonType3(){
        
    }
    
    private static SingletonType3 sgt;
    
    /**
     * 提供一个静态公有方法，当使用到该方法时，才去创建sgt单例对象。
     * 即懒汉式
     * @return
     */
    public static  SingletonType3 getInstance(){
        if(sgt==null){
            sgt=new SingletonType3();
        }
        return sgt;
    }
}
