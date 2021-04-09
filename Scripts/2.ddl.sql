-- 부서
CREATE TABLE Department (
	deptNo int(4) NOT null, -- 부서번호,
	deptName VARCHAR(20) null, -- 부서명,
	floor int(4) NULL -- 위치
);

-- 부서
ALTER TABLE Department
	ADD CONSTRAINT PK_Department -- 부서 기본키
	PRIMARY KEY (
		deptNo -- 부서번호
	);

-- 사원
CREATE TABLE Employee (
	empno int(8) NOT null, -- 사원번호,
	empname VARCHAR(20) NOT null, -- 사원명,
	title int(4) null, -- 직책,
	manager int(8) null, -- 직속상사,
	salary int(8) null, -- 급여,
	dno int(4) null, -- 부서,
	hiredate DATE NULL -- 입사일
);

-- 사원
ALTER TABLE Employee
	ADD CONSTRAINT PK_Employee -- 사원 기본키
	PRIMARY KEY (
		empno -- 사원번호
	);

-- 직책
CREATE TABLE Title (
	tNo int(4) NOT null, -- 직책번호,
	tName VARCHAR(10) NULL -- 직책명
);

-- 직책
ALTER TABLE Title
	ADD CONSTRAINT PK_Title -- 직책 기본키
	PRIMARY KEY (
		tNo -- 직책번호
	);

-- 사원
ALTER TABLE Employee
	ADD CONSTRAINT FK_Title_TO_Employee -- 직책 -> 사원
	FOREIGN KEY (
		title -- 직책
	)
	REFERENCES Title ( -- 직책
		tNo -- 직책번호
	);

-- 사원
ALTER TABLE Employee
	ADD CONSTRAINT FK_Employee_TO_Employee -- 사원 -> 사원
	FOREIGN KEY (
		manager -- 직속상사
	)
	REFERENCES Employee ( -- 사원
		empno -- 사원번호
	);

-- 사원
ALTER TABLE Employee
	ADD CONSTRAINT FK_Department_TO_Employee -- 부서 -> 사원
	FOREIGN KEY (
		dno -- 부서
	)
	REFERENCES Department ( -- 부서
		deptNo -- 부서번호
	);

create database erp_jsp_exam;

use erp_jsp_exam;

	
/*사원
ALTER TABLE "Employee"
	DROP FOREIGN KEY "FK_Title_TO_Employee"; -- 직책 -> 사원

사원
ALTER TABLE "Employee"
	DROP FOREIGN KEY "FK_Employee_TO_Employee"; -- 사원 -> 사원

사원
ALTER TABLE "Employee"
	DROP FOREIGN KEY "FK_Department_TO_Employee"; -- 부서 -> 사원
	
	
부서
ALTER TABLE "Department"
	DROP PRIMARY KEY; -- 부서 기본키

사원
ALTER TABLE "Employee"
	DROP PRIMARY KEY; -- 사원 기본키

직책
ALTER TABLE "Title"
	DROP PRIMARY KEY; -- 직책 기본키
	
부서
DROP TABLE IF EXISTS "Department";

DELETE FROM _cub_schema_comments WHERE table_name = 'Department';

사원
DROP TABLE IF EXISTS "Employee";

DELETE FROM _cub_schema_comments WHERE table_name = 'Employee';

직책
DROP TABLE IF EXISTS "Title";

DELETE FROM _cub_schema_comments WHERE table_name = 'Title';*/