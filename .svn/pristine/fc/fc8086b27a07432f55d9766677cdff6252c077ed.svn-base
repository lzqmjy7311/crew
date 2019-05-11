drop table APPLYDTL;

drop table BCTL;

drop table BH_CLEAR;

drop table BH_JOB_INFO;

drop table BH_LOAD_INFO;

drop table BH_PROC;

drop table BH_PROC_LOG;

drop table BH_PROC_STATUS;

drop table BH_PROC_STEP;

drop table BH_SUB_PROC_LOG;

drop table BH_SUB_PROC_STEP;

drop table BH_WARNING_LOG;

drop table BI_NATIONREGION;

drop table BI_TLR_FAVT;

drop table DATA_DIC;

drop table FUNCTION_INFO;

drop table GLOBALINFO;

drop table HOLIDAY;

drop table PASSWORD_HIS;

drop table PF_SYS_PARAM;

drop table ROLE_FUNC_REL;

drop table ROLE_INFO;

drop table SEQCTL;

drop table SYS_CURRENCY;
drop table SYS_CURRRATE;

drop table SYS_TASK_INFO;

drop table SYS_TASK_LOG;

drop table TBL_CRON_TASK_JOB;

drop table TBL_CRON_TASK_JOB_LOG;

drop table TBL_CS_BIZ_LOG;

drop table TBL_CS_FILE_EXPORT_TSK_INF;

drop table TLR_BCTL_REL;

drop table TLR_INFO;

drop table TLR_LOGIN_LOG;

drop table TLR_ROLE_REL;

drop table BI_QUARTZ_JOB_LOG;

drop table FP_PAGE_TYPE;

drop table FP_PAGE_OPT_ITEM;

drop table FP_PAGE_OPT_DETAIL;

drop table FP_PAGE_ITEM;

drop table FP_PAGE_DETAIL;

create table APPLYDTL
(
   ID                   CHAR(32)               not null,
   CONTRACTNO           VARCHAR(20),
   APPNO                VARCHAR(20),
   TXN_DATE             CHAR(8),
   BRCODE               VARCHAR(4),
   TLSRNO               VARCHAR(20),
   AUTO_FLAG            CHAR(1),
   APPROVER             VARCHAR(8),
   AUTO_APPROVER        CHAR(1),
   FUNC_CODE            VARCHAR(10),
   APPTYPE              CHAR(2),
   ATTITUDE             CHAR(1),
   ROLE_ID              INTEGER,
   MEETING_FLAG         CHAR(1),
   MISC                 VARCHAR(256),
   LAST_UPD_TLR         VARCHAR(8),
   LAST_UPD_DATE        CHAR(8),
   LAST_UPD_FUNC        VARCHAR(20),
   CINO                 VARCHAR(32),
   UNTREAD              CHAR(1),
   REASON               VARCHAR(4000),
   primary key (ID)
);

create table BCTL
(
   BRCODE               CHAR(4)                not null,
   BRNO                 VARCHAR(20)            not null,
   BRNAME               VARCHAR(60),
   BRCLASS              CHAR(1),
   BRATTR               CHAR(1),
   BLN_BRANCH_CLASS     CHAR(1),
   BLN_BRANCH_BRCODE    CHAR(4),
   BLN_MANAGE_BRCODE    CHAR(4),
   BLN_UP_BRCODE        CHAR(4),
   TXN_BRCODE           CHAR(4),
   AUTHLVL              CHAR(1),
   LINKMAN              VARCHAR(20),
   TELENO               CHAR(20),
   ADDRESS              VARCHAR(60),
   POSTNO               CHAR(6),
   OTHER_AREA_FLAG      CHAR(1),
   REGIONALISM          CHAR(6),
   FINANCE_CODE         CHAR(14),
   STATUS               CHAR(1),
   MISCFLGS             CHAR(20),
   MISC                 VARCHAR(256),
   LAST_UPD_TLR         VARCHAR(8),
   LAST_UPD_FUNC        VARCHAR(20),
   LAST_UPD_DATE        CHAR(8),
   ST                   CHAR(1),
   IS_LOCK              CHAR(1),
   IS_DEL               CHAR(1),
   primary key (BRCODE)
);

