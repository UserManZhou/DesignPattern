# 观察者模式 (Observer Pattern)

---

## 一、模式概述

### 1.1 定义

观察者模式（Observer Pattern）是一种**行为型设计模式**，定义了对象之间的一对多依赖关系。当一个对象（Subject/主题）的状态发生改变时，所有依赖于它的对象（Observer/观察者）都会得到通知并自动更新。

### 1.2 别名

- 发布-订阅模式（Publish-Subscribe，简化的理解）
- 模型-视图模式（Model-View）
- 源-监听器模式（Source-Listener）

### 1.3 核心思想

**松耦合（Loose Coupling）**：主题只知道观察者实现了某个接口，不需要知道观察者的具体类是谁、做了什么。主题和观察者之间是抽象耦合，可以独立地复用和扩展。

---

## 二、模式结构

### 2.1 UML 类图

```
┌─────────────────────────────────────────────────────────────────┐
│                          <<interface>>                           │
│                           Subject                               │
├─────────────────────────────────────────────────────────────────┤
│ + registerObserver(observer: Observer): void                    │
│ + removeObserver(observer: Observer): void                      │
│ + notifyObservers(): void                                       │
└──────────────────────────┬──────────────────────────────────────┘
                           │
                           │ implements
                           │
┌──────────────────────────▼──────────────────────────────────────┐
│                       ObjectFor3D                               │
├─────────────────────────────────────────────────────────────────┤
│ - listeners: List<Observer>       // 观察者列表                   │
│ - msg: String                     // 主题状态(3D号码)             │
├─────────────────────────────────────────────────────────────────┤
│ + registerObserver(observer: Observer): void                    │
│ + removeObserver(observer: Observer): void                      │
│ + notifyObservers(): void          // 遍历通知所有观察者           │
│ + setMsg(msg: String): void        // 改变状态 + 通知             │
└──────┬──────────────────────────────────────────────────────────┘
       │
       │ notifies (通知)
       │
       ▼
┌─────────────────────────────────────────────────────────────────┐
│                      <<interface>>                               │
│                        Observer                                 │
├─────────────────────────────────────────────────────────────────┤
│ + update(msg: String): void                                     │
└──────┬────────────────────────────────┬─────────────────────────┘
       │                                │
       │ implements                     │ implements
       │                                │
┌──────▼──────────────────┐   ┌─────────▼─────────────────────────┐
│       Observer1         │   │          Observer2                 │
├─────────────────────────┤   ├───────────────────────────────────┤
│ + Observer1(subject)    │   │ + Observer2(subject)               │
│   // 构造时注册自己       │   │   // 构造时注册自己                 │
│ + update(msg): void     │   │ + update(msg): void               │
│   // 打印 "observer1    │   │   // 打印 "observer2               │
│      得到3D号码..."      │   │      得到3D号码..."                │
└─────────────────────────┘   └───────────────────────────────────┘
```

### 2.2 角色说明

| 角色 | 类/接口 | 职责 |
|------|---------|------|
| **抽象主题 (Subject)** | `Subject` 接口 | 提供注册、移除、通知观察者的接口规范 |
| **具体主题 (ConcreteSubject)** | `ObjectFor3D` | 维护观察者列表；状态变化时通知所有观察者 |
| **抽象观察者 (Observer)** | `Observer` 接口 | 定义 `update()` 更新接口，所有观察者必须实现 |
| **具体观察者 (ConcreteObserver)** | `Observer1`, `Observer2` | 实现 `update()`，执行具体的响应逻辑 |

---

## 三、代码详解

### 3.1 项目目录结构

```
observer/
├── README.md                          ← 本文档
└── repository/
    ├── Subject.java                   ← 抽象主题接口
    ├── Observer.java                  ← 抽象观察者接口
    ├── ObjectFor3D.java               ← 具体主题（3D服务号）
    └── service/
        ├── Observer1.java             ← 具体观察者1（使用者1）
        └── Observer2.java             ← 具体观察者2（使用者2）
```

### 3.2 抽象主题接口：`Subject.java`

```java
@Component
public interface Subject {
    void registerObserver(Observer observer);   // 注册观察者
    void removeObserver(Observer observer);     // 移除观察者
    void notifyObservers();                     // 通知所有观察者
}
```

