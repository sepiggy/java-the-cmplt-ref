[TOC]

# 第I部分 Java语言

## 第3章 数据类型、变量和数组

### 3.9 类型转换和强制类型转换

#### 3.9.1 Java的自动类型转换

1. 当将某种类型的数据赋给另外一种类型的变量时，如果满足如下两个条件，就会发生扩宽转换(widening conversion)：
   - 两种类型是兼容的。
   - 目标类型大于源类型。
2. 当将字面整数常量保存到byte、short、long或char类型的变量中时，Java也会执行自动类型转换。

#### 3.9.2 强制转换不兼容的类型

1. 为了实现两种不兼容类型之间的转换，必须使用强制类型转换，其语法格式为：
   `(target-type) value`
   其中，target-type 指定了期望将特定值转换成哪种类型。eg：

   - int类型变量转换为byte类型变量，若不使用强制类型转换，报错！

     ```java
     int i = 1;
     byte b;
     b = i; // 编译器报错
     ```

   - int类型变量转换为byte类型变量，必须使用强制类型转换。

     ```java
     int i = 1;
     byte b;
     b = (byte) i;
     ```

   - int类型变量转换为byte类型变量，如果整数的值超出了byte类型的范围，结果将以byte类型的范围为模减少（即为用整数除以byte范围后的余数）。

     ```java
     int i = 257;
     byte b;
     b = (byte) i; // b = 1
     ```

2. 强制转换的两种类型：

   - 缩小转换(narrowing conversion)：显示地使数值变得更小以适应目标类型的转换。详见上一个例子。

   - 截尾(truncation)：将浮点值赋给整数类型时，小数部分会丢失。
     当浮点值赋给整数类型时，除了发生`截尾`之外，如果整数部分的数值太大，以至于无法保存到目标整数类型中，那么数值也会以目标类型的范围为模减少。eg:

     ```java
     double d = 257.1234567;
     int i;
     i = (int) d; // i = 257
     byte b;
     b = (byte) d; // b = 1
     ```

### 3.10 表达式中的自动类型提升
1. 类型转换发生的两个地方：
   - 赋值
   - 表达式
2. 表达式中的类型提升规则：
   - 所有byte、short和char类型的操作数都被提升为int类型。
   - 若有一个操作数是long类型，就将整个表达式提升为long类型。
   - 若有一个操作数是float类型，就将整个表达式提升为float类型。
   - 若有一个操作数是double类型，就将整个表达式提升为double类型。

### 3.11 数组 

- 数组是以通用名称引用的一组类型相同的变量。
- 可以创建任意类型的数组，并且数组可以是一维或多维的。
- 数组中的特定元素通过索引进行访问。
- 数组为分组相关信息提供了一种便利的方法。

#### 3.11.1 一维数组

1. 本质：`一连串类型相同的变量。`

2. 创建数组

   - 两个步骤

     - 创建期望类型的数组变量

       > 声明一维数组的一般形式如下：`type array-var[];`
       > 其中，`type`声明了数组的元素类型，其决定了数组可以包含什么类型的数据。

     - 使用`new`运算符分配容纳该数组的内存，并将其赋给数组变量

       > 将`new`运算符用于一维数组的一般形式如下：`array-var = new type[size];`
       > 其中，`type`指定了将要分配的数据的类型，`size`指定了数组中元素的数量，`array-var`是链接到数组的数组变量。
       > 通过`new`分配的数组，其元素会被自动初始化为0（数值类型）、false（布尔类型）、null（引用类型）。

   - 例子
     *分配一个具有12个元素的整数数组，并将该数组链接到month_days:*

     ```java
     // 声明数组变量和分配内存分开写
     int[] month_days;
     month_days = new int[12];
     // 声明数组变量和在内存中分配数组可以合为一条语句，与上两句等价
     int[] month_days = new int[12];
     ```

     *执行完上述语句之后，month_days将指向具有12个整数的数组，并且数组中的所有元素都被初始化为0。*

3. 访问数组

   - 通过在方括号中指定索引的方法访问数组中的特定元素。
   - 所有数组的索引都是从**0**开始的。

4. 声明数组

   - 声明数组变量时，可以对其进行初始化。其一般形式如下：`array-var = array initializer`
     其中，`array-var`为数组变量，`array initializer`为数组初始化器。eg:

     ```java
     int[] month_days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
     ```

   - 数组初始化器(array initializer)是一个位于花括号中由逗号分隔的表达式列表。

   - Java会自动创建足够大的数组，以容纳在数组初始化器中指定的元素，此时不需要使用new运算符。

5. 数组变量在赋值操作符的左边，其右边只能为：

   - new 运算符

     ```java
     int[] arr = new int[5];
     ```

   - 数组初始化器

     ```java
     int[] arr = { 1, 2, 3, 4, 5 };
     ```

   - 另一个数组变量

     ```java
     int[] arr = { 1, 2, 3, 4, 5 };
     int[] a = { 6, 7, 8, 9, 10 };
     arr = a;
     ```

#### 3.11.2 多维数组

1. 本质：`数组的数组`

2. 声明数组

   ```java
   // 声明一个二维数组,从【概念】上讲其对应一个4*5矩阵
   int twoD[][] = new int[4][5];
   ```

