# 设计初衷  
- 为Spring开发者提供一种，更快速、体验更好的Spring应用开发方式
- 开箱即用，同时也可快速扩展
- 嵌入式的Tomcat
- 绝对没有冗余代码，无需XML配置

# 核心功能  
- 核心能力：Spring容器、日志、自动配置AutoCongfiguration、Starters  
- web应用的能力：MVC、嵌入式Web服务器
- 数据访问(持久化)：关系型数据库、非关系型数据库
- 强大的整合其他技术的能力
- 测试：强悍的应用测试

# 自动配置  
@SpringBootApplication  
``` java  
@SpringBootConfiguration
@EnableAutoConfiguration // 开启自动配置
@ComponentScan() // 扫描注册的注解
```