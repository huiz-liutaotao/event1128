## 一个事件管理系统

## 背景

开发一个事件管理系统，提供增、删、改和查接口，并确保接口调用的正确性。

## 主要功能

创建事件
删除事件
修改事件
列出所有事件

使用 Mysql 数据库进行数据存储

批量处理

异常处理

系统监控 ：http://localhost:8080/thread-pool/status

## 安装和使用

###  前提条件

​    1、 安装JDK 17 或更高版本（推荐使用 Java 17）。

​    2、安装Maven（用于构建项目）。

###   运行

​     1、下载项目代码到本地  git clone https://github.com/huiz-liutaotao/event1128。

​     2、修改application.yml中的Mysql数据源配置（需改成当前的配置信息），可以参考下面的“调整配置”小节。

​     3、切换到根目录event下，执行打包：mvn clean package，在target目录下生成项目的后台jar：eventMgr-0.0.1-SNAPSHOT.jar。

​      4、将以上jar包放到任何一个目录，执行 java   -jar  eventMgr-0.0.1-SNAPSHOT.jar 来运行该项目。

​      5、在根目录下找到压缩文件node_modules.zip，将其解压到当前目录，解压完后 node_modules文件夹和public文件夹属于同一级别（由于node_modules过大无法正常上传，只能通过压缩后上传）。

​      6、切换到目录event/incident-management-frontend目录下，执行 npm start，启动前端页面。

###   调整配置

​    当需要链接Mysql数据库时，将修改以下对应的配置项就可以链接上数据库。

![image-20241128121549276](C:\Users\junhliu\AppData\Roaming\Typora\typora-user-images\image-20241128121549276.png)

   当需要修改缓存配置时，可以修改如下配置项：

![image-20241128121658283](C:\Users\junhliu\AppData\Roaming\Typora\typora-user-images\image-20241128121658283.png)

## 设计文档

请参考《事件管理系统设计文档》。

## 扩展文档

请参考《事件管理系统扩展计划文档》。