create table BH_CLEAR
(
   TABLE_SEQ            INTEGER                not null,
   TABLE_ENG            VARCHAR(30)            not null,
   TABLE_CHN            VARCHAR(60)            not null,
   CLEAN_INTERVAL       VARCHAR(30)            not null,
   RUNTIME              CHAR(2)                not null,
   DATE_FIELD           VARCHAR(30),
   CLEAR_CONDITION      VARCHAR(200),
   COMMIT_CNT           INTEGER                not null,
   FLAG                 CHAR(1)                not null,
   JOBNO                INTEGER                not null,
   MODE_TYPE            CHAR(1),
   BACKUP_FLAG          CHAR(1)                not null,
   DESC_TX              VARCHAR(1024),
   LAST_UPD_TS          CHAR(17),
   primary key (TABLE_SEQ)
);

create table BH_JOB_INFO
(
   JOBNO                INTEGER                not null,
   PRE_JOBNO            INTEGER,
   PRE_AUTORUN          CHAR(1),
   SYSTEM_TYPE          CHAR(2),
   RUNONLINE            CHAR(2),
   TIMESTAMPS           CHAR(17),
   MISCFLGS             VARCHAR(256),
   MISC                 VARCHAR(256),
   primary key (JOBNO)
);

create table BH_LOAD_INFO
(
   ID                   INTEGER                not null,
   TABLE_NAME           VARCHAR(30)            not null,
   LOAD_TYPE            CHAR(1)                not null,
   LAST_UPD_DT          INTEGER                default 0,
   KEYWORD              VARCHAR(50)            default ' ',
   IS_UPLOAD            CHAR(1)                default '0',
   TABLE_SPACE_NAME     CHAR(30)               default ' ',
   DESCS                VARCHAR(256),
   primary key (ID)
);

create table BH_PROC
(
   BHDATE               CHAR(8)                not null,
   JOBNO                INTEGER                not null,
   STEP                 INTEGER                not null,
   SUB_STEP             INTEGER                not null,
   RESUME_POINT         CHAR(60),
   PROC_VALUE           VARCHAR(1024),
   primary key (BHDATE, JOBNO, STEP, SUB_STEP)
);

create table BH_PROC_LOG
(
   ID                   NUMERIC(6)             not null,
   BHDATE               CHAR(8)                not null,
   JOBNO                INTEGER                not null,
   STEP                 INTEGER                not null,
   SUB_STEP             INTEGER                not null,
   PROCESS_FUNCTION     CHAR(120),
   PROCESSID            INTEGER,
   START_TIME           CHAR(17),
   END_TIME             CHAR(17),
   STATUS               CHAR(1),
   TIMESTAMPS           CHAR(17),
   ERR_MSG              VARCHAR(1024),
   DESC1                VARCHAR(1024),
   DESC2                VARCHAR(1024),
   primary key (ID),
   unique (SUB_STEP, STEP, JOBNO, BHDATE)
);

create table BH_PROC_STATUS
(
   ID                   NUMERIC(6)             not null,
   BHDATE               CHAR(8)                not null,
   JOBNO                INTEGER                not null,
   STEP                 INTEGER                not null,
   SUB_STEP             INTEGER                not null,
   PROCESS_FUNCTION     VARCHAR(120),
   PROCESSID            INTEGER,
   START_TIME           CHAR(17),
   END_TIME             CHAR(17),
   SUB_FLAG             CHAR(1),
   STATUS               CHAR(1),
   BRANCHLIST           VARCHAR(1024),
   DESC1                VARCHAR(1024),
   DESC2                VARCHAR(1024),
   TIMESTAMPS           CHAR(17),
   primary key (ID),
   unique (JOBNO, BHDATE)
);

