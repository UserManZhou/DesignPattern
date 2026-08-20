# 策略模式 (Strategy Pattern)

---

## 一、模式概述

### 1.1 定义

策略模式（Strategy Pattern）是一种**行为型设计模式**，它定义了一组算法族（Strategy Family），将每一种算法分别封装起来，使它们可以互相替换。算法的变化独立于使用它的客户（Context）。

### 1.2 别名

- Policy 模式
- 策略模式 / 政策模式

### 1.3 核心思想

**多用组合、少用继承（Favor Composition over Inheritance）**：行为被抽象为一组策略接口，运行时通过注入 / 切换实现动态替换，而不是用继承在子类里重写行为。

### 1.4 类图定位

GoF 23 种设计模式中的**行为型模式**。

### 1.5 一句话理解

**"结果一样，做法不同，做法可随时换"**——先把这句话记住，再往下看例子。本项目里，`Role`（角色）的"攻击 / 防御 / 奔跑 / 显示"就是四个可以随时更换的做法。

---

## 二、通俗易懂的例子：先懂概念再看代码

> 看代码之前，先用日常生活的例子把"策略模式到底在解决什么问题"讲透。你会发现：策略模式一点都不神秘，它就是你每天都在做的事。每个例子都配一张"生活角色 ↔ 策略模式角色"的小映射表。

### 2.1 例子一：出行 / 通勤方式（首选）

**场景**：从家到公司，目的地固定不变。可以选择地铁、打车、骑自行车或者步行——"到达公司"这个结果完全相同，但**每一种出行方式就是一套独立的算法（策略）**。

- 换乘演绎：今天下雨打车，明天天气好改乘地铁——**人不用换，只换出行方式**（这就是运行时切换策略）。
- 新方式加入：共享单车出现后，只需新增"骑单车"这一种方式，通勤者（Context）的代码零改动。

| 生活角色 | 策略模式角色 | 本项目对应 |
|---------|-------------|-----------|
| 通勤者 | Context（上下文） | `Role` |
| 出行接口 | Strategy（策略接口） | `I*Behavior` |
| 地铁 / 打车 / 步行 | 具体策略 | `AttackJY` 等具体策略类 |

### 2.2 例子二：付款方式

**场景**：同一件商品，金额不变。可以选择微信、支付宝、现金或者信用卡支付——支付这个动作相同，只是渠道算法不同，而且**随时可以换**。

| 生活角色 | 策略模式角色 |
|---------|-------------|
| 顾客 / 收银台 | Context（上下文） |
| 支付方式接口 | Strategy（策略接口） |
| 微信 / 支付宝 / 现金 | 具体策略 |

### 2.3 例子三：商场促销

**场景**：同一件商品，商家可以套用不同的促销策略——满 300 减 50、全场 8 折、会员价、返券。前台结账时按规则选择一种套用，规则随时可以新增。

| 生活角色 | 策略模式角色 |
|---------|-------------|
| 收银台 | Context（上下文） |
| 促销接口 | Strategy（策略接口） |
| 满减 / 打折 / 返券 | 具体策略 |

### 2.4 例子四：点餐口味

**场景**：同一道"面条"，可以选择清汤、麻辣或番茄口味——原料相同，做法（策略）不同，点单时选一种，以后还可以加新口味。

| 生活角色 | 策略模式角色 |
|---------|-------------|
| 食客 / 点餐单 | Context（上下文） |
| 做法接口 | Strategy（策略接口） |
| 清汤 / 麻辣 / 番茄 | 具体策略 |

### 2.5 例子五：编程世界版（给有代码经验者）

- **排序算法 `Comparator`**：同一个集合，按年龄排序、按姓名排序或按薪资排序——排序动作相同，比较规则（策略）不同。
- **文件压缩**：同一个文件，选择 ZIP、RAR 或 7z 格式——压缩动作相同，压缩算法（策略）不同。
- **图片上传**：同一个图片，上传到本地、OSS 或云盘——上传动作相同，存储渠道（策略）不同。

### 2.6 例子的共性总结

| 例子 | 固定不变的是什么（Context / 目标） | 变化的是什么（策略） | 为什么好 |
|------|---------------------------------|--------------------|---------|
| 出行 | 通勤者与目的地 | 出行方式 | 可换、可加、互不影响 |
| 付款 | 商品与金额 | 支付渠道 | 可换、可加、互不影响 |
| 促销 | 商品与价格 | 促销规则 | 可换、可加、互不影响 |
| 点餐 | 面条原料 | 口味做法 | 可换、可加、互不影响 |
| 排序 | 数据集与排序动作 | 比较规则 | 可换、可加、互不影响 |

共性：**Context 不变，算法可换，新增算法不碰旧代码**。

