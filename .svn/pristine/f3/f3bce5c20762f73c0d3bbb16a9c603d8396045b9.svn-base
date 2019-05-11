SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS T_PL_ACC_RISK_RANK;
DROP TABLE IF EXISTS T_PL_TASK_ROUTINE_MONI;

/* Create Tables */

CREATE TABLE T_PL_ACC_RISK_RANK
(
	FD_ACC_ID varchar(32),
	FD_ACC_STATUS int,
	FD_DIS_DATE date,
	-- 0：未结清
	-- 1：已结清
	FD_SETTLE_FLAG int COMMENT '0：未结清
1：已结清',
	FD_PRODUCT_TYPE int,
	FD_RISK_RANK int,
	FD_PROCESS_DATE date
);


CREATE TABLE T_PL_TASK_ROUTINE_MONI
(
	FD_ACC_ID varchar(32) NOT NULL,
	FD_ACC_STATUS int,
	FD_DIS_DATE date,
	-- 0：未结清
	-- 1：已结清
	FD_SETTLE_FLAG int COMMENT '0：未结清
1：已结清',
	FD_PRODUCT_TYPE int,
	FD_RANK_PREV int,
	FD_RANK int,
	-- 单位为：月
	FD_TRIG_RATE double COMMENT '单位为：月',
	-- 单位为月
	FD_TRIG_RATE_ADJUST double COMMENT '单位为月',
	FD_TRIG_DATE_PREV date,
	FD_TRIG_DATE_NEXT date,
	FD_OBSERV_START date,
	FD_PROCESS_DATE date,
	PRIMARY KEY (FD_ACC_ID)
);



