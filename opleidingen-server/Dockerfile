FROM maven:latest

RUN apt-get update          #24/02/2015
RUN apt-get install -y bzip2
RUN apt-get clean

RUN groupadd --gid 900 jenkins
RUN adduser --system --gid 900 --uid 989 --shell /bin/bash jenkins

RUN echo Europe/Brussels > /etc/timezone && dpkg-reconfigure --frontend noninteractive tzdata
RUN mkdir -p /usr/src/opleidingen

ARG JSPM_GITHUB_AUTH_TOKEN=local
ENV JSPM_GITHUB_AUTH_TOKEN $JSPM_GITHUB_AUTH_TOKEN
USER jenkins
WORKDIR /usr/src/opleidingen