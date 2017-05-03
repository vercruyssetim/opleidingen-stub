FROM maven:latest

RUN apt-get update          #24/02/2015
RUN apt-get install -y bzip2
RUN apt-get clean

RUN useradd jenkins -p jenkins -m
RUN echo Europe/Brussels > /etc/timezone && dpkg-reconfigure --frontend noninteractive tzdata
RUN mkdir -p /usr/src/opleidingen
WORKDIR /usr/src/opleidingen