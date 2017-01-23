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

### 4.1 算术运算符











   ​


