# spring JDBC的使用案例

返祖调查

## 依赖
```xml
<dependencys>

    <!--spring容器-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.2.6.RELEASE</version>
    </dependency>
    
    <!--springJdbc-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.2.6.RELEASE</version>
    </dependency>
    
    <!--maria的数据库驱动-->
    <dependency>
        <groupId>org.mariadb.jdbc</groupId>
        <artifactId>mariadb-java-client</artifactId>
        <version>2.6.0</version>
    </dependency>
    
</dependency>

```

## 配置流程

### 1. 创建实体类(User)

### 2. 创建实体类的映射器Mapper(UserMapper)

内部需要实现接口`RowMapper<T>`,并重写方法`mapRow`

### 3. 配置数据源(application.xml)

主要是配置数据库的信息

### 4. 创建dao层(UserDao)

- 通过set方法来注入数据库信息(dataSource)

- 编写crud方法

### 5. 在main方法/测试案例中,通过dao来执行crud方法