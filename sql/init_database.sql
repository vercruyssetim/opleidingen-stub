create database skeleton;
use skeleton;

create user 'skeleton' identified by 'skeleton';
grant CREATE, ALTER, SELECT, INSERT, UPDATE on *.* to 'skeleton';

create user 'readonly' identified by 'readonly';
grant SELECT on *.* to 'readonly';

create user 'migration' identified by 'migration';
grant CREATE, ALTER, INDEX, SELECT, INSERT, UPDATE, REFERENCES, DROP on *.* to 'migration';

flush privileges;