### 2.7 回到本项目一句话串讲

游戏角色（`Role`）就是"通勤者"，攻击 / 防御 / 奔跑 / 显示就是"出行方式"——角色可以随时换武功、换装备，**这就是策略模式**。下面的章节就把这份直觉对应到 UML 类图和真实代码上。

---

## 三、模式结构

### 3.1 UML 类图（基于本项目真实类）

```
                        ┌─────────────────────────────────────────────┐
                        │                 <<abstract>>                │
                        │                    Role                     │
                        │  ───────────────────────────────────────    │
                        │  # name : String                           │
                        │  # iDisplayBehavior : IDisplayBehavior     │
                        │  # iRunBehavior : IRunBehavior             │
                        │  # iAttackBehavior : IAttackBehavior       │
                        │  # iDefendBehavior : IDefendBehavior       │
                        │  ───────────────────────────────────────    │
                        │  + setiXxxBehavior(...) : Role（链式）      │
                        │  + display() / run() / attack() / defend() │
                        │  + getName() : String                      │
                        └──────────┬──────────────┬──────────────────┘
                                   │ extends      │ extends
                          ┌────────▼─────┐  ┌─────▼────────┐
                          │    RoleA     │  │    RoleB     │
                          │ (具体上下文)   │  │ (具体上下文)  │
                          └──────────────┘  └──────────────┘
                             (RoleC 与 RoleA/RoleB 同构，省略)

   <<interface>>    <<interface>>    <<interface>>    <<interface>>
   IDisplayBehavior IRunBehavior     IAttackBehavior  IDefendBehavior
   ───────────────  ─────────────    ───────────────  ──────────────
   + display()      + run()          + attack()       + defend()
          ▲               ▲                ▲               ▲
          │ implements    │ implements     │ implements    │ implements
   ┌──────┴─────┐  ┌──────┴─────┐  ┌──────┴───────┐  ┌─────┴──────┐
   │  DisplayA  │  │  RunJCTQ   │  │  AttackJY    │  │ DefendTBS  │
   │  查看A     │  │ 金蝉脱壳    │  │ 九阳神功攻击  │  │  铁布衫    │
   └────────────┘  └────────────┘  └──────────────┘  └────────────┘
```

### 3.2 角色说明

| 角色 | 类 / 接口 | 职责 |
|------|----------|------|
| **抽象上下文 (Context)** | `Role`（抽象类） | 持有 4 个策略接口引用，提供链式 setter 与委托方法 |
| **具体上下文 (ConcreteContext)** | `RoleA`、`RoleB`、`RoleC` | 构造器传入角色名，行为完全由外部注入 |
| **抽象策略 (Strategy)** | `IDisplayBehavior` 等 4 个接口 | 定义行为方法签名，每种行为一个接口 |
| **具体策略 (ConcreteStrategy)** | `DisplayA`、`RunJCTQ`、`AttackJY`、`DefendTBS` | 实现各自的行为算法 |

对照第二章的出行例子：`Role` 是通勤者，4 个 `I*Behavior` 是"出行接口"，`AttackJY` 等具体策略就是"地铁 / 打车"。

---

## 四、代码详解

### 4.1 目录结构

```
strategyPattern/
├── README.md                          ← 本文档
└── bean/
    ├── Role.java                      ← 抽象上下文（抽象类）
    ├── IDisplayBehavior.java          ← 显示策略接口
    ├── IRunBehavior.java              ← 奔跑策略接口
    ├── IAttackBehavior.java           ← 攻击策略接口
    ├── IDefendBehavior.java           ← 防御策略接口
    ├── DisplayA.java                  ← 具体显示策略
    ├── RunJCTQ.java                   ← 具体奔跑策略
    ├── AttackJY.java                  ← 具体攻击策略
    ├── DefendTBS.java                 ← 具体防御策略
    ├── RoleA.java                     ← 具体角色 A
    ├── RoleB.java                     ← 具体角色 B
    └── RoleC.java                     ← 具体角色 C
```

### 4.2 抽象上下文：`Role.java`

