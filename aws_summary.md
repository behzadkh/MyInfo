==== how to connect to EC2 terminal ====

linux> cd [to path of secured file(private key pair) in *.pem]
linux> chmod 400 MyNewKeyPair.pem
linux> ssh username@ipaddress -i MyNewKeyPair.pem

in EC2 terminal> sudo su
EC2> yum update -y


