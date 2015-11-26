FROM ubuntu:latest

RUN apt-get update && apt-get install -y npm curl mosquitto-clients wget mysql-client git build-essential

RUN curl -sL https://deb.nodesource.com/setup_5.x | sudo -E bash -
RUN apt-get install --yes nodejs

RUN npm install web-terminal -g

RUN useradd -d /home/guest -m -s /bin/bash guest
RUN echo 'guest:guest-' | chpasswd

COPY motd /etc/motd
COPY bash_history /.bash_history
RUN chown guest:guest /.bash_history

EXPOSE 3000

USER guest
WORKDIR /home/guest

ENTRYPOINT [ "web-terminal", "--port", "3000" ]