```java
public abstract class Role {

    // @author zh @date 2026-08-10 17:19:27 @description 角色名称
    protected String name;

   /* // @author zh @date 2026-08-10 17:27:16 @description 角色显示
    protected abstract void display();

    // @author zh @date 2026-08-10 17:27:37 @description 角色运行
    protected abstract void run();

    // @author zh @date 2026-08-10 17:28:14 @description 角色攻击
    protected abstract void attack();

    // @author zh @date 2026-08-10 17:28:31 @description 角色防御
    protected abstract void defend();*/

    // ----------------------优化---------------------------------

    protected IDefendBehavior iDefendBehavior;

    protected IDisplayBehavior iDisplayBehavior;

    protected IRunBehavior iRunBehavior;

    protected IAttackBehavior iAttackBehavior;

    public IDefendBehavior getiDefendBehavior() {
        return iDefendBehavior;
    }

    public Role setiDefendBehavior(IDefendBehavior iDefendBehavior) {
        this.iDefendBehavior = iDefendBehavior;
        return this;
    }

    public IDisplayBehavior getiDisplayBehavior() {
        return iDisplayBehavior;
    }

    public Role setiDisplayBehavior(IDisplayBehavior iDisplayBehavior) {
        this.iDisplayBehavior = iDisplayBehavior;
        return this;
    }

    public IRunBehavior getiRunBehavior() {
        return iRunBehavior;
    }

    public Role setiRunBehavior(IRunBehavior iRunBehavior) {
        this.iRunBehavior = iRunBehavior;
        return this;
    }

    public IAttackBehavior getiAttackBehavior() {
        return iAttackBehavior;
    }

    public Role setiAttackBehavior(IAttackBehavior iAttackBehavior) {
        this.iAttackBehavior = iAttackBehavior;
        return this;
    }

    public void display() {
        iDisplayBehavior.display();
    }

    public void run() {
        iRunBehavior.run();
    }

    public void attack() {
        iAttackBehavior.attack();
    }

    public void defend() {
        iDefendBehavior.defend();
    }

    public String getName() {
        return this.name;
    }

}
```

**要点分析：**
- 四个策略字段使用 `protected`，命名以小写 `i` 开头（`iDisplayBehavior`），`i` 表示 interface（接口）。
- 四个 setter 都返回 `this`，支持**链式调用**：`role.setiAttackBehavior(...).setiRunBehavior(...)`，一条链完成多策略注入。
- `display()` / `run()` / `attack()` / `defend()` 四个方法只是**委托**给对应策略对象执行，不关心具体实现——这就是"组合优于继承"。
- 被注释掉的 4 个 `abstract` 方法正是"优化前"的坏设计（详见第五章），与 `// ----------------------优化---------------------------------` 注释下方的策略写法形成鲜明对比。

### 4.3 四个策略接口

```java
public interface IDisplayBehavior {
    void display();
}

public interface IRunBehavior {
    void run();
}

public interface IAttackBehavior {
    void attack();
}

public interface IDefendBehavior {
    void defend();
}
```

**要点分析：**
- 每个接口只有一个方法，符合**接口隔离原则（ISP）**：角色需要哪种行为就注入哪个策略，互不干扰。
- 接口只定义"做什么"，具体"怎么做"由实现类决定。

### 4.4 四个具体策略类

```java
public class DisplayA implements IDisplayBehavior {
    @Override
    public void display() {
        System.out.println("查看A");
    }
}

public class RunJCTQ implements IRunBehavior {
    @Override
    public void run() {
        System.out.println("金蝉脱壳");
    }
}

public class AttackJY implements IAttackBehavior {
    @Override
    public void attack() {
        System.out.println("使用九阳神功攻击");
    }
}

public class DefendTBS implements IDefendBehavior {
    @Override
    public void defend() {
        System.out.println("铁布衫");
    }
}
```

**要点分析：**
- 类名后缀是武功 / 装备拼音缩写：`JY` = 九阳（神功）、`TBS` = 铁布衫、`JCTQ` = 金蝉脱壳。
- 每个具体策略类只实现一种行为，职责单一；未来新增"乾坤大挪移"只需新建一个 `IAttackBehavior` 的实现类，现有代码零改动。

### 4.5 三个具体角色类

```java
public class RoleA extends Role {
    public RoleA(String name) {
        this.name = name;
    }
}

public class RoleB extends Role {
    public RoleB(String name) {
        this.name = name;
    }
}

public class RoleC extends Role {
    public RoleC(String name) {
        this.name = name;
    }
}
```

**要点分析：**
- 构造器只传名字，**行为完全由外部注入**——角色与行为彻底解耦。
- 三个具体角色类几乎一模一样（只差类名），这正是策略模式的常态：具体上下文只负责"是谁"，不负责"会什么"。

---

## 五、设计推导：从坏设计到策略模式

> 本章是本仓库的**最大亮点**。代码里被注释掉的内容，正是"优化前"的坏设计。下面看坏设计是怎么一步步演进成策略模式的。

### 5.1 坏设计一（继承式重写）：每个角色重写全部 4 个方法

`Role.java` 中被注释掉的 4 个抽象方法（"优化前"坏设计）：

```java
   /* // @author zh @date 2026-08-10 17:27:16 @description 角色显示
    protected abstract void display();

    // @author zh @date 2026-08-10 17:27:37 @description 角色运行
    protected abstract void run();

    // @author zh @date 2026-08-10 17:28:14 @description 角色攻击
    protected abstract void attack();

    // @author zh @date 2026-08-10 17:28:31 @description 角色防御
    protected abstract void defend();*/
```

