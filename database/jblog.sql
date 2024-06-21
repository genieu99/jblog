-- user
desc user;
select * from user;
select id, name from user where id = 'yujin0419';
select id, name, password, join_date from user where id = 'yujin0419' and password = password('1234');
insert into user values('yujin0419', '문유진', '1234', '2023-06-18');
delete from user where id = 'newyork';

-- blog
desc blog;
select * from blog;
select id, title, logo from blog;
delete from blog where id = 'newyork';

-- category
desc category;
select * from category;
alter table category change desription description varchar(200);
select name, description from category where id = 'yujin0419';
insert into category values(null, '루돌프', '루돌프 사슴코는 개코', current_date(), 'yujin0419');
delete from category where id = 'newyork';

-- post
desc post;
select * from post;
select no from category where id = 'poscodx' and name = "미분류";
delete from post where no = 6;
insert into post values(null, '산타할아버지', '산타할아버지는 진짜 굴뚝으로 들어오나요?', current_date(), 3);
insert into post values(null, '넌센스!', '할아버지랑 같이 산에 갔다가 불이 나면?', current_date(), 3);
insert into post values(null, '진짠가??', '루돌프 코는 진짜 빛나요?', current_date(), 4);
select post.no, title, contents, post.reg_date from post left join category on post.category_no = category.no where category.id = 'yujin0419' and post.no = 2;

	-- getPostListByCategory
select post.no as no, title, contents, post.reg_date as regDate, category_no as categoryNo from post
left join category on post.category_no = category.no
where category.id = 'yujin0419' and category.no = 4
order by no desc;


select no, name, description, ifnull(count_post.count, 0) as count
from category left join (select count(*) as count, category_no from post group by category_no) count_post on count_post.category_no = category.no
where id = 'yujin0419' order by no desc;

select post.no, title, contents, post.reg_date as regDate from post
left join category on post.category_no = category.no
where category.id = 'yujin0419' and post.category_no = 3
order by no desc
limit 1;

select post.no, title, contents, post.reg_date as regDate from post
left join category on post.category_no = category.no
where category.id = 'yujin0419' and post.no = 3;