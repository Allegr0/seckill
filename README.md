# seckill
一个基于SSM框架的高并发秒杀系统  
采用IDEA+Maven+SSM+Mysql+Redis+Jetty、Bootstrap/Jquery开发  
项目搭建过程详解：http://www.cnblogs.com/kukri/p/9027813.html
# Quick Start  
1.把项目clone到本地。  
2.从IDEA的pom.xml打开项目。  
3.修改数据库配置信息jdbc.properties。  
4.在Mysql中执行seckill/src/main/sql/schema.sql的脚本初始化数据库  
5.配置一个web服务器（tomcat或jetty），项目中pom.xml配了jetty的插件，可以直接从jetty启动  
6.http://localhost:8080/seckill/list  
7.enjoy