对应地，`RoleA.java` 中被注释掉的重写：

```java
    @Override
    protected void display() {
        System.out.println("样子1");
    }

    @Override
    protected void run() {
        System.out.println("金蝉脱壳");
    }

    @Override
    protected void attack() {
        System.out.println("降龙十八掌");
    }

    @Override
    protected void defend() {
        System.out.println("铁头功");
    }
```

`RoleB.java` 中被注释掉的重写（注意 `run()` / `attack()` 与 RoleA 几乎相同）：

```java
    @Override
    protected void display() {
        System.out.println("样子2");
    }


    @Override
    protected void run() {
        System.out.println("金蝉脱壳");
    }

    @Override
    protected void attack() {
        System.out.println("降龙十八掌");
    }

    @Override
    protected void defend() {
        System.out.println("铁布衫");
    }
```

`RoleC.java` 中被注释掉的重写（注意 `display()` 与 `defend()` 的拷贝来源注释）：

```java
/*
    @Override
    protected void display() {
        System.out.println("样子1");//从RoleA中拷贝
    }

    @Override
    protected void run() {
        System.out.println("烟雾弹");
    }

    @Override
    protected void attack() {
        System.out.println("九阳神功");
    }

    @Override
    protected void defend() {
        System.out.println("铁布衫");//从B中拷贝
    }*/
```

### 5.2 坏设计的三大问题

**① 代码重复**：`RoleB` 与 `RoleA` 的 `run()`（金蝉脱壳）、`attack()`（降龙十八掌）几乎一样，`RoleC` 更是直接从 `RoleA` / `RoleB` 复制粘贴，注释里写得明明白白：

```java
// RoleC.java 中被注释掉的内容（节选）
    @Override
    protected void display() {
        System.out.println("样子1");//从RoleA中拷贝
    }
    ...
    @Override
    protected void defend() {
        System.out.println("铁布衫");//从B中拷贝
    }
```

**② 修改一处要改多个类**：如果"金蝉脱壳"的身法要调整，`RoleA`、`RoleB` 都要改；如果"铁布衫"要削弱，`RoleB`、`RoleC` 都要改。改动点随着角色数量线性增长，极易漏改。

**③ 行为无法复用，也无法在运行时切换**：行为被写死在每个角色里，一个角色想"换个招"只能改代码重新编译；想给现有角色附加新行为，没有任何入口。

### 5.3 演进一：接口抽取

把每种行为抽成独立接口，先定义"做什么"：

```java
public interface IAttackBehavior {
    void attack();
}
```

行为从"角色内部的方法"变成"可独立存在、可独立替换的算法"。这一步完成了"算法族"的封装。

### 5.4 演进二：组合替代继承

`Role` 不再要求子类重写行为，而是**持有**策略接口并委托：

```java
public abstract class Role {
    protected IAttackBehavior iAttackBehavior;   // 持有策略

    public Role setiAttackBehavior(IAttackBehavior iAttackBehavior) {
        this.iAttackBehavior = iAttackBehavior;   // 注入策略
        return this;                              // 链式调用
    }

    public void attack() {
        iAttackBehavior.attack();                 // 委托给策略
    }
}
```

角色与行为的关系从"继承（is-a）"变成"组合（has-a）"，行为可以在**运行时**注入和替换。

### 5.5 对比表：继承式 vs 策略模式

| 对比维度 | 继承式重写（坏设计） | 策略模式（本项目） |
|---------|--------------------|------------------|
| 行为定义 | 每个子类重写全部 4 个方法 | 行为抽成接口，独立封装 |
| 代码重复 | RoleC 从 RoleA / RoleB 拷贝 | 行为只需实现一次，随处复用 |
| 新增角色 | 需要重写 / 拷贝行为 | 只需注入需要的策略 |
| 新增行为 | 每个角色类都要改 | 只需新增一个策略类 |
| 运行时切换 | 不可能（写死在代码里） | 随时 `setiXxxBehavior` 替换 |

### 5.6 "优化"前后代码对照

| 阶段 | 代码位置 | 状态 |
|------|---------|------|
| 优化前（坏设计） | `Role.java` 注释掉的 4 个 `abstract` 方法 | 已注释，禁用 |
| 优化前（坏设计） | `RoleA / RoleB / RoleC.java` 注释掉的重写方法 | 已注释，禁用 |
| 优化后（策略模式） | `Role.java` 的 4 个策略字段 + 委托方法 | 启用 |
| 优化后（策略模式） | 4 个 `I*Behavior` 接口 + 4 个具体策略类 | 启用 |

