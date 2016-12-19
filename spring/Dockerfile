FROM maven:latest

ENV HTTP_PROXY 'http://vdabprdproxy.vdab.be:8080'
ENV http_proxy 'http://vdabprdproxy.vdab.be:8080'
ENV HTTPS_PROXY 'http://vdabprdproxy.vdab.be:8080'
ENV https_proxy 'http://vdabprdproxy.vdab.be:8080'

RUN apt-get update          #24/02/2015
RUN apt-get install -y bzip2
RUN apt-get clean

RUN useradd jenkins -p jenkins -m
RUN echo Europe/Brussels > /etc/timezone && dpkg-reconfigure --frontend noninteractive tzdata
RUN mkdir -p /usr/src/ai-server
WORKDIR /usr/src/ai-server