**要点分析：**
- 使用 `@Component` 注解，说明在 Spring 容器中可以通过类型注入。
- 三个核心方法构成了主题的标准协议：**注册 → 移除 → 通知**。
- 接口隔离原则：只暴露观察者管理相关的方法。

### 3.3 抽象观察者接口：`Observer.java`

```java
public interface Observer {
    void update(String msg);  // 接收主题的更新通知
}
```

**要点分析：**
- 极简设计，只有一个 `update(String msg)` 方法。
- `msg` 参数是被推送的数据（推模型），观察者被动接收。
- 也可设计为空参，让观察者主动拉取（拉模型），Java 内置的 `Observer.update(Observable o, Object arg)` 就是推拉结合。

### 3.4 具体主题：`ObjectFor3D.java`

```java
public class ObjectFor3D implements Subject {
    private List<Observer> listeners = new ArrayList<>();  // 观察者列表
    private String msg;                                     // 主题状态

    @Override
    public void registerObserver(Observer observer) {
        listeners.add(observer);        // 添加到列表
    }

    @Override
    public void removeObserver(Observer observer) {
        int indexOf = listeners.indexOf(observer);
        if (indexOf >= 0) {
            listeners.remove(indexOf);  // 安全移除
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer listener : listeners) {
            listener.update(msg);       // 逐个通知
        }
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();              // 状态变化 → 自动通知！
    }
}
```

**要点分析：**
- `listeners` 使用 `ArrayList` 存储，通知顺序与注册顺序一致。
- `setMsg()` 中改变状态后**立即调用** `notifyObservers()`，这是观察者模式的典型用法。
- `removeObserver()` 中使用了 `indexOf()` 判断，避免因不存在的元素触发异常。
- 业务场景：**"3D服务号"** 模拟的是彩票/号码推送服务，当号码更新时通知所有订阅者。

### 3.5 具体观察者1：`Observer1.java`

```java
public class Observer1 implements Observer {
    public Observer1(Subject subject) {
        subject.registerObserver(this);  // 构造时自动注册！
    }

    @Override
    public void update(String msg) {
        System.out.println("observer1 得到 3D 号码  -->" + msg + ", 我要记下来。");
    }
}
```

**要点分析：**
- **构造时自动注册**：这是常见的设计技巧，观察者创建时自动绑定到主题，减少调用方的心智负担。
- `update()` 中的逻辑很简单（仅打印），实际项目中可以替换为：更新数据库、发送消息、刷新UI等。

### 3.6 具体观察者2：`Observer2.java`

```java
public class Observer2 implements Observer {
    public Observer2(Subject subject) {
        subject.registerObserver(this);  // 同样的构造时注册模式
    }

    @Override
    public void update(String msg) {
        System.out.println("observer2 得到 3D 号码  -->" + msg + ", 我要记下来。");
    }
}
```

**要点分析：**
- 与 Observer1 结构完全一致，体现了观察者模式的核心优势：**主题不需要知道观察者的具体类型，新增观察者无需改动主题代码**。
- 符合**开闭原则**：对扩展开放（新增观察者），对修改关闭（无需修改 Subject/ObjectFor3D）。

---

## 四、执行流程

### 4.1 时序图

```
客户端              ObjectFor3D         Observer1          Observer2
  │                     │                   │                  │
  │  new Observer1(s)   │                   │                  │
  │─────────────────────>                   │                  │
  │                     │ registerObserver  │                  │
  │                     │<──────────────────│                  │
  │                     │ (listeners.add)   │                  │
  │                     │                   │                  │
  │  new Observer2(s)   │                   │                  │
  │─────────────────────────────────────────────────────────>  │
  │                     │ registerObserver                    │
  │                     │<────────────────────────────────────│
  │                     │ (listeners.add)                     │
  │                     │                   │                  │
  │  setMsg("2026-001") │                   │                  │
  │─────────────────────>                   │                  │
  │                     │ (msg = "2026-001")│                  │
  │                     │ notifyObservers() │                  │
  │                     │───────update──────>                  │
  │                     │                   │ "observer1 得    │
  │                     │                   │ 到3D号码→        │
  │                     │                   │ 2026-001..."     │
  │                     │───────────────────────────────update─>
  │                     │                   │        "observer2│
  │                     │                   │        得到..."   │
  │                     │                   │                  │
```

