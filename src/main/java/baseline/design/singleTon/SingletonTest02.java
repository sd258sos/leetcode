package baseline.design.singleTon;

import java.io.*;

/**
 * 单例模式测试类 对已经测试线程安全、 延时加载的实现单例的方式的思考
 * 
 * @author Peter
 */
public class SingletonTest02 {

	public static void main(String[] args) throws ReflectiveOperationException, IOException {
		// 测试是否为单例
		// SingletonType1 instance1 = SingletonType1.getInstance();
		// SingletonType1 instance2 = SingletonType1.getInstance();

		// SingletonType2 instance1 = SingletonType2.getInstance();
		// SingletonType2 instance2 = SingletonType2.getInstance();

		// System.out.println("懒汉式1，线程不安全~");
		// SingletonType3 instance1 = SingletonType3.getInstance();
		// SingletonType3 instance2 = SingletonType3.getInstance();

		// System.out.println("懒汉式2，线程安全~");
		// SingletonType4 instance1 = SingletonType4.getInstance();
		// SingletonType4 instance2 = SingletonType4.getInstance();

		// System.out.println("懒汉式3，线程不安全~");
		// SingletonType5 instance1 = SingletonType5.getInstance();
		// SingletonType5 instance2 = SingletonType5.getInstance();

		/*
		 * 这种方式如果因为JVM的优化导致的重排序就会导致空指针异常 所以， 应该在其单例成员上加上从volatile关键字去防止重排序
		 */
		// System.out.println("懒汉式4，双重检查，线程安全~");
		// SingletonType6 instance1 = SingletonType6.getInstance();
		// SingletonType6 instance2 = SingletonType6.getInstance();

		// System.out.println("使用静态内部类完成单例模式，线程安全~");
		// SingletonType7 instance1 = SingletonType7.getInstance();
		// SingletonType7 instance2 = SingletonType7.getInstance();
//		 SingletonType7Extend instance1 = SingletonType7Extend.getInstance();
//		 SingletonType7Extend instance2 = SingletonType7Extend.getInstance();

		// 利用反射可以创建多个该类的对象，从而破坏单例模式的设计
//		Constructor<SingletonType7Extend> constructor = 
//				SingletonType7Extend.class.getDeclaredConstructor();
//		constructor.setAccessible(true);
		/*
		 * 
		 * 获取到内部类再获取到内部类的属性，然后将属性设置为null，
		 * 然后通过反射
		 */
//		 Class<?>[] insideClasses = SingletonType7Extend.class.getDeclaredClasses();
//		 Field declaredField = insideClasses[0].getDeclaredField("SGT");
//		 declaredField.setAccessible(true);
//		 declaredField.set(null, null);
//		 System.out.println(declaredField.get(null));
//		SingletonType7Extend instance1 = constructor.newInstance();
//		SingletonType7Extend instance2 = constructor.newInstance();



		// Constructor<SingletonType8> constructor =
		// SingletonType8.class.getDeclaredConstructor();

		 System.out.println("使用枚举完成单例模式，线程安全~");
		 SingletonType8 instance1 = SingletonType8.SGT;
//		 SingletonType8 instance2 = SingletonType8.SGT;

//		 Constructor<SingletonType8> constructor = SingletonType8.class.getDeclaredConstructor();
//		 SingletonType8 instance1 = constructor.newInstance();
//		 SingletonType8 instance2 = constructor.newInstance();
		 
//		 利用反序列化可以创建多个该类的对象，从而破坏单例模式的设计
//		 序列化
		 ObjectOutputStream oos = new ObjectOutputStream(
		 new FileOutputStream("src/main/resources/temp.txt"));
		 oos.writeObject(instance1);
		 oos.close();
		 //反序列化
		 ObjectInputStream ois = new ObjectInputStream(
		 new FileInputStream("src/main/resources/temp.txt"));
		 SingletonType8 instance3 = (SingletonType8)
		 ois.readObject();
//		 
//			System.out.println("两个引用是否指向同一个对象：" + (instance1 == instance2));
			System.out.println("instance1的hashCode：" + instance1.hashCode());
//			System.out.println("instance2的hashCode：" + instance2.hashCode());
			System.out.println("instance3的hashCode：" + instance3.hashCode());

	}

}
