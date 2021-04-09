select user(),database();


select * from employee;
desc employee;
select * from department;
select * from title;

select e.empno, e.empname,t.tname, m.empname  as managerName, m.empno as managerNo, e.salary ,d.deptname, e.hiredate 
  from employee e join title t on e.title = t.tno 
  left join  employee m on e.manager = m.empno 
  join department d on e.dept = d.deptno ;

insert into employee values
	(1004,'개새끼',5,4377,500000,1,'2020-09-09');

update employee 
	set empno = 1006, empname = '병신', title = 3, manager = 1003, salary = 1000000,dno = 1, hiredate ='2021-08-09'
	where empno = 1004;

delete	from employee where empno = 1006;
 alter table employee change column dno dept int(4);


