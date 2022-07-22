# 使用须知
## 环境
Java 8
## 功能介绍
该软件用于刷题特工队统计成员刷题量，方便统计，数据更加准确，能够根据用户id统计该用户目前的题解数量  
当前版本支持本地文件方式导入用户名信息，文件格式csv，数据输出同样采用csv格式
## 使用
首先移动到jar包所在目录，执行下面的命令
```
PS D:\JavaProjects\leetcode-more-offline\target> java -jar .\leetcode-more-offline-1.0.jar
--------Leetcode-more----------
starting
请输入用户数据文件名,并确保文件与该软件处于同一目录：
userIds.csv
请输入数据结果文件名:
data.csv
exit
```
## 附录
### 文件格式
userIds.csv
```
userA
UserB
...
```