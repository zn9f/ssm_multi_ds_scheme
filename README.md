```
方案1
通过Spring AOP在业务层实现读写分离，在DAO层调用前定义切面，利用Spring的AbstractRoutingDataSource解决多数据源的问题，
实现动态选择数据源

优点：通过注解的方法在DAO每个方法上配置数据源，原有代码改动量少，易扩展，支持多读
缺点：需要在DAO每个方法上配置注解，人工管理，容易出错
实现方式

方案2
通过Mybatis的Plugin在业务层实现数据库读写分离，在MyBatis创建Statement对象前通过拦截器选择真正的数据源，
在拦截器中根据方法名称不同（select、update、insert、delete）选择数据源。

优点：原有代码不变，支持多读，易扩展
缺点：
实现方式


方案3
如果你的后台结构是spring+mybatis，可以通过spring的AbstractRoutingDataSource和mybatis Plugin拦截器实现非常友好的
读写分离，原有代码不需要任何改变。
```