`// ----------------------优化---------------------------------` 注释把"优化前"与"优化后"两段代码清晰地分隔开——上下两段正好对应本章推导的起点与终点。

---

## 六、使用示例与执行流程

> 本项目 `strategyPattern` 包内没有可运行的 main / test 演示类，下面的示例代码供你在自己的测试类中复制运行验证。

### 6.1 示例代码：注入策略并调用

```java
public class StrategyDemo {
    public static void main(String[] args) {
        // 构造角色（此时还没有任何武功）
        RoleA roleA = new RoleA("张无忌");

        // 链式注入四个策略（核心！）
        roleA.setiDisplayBehavior(new DisplayA())
             .setiRunBehavior(new RunJCTQ())
             .setiAttackBehavior(new AttackJY())
             .setiDefendBehavior(new DefendTBS());

        // 调用委托方法，输出实际行为
        roleA.display();   // 查看A
        roleA.run();       // 金蝉脱壳
        roleA.attack();    // 使用九阳神功攻击
        roleA.defend();    // 铁布衫

        // 运行时切换策略：换一个攻击武功
        // 假设此时新增了攻击策略类 AttackQX（乾坤大挪移，implements IAttackBehavior）
        roleA.setiAttackBehavior(new AttackQX());
        roleA.attack();    // 使用乾坤大挪移攻击
    }
}
```

**要点分析：**
- 若某个行为未注入就调用（如只注入了 `iAttackBehavior` 却调用 `roleA.run()`），委托方法会因策略引用为 `null` 抛出**空指针异常**——调用方必须保证"先注入，再使用"。
- 运行时切换只需调用一次 setter，`Role`、`RoleA` 乃至其它角色类**零改动**——这就是策略模式的核心价值。

### 6.2 时序图

```
 客户端                 RoleA(Role)         IAttackBehavior         AttackJY
   │                        │                     │                     │
   │ new RoleA("张无忌")     │                     │                     │
   │───────────────────────>│                     │                     │
   │                        │ (仅设置 name)       │                     │
   │                        │                     │                     │
   │ setiAttackBehavior(    │                     │                     │
   │     new AttackJY())    │                     │                     │
   │───────────────────────>│                     │                     │
   │                        │ iAttackBehavior =   │                     │
   │                        │     new AttackJY()  │                     │
   │                        │                     │                     │
   │ attack()               │                     │                     │
   │───────────────────────>│                     │                     │
   │                        │ iAttackBehavior.    │                     │
   │                        │     attack()        │                     │
   │                        │──────────────────────────────────────────>
   │                        │                     │    "使用九阳神功攻击"
   │<────────────────────────────────────────────────────────────────────
```

### 6.3 执行步骤

1. **构造角色**：`new RoleA("张无忌")`，构造器只设置 `name`。
2. **注入策略**：通过链式 setter 注入 4 个具体策略对象。
3. **调用委托方法**：`roleA.attack()` 委托给 `iAttackBehavior.attack()`。
4. **多态执行**：JVM 动态绑定到 `AttackJY.attack()`，输出"使用九阳神功攻击"。
5. **运行时切换**：重新调用 `setiAttackBehavior(new AttackQX())` 后，`attack()` 输出变为新武功。

---

## 七、运行时动态切换策略

策略模式区别于普通多态的核心是：**行为可以在运行时替换**。

回到第二章的出行例子——"今天打车，明天地铁"：通勤者（Context）不变，只是换了一种出行方式（策略）。本项目同理，同一个角色可以在不同场合换不同的武功 / 装备：

```java
// 同一个角色，不同场合换不同的武功 / 装备
role.setiAttackBehavior(new AttackJY());   // 场景一：使用九阳神功
// ... 战斗中缴获新秘籍
role.setiAttackBehavior(new AttackQX());   // 场景二：换乾坤大挪移
role.attack();                             // 行为立刻改变，Role 代码零改动
```

**策略共享与状态问题：**
- 本项目 4 个具体策略（`DisplayA`、`RunJCTQ`、`AttackJY`、`DefendTBS`）都是**无状态**的——只输出一句话，不持有成员状态，因此同一个策略实例可以被多个 `Role` 共享。
- 如果策略内部有可变状态（如血量、冷却时间），多个 Context 共享同一策略实例就会互相污染。此时应让每个 Context 持有独立的策略实例，或把策略设计成无状态的纯函数。

---

## 八、优缺点分析

### 8.1 优点

| 优点 | 说明 |
|------|------|
| **开闭原则 (OCP)** | 新增武功 / 行为只需新增一个策略类，`Role` 及现有角色零改动 |
| **代码复用** | 行为独立封装，多个角色可复用同一策略，杜绝 RoleC 式的复制粘贴 |
| **消除条件判断** | 不再需要 if-else 判断角色类型来决定行为 |
| **运行时切换** | 行为可动态注入、替换，支持"换装备 / 换招"场景 |