3. 分配内存

   - 只需要为第一（最左边的）维分配内存。余下的维分配内存可以手动完成。

     ```java
     int twoD[][] = new int[4][];
     twoD[0] = new int[5];
     twoD[1] = new int[5];
     twoD[2] = new int[5];
     twoD[3] = new int[5];
     ```

   - 当手动分配维数时，不必为每一维分配相同数量的元素，可以控制每个数组的长度。

     ```java
     int twoD[][] = new int[4][];
     twoD[0] = new int[1];
     twoD[1] = new int[2];
     twoD[2] = new int[3];
     twoD[3] = new int[4];
     ```

4. 初始化

   - 在`{}`中包含每一维的数组初始化器。
   - 在数组初始化器中可以使用表达式以及字面值。

   ```java
   double m[][] = {
     { 0*0, 1*0, 2*0, 3*0 },
     { 0*1, 1*1, 2*1, 3*1 },
     { 0*2, 1*2, 2*2, 3*2 },
     { 0*3, 1*3, 2*3, 3*3 }
   };
   ```

#### 3.11.3 另一种数组声明语法
1. `type[] var-name;`等价于`type var-name[]`

2. 当同时声明多个数组时，这种形式可以提供便利。

   ```java
   int[] nums, nums2, nums3;
   ```

3. 当将数组指定为方法的返回类型时，这种声明方法也是有用的。

### 3.12 关于字符串的一些说明

### 3.13 向 C/C++ 程序员提供指针方面的说明



## 第4章 运算符

- 算术运算符
- 位运算符
- 关系运算符
- 逻辑运算符
- 其它运算符

### 4.1 算术运算符

```java
+ - * / % ++ += -= *= /= %= --
```

**算术运算符的操作数必须是byte、short、int、long、char五种类型中的一种。**

#### 4.1.1 基本算术运算符

```java
+ - * /
```

#### 4.1.2 求模运算符

```java
%
```

#### 4.1.3 算术与赋值复合运算符

```java
// 对于所有的二元算术运算，都有相应的复合赋值运算符。
```

#### 4.1.4 自增与自减运算符

```java
++ --
```

### 4.2 位运算符

```java
~ & | ^ >> >>> << &= |= ^= >>= >>>= <<=
```

**位运算符的操作数必须是byte、short、int、long、char五种类型中的一种。**

### 4.3 关系运算符

1. 作用：`用来判定一个操作数与另外一个操作数之间的关系。`这里的`关系`包括`相等`和`排序`关系。

2. 六大关系运算符：

   ```java
   ==	!=	>	<	>=	<=
   ```

3. 运算结果：`布尔值`

4. 应用：`if语句和循环语句的控制表达式中`

5. 操作数

   - `==`和`!=`的操作数：任何类型
   - `>`、`<`、`>=`、`<=`的操作数：数值类型（byte、short、int、long、char）


### 4.4 布尔逻辑运算符

1. 作用：`操作布尔型操作数`

2. 布尔逻辑运算符列表

   ```java
   &	|	^	||	&&	!	&=	|=	^=	==	!=	?:
   ```

3. 运算结果：`布尔值`

4. 操作数：`布尔类型`

### 4.5 赋值运算符

### 4.6 "?"运算符

### 4.7 运算符的优先级

1. 赋值运算符的优先级最低

### 4.8 使用圆括号


## 第5章 控制语句

1. 定义：`根据程序的状态变化，引导程序的执行流程和分支的语句。`
2. 分类
   - 选择语句：允许程序根据表达式的输出或变量的状态，选择不同的执行路径。
   - 迭代语句：使程序能够重复执行一条或多条语句。
   - 跳转语句：使程序能够以非线性的方式执行。


### 5.1 选择语句

1. 作用：根据只有在运行期间才知道的条件来控制程序的执行流程。
2. 分类
   - if 语句
   - switch 语句

#### 5.1.1 if 语句

1. 可以使用if语句通过两个不同的路径，引导程序的执行流程。

2. 语法形式

   ```java
   if (condition) statement1;
   else statement2;
   ```

   其中，每条语句既可以是单条语句，也可以是位于花括号中的复合语句（代码块）。condition是返回布尔值的任何表达式。else子句是可选的。

3. 流程
   `如果condition为true，就执行statement1；否则执行statement2（如果存在的话）。不允许两条语句都执行。`

4. 最通常的情况是，用于控制if语句的表达式会使用关系运算符。然而，也可以使用单个布尔型变量控制if语句，eg:

   ```java
   boolean dataAvailable;
   if (dataAvailable)
     ProcessData();
   else
     waitForMoreData();
   ```

5. 在if和else之后只能有一条语句。如果希望包含多条语句，那么需要创建代码块，eg:

   ```java
   int bytesAvailable;
   if (bytesAvailable > 0) {
     ProcessData();
     bytesAvailable -= n;
   } else
     waitForMoreData();
   ```

6. if语句的变式

   1. 嵌套的if语句
      嵌套的if语句是另外一个if或else的目标。当嵌套if语句时，需要记住的主要问题是：
      `else语句总是与位于同一代码块中最近（并且还没有else子句与之关联）的if语句相关联，作为其else子句。`

      ```java
      if (i == 10) {
        if (j < 20) a = b;
        if (k > 100) c = d;
        else a = c;
      }
      else a = d;
      ```

   2. if-else-if语句
      if-else-if语句是一种基于一系列嵌套if语句的常见编程结构，其形式如下所示：

      ```java
      if (condition)
        statement;
      else if (condition)
        statement;
      else if (condition)
        statement;
      .
      .
      .
      else
        statement;
      ```

      if语句从上向下执行。一旦某个条件为true，就会执行与之关联的if语句，并且会略过剩余的语句。如果没有一个条件为true，就执行最后的else语句。最后的else语句作为默认条件，也就是说，如果所有其他条件测试都失败，就执行最后的else语句。如果没有最后的else语句，并且所有其他条件都是false，那么没有动作会发生。




