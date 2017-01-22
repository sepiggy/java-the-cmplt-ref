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

#### 3.11.1 一维数组

