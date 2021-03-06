drop table if exists CAMEL_MESSAGEPROCESSED;
drop table if exists audit_log;
drop table if exists messages;

-- required by Camel JdbcMessageIdRepository
create table CAMEL_MESSAGEPROCESSED (
    processorName varchar(255),
    messageId varchar(100),
    createdAt timestamp
);

create table audit_log (
    audit_id int primary key,
	message varchar(255) not null
);

create table messages (
    message_id serial primary key,
	  message varchar(255) not null
);

create table PERSON (
	id int primary key, 
	name varchar(255)
);

create table EMPLOYEE (
	id int primary key, 
	name varchar(255)
);

create table Manager (
	id int primary key, 
	name varchar(255)
);

commit;
