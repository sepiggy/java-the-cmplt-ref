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

1. 缩小转换(narrowing conversion)：显示地使数值变得更小以适应目标类型的转换。
2. 为了实现两种不兼容类型之间的转换，引入强制类型转换，其语法格式为：
   `(target-type) value`
   其中，target-type 指定了期望将特定值转换成哪种类型。
   ​