create table BH_PROC_STEP
(
   ID                   NUMERIC(6)             not null,
   JOBNO                INTEGER                not null,
   STEP                 INTEGER                not null,
   SUB_STEP             INTEGER                not null,
   PROCESS_FUNCTION     CHAR(120)              not null,
   PROCESS_PARAM        VARCHAR(512),
   PROCESS_TLRNO        CHAR(7),
   RUNTIME              CHAR(2),
   SUB_FLAG             CHAR(1),
   MAXPROC              INTEGER,
   TEMP_FLAG            CHAR(1),
   SUSPEND              CHAR(1),
   AUTO                 CHAR(1),
   TIMESTAMPS           CHAR(17),
   DESC0                VARCHAR(128),
   DESC1                VARCHAR(1024),
   DESC2                VARCHAR(1024),
   REPORT_FLAG          VARCHAR(10),
   REPORT_DATA_FLAG     CHAR(1),
   REPEAT_CNT           INTEGER,
   primary key (ID)
);

create table BH_SUB_PROC_LOG
(
   ID                   NUMERIC(6)             not null,
   JOBNO                INTEGER                not null,
   STEP                 INTEGER                not null,
   SUB_STEP             INTEGER                not null,
   FUNC_STEP            INTEGER                not null,
   SUB_PROCE_FUNCTION   CHAR(120),
   BHDATE               CHAR(8)                not null,
   BREAK_POINT          VARCHAR(1024),
   STATUS               CHAR(1),
   primary key (ID)
);

create table BH_SUB_PROC_STEP
(
   ID                   NUMERIC(6)             not null,
   JOBNO                INTEGER                not null,
   STEP                 INTEGER                not null,
   SUB_STEP             INTEGER                not null,
   FUNC_STEP            INTEGER                not null,
   SUB_PROCE_FUNCTION   CHAR(120),
   RUNTIME              CHAR(2),
   primary key (ID)
);

create table BH_WARNING_LOG
(
   ID                   NUMERIC(6)             not null,
   TXDATE               CHAR(8)                not null,
   JOBNO                INTEGER                not null,
   STEP                 INTEGER                not null,
   SUB_STEP             INTEGER                not null,
   CONTRACTNO           CHAR(20),
   PERI                 INTEGER,
   MSG                  VARCHAR(1024),
   LINE                 VARCHAR(1024),
   TIMESTAMPS           CHAR(17),
   primary key (ID)
);

create table BI_NATIONREGION
(
   NATIONREGION_CODE    VARCHAR(10)            not null,
   CHINA_NAME           VARCHAR(128),
   NATIONREGION_NUMBER  VARCHAR(10),
   CHINA_SHORT_NAME     VARCHAR(128),
   ENG_NAME             VARCHAR(128),
   ENG_SHORT_NAME       VARCHAR(128),
   ST                   CHAR(1),
   IS_LOCK              CHAR(1),
   IS_DEL               CHAR(1),
   CRT_DT               CHAR(8),
   LAST_UPD_TMS         VARCHAR(14),
   LAST_UPD_OPER        VARCHAR(20),
   primary key (NATIONREGION_CODE)
);

create table BI_TLR_FAVT
(
   ID                   VARCHAR(32)            not null,
   TLR_NO               VARCHAR(20),
   FUNC_ID              VARCHAR(20),
   SHOW_SEQ             INTEGER,
   FUNC_TYPE            VARCHAR(20),
   primary key (ID)
);

create table DATA_DIC
(
   ID                   VARCHAR(32)            not null,
   DATA_TYPE_NO         INTEGER          not null,
   DATA_NO              VARCHAR(20)            not null,
   DATA_TYPE_NAME       VARCHAR(60),
   DATA_NO_LEN          INTEGER,
   DATA_NAME            VARCHAR(150),
   LIMIT_FLAG           CHAR(1),
   HIGH_LIMIT           VARCHAR(20),
   LOW_LIMIT            VARCHAR(40),
   MISCFLGS             VARCHAR(20),
   primary key (ID)
);

