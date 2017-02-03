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

2. ```java
   &	|	^	||	&&	!	&=	|=	^=	==	!=	?:
   ```

3. 运算结果：`布尔值`

4. 操作数：`布尔类型`

### 4.5 赋值运算符

### 4.6 "?"运算符

### 4.7 运算符的优先级

- 赋值运算符的优先级最低

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