#### 5.1.2 switch 语句

1. switch语句是Java的多分支语句。它为根据一个表达式的值调度执行代码的不同部分，提供了一种简单方法。因此，相对于一系列if-else-if语句，switch语句通常是更好的替代方法。 下面是switch语句的一般形式：

   ```java
   switch (expression) {
     case value1:
       // statement sequence
       break;
     case value2:
       // statement sequence
       break;
     .
     .
     .
     case valueN:
       // statement sequence
       break;
     default:
       // default statement sequence
   }
   ```

2. expression表达式类型（6种）：`byte、short、int、char或枚举类型以及String类型（JDK 7+）`

3. case语句：

   - 指定的每个数值必须是唯一的常量表达式（例如字面值）
   - case值不允许重复
   - 每个数值的类型必须和expression的类型兼容

4. 工作方式：
   将表达式的值与case语句中的每个值进行比较，如果发现一个匹配，就会执行该case语句后面的代码；如果没有常量和表达式相匹配，就执行default语句。然而，default语句是可选的。如果没有case常量能与之匹配，并且没有提供default语句，就不会发生进一步的动作。

5. 在switch语句中，可以使用break语句终止语句序列。当遇到break语句时，执行过程就会进入整个switch语句后面的第一行代码。break语句具有“跳出”switch语句的效果。

6. switch语句的变式：嵌套的switch语句
   可以将switch语句作为外层switch语句的一部分，这称为嵌套的switch语句。因为switch语句定义有自己的代码块，所以内部switch语句中的case常量和外部switch语句中的case常量之间不会引起冲突。

7. switch语句的三个特征

   - switch语句只能进行相等性测试，这一点与if语句不同，if语句可以对任何类型的布尔表达式进行求值。也就是说，switch语句只查看表达式的值是否和某个case常量相匹配。
   - 在同一switch语句中，两个case常量不允许具有相同的值。当然，switch语句与包围它的外层switch语句可以具有相同的case常量。
   - 相对于一系列嵌套的if语句，switch语句通常效率更高。




### 5.2 迭代语句

Java的迭代语句包括for、while以及do-while语句。这些语句会创建通常称之为循环的效果。循环重复执行同一套指令，直到遇到结束条件。

#### 5.2.1 while语句

1. 一般形式

   ```java
   while (condition) {
     // body of loop
   }
   ```

   condition可以是任何布尔表达式。只要这个布尔表达式为true，就会执行循环体；当condition变为false时，程序控制就会转移到紧随循环之后的下一行代码。如果重复执行的语句只有一条，花括号就不是必需的。

2. 因为while循环是在每次循环开始时，对condition表达式进行求值，所以如果condition一开始就是false，那么循环体一次都不会执行。

3. while循环的循环体可以为空。在java中，空语句（只包含一个分号的语句）在语法上是合法的。 

#### 5.2.2 do-while 语句

1. why need `do-while`
   正如刚才看到的，如果控制while循环的condition最初为false，那么循环体就不会被执行。然而，有时希望至少执行一次循环体，即使condition最初为false。于是引入do-while语句。

2. 一般形式

   ```java
   do {
     // body of loop
   } while (condition);
   ```

   do-while循环的每次迭代首先执行循环体，然后对condition进行求值。如果condition为true，就继续执行循环；否则终止循环。其中condition必须是布尔表达式。


#### 5.2.3 for语句

1. 传统for语句的一般形式：

   ```java
   for(initialization; condition; iteration) {
     // body
   }
   ```

2. 在for循环内部声明循环控制变量

3. 使用逗号

4. for循环变体

#### 5.2.4 for循环的for-each版本

1. for-each风格的for循环也被称为增强的for循环。for循环的for-each版本的一般形式如下：

   ```java
   for(type itr-var : collection) statement-block
   ```

   type指定了类型，itr-var指定了迭代变量的名称，迭代变量用于接收来自集合的元素，从开始到结束，每次接收一个。collection指定了要遍历的集合。对于循环的每次迭代，会检索出集合中的下一个元素，并存储在itr-var中。循环会重复执行，直到得到集合中的所有元素。

2. for-each风格的for循环中，迭代变量是“只读的”。eg. NoChange.java

3. 对多维数组进行迭代 eg.ForEach3.java


#### 5.2.5 嵌套的循环



### 5.3 跳转语句

Java支持三种跳转语句：break、continue、return。这些语句将控制转移到程序的其他部分。
注意：

> 除了在此讨论的跳转语句外，Java还支持另外一种可以改变程序执行流程的方式——通过异常处理。异常处理提供了一种结构化方式，用来捕捉运行时错误并通过程序对其进行处理。异常处理是由try、catch、throw、throws以及finally等关键字支持的。本质上，异常处理机制允许程序执行非本地的分支。

#### 5.3.1 使用break语句

在Java中，break语句有三种用途：

1. 用于终止switch语句中的语句序列

2. 用于退出循环

   - 可以在所有Java循环中使用break语句，包括有意设计的无限循环。
   - 如果在一系列嵌套的循环中使用break语句，那么break语句只中断最内层的循环。
   - 在一个循环中可以出现多条break语句。但是请小心，过多的break语句可能会破坏代码的结构。
   - 在某条switch语句中使用的break语句，只会影响该switch语句，不会结束任何外层循环。