create table FUNCTION_INFO
(
   FUNCID               VARCHAR(20)            not null,
   FUNCNAME             VARCHAR(60),
   PAGEPATH             VARCHAR(250),
   LOCATION             INTEGER,
   ISDIRECTORY          INTEGER,
   LASTDIRECTORY        VARCHAR(20),
   SHOWSEQ              INTEGER,
   FUNC_CLASS           CHAR(1),
   FUNC_TYPE            CHAR(1),
   WORKFLOW_FLAG        CHAR(1),
   UP_FUNC_CODE         CHAR(10),
   FUNC_DESC            VARCHAR(60),
   STATUS               CHAR(1),
   MISCFLGS             CHAR(20),
   MISC                 VARCHAR(1024),
   ICON_CLS             VARCHAR(256),
   primary key (FUNCID)
);

create table GLOBALINFO
(
   ID                   NUMERIC(6)             not null,
   SYSTEM_NAME          VARCHAR(20),
   TBSDY                CHAR(8),
   BHDATE               CHAR(8),
   LBHDATE              CHAR(8),
   STATUS               CHAR(1),
   SYSTEM_TYPE          CHAR(2),
   MISCFLGS             VARCHAR(20),
   primary key (ID)
);

create table HOLIDAY
(
   ID                   CHAR(32)               not null,
   "YEAR"               INTEGER,
   HOLIDAY_DEF          VARCHAR(366),
   LAST_UPD_OPER_ID     VARCHAR(32),
   LAST_UPD_TIME        CHAR(14),
   primary key (ID)
);

create table PASSWORD_HIS
(
   ID                   VARCHAR(32)            not null,
   USERID               VARCHAR(32)            not null,
   PASSWORD             VARCHAR(100)           not null,
   ENC_MODE             VARCHAR(10),
   MODIFIED_TIME        CHAR(14)               not null,
   primary key (ID)
);

create table PF_SYS_PARAM
(
   PARAM_ID             VARCHAR(4)             not null,
   MAGIC_ID             VARCHAR(20)            not null,
   PARAM_START_TM       CHAR(8),
   PARAM_END_TM         CHAR(8),
   PARAM_CHANG_FLAG     CHAR(1),
   PARAM_VALUE_TX       VARCHAR(512),
   LAST_UPD_TLR         CHAR(8),
   LAST_UPD_FUNC        VARCHAR(20),
   LAST_UPD_DATE        CHAR(8),
   DESC0                VARCHAR(256),
   ST                   CHAR(1),
   IS_LOCK              CHAR(1),
   IS_DEL               CHAR(1),
   primary key (PARAM_ID, MAGIC_ID)
);

create table ROLE_FUNC_REL
(
   ID                   CHAR(32)               not null,
   ROLE_ID              INTEGER,
   FUNCID               VARCHAR(20),
   primary key (ID)
);

create table ROLE_INFO
(
   ROLE_ID              INTEGER                not null,
   ROLE_NAME            VARCHAR(30),
   STATUS               CHAR(1),
   EFFECT_DATE          CHAR(8),
   EXPIRE_DATE          CHAR(8),
   BRCLASS              CHAR(1),
   MISCFLGS             CHAR(20),
   MISC                 VARCHAR(256),
   ROLE_TYPE            CHAR(1),
   IS_LOCK              CHAR(1),
   CRT_DT               CHAR(8),
   LAST_UPD_TMS         VARCHAR(14),
   LAST_UPD_OPER        VARCHAR(20),
   ST                   CHAR(1),
   primary key (ROLE_ID)
);

create table SEQCTL
(
   ID                   CHAR(32)               not null,
   VALUE_NO             INTEGER                default 0,
   VALUE_INDEX          VARCHAR(40),
   VALUE_CURR           INTEGER,
   MAX_VALUE            INTEGER,
   MIN_VALUE            INTEGER,
   primary key (ID)
);

CREATE TABLE
    SYS_CURRENCY
    (
        CURCD VARCHAR(6) NOT NULL,
        CNNAME VARCHAR(52),
        ST CHAR(1),
        IS_LOCK CHAR(1),
        IS_DEL CHAR(1),
        CREATE_DATE CHAR(8),
        LAST_UPD_DATE CHAR(8),
        LAST_UPD_TLR VARCHAR(20),
        SHOWSEQ INTEGER,
        ISUSD CHAR(1),
        ENNAME VARCHAR(20),
        CURSYMBOL VARCHAR(20),
        CREATE_TLR VARCHAR(20),
        BASE_UNIT VARCHAR(4),
        MIN_UNIT VARCHAR(4),
        CUR_EDICD CHAR(3),
        CUR_EDINAME VARCHAR(25),
        CURNO VARCHAR(6),
        DRATEDAYS CHAR(1),
        PRIMARY KEY (CURCD)
    );