### 4.2 执行步骤

1. **创建主题**：`ObjectFor3D subject = new ObjectFor3D();`
2. **创建观察者并自动注册**：
   - `new Observer1(subject)` → 构造器中调用 `subject.registerObserver(this)`
   - `new Observer2(subject)` → 同上
3. **触发通知**：`subject.setMsg("2026-001")` → 内部调用 `notifyObservers()`
4. **通知传播**：遍历 `listeners` 列表，依次调用每个观察者的 `update(msg)`
5. **观察者响应**：Observer1 和 Observer2 各自执行自己的 `update()` 逻辑

---

## 五、推模型 vs 拉模型

### 5.1 本项目采用：推模型 (Push Model)

```
Subject ──update(msg)──> Observer
          (推送数据)
```

- **优点**：观察者实现简单，不需要主动获取数据。
- **缺点**：所有观察者收到相同的数据，不够灵活；如果 Subject 字段很多，推送全部数据是浪费。

### 5.2 拉模型 (Pull Model)

```
Subject ──update()──> Observer ──getData()──> Subject
        (仅通知）      (观察者主动拉取)
```

- **优点**：观察者可按需拉取所需数据，更灵活。
- **缺点**：观察者需要持有 Subject 的引用，耦合度略高。

实际项目中，**推拉结合**最常用：通知时携带最小必要信息，观察者需要更多细节时再拉取。

---

## 六、优缺点分析

### 6.1 优点

| 优点 | 说明 |
|------|------|
| **松耦合** | Subject 只依赖 Observer 接口，不依赖具体实现 |
| **开闭原则** | 新增观察者无需修改 Subject 代码 |
| **广播通信** | 一个 Subject 变化，所有 Observer 自动收到通知 |
| **动态关系** | 可在运行时动态添加/移除观察者 |

### 6.2 缺点

| 缺点 | 说明 |
|------|------|
| **通知顺序不可控** | `ArrayList` 的顺序是注册顺序，但多线程下可能出问题 |
| **性能问题** | 观察者多时，逐个通知可能较慢 |
| **循环依赖风险** | 如果观察者和主题互相调用 update，可能造成死循环 |
| **内存泄漏** | 观察者注册后忘记移除，导致无法被 GC 回收 |
| **异常处理** | 一个观察者抛出异常可能影响后续观察者的通知 |

### 6.3 改进建议

- 使用 `CopyOnWriteArrayList` 替代 `ArrayList` 保证线程安全。
- 在 `notifyObservers()` 中增加 try-catch，一个观察者异常不影响其他观察者。
- 观察者不再需要时，务必调用 `removeObserver()` 移除。

---

## 七、Java/Spring 中的观察者模式

### 7.1 JDK 内置实现（Java 9 之前）

```java
// 已废弃但仍值得了解
java.util.Observable   // 主题基类
java.util.Observer     // 观察者接口
```

- 从 Java 9 开始被标记为 `@Deprecated`，原因是：Observable 是类而非接口，限制了复用。

### 7.2 Spring 事件机制

Spring 的事件机制本质上也是观察者模式的实现：

| Spring 角色 | 对应观察者模式角色 |
|-------------|-------------------|
| `ApplicationEvent` | 消息/数据载体 |
| `ApplicationEventPublisher` | 主题 (Subject) |
| `@EventListener` / `ApplicationListener` | 观察者 (Observer) |
| `ApplicationContext` | 事件总线 |

```java
// Spring 风格的观察者模式示例
@Component
public class OrderService {
    @Autowired
    private ApplicationEventPublisher publisher;

    public void createOrder() {
        // ... 业务逻辑
        publisher.publishEvent(new OrderCreatedEvent(this, order));
    }
}

@Component
public class SmsListener {
    @EventListener
    public void handleOrderCreated(OrderCreatedEvent event) {
        // 发送短信通知
    }
}
```

### 7.3 本项目与 Spring 结合

本项目的 `Subject` 接口标注了 `@Component`，说明项目中后续可能会通过 Spring 的依赖注入来获取和管理 Subject 实例，将观察者模式与 Spring 容器整合。

---

## 八、业务场景深度解析