3. 用作goto语句的“文明”形式

   - 使用标签的break语句的一般形式如下所示：

     ```java
     break label;
     ```

#### 5.3.2 使用continue语句

1. 用来提前终止循环的一次迭代。
2. 与break语句一样，continue语句也可以指定一个标签，描述继续执行哪个包含它的循环。

#### 5.3.3 return 语句

1. return语句表示要显示地从方法返回。也就是说，return语句导致程序的执行控制转移给方法的调用者。因此，它被归类到跳转语句。
2. 在方法中，任何时候都可以使用return语句将执行控制转移到方法的调用者。





## 第6章 类

### 6.1 类的基础知识

> 类定义了一种新的数据类型。一旦定义一个类，就可以使用这种新的类型创建该类型的对象。因此，类是对象的模板，对象是类的实例。因为对象是类的实例，所以经常会看到交换使用“对象”和“实例”这两个词。

#### 6.1.1 类的一般形式

#### 6.1.2 一个简单的类

1. 类的声明
   ```java
   // 声明一个Box类
   class Box {
     double width;
     double height;
     double depth;
   }
   ```

   类的声明仅创建了一个模板，它没有创建实际的对象。因此，前面的代码没有创建Box类型的任何对象。

2. 对象创建

   ```java
   // 实际创建一个Box对象
   Box mybox = new Box(); // create a Box object called mybox
   ```

### 6.2 声明对象

1. 创建一个类，就是在创建一种新的数据类型。可以使用这个类声明该类型的对象。

2. 声明一个类的对象需要两个步骤：

   1. 声明类类型的一个变量，这个变量没有定义对象，它只是一个引用对象的变量。
   2. 获取对象实际的物理副本，并将其赋给那个变量。可以使用new运算符完成这一操作。new运算符动态地（在运行时）为对象分配内存，并返回指向对象的引用。这个引用基本上是由new为该对象分配的内存地址。然后将这个引用存储在变量中。因此在Java中，所有类对象都必须动态分配。

3. 声明对象的代码示例

   ```java
   Box mybox; // declare reference to object
   mybox = new Box(); // allocate a Box object
   ```

   **第一行代码将mybox声明为对Box类型对象的引用。执行这行代码后，mybox不指向实际的对象。**

   **第二行代码分配实际的对象，并将对该对象的引用赋给mybox。执行第二行代码后，就可以使用mybox变量了，就好像它是一个Box对象。但实际上，mybox只是保存了实际Box对象的内存地址。**

4. 类是逻辑结构，对象是物理实体。


### 6.3 为对象引用变量赋值

**当将一个对象引用变量赋值给另外一个对象引用变量时，不是创建对象的副本，而是创建引用的副本。**

### 6.4 方法

1. 类通常由两部分构成：`实例变量`和`方法`。

2. 方法的一般形式：

   ```java
   type name(parameter-list) {
     // body of method
   }
   ```

3. 当在定义实例变量的类之外访问实例变量时，必须通过对象使用点运算符引用变量。但是，当在定义实例变量的类的内部访问实例变量时，可以直接引用变量。对于方法调用也是如此。

4. 返回值

   1. 方法返回值的类型必须和方法指定的返回类型兼容。
   2. 用于接收方法返回值的变量，也必须和方法指定的返回类型兼容。

5. 参数

   1. 形参：由方法定义的、当调用方法时用于接收数值的变量。
   2. 实参：当调用方法时传递给方法的数值。

### 6.5 构造函数

1. 构造函数在创建对象之后立即初始化对象。

2. 构造函数的名称和包含它的类的名称相同，并且在语法上和方法类似。

3. 一旦定义构造函数，就会在创建对象之后、new运算符完成之前，立即自动调用构造函数。

4. 构造函数没有返回类型，也不返回void类型。这是因为类构造函数的返回类型隐式地为类本身。

5. 如果没有显式地为类定义构造函数，Java会为类创建默认的构造函数。eg:

   ```java
   Box mybox1 = new Box(); // new Box()是调用Box()构造函数
   ```

   在上面这行代码中，没有为Box定义构造函数，但是Java会提供一个默认构造函数，因此上面这行代码不会报错。其中，`new Box();`就表示调用Box类的默认构造函数。

6. 默认构造函数自动地将所有实例变量初始化为其默认值。对于数值类型、引用类型和boolean类型，这个默认值分别是0、null和false。

7. 一旦定义自己的构造函数，Java就不再提供默认的构造函数。

### 6.6 this关键字

1. why `this`?
   有时，方法需要引用调用它的对象。为了能够进行这种操作，Java定义了`this`关键字。

2. 使用this关键字可以解决`当局部变量和实例变量具有相同的名称时，局部变量隐藏实例变量`的问题。eg:

   ```java
   class Box {
     double width;
     double height;
     double depth;
     
     // Use this to resolve name-space collisions.
     Box(double width, double height, double depth) {
       this.width = width;
       this.height = height;
       this.depth = depth;
     }
   }
   ```

### 6.7 垃圾回收（garbage collection）

### 6.8 finalize()方法

1. 通过Java提供的“终结（finalization）”机制，可以定义当对象即将被垃圾回收器回收时发生的特定动作。

2. 为了给类添加终结器（finalizer），可以定义finalize()方法。当即将回收类的对象时，Java运行时会调用该方法。在finalize()方法内部，可以指定在销毁对象之前必须执行的那些动作。

