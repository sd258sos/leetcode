package baseline.design.singleTon;


/**
 * 单例模式测试类
 * @author Peter
 */
public class SingletonTest01 {

    public static void main(String[] args) {
        // 测试是否为单例
//        SingletonType1 instance1 = SingletonType1.getInstance();
//        SingletonType1 instance2 = SingletonType1.getInstance();
        
//        SingletonType2 instance1 = SingletonType2.getInstance();
//        SingletonType2 instance2 = SingletonType2.getInstance();
        
//        System.out.println("懒汉式1，线程不安全~");
//        SingletonType3 instance1 = SingletonType3.getInstance();
//        SingletonType3 instance2 = SingletonType3.getInstance();
    	
        
//        System.out.println("懒汉式2，线程安全~");
//        SingletonType4 instance1 = SingletonType4.getInstance();
//        SingletonType4 instance2 = SingletonType4.getInstance();
        
//        System.out.println("懒汉式3，线程不安全~");
//        SingletonType5 instance1 = SingletonType5.getInstance();
//        SingletonType5 instance2 = SingletonType5.getInstance();
        
//        System.out.println("懒汉式4，双重检查，线程安全~");
//        SingletonType6 instance1 = SingletonType6.getInstance();
//        SingletonType6 instance2 = SingletonType6.getInstance();
    	
        
        System.out.println("使用静态内部类完成单例模式，线程安全~");
        com.powernode.designpattern.day02.part1.SingletonType7 instance1 = com.powernode.designpattern.day02.part1.SingletonType7.getInstance();
        com.powernode.designpattern.day02.part1.SingletonType7 instance2 = com.powernode.designpattern.day02.part1.SingletonType7.getInstance();
    	System.out.println("两个引用是否指向同一个对象："+(instance1 == instance2));
    	System.out.println("instance1的hashCode："+instance1.hashCode());
    	System.out.println("instance2的hashCode："+instance2.hashCode());
        
//        System.out.println("使用枚举完成单例模式，线程安全~");
//        SingletonType8 instance1 = SingletonType8.SGT;
//        SingletonType8 instance2 = SingletonType8.SGT;
        
       
    }

}