CREATE TABLE
    SYS_CURRRATE
    (
        ID VARCHAR(32) NOT NULL,
        CURCD CHAR(3) NOT NULL,
        CURRRATE_DATE CHAR(8) NOT NULL,
        LAST_UPD_DATE CHAR(8),
        LAST_UPD_TLR VARCHAR(8),
        TO_CURCD CHAR(3) NOT NULL,
        BUY_RATE NUMERIC(16,3),
        SELL_RATE NUMERIC(16,3),
        EXCHG_RATE NUMERIC(16,3),
        CONSTRAINT PK_SYSCURRRATE PRIMARY KEY (ID)
    );
create table SYS_TASK_INFO
(
   TSK_ID               CHAR(14)               not null,
   INT_OPER_ID          VARCHAR(20),
   INS_CD               VARCHAR(20),
   INT_INS_ID           VARCHAR(10),
   ADT_RCD_PK           VARCHAR(32),
   UPD_TRANS_CD         CHAR(2),
   CRT_DT               CHAR(8),
   LAST_UPD_OPER        VARCHAR(20),
   LAST_UPD_TMS         VARCHAR(14),
   NEW_VAL1             VARCHAR(2048),
   NEW_VAL2             VARCHAR(2048),
   OLD_ST               CHAR(1),
   primary key (TSK_ID)
);

create table SYS_TASK_LOG
(
   TSK_ID               CHAR(14)               not null,
   INT_OPER_ID          VARCHAR(20),
   INS_CD               VARCHAR(20),
   INT_INS_ID           VARCHAR(10),
   ADT_RCD_PK           VARCHAR(32),
   UPD_TRANS_CD         CHAR(2),
   CRT_DT               CHAR(8),
   LAST_UPD_OPER        VARCHAR(20),
   LAST_UPD_TMS         VARCHAR(14),
   NEW_VAL1             VARCHAR(2048),
   NEW_VAL2             VARCHAR(2048),
   APPROVE_RESULT       CHAR(2),
   APPROVE_OPER_ID      VARCHAR(20),
   APPROVE_INS_CD       VARCHAR(20),
   APPROVE_TM           VARCHAR(14),
   APPROVE_REMARK       VARCHAR(256),
   OLD_VAL1             VARCHAR(2048),
   OLD_VAL2             VARCHAR(2048),
   primary key (TSK_ID)
);

create table TBL_CRON_TASK_JOB
(
   ID                   VARCHAR(32)            not null,
   JOBNO                INTEGER                not null,
   PROCESS_FUNCTION     VARCHAR(256)           not null,
   PROCESS_PARAM        VARCHAR(512),
   MAXPROC              INTEGER,
   RUNTIME              CHAR(2),
   DAYS_OF_MONTH        INTEGER,
   REPEAT_TIME          INTEGER,
   REPEAT_CNT           INTEGER,
   START_TIME           CHAR(6),
   END_TIME             CHAR(6),
   LAST_RUN_TIME        CHAR(14),
   DUE_TIME             CHAR(14),
   SUC_FLAG             CHAR(1),
   FAIL_FLAG            CHAR(1),
   AUTO                 CHAR(1),
   LOCK_OWN             VARCHAR(10),
   DESC0                VARCHAR(128),
   DESC1                VARCHAR(1024),
   DESC2                VARCHAR(1024),
   TIMESTAMPS           CHAR(14),
   DUALCONTROL_LOCKSTATUS VARCHAR(1),
   primary key (ID)
);

