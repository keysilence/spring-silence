#!/bin/sh

echo "############## start ##############"

# 拉取代码
git pull

# 编译
mvn clean install -Dmaven.test.skip=true

# 拷贝新编译的mvc.war
cp -f mvc/target/mvc.war ./

# 删除本地已打镜像mvc:latest
docker rmi -f mvc:latest

# 设置镜像标签名
tag_name=mvc:latest

# 构建镜像
docker build -f ./Dockerfile -t ${tag_name} .

# 登录网易云镜像服务器
docker login -u chenmohaha_2000@163.com -p cm13811666786 hub.c.163.com

# 修改标签
docker tag mvc:latest hub.c.163.com/keysilence/store/docker/mvc:1.0.0

# 推到网易云
docker push hub.c.163.com/keysilence/store/docker/mvc:1.0.0

#git clean -df

echo "############## end ##############"