> 好的设计模式一定诞生于真实的业务痛点。下面从业务视角出发，完整复盘「3D服务号推送系统」的设计推导过程。

### 8.1 业务背景：一个标准的消息订阅需求

**场景设定：**

> 某体育彩票中心运营着一个「3D福彩服务号」，每天开奖后会产出一个最新的 3D 中奖号码。彩民们希望第一时间知道号码，但不同彩民的关注点和后续动作各不相同：
> - **彩民甲（Observer1）**：收到号码后记录到自己的笔记本里。
> - **彩民乙（Observer2）**：收到号码后也记下来，但他用的是手机的备忘录。
> - **未来可能加入的彩民丙**：收到号码后直接转发到微信群。
> - **未来可能加入的彩民丁**：收到号码后用算法分析下一期的趋势。

**核心业务问题：服务号如何通知所有彩民，又不与每个彩民的具体行为强绑定？**

### 8.2 业务推导：从笨办法到设计模式

#### ❌ 方案一：硬编码调用（最原始的做法）

```java
// 服务号每次产生新号码后，逐个调用每个彩民的方法
public class Bad3DService {
    private Observer1 user1 = new Observer1();
    private Observer2 user2 = new Observer2();

    public void newNumber(String msg) {
        user1.recordInNotebook(msg);  // 写死：彩民甲用笔记本记录
        user2.recordInPhone(msg);     // 写死：彩民乙用手机记录
        // 每来一个新彩民，都要改这段代码！→ 违反开闭原则
    }
}
```

**问题**：每增加一个彩民，服务号代码就得改。100 个彩民 = 100 行硬编码。这是维护噩梦。

#### ❌ 方案二：统一方法名（稍好一点，但还不够）

```java
// 规定所有彩民必须实现 record() 方法，但仍是逐个硬编码
public class StillBadService {
    private UserA userA = new UserA();  // UserA 有 record() 方法
    private UserB userB = new UserB();  // UserB 也有 record() 方法

    public void newNumber(String msg) {
        userA.record(msg);  // 虽然方法名统一了，但变量类型是写死的
        userB.record(msg);  // 新增用户仍需改代码
    }
}
```

**问题**：方法名统一了，但服务号仍然持有每个具体用户的引用——没有解耦。

#### ✅ 方案三：观察者模式（本项目的做法）

```java
// 服务号只认识"观察者"这个角色，不关心具体是谁
public class ObjectFor3D implements Subject {
    private List<Observer> listeners = new ArrayList<>();  // 只依赖接口，不依赖具体类！

    public void setMsg(String msg) {
        this.msg = msg;
        for (Observer listener : listeners) {
            listener.update(msg);  // 多态！谁来都行，只要实现了 Observer 接口
        }
    }
}
```

**业务价值**：
- 新增彩民只需新建一个类实现 `Observer`，服务号代码 **零改动**。
- 服务号不知道也不需要知道彩民收到号码后做什么 —— 真正的解耦。

### 8.3 业务角色映射

将代码中的类映射回真实业务角色，理解"谁在做什么"：

```
业务世界                             代码世界
─────────                           ─────────
「3D福彩服务号」         ←→     ObjectFor3D (具体主题)
    │ 每天开奖                           │ 持有号码 msg
    │ 通知所有订阅者                      │ 维护 listeners 列表
    │                                    │ setMsg() 触发 notifyObservers()

「彩民甲」                ←→     Observer1 (具体观察者)
    │ 用笔记本记录号码                    │ update() 中打印 "observer1 得到..."
    │ 订阅服务号                          │ 构造器中 subject.registerObserver(this)

「彩民乙」                ←→     Observer2 (具体观察者)
    │ 用手机备忘录记录                    │ update() 中打印 "observer2 得到..."
    │ 订阅服务号                          │ 同上

「未来彩民丙」(假设)      ←→     EmailObserver (可随时新增)
    │ 转发到微信群                        │ update() 中发送群消息
    │ 订阅服务号                          │ 同上，无需改任何现有代码！
```

### 8.4 完整业务流程推演