create table TBL_CRON_TASK_JOB_LOG
(
   ID                   VARCHAR(32)            not null,
   JOBNO                INTEGER                not null,
   SUB_PROCE_FUNCTION   VARCHAR(256)           not null,
   EXCUTE_TIME          CHAR(14),
   EXCUTE_RESULT        CHAR(1),
   EXCUTE_OWN           VARCHAR(10),
   FAIL_FLAG            CHAR(1),
   SUC_FLAG             CHAR(1),
   EXCEPTION_MSG        VARCHAR(512),
   END_EXCUTE_FLAG      CHAR(1),
   primary key (ID)
);

create table TBL_CS_BIZ_LOG
(
   ID                   CHAR(36)               not null,
   LOG_ID               CHAR(36)               not null,
   TXN_DATE             CHAR(8)                not null,
   TXN_START_TIME       CHAR(6)                not null,
   TXN_END_TIME         CHAR(6)                not null,
   TXN_RUN_TIME         INTEGER                not null,
   BRCODE               CHAR(20),
   OPRCODE              CHAR(20),
   IP_ADR               VARCHAR(20),
   FUNCID               VARCHAR(20),
   OPRTXNCD             VARCHAR(100),
   TXN_BIZ_LOG1         VARCHAR(2048),
   TXN_BIZ_LOG2         VARCHAR(2048),
   TXN_STATUS           CHAR(2),
   TXN_FAIL_LOG         VARCHAR(2048),
   primary key (ID)
);

create table TBL_CS_FILE_EXPORT_TSK_INF
(
   TSK_ID               CHAR(36)               not null,
   TSK_NM               VARCHAR(50),
   TSK_START_TMS        CHAR(14),
   TSK_START_OP         VARCHAR(40),
   TSK_DESC             VARCHAR(60),
   TSK_PARAM1           VARCHAR(2048),
   TSK_PARAM2           VARCHAR(2048),
   TSK_OWNER            VARCHAR(40),
   TSK_END_TMS          CHAR(14),
   TSK_RUN_CLASS        CHAR(2),
   EXP_FILE_NM          VARCHAR(128),
   EXP_RCD_NUM          INTEGER,
   EXP_RCD_SUM_NUM      INTEGER,
   EXP_FILE_SIZE        INTEGER,
   TSK_STAT             CHAR(1),
   primary key (TSK_ID)
);


create table TLR_BCTL_REL
(
   ID                   CHAR(32)               not null,
   TLR_NO               VARCHAR(20),
   BR_NO                VARCHAR(20),
   primary key (ID)
);

create table TLR_INFO
(
   TLRNO                VARCHAR(20)            not null,
   TLR_NAME             VARCHAR(30),
   TLR_TYPE             CHAR(1),
   EMAIL                VARCHAR(40),
   BRCODE               CHAR(4),
   PASSWORD             VARCHAR(50),
   STATUS               CHAR(1),
   ROLEID               INTEGER,
   MSRNO                INTEGER,
   FLAG                 CHAR(1),
   LOGIN_IP             VARCHAR(20),
   SESSION_ID           VARCHAR(256),
   CHEK_DPWD_FLG        CHAR(1),
   CREATE_DATE          CHAR(8),
   LASTACCESSTM         CHAR(14),
   LASTLOGOUTTM         CHAR(14),
   LASTPWDCHGTM         CHAR(14),
   LASTFAILEDTM         CHAR(14),
   PSWDERRCNT           INTEGER,
   TOTPSWDERRCNT        INTEGER,
   PSWDERRDATE          CHAR(8),
   PASSWDENC            VARCHAR(10),
   FAILMAXLOGIN         INTEGER,
   PASSWDCHGINTERVAL    INTEGER,
   PASSWDWARNINTERVAL   INTEGER,
   IS_LOCK              CHAR(1),
   LOCK_REASON          VARCHAR(200),
   IS_LOCK_MODIFY       CHAR(1),
   CRT_DT               CHAR(8),
   LAST_UPD_TMS         VARCHAR(14),
   LAST_UPD_OPER        VARCHAR(20),
   ST                   CHAR(1),
   primary key (TLRNO)
);

