# FASTA算法

FASTA程序是第一个广泛使用的数据库相似性搜索程序

FastA算法是由Lipman和Pearson于1985年发表的，关于序列比对的启发式算法。
<br/>以下链接是EBI提供的fasta服务。
<br/>http://www.ebi.ac.uk/fasta33/ 


FASTA算法是**顺序**将数据库中的每一个序列与查询序列比较，返回与查询序列非常相似的数据库序列。

### FASTA算法的基本思路

是**识别与待查**序列相匹配的很短的序列片段，称为k-tuple（即连续的k个字符，k-tuple）

1. 确定两个序列的共同k元组，k决定了子串的大小。
<br/>增大k参数就会减少子串命中的数目，也就会减少所需要的最佳搜索的数目，提高搜索速度。

2. 找出两个序列具有最大匹配的相对位移。<br/>
![](https://github.com/HaloAncy/BioInformatics/blob/master/jpg/Fasta1.jpg)  

### 算法设置两个数据结构表：

#### 查找表

存放第一条序列各k元组的位置

#### 位移向量表

位移决定一个序列相对于另一个发生
<br/>如果共同的k元组起始于s[i]和t[j]，则位移等于i-j<br/>
![](https://github.com/HaloAncy/BioInformatics/blob/master/jpg/Fasta2.jpg)  

### 位移累计最大值意义：
该位移下匹配最多
<br/>计算相应动态规划矩阵对角线附近区域

#### PS
FASTA对蛋白质序列搜索的结果要比对DNA序列搜索的结果更敏感。
<br/>它对数据库的每一次搜索都只有一个最佳的比对，一些有意义的比对可能被错过。
