FROM openjdk:8u292

LABEL MAINTAINER=Andy
WORKDIR /apps
ADD target/buaa-uaa.jar /apps/
CMD ["java","-jar","buaa-uaa.jar"]
# docker run --name buaa-uaa \
# -e spring_cloud_nacos_server_addr=10.0.0.12:8848 \
# -e zlt_datasource_ip=10.0.0.12 \
# -e zlt_datasource_username=root \
# -e zlt_datasource_password=redhat \
# -e spring_redis_host=10.0.0.12 \
# -d buaa-uaa:4.5