package baseline.design.singleTon;

/**
 * 懒汉式（线程安全，双重检查同步代码块）
 * 优缺点说明：
        1) Double-Check 概念是多线程开发中常使用到的，如代码中所示，
        我们进行了两次 if (sgt == null)检查，这样就可以保证线程安全
        （SingletonType6的实例在内存中只有一个）。
        2) 这样，实例化代码只用执行一次，后面再次访问时，判断 if (sgt == null)，
        如果sgt不为null，就直接 return 实例化对象，也避免的反复进行方法同步.
        3) 线程安全； 延迟加载； 效率较高
        4) 思考：在实际开发中， 应不应该使用这种方式实现单例模式呢？
        5) 结论：在实际开发中，如果是需要可以考虑使用这种方式实现单例模式，
        但是需要在本单例的静态变量前加上volatile关键字修饰才能保证在后续不会
        出现问题。
 * @author Peter
 */
public class SingletonType6 {
	
	
	private  String str1;
	
	private  String str2;
	
	private  String str3;
	
	private  String str4;

    private SingletonType6() {
    	this.str1="xxx";
		this.str2="xxx";
		this.str3="xxx";
		this.str4="xxx";
    }
    
    
    

    /**
	 * @return the str1
	 */
	public String getStr1() {
		return str1;
	}

	/**
	 * @param str1 the str1 to set
	 */
	public void setStr1(String str1) {
		this.str1 = str1;
	}

	/**
	 * @return the str2
	 */
	public String getStr2() {
		return str2;
	}

	/**
	 * @param str2 the str2 to set
	 */
	public void setStr2(String str2) {
		this.str2 = str2;
	}

	/**
	 * @return the str3
	 */
	public String getStr3() {
		return str3;
	}

	/**
	 * @param str3 the str3 to set
	 */
	public void setStr3(String str3) {
		this.str3 = str3;
	}

	/**
	 * @return the str4
	 */
	public String getStr4() {
		return str4;
	}

	/**
	 * @param str4 the str4 to set
	 */
	public void setStr4(String str4) {
		this.str4 = str4;
	}




	private static volatile SingletonType6 sgt = null;

    /**
     * 提供一个静态公有方法，加入双重检查的代码，解决线程安全问题，
     * 同时解决懒加载问题。 
     * 同时解决了效率问题，推荐使用
     * @return
     */
    public static SingletonType6 getInstance() {
        if (sgt == null) {
            synchronized (SingletonType6.class) {
                if (sgt == null) {
                    sgt = new SingletonType6();
                }
            }
        }
        return sgt;
    }
}
