# Tomcat项目的入门

## (基于idea)通过Maven创建java-webapp的步骤

### 1. 创建项目

新建一个项目,通过maven的archetype(原型,骨架)来创建模块  
此处archetype选择`org.apache.maven.archetypes:maven-archetype-webapp`  
idea中可以指定tomcat生成的外部out路径  

### 2. 创建Tomcat服务器(本案例使用Tomcat9)

EditConfiguration→选择tomcat,并对其进行基础配置(端口,url路径等,具体配置省略)  
补充:配置deployment时,需要选择对应的artifact(组件,加工品)或war包  
并配置其容器所隐射的地址(application context 的路径)

---

## 文件夹解释

### 1. servlet

关于servlet相关的用法,文件夹下有说明文档可以查看

### 2. filter

过滤器的使用

### 3. cookie

cookie相关