```
时间线 ──────────────────────────────────────────────────────────>

Day 1  上午 9:00   服务号「3D福彩」上线
                   new ObjectFor3D() — 服务号创建好了，暂时没人订阅
                   
       上午 9:05   彩民甲看到广告，扫码关注
                   new Observer1(subject)
                   └→ subject.registerObserver(this) — 彩民甲进入订阅列表
                   
       上午 9:10   彩民乙也关注了
                   new Observer2(subject)
                   └→ subject.registerObserver(this) — 彩民乙进入订阅列表

                   此时的 listeners 列表：[Observer1@a1b2, Observer2@c3d4]
                   ─────────────────────────────────────────────

       晚上 8:30   🎰 开奖！号码「2026-001」诞生
                   subject.setMsg("2026-001")
                   │
                   ├─→ [1/2] observer1.update("2026-001")
                   │         彩民甲收到通知 → "observer1 得到 3D 号码 -->2026-001, 我要记下来。"
                   │         掏出笔记本记录下来 ✍️
                   │
                   └─→ [2/2] observer2.update("2026-001")
                             彩民乙收到通知 → "observer2 得到 3D 号码 -->2026-001, 我要记下来。"
                             打开手机备忘录记录下来 📱
                   ─────────────────────────────────────────────

Day 30  彩民甲中奖了，不再关注
                   subject.removeObserver(observer1)
                   └→ 彩民甲从订阅列表移除，下期不再收到通知
                   
       新来了彩民丙（要求发微信通知）
                   new WechatObserver(subject)
                   └→ 无需改动服务号代码，直接加入订阅列表
                   ─────────────────────────────────────────────
                   
       晚上 8:30   再次开奖
                   只有 Observer2 和 WechatObserver 收到通知
                   Observer1 已退订，不会收到
```

### 8.5 业务扩展：从不打印变成真实业务动作

当前代码中 `update()` 只做 `System.out.println()`，是为了演示。在真实业务中，可以替换为：

```java
// 彩民甲：记录到数据库
public class Observer1 implements Observer {
    @Override
    public void update(String msg) {
        historyRepository.save(new NumberRecord(msg, LocalDateTime.now()));
    }
}

// 彩民乙：发送短信给自己
public class Observer2 implements Observer {
    @Override
    public void update(String msg) {
        smsService.send("138xxxx1234", "最新3D号码: " + msg + "，祝您好运！");
    }
}

// 彩民丙：转发微信群
public class WechatObserver implements Observer {
    @Override
    public void update(String msg) {
        wechatBot.sendGroupMsg("彩民交流群", "开奖啦！本期3D号码：" + msg);
    }
}

// 彩民丁：AI 趋势分析
public class AIAnalysisObserver implements Observer {
    @Override
    public void update(String msg) {
        aiEngine.analyzeTrend(msg);  // 用算法分析下期走势
    }
}

// 服务号代码！——完全不需要改动！
subject.setMsg("2027-001");  // 一行代码触发四个完全不同业务动作
```

**关键洞察**：`subject.setMsg()` 这一行代码，触发了四个**完全不同**的业务行为（存库、发短信、发微信、AI分析）——但服务号对此一无所知，也不需要知道。这就是观察者模式的业务威力。

### 8.6 业务场景对比：如果用其他方式实现

| 实现方式 | 新增 1 个用户 | 新增 10 个用户 | 新增 100 个用户 |
|---------|-------------|--------------|---------------|
| 硬编码逐个调用 | 改 1 处服务号代码 | 改 10 处服务号代码 | 改 100 处，不可维护 |
| 观察者模式 | 新建 1 个类 + 注册 | 新建 10 个类 + 注册 | 新建 100 个类 + 注册，**服务号 0 改动** |

### 8.7 现实世界的业务类比

| 现实业务 | Subject（主题） | Observer（观察者） | 通知内容 |
|---------|----------------|-------------------|---------|
| 📰 公众号订阅 | 公众号 | 粉丝 | 新文章推送 |
| 📧 邮件订阅 | 新闻网站 | 订阅者 | 每日简报 |
| 📈 股票预警 | 股票交易所 | 股民 | 价格突破阈值 |
| 🛒 外卖配送 | 外卖平台 | 买家 | 骑手位置更新 |
| 🏦 银行风控 | 交易系统 | 风控系统/短信/邮件 | 大额交易告警 |
| 🏥 医院挂号 | 挂号系统 | 患者APP/短信/大屏 | 叫号通知 |
| 🎮 游戏活动 | 游戏服务器 | 在线玩家 | 限时活动公告 |