create table TLR_LOGIN_LOG
(
   LOG_ID               VARCHAR(32)            not null,
   TLR_NO               VARCHAR(20),
   BR_NO                VARCHAR(20),
   LOGIN_SUC_TM         CHAR(14),
   LOGIN_OUT_TM         CHAR(14),
   LOGIN_FAIL_TM        CHAR(14),
   LOGIN_ADDR           VARCHAR(20),
   LOGIN_REMARK         VARCHAR(256),
   SESSION_ID           VARCHAR(256),
   CRT_TM               CHAR(14),
   primary key (LOG_ID)
);

create table TLR_ROLE_REL
(
   ID                   CHAR(32)               not null,
   TLRNO                VARCHAR(20),
   ROLE_ID              INTEGER,
   STATUS               CHAR(1),
   primary key (ID)
);
CREATE TABLE BI_QUARTZ_JOB_LOG
(
    LOG_ID VARCHAR(32) NOT NULL,
    QUARTZ_ID VARCHAR(32),
    EXEC_TM DATE,
    END_TM DATE,
    QUARTZ_NAME VARCHAR(128),
    QUARTZ_RESULT CHAR(2),
    REMARK VARCHAR(1024),
    PRIMARY KEY (LOG_ID)
);

CREATE TABLE FP_PAGE_TYPE 
(
    ID CHAR(32) NOT NULL,
    NAME VARCHAR(256) NOT NULL,
    DESC_INFO VARCHAR(512) NOT NULL,
    TYPE CHAR(1) NOT NULL,
    PARENT CHAR(32) NOT NULL,
    STATUS CHAR(1) NOT NULL,
    LAST_UPD_TLR VARCHAR(20) NULL,
    LAST_UPD_TS VARCHAR(17) NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE FP_PAGE_OPT_ITEM 
(
    ID CHAR(32) NOT NULL,
    NAME VARCHAR(256) NOT NULL,
    DESC_INFO VARCHAR(512) NOT NULL,
    VIEWTYPE CHAR(1) NOT NULL,
    TYPEID CHAR(32) NOT NULL,
    STATUS CHAR(1) NOT NULL,
    LAST_UPD_TLR VARCHAR(20) NULL,
    LAST_UPD_TS VARCHAR(17) NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE FP_PAGE_OPT_DETAIL 
(
    ID CHAR(32) NOT NULL,
    NAME VARCHAR(256) NOT NULL,
    DESC_INFO VARCHAR(512) NOT NULL,
    OPERATION CHAR(1) NOT NULL,
    OPT_CLAZZ VARCHAR(256) NULL,
    OPT_SCRIPT VARCHAR(1024) NULL,
    DEFAULT_CQID VARCHAR(64) NULL,
    PARENT CHAR(32) NOT NULL,
    STATUS CHAR(1) NOT NULL,
    SEQID CHAR(3) NOT NULL,
    LAST_UPD_TLR VARCHAR(20) NULL,
    LAST_UPD_TS VARCHAR(17) NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE FP_PAGE_ITEM 
(
    ID CHAR(32) NOT NULL,
    NAME VARCHAR(256) NOT NULL,
    DESC_INFO VARCHAR(512) NOT NULL,
    TYPEID CHAR(36) NOT NULL,
    VIEWTYPE CHAR(1) NOT NULL,
    DEFAULTNO CHAR(32) NOT NULL,
    OP_ITEM_ID CHAR(32) NULL,
    STATUS CHAR(1) NOT NULL,
    LAST_UPD_TS VARCHAR(17) NULL,
    LAST_UPD_TLR VARCHAR(20) NULL,
    PRIMARY KEY (ID)
);
CREATE TABLE FP_PAGE_DETAIL 
(
    ID CHAR(32) NOT NULL,
    NAME VARCHAR(256) NOT NULL,
    DESC_INFO VARCHAR(512) NOT NULL,
    PAGFE_URL VARCHAR(256) NOT NULL,
    PARAM_LIST VARCHAR(512) NULL,
    PARENT CHAR(32) NOT NULL,
    SEQID CHAR(3) NULL,
    OPT_DETAILS VARCHAR(512) NULL,
    STATUS CHAR(1) NOT NULL,
    LAST_UPD_TLR VARCHAR(20) NULL,
    LAST_UPD_TS VARCHAR(17) NULL,
    PRIMARY KEY (ID)
);

