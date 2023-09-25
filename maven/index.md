# 什么是maven  
项目管理工具， 可以通过一小段描述信息来管理项目的构建，报告和文档的项目管理工具软件。
- 它包含了一个项目对象模型 (Project Object Model)
- 一组标准集合
- 一个项目生命周期(Project Lifecycle)
- 一个依赖管理系统(Dependency Management System)
- 和用来运行定义在生命周期阶段(phase)中插件(plugin)目标(goal)的逻辑
## Maven项目工程标准结构  
```
    java工程名（项目名）
        |-- src目录
          |-- main目录（主干代码）
            |-- java目录（java代码）
            |-- resources目录（配置文件）
          |-- test目录（测试代码）
            |-- java目录（java代码）
            |-- resources目录（配置文件）
        |-- pom.xml（maven工程核心配置文件）
        |-- target目录（存放编译后的class文件.....）
```  
```
    web工程名（项目名）
    |-- src目录
      |-- main目录（主干代码）
        |-- java目录（java代码）
        |-- resources目录（配置文件）
        |-- webapp目录（页面资源）
          |-- WEB-INF
            |-- web.xml(web工程核心配置文件)
          |-- index.jsp
          |-- css、js、img..
      |-- test目录（测试代码）
        |-- java目录（java代码）
        |-- resources目录（配置文件）
    |-- pom.xml（maven工程核心配置文件）
    |-- target目录（存放编译后的class文件.....）
```  
# 生命周期和插件  
我们可以在 cmd 中通过一系列的 maven 命令，来对我们的工程进行编译、测试、打包、安装、部署。

1）clean，maven工程的清理命令，执行clean会删除target目录及内容。

2）compile，maven工程的编译命令，作用是将 src/main/java 下的文件编译为class文件输出到target目录下。

3）test，maven工程的测试命令，作用是执行 src/test/java 下单元测试类，并编译为class文件。

4）package，maven工程的打包命令，对于java工程执行package打成jar包，对于web工程打成war包。

5）install，maven工程的安装命令，执行install将maven工程打成jar包或war包，并发布到本地仓库。

6）deploy，maven工程部署命令，将jar或war包部署（上传）到私服中。
## 生命周期
maven 对项目构建过程分为“三套相互独立的” 生命周期，这三套生命周期分别是：

1. Clean Lifecycle(清理生命周期)：在进行真正的构建之前进行一些清理工作。
    - 命令:clean
2. Default Lifecycle(默认生命周期)：构建的核心部分：编译 --> 测试 --> 打包 --> 安装 -->部署等等。
    - 命令: compile  test  package  install  deploy
3. Site Lifecycle(站点生命周期)：生成项目报告，站点，发布站点。
    - 命令: site

在同一个生命周期中的命令，执行后面的命令，前面的命令自动执行