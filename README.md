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