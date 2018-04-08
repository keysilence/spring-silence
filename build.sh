#!/bin/sh

git pull

echo "############## start ##############"
mvn clean install -Dmaven.test.skip=true

cp mvc/target/mvc.war ./

#base_url=10.19.248.200:30100
#docker_url=${base_url}/g_laikang/laikang-app-admin:latest
docker rmi -f mvc:latest

tag_name=mvc:latest

docker build -f ./Dockerfile -t ${tag_name} .

docker login -u chenmohaha_2000@163.com -p cm13811666786 hub.c.163.com

docker tag mvc:latest hub.c.163.com/keysilence/store/docker/mvc:1.0.0

docker push hub.c.163.com/keysilence/store/docker/mvc:1.0.0

#echo "docker login -u ggov ${base_url}"
#docker login -u ggov -p !qaz2wsX ${base_url}
#
#docker push ${docker_url}

#git clean -df

echo "############## end ##############"
