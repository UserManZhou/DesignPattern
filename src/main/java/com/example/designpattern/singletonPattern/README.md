# 单例设计模式（Singleton Pattern）

单例模式是一种创建型设计模式，确保一个类只有一个实例，并提供一个全局访问点来获取该实例。

---

## 目录结构

```
singletonPattern/
├── eagerSingleton/              # 饿汉式单例
│   ├── Singleton.java           # 饿汉式 - 静态变量直接实例化
│   └── NewSingleton.java        # 饿汉式 - 静态代码块实例化
├── lazySingleton/               # 懒汉式单例
│   ├── ThreadUnsafeSingleton.java   # 懒汉式 - 线程不安全
│   ├── ThreadSafeSingleton.java     # 懒汉式 - synchronized 方法锁
│   └── DoubleCheckLockSingleton.java # 懒汉式 - 双重检查锁（DCL）
├── innerClassSingleton/         # 静态内部类单例
│   └── InnerClassSingleton.java
└── enumSingletion/              # 枚举单例
    └── EnumSingleton.java
```

---

## 一、饿汉式单例（Eager Singleton）

### 1.1 静态变量直接实例化

**类名**：`Singleton`

**实现方式**：在类加载时直接通过静态变量 `new Singleton()` 完成实例化，JVM 保证类加载过程是线程安全的。

**代码示例**：

```java
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
```

**特点**：

- 实例在类加载时立即创建，不依赖任何外部条件
- JVM 类加载机制天然保证线程安全，无需额外同步措施
- `getInstance()` 方法直接返回已有实例，无任何判断逻辑

**优点**：

- 实现简单，代码量最少
- 天然线程安全，由 JVM 类加载机制保证
- `getInstance()` 调用无锁，性能最优
- 没有懒加载带来的延迟问题

**缺点**：

- 不支持懒加载（Lazy Loading），类加载时就创建实例，无论是否使用
- 如果实例创建过程依赖外部参数或配置，则无法使用此方式
- 如果该单例类从未被使用，实例仍然会被创建，造成内存浪费

**适用场景**：

- 单例对象占用资源较少
- 程序启动时就确定会使用该单例
- 对启动速度无严格要求

---

### 1.2 静态代码块实例化

**类名**：`NewSingleton`

**实现方式**：通过 `static {}` 静态代码块完成实例化，本质上与静态变量方式相同，都是在类加载阶段完成，但允许在代码块中执行更复杂的初始化逻辑。

**代码示例**：

```java
public class NewSingleton {
    private static NewSingleton newSingleton;

    static {
        System.out.println("静态方法加载");
        newSingleton = new NewSingleton();
    }

    private NewSingleton() {
    }

    public static NewSingleton getInstance() {
        return newSingleton;
    }
}
```

**特点**：

- 与静态变量方式本质相同，均在类加载时完成实例化
- 静态代码块中可以执行更复杂的初始化逻辑（如读取配置、初始化资源等）
- JVM 类加载机制保证线程安全

**优点**：

- 天然线程安全，由 JVM 类加载机制保证
- 相比静态变量方式，静态代码块支持更复杂的初始化逻辑
- `getInstance()` 调用无锁，性能最优

**缺点**：

- 同样不支持懒加载，类加载时就创建实例
- 如果静态代码块中初始化逻辑较重，会影响类加载速度
- 如果该单例类从未被使用，实例仍然会被创建

**适用场景**：

- 需要在实例化时执行复杂初始化逻辑（如加载配置文件、初始化连接池等）
- 单例对象在程序启动时就确定需要使用

---

## 二、懒汉式单例（Lazy Singleton）

### 2.1 线程不安全的懒汉式

**类名**：`ThreadUnsafeSingleton`

**实现方式**：在 `getInstance()` 方法中先判断实例是否为 `null`，为 `null` 时才创建实例。存在竞态条件（Race Condition），多线程环境下可能创建多个实例。

**代码示例**：

```java
public class ThreadUnsafeSingleton {
    private static ThreadUnsafeSingleton threadUnsafeSingleton = null;

    private ThreadUnsafeSingleton() {
    }

    public static ThreadUnsafeSingleton getInstance() {
        if (threadUnsafeSingleton == null) {
            try {
                Thread.sleep(1); // 模拟延迟，放大竞态条件
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadUnsafeSingleton = new ThreadUnsafeSingleton();
        }
        return threadUnsafeSingleton;
    }
}
```

**特点**：

- 支持懒加载，只在首次调用 `getInstance()` 时才创建实例
- 没有任何同步措施，多线程下存在竞态条件
- `Thread.sleep(1)` 用于模拟实际场景中的延迟，放大线程安全问题

**优点**：

- 支持懒加载，节省内存资源
- 实现简单，代码量少
- 单线程环境下完全可用

