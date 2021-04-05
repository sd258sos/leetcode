package baseline.design.singleTon;

import java.io.Serializable;

/**
 * 枚举（线程安全）
 * 优缺点说明：
        1) 这借助 JDK1.5 中添加的枚举来实现单例模式。不仅能避免多线程同步问题，
        而且还能防止利用反射和反序列化重新创建新的对象去破坏单例模式。
        2) 这种方式是 Effective Java  作者 Josh Bloch  （乔什布洛赫）提倡的方式
        3) 结论： 推荐使用，但是思考有没有什么问题？
        4) 缺点：不能实现延时加载。
 * @author Peter
 */
public enum SingletonType8 implements Serializable{
    SGT;
    
    public void smile(){
        System.out.println("hahaha!");
    }
}