3. finalize()方法的一般形式

   ```java
   protected void finalize() {
     // finalization code here
   }
   ```

4. 只会在即将进行垃圾回收之前调用finalize()方法。这意味着不知道什么时候会执行finalize()方法，甚至也不知道是否会执行finalize()方法。所以，程序应当提供释放对象所使用的系统资源等内容的一些其他方法。对于常规的程序操作而言，不应依赖于finalize()方法。

### 6.9 堆栈类



## 第7章 方法和类的深入分析

### 7.1 重载方法

1. 概念
   `在同一个类中可以定义两个或多个共享相同名称的方法，只要它们的参数声明不同即可。`
   当出现这种情况时，这些方法被称为是**重载的（overloaded）**，并且这一过程被称为**方法重载（method overloading）**。
2. 方法重载是Java支持**多态**性的方式之一。
3. 当调用重载方法时，Java所使用参数的类型和/或数量决定了实际调用哪个版本。
4. 方法的返回类型在重载版本的判断中不起作用。
5. 当调用重载的方法时，Java在用来调用方法的实参和方法形参之间查找匹配。当没有找到准确的匹配时，Java会使用自动类型转换。
6. 构造函数也可以被重载。

### 7.2 将对象用作参数

1. 方法的参数不仅可以是简单类型，还可以是对象（类类型 / 引用类型）。

2. 对象参数最常用于调用构造函数。经常会希望创建在开始时就与已经存在的某些对象相同的对象。为此，必须定义一个以类对象作为参数的构造函数。eg:

   ```java
   class Box {
     double width;
     double height;
     double depth;
     
     Box(Box ob) {
       width = ob.width;
       height = ob.height;
       depth = ob.depth;
     }
     
     Box(double w, double h, double d) {
       width = w;
       height = h;
       depth = d;
     }
     
     Box() {
       width = -1;
       height = -1;
       depth = -1;
     }
   }

   // 测试Box类
   Box mybox1 = new Box(10, 20, 15);
   Box myclone = new Box(mybox1); // create copy of mybox1
   ```

### 7.3 参数传递的深入分析

1. Java使用值调用（call-by-value）传递所有实参，但是根据所传递的是基本类型还是引用类型，精确效果是不同的。
2. 当为方法传递基本类型时，使用值传递，因此会得到实参的副本，并且对接收实参的形参所进行的操作，对方法的外部没有影响。
3. 当为方法传递对象时，情况就完全不同了，因为对象是通过引用调用传递的。请牢记，`当创建类变量时，只是创建指向对象的引用`。因此，当将引用传递给方法时，接收引用的形参所引用的对象与实参引用的是同一个对象。这意味着对象就好像是通过引用调用传递给方法的。`在方法内修改对象会影响到作为实参的对象`。
4. 当将对象引用传递给方法时，引用本身是使用**值**调用传递的。但是，由于传递的值引用一个对象，因此值的副本仍然引用相应实参指向的同一个对象。

### 7.4 返回对象

1. 方法可以返回任意类型的数据，包括基本数据类型和类类型（引用类型）。

### 7.5 递归

1. 递归是根据自身定义内容的过程。就Java编程而言，递归是一个允许方法调用自身的特性。调用自身的方法被称为**递归方法**。
2. 递归的典型例子——阶乘。
3. 当编写递归方法时，在某个地方必须有一条if语句，用于强制方法返回而不再执行递归调用。如果没有这么做，一旦调用该方法，就永远不会返回。

### 7.6 访问控制

1. Why？
   封装将操作数据的代码和数据链接起来。同时，封装提供了另外一个重要的特性：`访问控制`。以此来控制程序的哪些部分可以访问类的成员，防止对**数据**的误用。

2. Java访问控制机制的分类

   - 单个类的访问控制：`访问修饰符`
   - 多个类的访问控制：`接口`、`包`（见后）

3. 三大访问修饰符

   |   访问修饰符   |                   作用                   |
   | :-------: | :------------------------------------: |
   |  public   |  如果类的某个成员使用public进行修饰，那么该成员可以被任何代码访问   |
   |  private  | 如果类的某个成员被标识为private，那么该成员只能被所属类的其他成员访问 |
   | protected |                  继承用                   |
   |    默认     |                                        |

4. Where?
   `访问修饰符位于其他成员类型限定符的前面。也就是说，它必须位于成员声明语句的最前面。`eg：

   ```java
   public int i;
   private double j;
   private int myMethod(int a, char b) { //... }
   ```

### 7.7 理解static

1. why static?
   有时可能希望定义能够`独立于类的所有对象进行使用的成员`。在正常情况下，只有通过组合类的对象才能访问类的成员。但是，也可以创建能够由类本身使用的成员，而不需要通过对特定实例的引用。为了创建这种成员，需要在成员声明的前面使用关键字`static`。
2. 如果成员被声明为静态的，就可以在创建类的任何对象之前访问该成员，并且不需要使用任何对象引用。
3. 方法和变量都可以声明为静态的。
4. 被声明为静态的实例变量，在本质上是全局变量。当声明类的对象时，不会生成静态变量的副本。相反，类的所有实例共享相同的静态变量。
5. 声明为静态的方法的三个限制
   1. 只能直接调用其他静态方法。
   2. 只能直接访问静态数据。
   3. 不能以任何方式引用this或super关键字
6. 静态代码块
   为了初始化静态变量，如果需要进行计算，可以声明静态代码块。静态代码块只执行一次，当第一次加载类时执行。

