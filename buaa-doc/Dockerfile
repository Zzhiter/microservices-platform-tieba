FROM mysql:5.7

LABEL MAINTAINER=Andy

COPY sql/*.sql /docker-entrypoint-initdb.d/
# docker run --name buaa-db -v /data/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=test -d buaa-db:mysql-8.0.25