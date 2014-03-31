drop table T_CONNECTION if exists;

create table T_CONNECTION (ID integer identity primary key, USERNAME varchar(25), USER_AGENT varchar(100), CLIENT_IP varchar(30), CREATION_DATE date);