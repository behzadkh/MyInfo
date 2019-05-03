==== how to connect to EC2 terminal ====

linux> cd [to path of secured file(private key pair) in *.pem]
linux> chmod 400 MyNewKeyPair.pem
linux> ssh username@ipaddress -i MyNewKeyPair.pem

in EC2 terminal> sudo su
EC2> yum update -y

=== which service to use === 
EC2> aws s3 ls
EC2> aws configure
EC2> aws s3 ls
--- make a bucket ---
EC2> aws s3 mb s3://acloudguru1234-rk   
EC2> aws s3 ls
EC2> echo "hello cloud gurus" > hello.txt
EC2> ls
EC2> aws s3 cp hello.txt s3://acloudguru1234-rk
EC2> aws s3 ls s3://acloudguru1234-rk


==== assigned role to EC2 and then 
EC2> cd ~/.aws
EC2> ls
config credentials
EC2> rm credentials
EC2> rm config
EC2> aws s3 ls
acloudguru1234-rk
EC2> aws s3 ls s3://acloudguru1234-rk
EC2> echo "hello cloud gurus2" > hello2.txt
EC2> aws s3 cp hello2.txt s3://acloudguru1234-rk
EC2> aws s3 ls s3://acloudguru1234-rk
hello.txt hello2.txt