**缺点**：

- **线程不安全**：多个线程同时进入 `if (instance == null)` 判断时，可能各自创建一个实例，破坏单例约束
- 多线程环境下不可靠，不推荐在生产环境中使用

**适用场景**：

- 仅限单线程环境使用
- 用于学习和理解懒加载的概念，不适合生产环境

---

### 2.2 线程安全的懒汉式（synchronized 方法锁）

**类名**：`ThreadSafeSingleton`

**实现方式**：在 `getInstance()` 方法上加 `synchronized` 关键字，使整个方法成为同步方法，保证同一时刻只有一个线程能进入该方法。

**代码示例**：

```java
public class ThreadSafeSingleton {
    private static ThreadSafeSingleton threadSafeSingleton = null;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (threadSafeSingleton == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }
}
```

**特点**：

- 通过 `synchronized` 修饰整个 `getInstance()` 方法实现线程安全
- 每次调用 `getInstance()` 都会获取锁，即使实例已经创建

**优点**：

- 线程安全，多线程环境下能保证只创建一个实例
- 支持懒加载，节省内存资源
- 实现简单，容易理解

**缺点**：

- **性能低下**：每次调用 `getInstance()` 都需要获取锁，而实际上只有首次创建实例时才需要同步
- 锁的粒度太大（锁住整个方法），并发度低，高并发场景下成为性能瓶颈
- 不推荐在高并发场景中使用

**适用场景**：

- 并发量不高，对性能要求不严格的场景
- 需要线程安全的懒加载单例，且实现复杂度要求低

---

### 2.3 双重检查锁（Double-Checked Locking, DCL）

**类名**：`DoubleCheckLockSingleton`

**实现方式**：在 `synchronized` 块内进行两次 `null` 检查。第一次检查避免不必要的同步（实例已创建时直接返回），第二次检查确保在同步块内只有一个线程创建实例。

**代码示例**：

```java
public class DoubleCheckLockSingleton {
    private static DoubleCheckLockSingleton instance = null;

    private DoubleCheckLockSingleton() {
    }

    public static DoubleCheckLockSingleton getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (DoubleCheckLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckLockSingleton();
                }
            }
        }
        return instance;
    }
}
```

**特点**：

- 两次 `null` 检查（外层检查避免重复加锁，内层检查防止重复创建）
- 只在实例未创建时才进入 `synchronized` 块，减少锁竞争
- 支持懒加载

**优点**：

- 线程安全，多线程环境下能保证只创建一个实例
- 支持懒加载，节省内存资源
- 相比 `synchronized` 方法锁，性能有显著提升（实例创建后不再需要加锁）

**缺点**：

- 实现相对复杂，需要注意指令重排问题
- **指令重排隐患**：`instance = new DoubleCheckLockSingleton()` 并非原子操作，分为三步：①分配内存 ②初始化对象 ③引用赋值。JVM 可能将②和③重排，导致其他线程获取到未初始化完成的对象（需要配合
  `volatile` 关键字解决，但当前代码未使用 `volatile`）
- 在 Java 5 及以上版本中，需要将 `instance` 声明为 `volatile` 才能完全避免指令重排问题

**适用场景**：

- 需要线程安全的懒加载单例
- 对性能有一定要求，不希望每次调用都加锁
- 推荐在 `instance` 字段上增加 `volatile` 关键字以确保完全正确

---

## 三、静态内部类单例（Inner Class Singleton）

**类名**：`InnerClassSingleton`

**实现方式**：利用 JVM 的类加载机制，通过静态内部类 `SingletonHolder` 持有外部类的实例。只有在调用 `getInstance()` 方法时才会触发 `SingletonHolder` 的类加载，从而实现懒加载，同时由 JVM
保证线程安全。

**代码示例**：

```java
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    private static class SingletonHolder {
        private static InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```

**特点**：

- 利用 JVM 类加载机制保证线程安全
- 静态内部类 `SingletonHolder` 只有在被引用时才会被加载，实现懒加载
- `SingletonHolder` 在加载时创建 `INSTANCE`，JVM 保证此过程线程安全

**优点**：

- 线程安全，由 JVM 类加载机制天然保证
- 支持懒加载，只有在首次调用 `getInstance()` 时才加载 `SingletonHolder` 类并创建实例
- 无锁，性能优秀
- 实现优雅，代码简洁
- 推荐使用的懒加载单例实现方式

**缺点**：

- 无法在创建实例时传递参数
- 如果实例化过程需要依赖外部参数，则不适合使用此方式
- 反序列化和反射攻击仍可能破坏单例（需要额外防护）

**适用场景**：

- 需要线程安全的懒加载单例
- 对性能要求较高
- 不需要在实例化时传递参数

