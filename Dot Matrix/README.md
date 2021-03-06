# 点阵图（Dot Plots）

又称为“矩阵作图法” 或“对角线作图法”

由 Gibbs 首先提出，是一种较为经典的搜索两序列间公共子序列的方法，可以在不同尺度上和不同相似度上发现两个序列之间的相近部分。

## 思想

将待比较的两个序列分别放在矩阵的两个轴上
- 一个在 X 轴，由左向右
- 一个在 Y 轴，由下向上

当对应的行与列上的字符匹配时，在矩阵的对应位置作出标记，逐个比较所有的字符对。
<br/>
![](https://github.com/HaloAncy/BioInformatics/blob/master/jpg/DM1.png)

如果两个序列之间存在一个相同的子串，则会存在一条与主对角线平行的由标记点构成的斜线与之对应。
<br/>
![](https://github.com/HaloAncy/BioInformatics/blob/master/jpg/DM2.png)

含有多个相同子序列的点阵图
<br/>
![](https://github.com/HaloAncy/BioInformatics/blob/master/jpg/DM3.png)

## 最佳比对
找到矩阵标记图中非重叠平行斜线的最长组合。

---

### 这一方法两个主要缺点：

- 比较的量，它随着序列大小的增加而增加，因为每一个残基都要与另一序列的所有残基比较；

- 必须从距阵中寻找对角线，并寻找各种可能的组合，以找出最佳排比。
 
++非常消耗资源++

---

## 点阵分析的应用

### 自身比对

- 寻找序列中的正向或反向重复序列

- 蛋白质的重复结构域(domain)

- 相同残基重复出现的低复杂区(Low Complexity)

- RNA二级结构中的互补区域等

### 对两条序列的相似性作整体的估计

---

## 点阵分析中的插入或删除
<br/>

![](https://github.com/HaloAncy/BioInformatics/blob/master/jpg/DM4.jpg)

效果
<br/>

![](https://github.com/HaloAncy/BioInformatics/blob/master/jpg/DM5.jpg)

<br/>

![](https://github.com/HaloAncy/BioInformatics/blob/master/jpg/DM6.jpg)

```
无ui unupdated
```