### 7.8 final介绍

1. 将变量声明为`final`，这么做可以防止修改变量的内容，本质上就是`将变量变成了常量`。

2. 因为final变量不能被修改，这意味着`final变量必须在声明时进行初始化`。有两种方法完成这个工作：

   - 在声明时为其提供一个值（最常见）eg:

     ```java
     final int FILE_NEW = 1;
     final int FILE_OPEN = 2;
     final int FILE_SAVE = 3;
     final int FILE_SAVEAS = 4;
     final int FILE_QUIT = 5;
     ```

   - 在构造函数中为其赋值

3. final变量名全部使用大写，每个单词之间用下划线连接。

### 7.9 重新审视数组

1. 对于数组重要的一点是，`它们是作为类的对象实现的`。
2. 数组的大小（即数组**能够**包含的元素的数量）包含在实例变量`length`中。所有数组都具有这个变量，并且它总是包含数组的大小。
3. length的值与实际使用的元素数量没有任何关系，`它只反映在最初设计时数组所能包含的元素数量`。

### 7.10 嵌套类和内部类

1. 在类A的内部定义另外一个类B，那么类B就是所谓的`嵌套类`；类A相应地称为`包含类`。
2. 嵌套类（类B）的作用域被限制在包含类（类A）之中，因此，嵌套类（类B）不能独立于包含类（类A）而存在。
3. 嵌套类（类B）可以访问包含类（类A）的成员，包括私有成员。但是，包含类（类A）不能访问嵌套类（类B）的成员。
4. 嵌套类（类B）既可以直接在包含类（类A）中作为成员进行声明，也可以在包含类（类A）的代码块中进行声明。
5. 嵌套类的分类：静态的和非静态的（常用）。
6. 静态的嵌套类是应用了static修饰符的嵌套类，只能通过对象访问包含类的非静态成员。也就是说，嵌套类不能直接引用包含类的非静态成员。
7. 非静态的嵌套类也称为`内部类`。内部类可以访问外部类的所有变量和方法，并且可以直接引用它们，引用方式与外部类的其他非静态成员使用的方式相同。
8. 内部类不仅可以在外部类的作用域内作为成员声明，还可以在任何代码块的作用域内定义。eg.可以在由方法定义的代码块中，甚至在for循环体内定义嵌套类。

### 7.11 String类介绍

1. `创建的每个字符串实际上都是String类型的对象。即使是字符串常量，实际上也是String对象。`eg:

   ```java
   System.out.println("This is a String object, too");
   ```

   字符串"This is a String object, too"就是一个String对象。

2. `String类型的对象是不可变的`：一旦创建一个String对象，其内容就不能再改变。
   尽管这看起来好像是一个严重的限制，但实际上不是，有两个原因：

   - 如果需要改变一个字符串，总是可以创建包含修改后内容的新字符串。
   - Java定义了String类的对等类，分别称为`StringBuffer`和`StringBuilder`，它们允许修改字符串，所以在Java中仍然可以使用所有常规的字符串操作（见后）。

3. 可以通过多种方式构造字符串，最简单的方式是使用类似下面的语句：

   ```java
   String myString = "this is a test";
   ```

4. Java为String对象定义了一个运算符——`+`，可以使用它连接两个字符串。eg:

   ```java
   String myString = "I" + " like" + "Java.";
   ```

   会使myString包含"I like Java."。

5. String类提供的三个常用方法

   | 方法名      | 一般形式                             | 作用                     |
   | -------- | -------------------------------- | ---------------------- |
   | equals() | boolean equals(String secondStr) | 测试两个字符串是否相等            |
   | length() | int length()                     | 获取字符串的长度               |
   | charAt() | char charAt(int index)           | 获取字符串中指定索引处的字符（索引从0开始） |

6. 字符串就像其他任何类型对象一样也可以定义数组。eg:

   ```java
   String[] strArr = { "one", "two", "three" };
   ```

### 7.12 使用命令行参数

1. why?

   当`运行`程序时，有时希望为程序传递信息，这可以通过为**main()**方法传递`命令行参数`来完成。

2. 命令行参数是`执行程序时在命令行上紧跟程序名称之后的信息`。

3. Java中的命令行参数作为字符串存储在String数组中，并传递给main()方法的args参数。第一个命令行参数存储在args[0]中，第二个存储在args[1]中，依此类推。

4. 所有命令行参数都是作为**字符串**传递的，必要的时候需要进行类型转换。

### 7.13 varargs：可变长度参数

1. why?
   从JDK5开始，Java提供了一个新特性，该特性可以简化某种方法的创建，这种方法需要使用数量可变的参数。这个特性称为`varargs`，也就是可变长度参数（variable-length argument）的英文缩写。使用可变长度参数的方法称为`可变参数方法（variable-arity method）`，或简称为`varargs方法`。

2. 可变长度参数通过三个句点（`...`）标识。eg:

   ```java
   static void vaTest(int... v) {}
   ```

3. `...`语法告诉编译器，可以使用`零个或更多个参数`调用vaTest()方法。
   这里，v被隐式地声明为int[]类型的`数组`。因此，在vaTest()方法内部，可以使用常规的数组语法访问v。eg:

   ```java
   static void vaTest(int... v) {
     for(int x : v)
       System.out.print(x + " ");
   }
   ```

4. 在varargs方法内部，可变参数是作为数组进行操作的。语法`...`告诉编译器将要使用可变长度参数，并且这些参数将被存储在这个数组中。

