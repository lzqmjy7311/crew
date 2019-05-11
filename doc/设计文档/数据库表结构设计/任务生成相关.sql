
/* Drop Tables */

DROP TABLE DFLISTRELE;
DROP TABLE DXLOANBAL;
DROP TABLE T_PL_ACC_RISK_FINAL_RANK;
DROP TABLE T_PL_CREDIT_KPI;
DROP TABLE T_PL_CREDIT_RANK;
DROP TABLE T_PL_IOU;
DROP TABLE T_PL_SCORE_A;
DROP TABLE T_PL_SCORE_B;
DROP TABLE T_PL_SCORE_C;
DROP TABLE T_PL_TASK_DEBT_COLLECT;
DROP TABLE T_PL_TASK_ROUTINE_MONI;
DROP TABLE T_PL_TASK_RULE_TRIG;
DROP TABLE T_PL_TASK_SM;
DROP TABLE T_PL_TASK_USAGE;




/* Create Tables */

CREATE TABLE DFLISTRELE
(
	LISTID varchar(30),
	LOANACNO varchar(30),
	PRODID varchar(20),
	BEGINDATE date
);


CREATE TABLE DXLOANBAL
(
	LOANACNO varchar(30) NOT NULL,
	CUSTID varchar(35),
	PRODID varchar(20),
	FIRSTBEGINDATE date,
	PAYOFFFLAG varchar(2),
	ACFLAG varchar(1),
	ACFLAG2 varchar(1),
	PRIMARY KEY (LOANACNO)
);


CREATE TABLE T_PL_ACC_RISK_FINAL_RANK
(
	FD_ACC_ID varchar(30),
	-- 0:非不良
	-- 1:不良
	FD_ACC_STATUS int,
	FD_DIS_DATE date,
	-- 0：未结清
	-- 1：已结清
	FD_SETTLE_FLAG int,
	FD_PRODUCT_CODE varchar(20),
	FD_RISK_RANK int,
	FD_PROCESS_DATE date
);


CREATE TABLE T_PL_CREDIT_KPI
(

);


CREATE TABLE T_PL_CREDIT_RANK
(

);


-- 增量表
CREATE TABLE T_PL_IOU
(
	FD_IOU_ID varchar(32),
	FD_IOU_DIS_DATE date,
	FD_PROCESS_DATE date
);


CREATE TABLE T_PL_SCORE_A
(

);


CREATE TABLE T_PL_SCORE_B
(

);


CREATE TABLE T_PL_SCORE_C
(

);


CREATE TABLE T_PL_TASK_DEBT_COLLECT
(
	FD_ACC_ID varchar(30) NOT NULL,
	-- 0:非不良
	-- 1:不良
	FD_ACC_STATUS int,
	FD_OVER_START_DATE date,
	FD_PRODUCT_CODE varchar(20),
	-- 单位：月
	FD_ACC_AGE int,
	-- 0：其他
	-- 1：低
	-- 2：较低
	-- 3：中
	-- 4：高
	-- 5：极高
	FD_COLLECT_RANK int,
	FD_COLLECT_COUNT int,
	FD_EXP_PAY_DATE date,
	FD_TRIG_DATE date,
	FD_PROCESS_DATE date,
	PRIMARY KEY (FD_ACC_ID)
);


CREATE TABLE T_PL_TASK_ROUTINE_MONI
(
	FD_ACC_ID varchar(30) NOT NULL,
	-- 0:非不良
	-- 1:不良
	FD_ACC_STATUS int,
	FD_DIS_DATE date,
	-- 0：未结清
	-- 1：已结清
	FD_SETTLE_FLAG int,
	FD_PRODUCT_CODE varchar(20),
	FD_RANK_PREV int,
	FD_RANK int,
	-- 单位为：月
	FD_TRIG_RATE double,
	-- 单位为月
	FD_TRIG_RATE_ADJUST double,
	FD_TRIG_DATE_PREV date,
	FD_TRIG_DATE_NEXT date,
	FD_OBSERV_START date,
	FD_PROCESS_DATE date,
	PRIMARY KEY (FD_ACC_ID)
);


CREATE TABLE T_PL_TASK_RULE_TRIG
(
	FD_ACC_ID varchar(30),
	FD_RULE_ID varchar(32),
	FD_RULE_CODE varchar(32),
	FD_RULE_NAME varchar(255),
	FD_RULE_DESC varchar(255),
	FD_RULE_RANK int,
	FD_RULE_TYPE int,
	FD_RULE_FOR int,
	FD_TRIG_DATE date,
	-- 0：系统自动触发
	-- 1：人工触发
	FD_TRIG_TYPE int,
	FD_PROCESS_DATE date
);


CREATE TABLE T_PL_TASK_SM
(
	FD_ACC_ID varchar(30),
	-- 0:非不良
	-- 1:不良
	FD_ACC_STATUS int,
	FD_DIS_DATE date,
	FD_PRODUCT_CODE varchar(20),
	-- 单位为：月
	FD_TRIG_RATE double,
	FD_TRIG_DATE date,
	FD_PROCESS_DATE date
);


CREATE TABLE T_PL_TASK_USAGE
(
	FD_IOU_ID varchar(32) NOT NULL,
	FD_IOU_DIS_DATE date,
	FD_TRIG_DATE_EXPECT date,
	FD_TRIG_DATE date,
	-- 0：未使用完毕
	-- 1：已使用完毕
	FD_USED_FLAG int,
	-- 0：系统自动触发
	-- 1：人工触发
	FD_TASK_TRIG_TYPE int,
	FD_PROCESS_DATE date,
	PRIMARY KEY (FD_IOU_ID)
);



