FROM ubuntu:latest

ENV NODE_VERSION 0.10.40
ENV NPM_VERSION 2.14.1

RUN apt-get update && apt-get install -y npm curl mosquitto-clients wget mysql-client git

# verify gpg and sha256: http://nodejs.org/dist/v0.10.31/SHASUMS256.txt.asc
# gpg: aka "Timothy J Fontaine (Work) <tj.fontaine@joyent.com>"
# gpg: aka "Julien Gilli <jgilli@fastmail.fm>"
RUN set -ex \
	&& for key in \
		7937DFD2AB06298B2293C3187D33FF9D0246406D \
		114F43EE0176B71C7BC219DD50A3051F888C628D \
	; do \
		gpg --keyserver ha.pool.sks-keyservers.net --recv-keys "$key"; \
	done

RUN curl -SLO "https://nodejs.org/dist/v$NODE_VERSION/node-v$NODE_VERSION-linux-x64.tar.gz" \
	&& curl -SLO "https://nodejs.org/dist/v$NODE_VERSION/SHASUMS256.txt.asc" \
	&& gpg --verify SHASUMS256.txt.asc \
	&& grep " node-v$NODE_VERSION-linux-x64.tar.gz\$" SHASUMS256.txt.asc | sha256sum -c - \
	&& tar -xzf "node-v$NODE_VERSION-linux-x64.tar.gz" -C /usr/local --strip-components=1 \
	&& rm "node-v$NODE_VERSION-linux-x64.tar.gz" SHASUMS256.txt.asc \
	&& npm install -g npm@"$NPM_VERSION" \
	&& npm cache clear

# Installation Wetty
WORKDIR /app
RUN git clone --depth 1 https://github.com/krishnasrinivas/wetty.git
WORKDIR /app/wetty
RUN npm install

RUN useradd -d /home/guest -m -s /bin/bash guest
RUN echo 'guest:guest-' | chpasswd

COPY motd /etc/motd
COPY bash_history /home/guest/.bash_history
RUN chown guest:guest /home/guest/.bash_history

EXPOSE 3000

ENTRYPOINT [ "node", "app.js", "-p", "3000" ]