### 8.8 从本项目延伸：业务中何时该用观察者模式？

> **是否需要观察者模式的判据**（自问三题）：

1. ✅ 是否存在 **1 个对象的改变需要通知 N 个其他对象**？（一对多）
2. ✅ 这 N 个对象的**具体类型和行为各不相同**？（异质观察者）
3. ✅ 未来**可能还会新增**更多类型的观察者？（可扩展性要求）

如果三个问题答案都是"是"——观察者模式就是最佳选择。

**反例（不适用观察者模式的情况）：**

```java
// 如果只有一个观察者，且永远不会变 → 不需要观察者模式，直接调用即可
public void handleOrder(Order order) {
    logService.log(order);  // 只有一个消费者，不需要一对多机制
}
```

---

## 九、与其他模式对比

| 对比模式 | 关系 | 区别 |
|---------|------|------|
| **发布-订阅模式** | 很相似 | Pub/Sub 通常有独立的 Event Channel/Broker，发布者和订阅者完全解耦且互不知晓；观察者模式中 Subject 直接维护 Observer 列表 |
| **中介者模式** | 相似但不同 | 中介者模式用一个中介对象来封装对象间的交互（星型结构）；观察者模式是 Subject 直接通知 Observers（广播） |
| **责任链模式** | 都是行为型 | 责任链中请求沿链传递直到被处理；观察者模式中所有观察者都会收到通知 |

---

## 十、设计原则体现

| 设计原则 | 体现 |
|---------|------|
| **开闭原则 (OCP)** | 新增 Observer1/Observer2 等观察者，无需修改 Subject/ObjectFor3D |
| **依赖倒置原则 (DIP)** | Subject 依赖抽象的 Observer 接口，而非具体类 |
| **单一职责原则 (SRP)** | Subject 只负责维护观察者和通知，Observer 只负责响应更新 |
| **里氏替换原则 (LSP)** | 所有 Observer 子类都可以替换接口使用 |
| **接口隔离原则 (ISP)** | Observer 接口只有一个 `update()` 方法，非常精简 |

---

## 十一、面向对象视角解析

观察者模式不仅是一个设计模式，更是面向对象四大特性（**封装、继承、多态、抽象**）的经典教学案例。下面从 OOP 本质出发，逐层拆解本项目代码。

### 11.1 封装 (Encapsulation)

> **隐藏内部实现细节，只暴露必要的访问接口。**

```java
// ObjectFor3D.java
private List<Observer> listeners = new ArrayList<>();  // ① 观察者列表：私有
private String msg;                                     // ② 主题状态：私有

public void setMsg(String msg) {                        // ③ 唯一的外部入口
    this.msg = msg;
    notifyObservers();     // 通知逻辑也被封装在内部
}
```

**封装体现：**

| 封装点 | 具体表现 | 好处 |
|--------|---------|------|
| 观察者列表 `listeners` | `private`，外部无法直接操作 | 防止外部直接修改列表导致不一致 |
| 状态数据 `msg` | `private`，只能通过 `setMsg()` 修改 | 数据入口可控，状态变更必定触发通知 |
| 通知逻辑 | 隐藏在 `notifyObservers()` 中 | 调用方无需关心通知机制（遍历/异常处理等） |
| 注册/移除 | 通过 `registerObserver` / `removeObserver` 方法 | 封装了对 `ArrayList` 的操作细节 |

> **一句话总结**：外部只看到 `setMsg()`，但不知道内部维护了一个观察者列表并会自动广播——这就是封装的力量。

### 11.2 继承与接口实现 (Inheritance & Interface Implementation)

> **子类复用父类的行为规范，通过接口定义协议。**

```
         <<interface>>               <<interface>>
           Subject                      Observer
              ▲                            ▲
              │ implements                 │ implements
              │                            │
         ObjectFor3D          Observer1 / Observer2
         (具体主题)              (具体观察者)
```

**本项目的继承结构：**

```java
// 1. Subject 是契约（协议），不是实现
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 2. ObjectFor3D "is-a" Subject —— 接口实现即是一种继承关系
public class ObjectFor3D implements Subject { ... }

// 3. Observer1 "is-a" Observer —— 同样的契约驱动
public class Observer1 implements Observer { ... }
public class Observer2 implements Observer { ... }
```