### 8.2 缺点

| 缺点 | 说明 |
|------|------|
| **类爆炸** | 每个策略一个类，行为多了类数量膨胀 |
| **调用方必须了解策略** | 客户端必须知道有哪些策略、选哪个策略注入 |
| **策略间不可互相调用** | 策略彼此独立，难以复用其它策略的中间结果 |
| **增加对象数量** | 每个 Context 需要持有策略对象，增加内存开销 |

### 8.3 改进建议

- 配合**工厂模式**创建策略：客户端不必关心具体策略类，由工厂按参数返回。
- 无状态策略设计为**单例 / 共享实例**，减少对象创建。
- 使用**枚举 + Map** 管理策略，减少类数量。
- 策略数量稳定且无需动态切换时，可考虑用 if-else 或函数式写法替代。

---

## 九、JDK / Spring / 框架中的策略模式

### 9.1 JDK 实例

| 实例 | 策略体现 |
|------|---------|
| `java.util.Comparator` | 排序策略：按年龄 / 按姓名 / 按薪资（对照第二章排序例子） |
| `ThreadPoolExecutor` 的 `RejectedExecutionHandler` | 拒绝策略：`AbortPolicy` / `DiscardPolicy` / `CallerRunsPolicy` 等 |
| `java.util.function` 函数式接口 | Java 8+ 用 `Function` / `Predicate` / Lambda 替代策略类 |

### 9.2 Spring 实例

| 实例 | 策略体现 |
|------|---------|
| `Resource` 与 `ResourceLoader` | 资源加载策略：`ClassPathResource` / `FileSystemResource` / `UrlResource` |
| `BeanFactory` 的 `InstantiationStrategy` | Bean 实例化策略：反射 / CGLIB |
| 依赖注入本身 | 容器负责选择注入哪个实现，就是策略选择 |
| `@Qualifier` / `@Primary` | 多个实现 Bean 时的策略选择机制 |

### 9.3 函数式写法对比

```java
// 传统策略模式：一个策略一个类
public class AttackJY implements IAttackBehavior {
    @Override
    public void attack() {
        System.out.println("使用九阳神功攻击");
    }
}

// Java 8+ 函数式写法：用 Lambda 替代策略实现类
IAttackBehavior attackJY = () -> System.out.println("使用九阳神功攻击");
IAttackBehavior attackQX = () -> System.out.println("使用乾坤大挪移攻击");
```

当策略只包含一个方法且无状态时，Lambda / 方法引用是策略模式在现代 Java 中的轻量写法。

---

## 十、业务场景深度解析（武侠游戏角色系统）

> 好的设计模式一定诞生于真实的业务痛点。下面从业务视角出发，复盘"武侠游戏角色系统"的设计推导过程。

### 10.1 业务背景

游戏角色拥有**显示 / 奔跑 / 攻击 / 防御**四类行为，不同角色组合不同：

| 角色 | 样子 | 身法 | 武功 | 护体 |
|------|------|------|------|------|
| RoleA | 样子1 | 金蝉脱壳 | 降龙十八掌 | 铁头功 |
| RoleB | 样子2 | 金蝉脱壳 | 降龙十八掌 | 铁布衫 |
| RoleC | 样子1 | 烟雾弹 | 九阳神功 | 铁布衫 |

需求演化：后期可能**新增武功**（如乾坤大挪移），角色可能**中途换装备 / 换招**（呼应第二章出行例子：同一角色不同场合选不同出行方式）。

### 10.2 业务推导：硬编码 if-else → 继承重写 → 策略模式

**第一步：硬编码 if-else**——按角色类型判断，每加一个角色改一次判断逻辑，代码爆炸且容易漏改。

**第二步：继承重写（本项目注释代码的由来）**——每个角色重写 4 个方法。结果：RoleC 从 RoleA / RoleB 复制粘贴，重复代码堆积，改一个招要改多个类。

**第三步：策略模式（本项目优化后的代码）**——4 个行为抽成接口，行为独立实现，角色只负责持有和委托。新武功 = 新增一个策略类；换招 = 运行时 setter。

### 10.3 业务角色映射

```
业务世界                          代码世界
─────────                         ─────────
「游戏角色」           ←→      Role（抽象上下文）
    持有行为、委托调用                持有 4 个策略字段、委托方法

「武功 / 身法 / 护体」  ←→      4 个 I*Behavior 接口
    攻击 / 奔跑 / 防御 / 显示         display / run / attack / defend

「九阳神功」           ←→      AttackJY（具体攻击策略）
「金蝉脱壳」           ←→      RunJCTQ（具体奔跑策略）
「铁布衫」             ←→      DefendTBS（具体防御策略）
「样子1 / 样子2」      ←→      DisplayA（具体显示策略）
```

