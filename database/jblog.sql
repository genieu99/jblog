desc user;
select * from user;
select id, name from user where id = 'yujin0419';
select id, name, password, join_date from user where id = 'yujin0419' and password = password('1234');
insert into user values('yujin0419', '문유진', '1234', '2023-06-18');
delete from user where id = 'yujin0419';

desc blog;
select * from blog;
select id, title, logo from blog;

select * from post;

desc category;
alter table category change desription description varchar(200);
select * from category;
select name, description from category where id = #{id }