---

## 四、枚举单例（Enum Singleton）

**类名**：`EnumSingleton`

**实现方式**：利用 Java 枚举的特性实现单例。枚举实例在 JVM 中由 JVM 保证唯一性，且枚举的构造方法由 JVM 在类加载时调用，天然线程安全。

**代码示例**：

```java
public enum EnumSingleton {

    INSTANCE;

    EnumSingleton() {
    }

    public void method() {
        // 业务方法
    }
}
```

**特点**：

- 利用 Java 枚举的语法特性，实现最为简洁
- JVM 保证枚举实例的唯一性和线程安全
- 枚举实例在类加载时创建

**优点**：

- **实现最简洁**，代码量最少
- **天然线程安全**，由 JVM 保证
- **天然防止反射攻击**：Java 语言规范禁止通过反射创建枚举实例
- **天然防止反序列化破坏单例**：枚举的序列化机制由 JVM 特殊处理，反序列化时不会创建新实例
- Effective Java 作者 Joshua Bloch 推荐的方式

**缺点**：

- 不支持懒加载，枚举实例在类加载时就创建
- 无法继承其他类（Java 枚举隐式继承 `java.lang.Enum`）
- 无法在构造方法中传递参数（枚举构造方法由 JVM 控制调用时机）
- 在某些序列化框架中可能需要特殊处理

**适用场景**：

- 最推荐的单例实现方式，尤其适合需要防止反射和反序列化攻击的场景
- 不需要懒加载
- 不需要继承其他类

---

## 五、对比总结

| 实现方式               | 线程安全 | 懒加载 | 防反射攻击 | 防反序列化破坏 | 性能       | 实现复杂度 |
|------------------------|----------|--------|------------|----------------|------------|------------|
| 饿汉式（静态变量）     | ✅       | ❌     | ❌         | ❌             | ⭐⭐⭐⭐⭐ | ⭐         |
| 饿汉式（静态代码块）   | ✅       | ❌     | ❌         | ❌             | ⭐⭐⭐⭐⭐ | ⭐⭐       |
| 懒汉式（线程不安全）   | ❌       | ✅     | ❌         | ❌             | ⭐⭐⭐⭐   | ⭐         |
| 懒汉式（synchronized） | ✅       | ✅     | ❌         | ❌             | ⭐⭐       | ⭐⭐       |
| 双重检查锁（DCL）      | ✅*      | ✅     | ❌         | ❌             | ⭐⭐⭐⭐   | ⭐⭐⭐     |
| 静态内部类             | ✅       | ✅     | ❌         | ❌             | ⭐⭐⭐⭐⭐ | ⭐⭐       |
| 枚举                   | ✅       | ❌     | ✅         | ✅             | ⭐⭐⭐⭐⭐ | ⭐         |

> *双重检查锁需要配合 `volatile` 关键字才能完全保证线程安全

---

## 六、推荐使用场景

1. **一般场景推荐**： **静态内部类** 实现方式，兼顾懒加载、线程安全、无锁高性能
2. **安全性要求高**： **枚举** 实现方式，天然防反射和反序列化攻击
3. **简单场景**： **饿汉式** 实现方式，实现最简单，适合确定会使用的单例
4. **需要懒加载 + 参数传递**： **双重检查锁（DCL）** 实现方式，注意配合 `volatile` 使用

---

## 七、线程池并发测试

项目中 `EagerSingletonTest` 使用 10 线程的线程池对以上所有单例实现进行了并发测试，验证多线程环境下的单例唯一性。

```java
ExecutorService executorService = Executors.newFixedThreadPool(10);
Runnable runnable = () -> {
    Singleton singleton = Singleton.getInstance();
    System.out.println(singleton + " " + Thread.currentThread().getName());
};
for(
int i = 0;
i< 10;i++){
        executorService.

execute(runnable);
}
        executorService.

shutdown();
```

测试方法说明： | 测试方法 | 测试对象 | 测试目的 | |---------|---------|---------| | `test()` | `Singleton` | 验证饿汉式（静态变量）多线程下的实例唯一性 | | `test2()` |
`NewSingleton` | 验证饿汉式（静态代码块）多线程下的实例唯一性 | | `test3()` | `ThreadUnsafeSingleton` | 验证懒汉式（线程不安全）在高并发下的实例非唯一性 | | `test4()` |
`ThreadSafeSingleton` | 验证懒汉式（synchronized）多线程下的实例唯一性 | | `test5()` | `DoubleCheckLockSingleton` | 验证双重检查锁多线程下的实例唯一性 | | `test6()` |
`InnerClassSingleton` | 验证静态内部类多线程下的实例唯一性 | | `test7()` | `EnumSingleton` | 验证枚举单例多线程下的实例唯一性 |