### 10.4 业务流程推演（时间线）

```
时间线 ──────────────────────────────────────────────────>

上线日   角色 A / B / C 创建，注入各自武功
         new RoleA("张三") + setiXxx(...)
         —— 各角色组合不同，代码清晰无重复

迭代 1   策划要求新增武功「乾坤大挪移」
         → 新建 AttackQX implements IAttackBehavior
         → 现有 3 个角色类 + Role 零改动

迭代 2   玩家要求角色中途换招
         → role.setiAttackBehavior(new AttackQX())
         → 运行时切换，无需重新编译部署
```

### 10.5 业务扩展：把 `System.out.println` 换成真实游戏逻辑

```java
public class AttackJY implements IAttackBehavior {
    @Override
    public void attack() {
        // 真实游戏逻辑：伤害计算、动作动画、技能特效、状态机
        int damage = computeDamage(attackPower, skillRate);
        roleAnimator.play("jiuyang");
        battleEngine.applyDamage(target, damage);
        skillStateMachine.enter(ATTACK_READY);
    }
}
```

### 10.6 何时该用策略模式的判据三问

1. 同一类操作，是否存在**多种可替换的做法**？
2. 这些做法是否**彼此独立**，且未来**可能新增**？
3. 是否需要在**运行时**切换做法（而不只是换对象）？

三个都答"是"，用策略模式。**反例**：如果做法固定、永不变化，用策略模式只会徒增类数量，直接 if-else 或一个方法即可。

---

## 十一、与其他模式对比

| 对比模式 | 关系 | 区别 |
|---------|------|------|
| **状态模式** | 都改变对象行为 | 状态模式的行为由**自身内部状态**变化触发；策略模式由**外部注入**决定 |
| **模板方法模式** | 都封装算法 | 模板方法用**继承**固定算法骨架，子类填空；策略模式用**组合**整体替换算法族 |
| **桥接模式** | UML 相似 | 桥接是**结构型**，解决两个维度组合；策略是**行为型**，解决算法替换，意图不同 |
| **工厂模式** | 常搭配使用 | 工厂负责**创建**策略，策略负责**执行**算法 |

文字说明：策略模式与状态模式最容易混淆——状态模式里，行为变化是对象自己状态迁移的结果；策略模式里，行为变化是外部主动"换方案"的结果。

---

## 十二、设计原则体现

| 设计原则 | 体现 |
|---------|------|
| **开闭原则 (OCP)** | 新增武功 / 角色无需修改 `Role`，只需新增策略类 |
| **依赖倒置 (DIP)** | `Role` 依赖 4 个策略接口，而非具体策略类 |
| **单一职责 (SRP)** | 每个策略类只做一件事（攻击 / 防御 / 奔跑 / 显示） |
| **里氏替换 (LSP)** | 任意具体策略实现都可替换接口使用 |
| **接口隔离 (ISP)** | 4 个接口各自只有一个方法 |
| **组合优于继承** | 本项目"优化"部分的核心：行为由持有 + 委托实现，而非继承重写 |

---

## 十三、面向对象视角解析

策略模式不仅是设计模式，更是面向对象四大特性（**封装、继承、多态、抽象**）的经典教学案例。下面从 OOP 本质出发，逐层拆解本项目代码。

### 13.1 封装 (Encapsulation)

- 策略字段（`iDisplayBehavior` 等）全部 `protected`，外部只能通过 setter 注入。
- 委托方法（`display()` 等）对外隐藏了"是谁在真正执行"——调用方只看到 `role.attack()`，不知道内部是委托给 `AttackJY`。

### 13.2 继承与接口实现 (Inheritance & Interface Implementation)

```
        <<abstract>> Role                   <<interface>> IAttackBehavior
             ▲ extends                              ▲ implements
             │                                        │
       RoleA / RoleB / RoleC                   AttackJY / AttackQX...
```

- `RoleA is-a Role`：具体上下文通过继承获得策略字段与委托方法。
- `AttackJY is-a IAttackBehavior`：具体策略通过接口实现获得算法契约。

### 13.3 多态 (Polymorphism)

```java
// Role.java —— attack() 委托方法
public void attack() {
    iAttackBehavior.attack();   // 运行时动态绑定到具体策略的 attack()
}
```

多态三个必要条件在本项目全部满足：

| 条件 | 本项目体现 |
|------|-----------|
| ① 继承 / 实现关系 | `AttackJY` 实现 `IAttackBehavior` |
| ② 方法重写 | `AttackJY.attack()` 重写接口方法 |
| ③ 父类引用指向子类对象 | `IAttackBehavior iAttackBehavior = new AttackJY()` |

