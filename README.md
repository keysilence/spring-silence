# spring-silence

## mvc
1.包含Spring MVC集成了Velocity以及Freemarker；
2.Spring MVC集成Jsp尚未成功；
3.包含ACE Admin规则样式；

### 打镜像
sh build.sh

### 本地运行
#### 查看本地镜像列表
docker images
#### 运行指定镜像
docker run -p 8080:8080 mvc:latest

### 查看镜像
#### 查看已运行镜像ID
docker ps
#### 进入镜像
docker exec -it {镜像ID} /bin/sh

### 预览
http://localhost:8080/first/helloWorldVelocity


## profile-config
区分不同环境，读取不同配置