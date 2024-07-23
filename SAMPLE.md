## 大致结构
1. xxl-job-admin：中心调度的web平台，可以配置多种任务和定时器
2. xxl-job-core: 核心工程，无论是调度平台，还是我们自己写的工程都需要引入这个核心工程，使用这个核心工程的内容来完成xxl-job的集成
3. xxl-job-executor-samples: 作者集成案例，包含两个模块，一个是非框架版的集成方式，一个是springboot版本的集成方式。