### 13.4 抽象 (Abstraction)

四层抽象层次拆解：

```
【接口层】4 个 I*Behavior   ← 只定义"做什么"（方法签名）
【策略层】AttackJY 等       ← 定义"怎么做"（具体算法）
【上下文层】Role            ← 定义"用什么做"（持有 + 委托）
【具体上下文层】RoleA/B/C    ← 定义"是谁"（角色名）
```

### 13.5 关联关系 (Association / Aggregation)

- `Role` 与策略之间是**组合 / 聚合（has-a）**关系：`Role` 持有 `IAttackBehavior` 引用，策略可以脱离 `Role` 独立存在，也可被多个 `Role` 共享（无状态时）。
- 与"继承（is-a）"对比：继承把行为焊死在类型体系里，组合把行为变成可插拔的零件。

### 13.6 OOP 总结对照表

| OOP 特性 | 核心问题 | 本项目答案 | 关键代码位置 |
|---------|---------|-----------|-------------|
| **封装** | 隐藏什么？暴露什么？ | 隐藏策略实现，暴露 setter 与委托方法 | `Role.java` |
| **继承 / 实现** | is-a 关系是什么？ | RoleA is-a Role；AttackJY is-a IAttackBehavior | 所有 `.java` 文件 |
| **多态** | 如何统一处理不同对象？ | `iAttackBehavior.attack()` 运行时动态绑定 | `Role.attack()` |
| **抽象** | 本质是什么？ | 行为抽象为接口族，算法可替换 | 4 个 `I*Behavior` |
| **关联 / 组合** | 对象间是什么关系？ | Role has-a 策略，组合替代继承 | `Role` 的 4 个策略字段 |

---

## 十四、复习要点

1. **核心公式**：结果一样，做法不同，做法可随时换。
2. **四个策略接口**：`IDisplayBehavior`、`IRunBehavior`、`IAttackBehavior`、`IDefendBehavior`，各自单一方法。
3. **四个具体策略**：`DisplayA`（查看A）、`RunJCTQ`（金蝉脱壳）、`AttackJY`（使用九阳神功攻击）、`DefendTBS`（铁布衫）。
4. **链式 setter**：`setiXxxBehavior(...)` 返回 `this`，支持一行链式注入。
5. **委托方法**：`Role.display() / run() / attack() / defend()` 只做委托，不实现算法。
6. **运行时切换**：`setiAttackBehavior(new Xxx())` 即可换招，Context 零改动。
7. **组合优于继承**：本项目"优化"部分的核心，行为由持有 + 委托实现。
8. **与状态模式的区别**：状态模式行为由内部状态触发，策略模式由外部注入。
9. **坏设计教训**：RoleC 从 RoleA / RoleB 复制粘贴——行为必须抽取为可复用的策略。
10. **先注入再使用**：未注入就调用委托方法会抛空指针异常（NPE）。
11. **无状态策略可共享**：本项目 4 个具体策略无状态，可被多个 Role 共享。
12. **函数式替代**：单方法无状态策略可用 Lambda 简化。

---

## 十五、项目文件索引

| 文件 | 路径 | 角色 |
|------|------|------|
| README.md | `strategyPattern/README.md` | 本文档（策略模式学习资料） |
| Role.java | `strategyPattern/bean/Role.java` | 抽象上下文（抽象类） |
| IDisplayBehavior.java | `strategyPattern/bean/IDisplayBehavior.java` | 显示策略接口 |
| IRunBehavior.java | `strategyPattern/bean/IRunBehavior.java` | 奔跑策略接口 |
| IAttackBehavior.java | `strategyPattern/bean/IAttackBehavior.java` | 攻击策略接口 |
| IDefendBehavior.java | `strategyPattern/bean/IDefendBehavior.java` | 防御策略接口 |
| DisplayA.java | `strategyPattern/bean/DisplayA.java` | 具体显示策略 |
| RunJCTQ.java | `strategyPattern/bean/RunJCTQ.java` | 具体奔跑策略 |
| AttackJY.java | `strategyPattern/bean/AttackJY.java` | 具体攻击策略 |
| DefendTBS.java | `strategyPattern/bean/DefendTBS.java` | 具体防御策略 |
| RoleA.java | `strategyPattern/bean/RoleA.java` | 具体角色 A |
| RoleB.java | `strategyPattern/bean/RoleB.java` | 具体角色 B |
| RoleC.java | `strategyPattern/bean/RoleC.java` | 具体角色 C |

---

> **创建日期**：2026-08-20  
> **作者**：zh  
> **文档生成日期**：2026-08-20
