# How To Install GitLab CE on Ubuntu 22.04|20.04|18.04

### Step 1: Update system & install dependencies
```
sudo apt update
sudo apt upgrade -y
sudo apt install -y ca-certificates curl openssh-server tzdata
```
### Step 2: Configure Postfix Send-Only SMTP Server
GitLab should be able to send emails to you on Git activities. Configure Postfix SMTP Server using the guide below:

- Install and configure Postfix as a Send-Only SMTP Server on Ubuntu

### Step 3: Add the GitLab CE Repository
Install dependency packages required:
```
sudo apt update
sudo apt install curl debian-archive-keyring lsb-release ca-certificates apt-transport-https software-properties-common -y
```
Import GitLab repo GPG key
```
gpg_key_url="https://packages.gitlab.com/gitlab/gitlab-ce/gpgkey"
curl -fsSL $gpg_key_url| sudo gpg --dearmor -o /etc/apt/trusted.gpg.d/gitlab.gpg
```
Add repository contents to /etc/apt/sources.list.d/gitlab_gitlab-ce.list file.
```
sudo tee /etc/apt/sources.list.d/gitlab_gitlab-ce.list<<EOF
deb https://packages.gitlab.com/gitlab/gitlab-ce/ubuntu/ focal main
deb-src https://packages.gitlab.com/gitlab/gitlab-ce/ubuntu/ focal main
EOF
```
```
sudo apt update
curl -sS https://packages.gitlab.com/install/repositories/gitlab/gitlab-ce/script.deb.sh | sudo bash
```
```
sudo apt update
sudo apt install gitlab-ce
sudo vim /etc/gitlab/gitlab.rb
     external_url 'http://gitlab.example.com'
sudo gitlab-ctl reconfigure       
```
### Step4 : Access GitLab CE Web Interface
URL http://gitlab.example.com

- cat /etc/gitlab/initial_root_password

-------------
# Now i am going to set SSL
cd /etc/gitlab/ ; openssl genrsa -aes128 -out server.key 2048
openssl rsa -in server.key -out server.key
openssl req -new -days 3650 -key server.key -out server.csr
openssl x509 -in server.csr -out server.crt -req -signkey server.key -days 3650
chmod 400 server.*

sudo vim /etc/gitlab/gitlab.rb
external_url 'https://www.tahlimorg.live'

nginx['enable'] = true
nginx['client_max_body_size'] = '250m'
nginx['redirect_http_to_https'] = true
nginx['ssl_certificate'] = "/etc/gitlab/server.crt"
nginx['ssl_certificate_key'] = "/etc/gitlab/server.key"
nginx['ssl_protocols'] = "TLSv1.2 TLSv1.3"

sudo gitlab-ctl reconfigure

updatedb
locate gitlab.yml
