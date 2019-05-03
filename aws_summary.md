==== how to connect to EC2 terminal ==== <br/>
<br/>
linux> cd [to path of secured file(private key pair) in *.pem] <br/>
linux> chmod 400 MyNewKeyPair.pem<br/>
linux> ssh username@ipaddress -i MyNewKeyPair.pem <br/>
<br/>
in EC2 terminal> sudo su <br/>
EC2> yum update -y <br/>

=== which service to use ===  <br/>
EC2> aws s3 ls <br/>
EC2> aws configure <br/>
EC2> aws s3 ls <br/>
--- make a bucket --- <br/>
EC2> aws s3 mb s3://acloudguru1234-rk   <br/>
EC2> aws s3 ls <br/>
EC2> echo "hello cloud gurus" > hello.txt <br/>
EC2> ls <br/>
EC2> aws s3 cp hello.txt s3://acloudguru1234-rk <br/>
EC2> aws s3 ls s3://acloudguru1234-rk <br/>
<br/>
<br/>
==== assigned role to EC2 and then <br/>
EC2> cd ~/.aws  <br/>
EC2> ls <br/>
config credentials <br/>
EC2> rm credentials <br/>
EC2> rm config <br/>
EC2> aws s3 ls <br/>
acloudguru1234-rk <br/>
EC2> aws s3 ls s3://acloudguru1234-rk <br/>
EC2> echo "hello cloud gurus2" > hello2.txt <br/>
EC2> aws s3 cp hello2.txt s3://acloudguru1234-rk <br/>
EC2> aws s3 ls s3://acloudguru1234-rk <br/>
hello.txt hello2.txt <br/>


