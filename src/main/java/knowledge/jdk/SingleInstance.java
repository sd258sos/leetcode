package knowledge.jdk;

/**
 * function singleInstance
 * create time: 2021/3/30-14:41
 *
 * @AUTHOR : JLU
 * VERSION : 1.0
 */
public class SingleInstance {

        //创建 SingleObject 的一个对象
        private static SingleInstance instance = new SingleInstance();

        //让构造函数为 private，这样该类就不会被实例化
        private SingleInstance(){}

        //获取唯一可用的对象
        public static SingleInstance getInstance(){
            return instance;
        }

        public void showMessage(){
            System.out.println("Hello World!");
        }

    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        SingleInstance object = SingleInstance.getInstance();

        //显示消息
        object.showMessage();
    }

    /**
     * 懒汉模式，线程不安全
     */
    public static class Singleton{
            private static Singleton instance;
            private Singleton(){}
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
    /**
     * 懒汉式，线程安全
     */

    public static class SingletonLazy {
        private static Singleton instance;

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }


}
