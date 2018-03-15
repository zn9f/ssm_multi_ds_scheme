```
通过Mybatis的Plugin在业务层实现数据库读写分离，在MyBatis创建Statement对象前通过拦截器选择真正的数据源，
在拦截器中根据方法名称不同（select、update、insert、delete）选择数据源。

优点：原有代码不变，支持多读，易扩展
缺点：
```