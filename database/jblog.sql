desc user;
select * from user;
select id, name from user where id = 'yujin0419';
select id, name, password, join_date from user where id = 'yujin0419' and password = password('1234');
insert into user values('yujin0419', '문유진', '1234', '2023-06-18');
delete from user where id = 'michole';

select * from blog;
select id, title, logo from blog;