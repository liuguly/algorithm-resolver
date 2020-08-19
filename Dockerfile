FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER lx_java@foxmail.com

RUN mkdir -p /home/liuxin/app/

WORKDIR /home/liuxin

EXPOSE 8014

ADD ./target/algorithm.jar ./app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]

CMD ["--spring.profiles.active=test"]