5. 使用不同数量的参数调用varargs方法，包括根本不使用任何参数。参数都被自动放进一个数组中并传递给相应的可变参数变量。对于没有参数的情况，数组的长度为0。

6. 使用可变长度参数的方法也可以具有`常规`参数。但是，`可变长度参数必须是方法最后声明的参数`。eg:

   ```java
   int doIt(int a, int b, double c, int... vals) {}
   ```

   调用doIt()方法时，前三个实参和前三个形参相匹配，然后所有剩余实参都假定属于vals。

7. 只能有一个可变长度参数。eg:

   ```java
   int doIt(int a, int b, double c, int... vals, double... morevals) {} // Error!
   ```

   试图声明第二个可变长度参数是非法的。

8. varargs方法可以被重载，共有两种方式：

   1. `通过可变长度参数的类型区分不同的版本`。eg:

      ```java
      vaTest(int ... v){}
      vaTest(boolean ... v){}
      ```

      就像可以通过不同类型的数组参数对方法进行重载一样，可以使用不同类型的可变长度参数来对varargs方法进行重载。

   2. `增加一个或多个常规参数`。eg:

      ```java
      vaTest(String msg, int... v){}
      ```

9. varargs方法与模糊性




## 第8章 继承

### 8.1 继承的基础知识

1. 对于继承某个超类的类来说，类声明的一般形式如下所示：

   ```java
   class subclass-name extends superclass-name {
     // body of class
   }
   ```

   对于创建的任何子类来说，只能指定一个超类。Java不支持将多个超类继承到单个子类中。

2. 子类不能访问超类中被声明为私有的那些成员。

3. 一旦创建一个定义对象通用方面的超类，就可以继承这个超类，形成更为特殊的子类。每个子类再简单地增加自己特有的属性，这就是继承的本质。

4. 可以将指向继承自某个超类的任何子类对象的引用，赋值给这个超类的引用变量（超类变量可以引用子类对象）。

5. **可以访问哪些成员是由引用变量的类型决定的，而不是由所引用对象的类型决定的。**也就是说，当将指向子类对象的引用赋值给超类的引用变量时，只能访问子类对象的那些在超类中定义的部分。eg:

   ```java
   class Box {
     double width;
     double height;
     double depth;
   }

   class BoxWeight extends Box {
     double weight;
     
     BoxWeight(double w, double h, double d, double m) {
       width = w;
       height = h;
       depth = d;
       weight = m;
     }
   }

   class Test {
     public static void main(String[] args) {
       Box box = new Box();
       BoxWeight boxWeight = new BoxWeight(1.0, 2.0, 3.0, 4.0);
       box = boxWeight;
       System.out.print(box.width);
       System.out.print(box.height);
       System.out.print(box.depth);
       System.out.print(box.weight); // error!!!
     }
   }
   ```

### 8.2 使用super关键字

1. why `super`?
   给出一个例子，子类Student继承超类Person，如下所示：

   ```java
   class Person {
     String name;
     int age;
     int gender;
     
     Person(String name, int age, int gender) {
       this.name = name;
       this.age = age;
       this.gender = gender;
     }
   }

   class Student extends Person {
     long stuNo;
     int grade;
     
     Student(String name, int age, int gender, long stuNo, int grade) {
       this.name = name;
       this.age = age;
       this.gender = gender;
       this.stuNo = stuNo;
       this.grade = grade;
     }
   }
   ```

   在这个例子中，继承自Person的类Student的实现还不够高效和健壮。例如，Student类的构造函数显式地初始化Person类的name、age和gender变量。不但复制超类中的代码，导致效率低下，而且这暗示着子类必须保证能够访问这些成员。但是，有时会希望创建只有自己才知道实现细节的超类（也就是将数据成员保存为私有的）。对于这种情况，子类就不能直接访问或初始化这些变量。因为封装是OOP的主要特性，所以Java为这个问题提供一个解决方案：无论何时，当子类需要引用它的**直接**超类时，都可以使用关键字`super`。
   `super`有两种一般用法：

   - 用于调用超类的构造函数
   - 用于访问超类中被子类的某个成员隐藏的成员

2. 使用super调用超类的构造函数
   子类可以通过使用下面的super形式，调用超类定义的构造函数：

   ```java
   super(arg-list);
   ```

   其中，arg-list是超类中构造函数需要的全部参数，`super()必须总是子类的构造函数中执行的第一条语句`。eg:

   ```java
   class Person {
     String name;
     int age;
     int gender;
     
     Person(String name, int age, int gender) {
       this.name = name;
       this.age = age;
       this.gender = gender;
     }
   }

   class Student extends Person {
     long stuNo;
     int grade;
     
     Student(String name, int age, int gender, long stuNo, int grade) {
       super(name, age, gender); // call superclass constructor
       this.stuNo = stuNo;
       this.grade = grade;
     }
   }
   ```

3. super的另一种用法
   super的另一种用法和this类似，只不过super总是在引用（在其中使用super关键字的子类的）超类。
   这种用法的一般形式如下：

   ```java
   super.member
   ```

   其中，member既可以是方法，也可以是实例变量。
   最常使用这种super形式的情况是，`子类的成员名称隐藏了超类中的同名成员`。

### 8.3 创建多级继承层次

