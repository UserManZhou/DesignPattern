# 装饰器模式（Decorator Pattern）学习记录

> 结构型设计模式之一。本目录以「游戏装备 + 宝石镶嵌」为例进行学习。

---

## 一、模式定义与意图

**定义**：装饰器模式允许在不改变原有对象结构的前提下，动态地为对象添加新的职责（功能）。它通过创建一个包装对象（装饰器）来包裹真实对象，装饰器与真实对象实现相同的接口，从而可以在调用前后附加额外的行为。

**意图**：
- 动态地给一个对象添加额外的职责，比通过继承生成子类更加灵活。
- 用「组合 + 委托」代替「继承」来扩展功能。
- 装饰器可以层层嵌套包裹，形成一条功能叠加的「装饰链」。

**一句话理解**：像给手机贴膜、装壳、挂绳——手机本体不变，每包一层就多一项功能，且可以任意组合叠加。

---

## 二、适用场景

1. **需要在不影响其他对象的情况下，动态、透明地给单个对象添加职责**。
2. **不适合用继承扩展的场景**：功能组合方式太多（如 M 种装备 × N 种宝石），用继承会产生类爆炸问题。
3. **需要撤销已添加的功能**：剥掉装饰器即可恢复原对象行为。
4. **当不能通过继承扩展时**：如类被 `final` 修饰，或继承体系已经存在且不便修改。

**典型例子**：
- Java I/O 流：`new BufferedReader(new InputStreamReader(new FileInputStream(file)))`
- 游戏装备镶嵌宝石（本目录示例）
- 给窗口添加滚动条、边框等 UI 装饰

---

## 三、结构角色说明

| 角色 | 说明 | 本示例对应 |
|------|------|-----------|
| 抽象构件（Component） | 定义核心业务的统一接口，是被装饰对象的规范 | `IEquip`（装备接口，含 `caculateAttack()` 计算攻击力、`description()` 描述） |
| 具体构件（ConcreteComponent） | 被装饰的原始对象，实现核心功能 | `ArmEquip`（屠龙刀）、`RingEquip`（戒指）、`WristEquip`（护腕）、`ShoeEquip`（鞋子） |
| 抽象装饰器（Decorator） | 实现或继承 Component 接口，内部持有一个 Component 引用，作为装饰器的公共规范 | `IEquipDecorator`（继承 `IEquip` 的空接口，起标识与约束作用） |
| 具体装饰器（ConcreteDecorator） | 持有并包装一个 Component，在调用前后附加自己的行为 | `BlueGemDecorator`（蓝宝石）、`RedGemDecorator`（红宝石）、`YellowGemDecorator`（黄宝石），均 +5 攻击力并在描述后追加宝石名 |

**结构示意**：

```
        IEquip（抽象构件）
        /            \
  具体构件类        IEquipDecorator（抽象装饰器，extends IEquip）
  ArmEquip 等            |
  RingEquip 等      具体装饰器类（BlueGem / RedGem / YellowGemDecorator）
                    内部持有 IEquip 引用，委托并增强
```

---

## 四、与目录中示例代码的对应关系

### 1. 抽象构件 —— `IEquip.java`

```java
public interface IEquip {
    int caculateAttack();   // 计算攻击力
    String description();   // 装备描述
}
```

### 2. 具体构件 —— `ArmEquip.java`（其余装备类同理）

```java
public class ArmEquip implements IEquip {
    @Override
    public int caculateAttack() {
        return 20;              // 屠龙刀基础攻击力
    }
    @Override
    public String description() {
        return "屠龙刀";
    }
}
```

### 3. 抽象装饰器 —— `IEquipDecorator.java`

```java
public interface IEquipDecorator extends IEquip {
}
```

> 它继承自 `IEquip`，保证所有装饰器「也是一件装备」，因此可以继续被其他装饰器包裹——这是装饰链得以成立的关键。

### 4. 具体装饰器 —— `BlueGemDecorator.java`（红/黄宝石同理）

```java
public class BlueGemDecorator implements IEquipDecorator {

    private IEquip iEquip;   // 持有被装饰对象（可以是装备，也可以是已镶宝石的装备）

    public BlueGemDecorator(IEquip iEquip) {
        this.iEquip = iEquip;
    }

    @Override
    public int caculateAttack() {
        return 5 + iEquip.caculateAttack();   // 增强行为：附加 5 点攻击力
    }

    @Override
    public String description() {
        return iEquip.description() + "蓝宝石";  // 附加描述
    }
}
```

### 5. 使用方式（装饰链）

```java
IEquip equip = new ArmEquip();                          // 屠龙刀：20
equip = new BlueGemDecorator(equip);                    // + 蓝宝石：25
equip = new RedGemDecorator(equip);                     // + 红宝石：30
equip = new RedGemDecorator(equip);                     // 再镶一颗红宝石：35（可重复装饰）

equip.caculateAttack();  // => 35
equip.description();     // => "屠龙刀蓝宝石红宝石红宝石"
```

**要点**：装饰器的构造参数类型是 `IEquip`，因此既能包裹具体构件，也能包裹另一个装饰器，从而实现任意组合、任意层级的动态增强。

---

## 五、优缺点

### 优点

1. **比继承更灵活**：动态组合、运行时叠加，避免「M 装备 × N 宝石」的类爆炸。
2. **符合开闭原则**：新增装饰（如新宝石种类）只需增加装饰器类，无需修改原有装备类。
3. **可以自由组合与撤销**：通过不同的装饰器排列组合产生不同行为，去掉装饰即恢复原状。
4. **职责划分清晰**：每件装备、每种宝石各自独立，单一职责，便于复用。

### 缺点

1. **多层装饰调试困难**：嵌套层次多时，调用链变长，出错定位较麻烦。
2. **产生较多小对象**：每层装饰都是一个新对象，频繁创建有一定开销。
3. **顺序敏感**：装饰器的叠加顺序可能影响最终结果，使用者需要理解装饰逻辑。
4. **移除指定装饰器不方便**：一旦包进装饰链，想抽掉中间某一层比较麻烦，通常只能重建。

---

## 六、与其他模式的简单对比（复习用）

| 对比项 | 装饰器模式 | 适配器模式 | 代理模式 |
|--------|-----------|-----------|---------|
| 目的 | 动态**增强**功能 | **转换**接口使其兼容 | **控制**对原对象的访问 |
| 接口关系 | 装饰器与被装饰者**接口相同** | 适配器与被适配者**接口不同** | 代理与被代理者接口相同 |
| 关注点 | 叠加新行为 | 接口转换 | 访问控制、延迟加载等 |