**为什么用接口而非抽象类？**

| 对比 | 接口 (Interface) | 抽象类 (Abstract Class) |
|------|-----------------|------------------------|
| 多实现 | ✅ 可实现多个接口 | ❌ 只能继承一个类 |
| 耦合度 | 极低，只有方法签名 | 可能有成员变量和已实现方法 |
| JDK 9 教训 | — | Java 9 废弃 `Observable` 正是因为它是个类 |

> **一句话总结**：接口定义了 **"做什么"**（协议），子类负责 **"怎么做"**（策略）。同一个 `update` 接口，Observer1 和 Observer2 可以有完全不同的行为。

### 11.3 多态 (Polymorphism)

> **同一个接口调用，表现出不同的行为——这是观察者模式最核心的 OOP 机制。**

```java
// ObjectFor3D.java —— notifyObservers() 方法
public void notifyObservers() {
    for (Observer listener : listeners) {   // ① 声明类型是 Observer 接口
        listener.update(msg);               // ② 运行时动态绑定到具体子类的 update()
    }                                        // ③ 多态！编译时不确定调用谁的方法
}
```

**多态执行过程（运行时绑定）：**

```
listeners = [Observer1@a1b2, Observer2@c3d4]

   遍历 → listener = Observer1@a1b2
            listener.update("2026-001")
            │
            └── JVM 查找 Observer1 的方法表
                └── 执行 Observer1.update() → "observer1 得到3D号码..."
    
   遍历 → listener = Observer2@c3d4
            listener.update("2026-001")
            │
            └── JVM 查找 Observer2 的方法表
                └── 执行 Observer2.update() → "observer2 得到3D号码..."
```

**多态的三个必要条件在本项目中全部满足：**

| 条件 | 本项目体现 |
|------|-----------|
| ① 继承/实现关系 | `Observer1`, `Observer2` 实现了 `Observer` 接口 |
| ② 方法重写 | 各自重写了 `update(String msg)` |
| ③ 父类引用指向子类对象 | `Observer listener` 指向 `Observer1` 或 `Observer2` 实例 |

> **一句话总结**：Subject 只认识 `Observer` 接口，在编译期完全不知道有哪些具体观察者，但运行时 JVM 通过动态绑定自动找到正确的 `update()` 实现——这就是多态的魔力。

### 11.4 抽象 (Abstraction)

> **只暴露关键信息，隐藏无关细节。在接口层面定义"本质是什么"。**

```java
// 抽象的层次结构

  【高层抽象】Subject/Observer 接口  ← 只定义"是什么角色"
        │          (注册/移除/通知) / (更新)
        │
  【中层抽象】ObjectFor3D            ← 定义"如何维护关系"
        │          (ArrayList管理、通知遍历)
        │
  【具体实现】Observer1/Observer2   ← 定义"收到通知后做什么"
                   (打印日志)
```

**抽象的层次拆分：**

| 抽象层级 | 文件 | 抽象了什么 | 隐藏了什么 |
|---------|------|-----------|-----------|
| 接口层 | `Subject.java` | "主题"角色的本质行为 | 存储结构、通知方式 |
| 接口层 | `Observer.java` | "观察者"角色的本质行为 | 收到通知后的具体逻辑 |
| 实现层 | `ObjectFor3D.java` | 主题的标准实现模式 | 具体的业务场景（3D号码） |
| 实现层 | `Observer1.java` | 一个观察者的响应模式 | 这只是打印，实际可以是发短信/写库/刷新UI |

**为什么抽象如此重要？——开放扩展的案例：**

```java
// 假设要新增"发送邮件"的观察者，只需新增一个类：

public class EmailObserver implements Observer {
    public EmailObserver(Subject subject) {
        subject.registerObserver(this);
    }
    
    @Override
    public void update(String msg) {
        sendEmail("user@example.com", "新3D号码: " + msg);  // 全新行为！
    }
}

// Subject、Observer、ObjectFor3D、Observer1、Observer2 —— 全部不需要改动！
```

> **一句话总结**：抽象让我们可以在不修改现有代码的前提下扩展系统——新增一个 `EmailObserver`，只需新建一个文件，零改动历史代码。

### 11.5 对象之间的关联关系 (Association / Aggregation)