1. 每个子类都会继承自己所有超类中的所有特征。因此，只需要添加自己的，特定的应用程序所需要的额外信息即可。这是继承的部分价值，`允许重用代码`。
2. super()总是引用**最近**超类的构造函数。
3. 在类层次中，如果超类的构造函数需要参数，那么所有子类必须“向上”传递这些参数。`不管子类本身是否需要参数`，都需要这么做。

### 8.4 构造函数的调用时机

1. 在类层次中，从超类到子类按照继承的顺序调用构造函数。
2. super()必须是子类构造函数中执行的第一条语句。
3. 如果没有使用super()，那么将执行每个超类的默认构造函数或无参构造函数。

### 8.5 方法重写

1. 在类层次中，如果子类的一个方法和超类的某个方法具有相同的名称和类型签名，那么称子类中的这个方法重写了超类中相应的那个方法。当在子类中调用被重写的方法时，总是调用由子类定义的版本，由超类定义的版本会被隐藏。

2. 如果希望访问类中被重写的方法，可以通过*super*完成该操作。eg:

   ```java
   // Method overriding.
   class A {
     int i, j;
     
     A(int a, int b) {
       i = a;
       j = b;
     }
     
     void show() {
       System.out.println("i and j: " + i + " " + j);
     }
   }

   class B extends A {
     int k;
     
     B(int a, int b, int c) {
       super(a, b);
       k = c;
     }
     
     void show() {
       super.show();
       System.out.println("k: " + k);
     }
   }
   ```

3. 只有当两个方法的**名称和类型签名都相同**时才会发生重写。如果不是都相同，那么这两个方法就只是简单的重载关系。eg:

   ```java
   // Method overloaded.
   class A {
     int i, j;
     
     A(int a, int b) {
       i = a;
       j = b;
     }
     
     void show() {
       System.out.println("i and j: " + i + " " + j);
     }
   }

   class B extends A {
     int k;
     
     B(int a, int b, int c) {
       super(a, b);
       k = c;
     }
     
     // overload show()
     void show(String msg) {
       System.out.println(msg + k);
     }
   }
   ```

### 8.6 动态方法调度

1. 方法重写形成了动态方法调度（dynamic method dispatch）的基础，动态方法调度是Java中最强大的功能之一。动态方法调度是一种机制，通过这种机制可以在**运行时**，而不是在编译时解析对重写方法的调用。动态方法调度很重要，因为这是Java实现**运行时多态**的机理所在。

2. 一个重要的原则：`超类引用变量可以指向子类对象`。
   Java利用这一事实，在运行时解析对重写方法的调用。下面是实现原理：

   > 当通过超类引用调用重写的方法时，Java根据在调用时所引用对象的类型来判定调用哪个版本的方法。因此，这个决定是在运行时做出的。如果引用不同类型的对象，就会调用不同版本的重写方法。换句话说，是当前正在引用的对象的类型（而不是引用变量的类型）决定了将要执行哪个版本的重写方法。所以，如果超类包含被子类重写的方法，那么当通过超类引用变量引用不同类型的对象时，会执行不同版本的方法。

3. 引用变量和对象类型（对比8.6第2条和8.1第5条）

   - 可以访问哪些成员是由引用变量的类型决定的，而不是由所引用对象的类型决定的。
   - 当前正在引用的对象的类型（而不是引用变量的类型）决定了将要执行哪个版本的重写方法。

4. 通过同时使用继承和运行时多态机制，可以定义由多个不同的，但是相互关联的对象类型使用的统一接口。

### 8.7 使用抽象类

1. 可以通过`abstract`类型修饰符，要求特定的方法必须被子类重写。这些方法被称作子类责任（subclass responsibility），因为在超类中没有提供实现。因此，子类必须重写它们——不能简单地使用在超类中定义的版本。

2. 为了声明抽象方法，需要使用下面的一般形式：

   ```java
   abstract type name(parameter-list);
   ```

   抽象方法没有方法体。

3. 任何包含一个或多个抽象方法的类都必须被声明为抽象的。

4. 为了声明抽象类，只需要简单地在类声明的开头、在class关键字的前面使用关键字`abstract`。

5. 对于抽象类不存在对象。也就是说，不能使用new运算符直接实例化抽象类。这种对象是无用的，因为抽象类的定义是不完整的。

6. 不能声明抽象的构造函数，也不能声明抽象的静态方法。

7. 抽象类的所有子类，要么实现超类中的所有抽象方法，要么自己也声明为抽象的。

8. 抽象类可以包含任意数量的具体方法。

9. 尽管抽象类不能用于实例化对象，但是可以使用它们创建对象引用，因为Java的运行时多态是通过使用超类引用实现的。因此，必须能够创建指向抽象类的引用，从而可以用于指向子类对象。

### 8.8 在继承中使用final关键字

1. 使用final关键字阻止重写。在声明的开头使用final作为修饰符的方法不能被重写。eg:

   ```java
   class A {
     final void meth() {
       System.out.println("This is a final method.");
     }
   }

   class B extends A {
     void meth() { // ERROR! Can't override.
       System.out.println("Illegal!");
     }
   }
   ```

2. 使用final关键字阻止继承。

   - 在类声明的前面使用final关键字可以阻止该类被继承。
   - 将类声明为final，就隐式地将类的所有方法也声明为final。
   - 将类同时声明为abstract和final是非法的，因为抽象类本身是不完整的，它依赖子类来提供完整的实现。eg:

   ```java
   final class A {
     // ...
   }

   // The following class is illegal.
   class B extends A { // ERROR! Can't subclass A
     // ...
   }
   ```

### 8.9 Object类



## 第9章 包和接口