> **对象之间的关系，决定了系统的耦合程度和生命周期。**

```
                    Subject (接口)
                        ▲
                        │ 实现
                        │
                   ObjectFor3D ◄──────────────────── 持有引用
                       │                                │
                       │ 1:N                            │ N
                       │ 聚合(Aggregation)               │
                       ▼                                │
                 List<Observer> ────────包含────────────┘
                       │
                       ├── Observer1  (独立生命周期)
                       └── Observer2  (独立生命周期)
```

**关系分析：**

| 关系类型 | 描述 | 代码体现 | 生命周期 |
|---------|------|---------|---------|
| **实现 (Realization)** | ObjectFor3D 实现 Subject 接口 | `implements Subject` | — |
| **聚合 (Aggregation)** | Subject 持有多个 Observer | `List<Observer> listeners` | Observer 可以独立于 Subject 存在 |
| **依赖 (Dependency)** | Observer 构造器依赖 Subject | `Observer1(Subject subject)` | 仅在构造时使用，不长期持有 |

**为什么是聚合而非组合？**

```java
// 聚合（Aggregation）：松散的"has-a"关系
// Observer 可以同时属于多个 Subject，也可以脱离 Subject 独立存在
Observer1 obs = new Observer1(subjectA);
obs.doOtherThings();  // Observer 有自己独立的生命周期

// 如果是组合（Composition）：强依赖的"part-of"关系
// Observer 的生命周期完全由 Subject 控制——本项目不是这种情况
```

> **一句话总结**：Subject 和 Observer 之间是松散的聚合关系——Observer 可以动态加入和退出，互不依赖对方的生命周期。

### 11.6 OOP 总结对照表

| OOP 特性 | 核心问题 | 本项目答案 | 关键代码位置 |
|---------|---------|-----------|-------------|
| **封装** | 隐藏什么？暴露什么？ | 隐藏 `listeners` 和 `msg`，暴露 `setMsg()` | `ObjectFor3D.java` |
| **继承/实现** | is-a 关系是什么？ | Observer1 is-a Observer；ObjectFor3D is-a Subject | 所有 `.java` 文件 |
| **多态** | 如何统一处理不同对象？ | `listener.update(msg)` — 运行时动态绑定 | `ObjectFor3D.notifyObservers()` |
| **抽象** | 本质是什么？ | Subject = 通知者，Observer = 响应者 | `Subject.java`, `Observer.java` |
| **关联/聚合** | 对象间是什么关系？ | Subject 1:N Observer，松散的聚合关系 | `ObjectFor3D.listeners` |

---

## 十二、复习要点

1. **核心公式**：Subject(1) ──notify──> Observer(N)，一对多依赖。
2. **三个关键方法**：`register` / `remove` / `notify`。
3. **推 vs 拉**：本项目是推模型，`update(msg)` 直接携带数据。
4. **构造时注册**：`Observer1(Subject)` 构造器中自动注册，简化使用。
5. **状态变化即通知**：`setMsg()` 中调用 `notifyObservers()`，是关键触发点。
6. **线程安全考虑**：多线程环境下 `ArrayList` 不安全，可用 `CopyOnWriteArrayList`。
7. **内存泄漏注意**：观察者不再使用时需调用 `removeObserver()` 移除。
8. **Spring 事件机制** 是观察者模式的企业级实现，工作中更常用。
9. **Java 9 废弃**了内置的 `Observer/Observable`，原因是 Observable 是类而非接口。
10. **适用判据**：当一个对象的变化需要通知多个其他对象，且不知道具体有哪些对象时，用观察者模式。

---

## 十三、项目文件索引

| 文件 | 路径 | 角色 |
|------|------|------|
| Subject.java | `observer/repository/Subject.java` | 抽象主题接口 |
| Observer.java | `observer/repository/Observer.java` | 抽象观察者接口 |
| ObjectFor3D.java | `observer/repository/ObjectFor3D.java` | 具体主题（3D服务号） |
| Observer1.java | `observer/repository/service/Observer1.java` | 具体观察者1 |
| Observer2.java | `observer/repository/service/Observer2.java` | 具体观察者2 |

---

> **创建日期**：2026-05-21  
> **作者**：zh  
> **文档生成日期**：2026-06-04
