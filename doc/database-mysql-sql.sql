/**
  the database structure
 */


/**
 the user role table
 */
CREATE TABLE `tbRole` (

`roleId` BIGINT  AUTO_INCREMENT COMMENT '角色Id',
`name` VARCHAR (16) CHARACTER SET utf8 DEFAULT NULL COMMENT '角色名称',
`authority` VARCHAR (9) CHARACTER SET utf8 DEFAULT 'rwx------' COMMENT '权限 参考于linux 为 属主-好友-其他',
`createDate` DATETIME DEFAULT NULL,
`delFlag` BOOLEAN DEFAULT FALSE ,
 PRIMARY KEY (`roleId`)

);


/**
 the school info table
   */
CREATE TABLE `tbSchlInfo`(

  `schlId` BIGINT AUTO_INCREMENT COMMENT '学校信息 Id',
  `schlName` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '学校名称',
  `schlLocation` VARCHAR(2048) DEFAULT NULL COMMENT '学校地址 JSON 数据格式',

  PRIMARY KEY (`schlId`)

);
/**
schlLocation JSON:

{
  "province"："String",
  "city":"String",
  "cityArea":"String",
  "schlArea":"String"
}


 */


/**
 the user table
 */
 CREATE TABLE `tbUser` (

 `userId` VARCHAR (13) CHARACTER SET utf8 NOT NULL  COMMENT '主键 用户Id 以电话号码注册',
 `roleId` BIGINT DEFAULT NULL COMMENT '外键 用户角色Id',
 `schlId` BIGINT DEFAULT NULL COMMENT '外键 学校Id',
 `realName` VARCHAR (16) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户真实姓名',
 `nickName` VARCHAR (16) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户昵称',
 `sex`  ENUM('F', 'M', 'S') CHARACTER SET utf8 DEFAULT 'S' COMMENT '用户性别 F 男 M 女 S 保密',
 `birthday` DATE DEFAULT NULL COMMENT '出生日期',
 `email` VARCHAR (64) CHARACTER SET utf8 DEFAULT NULL COMMENT '电子邮件',
 `registerDate` DATETIME DEFAULT NULL COMMENT '注册时间',
 `password` VARCHAR (64) CHARACTER SET utf8 DEFAULT NULL COMMENT '登录密码',

 PRIMARY KEY (`userId`),
 FOREIGN KEY (`roleId`) REFERENCES tbRole(`roleId`),
 FOREIGN KEY (`schlId`) REFERENCES tbCllgInfo(`schlId`)

 );




/**
 the college info
 */

CREATE TABLE `tbCllgInfo`(

 `cllgId` BIGINT AUTO_INCREMENT COMMENT '主键 学院Id',
 `userId` VARCHAR(13) CHARACTER SET  utf8 NOT NULL COMMENT '外键 用户Id' ,
 `cllgName` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '学院名称',
 `clssName` VARCHAR(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '班级名称',
  `delFlag` BOOLEAN DEFAULT FALSE,

  PRIMARY KEY (`cllgId`),
  FOREIGN KEY (`userId`) REFERENCES tbUser(`userId`)

);


/**
 the courses table
 */

CREATE TABLE `tbCrsInfo`(
 `crsId` BIGINT AUTO_INCREMENT COMMENT '课程Id',
 `userId` VARCHAR(13) CHARACTER SET utf8 NOT NULL COMMENT '外键 用户Id' ,
 `crsName` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '课程名称',
 `crsLocation` VARCHAR(1024) CHARACTER SET utf8 DEFAULT NULL COMMENT '课程上课地点',
 `crsTchrName` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '上课老师名字',
 `crsWeek` INT COMMENT '上课时间的周 0 1 2 3 4 5 6 代表 周日到周六',
 `crsTime` VARCHAR(16) COMMENT '上课的时间段',

 PRIMARY KEY (`crsId`),
 FOREIGN KEY (`userId`) REFERENCES tbUser(`userId`)

);



/**
 the job message table
 */

CREATE TABLE `tbMsgJob`(

  `msgId` BIGINT AUTO_INCREMENT COMMENT '工作消息Id',
  `creatorId` VARCHAR(13) CHARACTER SET utf8 NOT NULL COMMENT '创建人Id',
  `crsId` BIGINT DEFAULT -1 COMMENT '课程表里的课 若不是课程表里的课 此字段须为空 NULL',
  `crsDefName` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '自定义上课的课程名称',
  `crsDefLocation` VARCHAR(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '自定义上课的地点',
  `crsDatetime` DATETIME DEFAULT NULL COMMENT '上课的时间',
  `jobName` VARCHAR(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '兼职名称',
  `jobLocation` VARCHAR(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '兼职地点',
  `jobDescribe` VARCHAR(2048) CHARACTER SET utf8 DEFAULT NULL COMMENT '兼职简介',
  `jobSDate` DATETIME DEFAULT NULL COMMENT '兼职开始时间',
  `jobEDate` DATETIME DEFAULT NULL COMMENT '兼职结束时间',
  `credit` INT DEFAULT 0 COMMENT '学分',
  `msgType` INT DEFAULT -1 COMMENT '任务类型',
  `geterSex` ENUM('F','M','S') CHARACTER SET utf8 DEFAULT 'S' COMMENT '任务领取者的性别要求 为 S 时男女皆可领取',
  `msgStatus` ENUM('WAITING','RUNNING','FINISHED','CLOSED') CHARACTER SET utf8 DEFAULT 'WAITING' COMMENT '消息状态 等待中 进行中 已完成 已关闭',
  `isGeter` BOOLEAN DEFAULT FALSE COMMENT '消息领取状态 false 未领取 true 已领取',
  `createDate` DATETIME DEFAULT NULL COMMENT '工作消息创建时间',
  `getDate` DATETIME DEFAULT NULL COMMENT '工作消息领取时间',
  `isValid` BOOLEAN DEFAULT TRUE COMMENT '消息有效性',

  PRIMARY KEY (`msgId`),
  FOREIGN KEY (`creatorId`) REFERENCES tbUser(`userId`),
  FOREIGN KEY (`crsId`) REFERENCES tbCrsInfo(`crsId`)

);


/**
 the message task table
 */

CREATE TABLE `tbMsgTask`(

  `mtId` BIGINT AUTO_INCREMENT COMMENT '消息任务Id',
  `msgId` BIGINT NOT NULL COMMENT '任务Id',
  `creatorId` VARCHAR(13) CHARACTER SET utf8 NOT NULL COMMENT '发布任务者',
  `geterId` VARCHAR(13) CHARACTER SET utf8 NOT NULL COMMENT '领取任务者',
  `isGeterFinish` BOOLEAN DEFAULT FALSE COMMENT '任务执行者确认',
  `isCreatorConfirm` BOOLEAN DEFAULT FALSE COMMENT '任务发布者确认',
  `mtStatus` ENUM('RUNNING','FINISHED','CLOSED','OTHERS') CHARACTER SET utf8 DEFAULT 'RUNNING' COMMENT '任务状态',
  `isValid` BOOLEAN DEFAULT TRUE COMMENT '任务有效性',
  `createDate` DATETIME DEFAULT NULL COMMENT '任务生成时间',
  `finishDate` DATETIME DEFAULT NULL COMMENT '行者确认时间',
  `confirmDate` DATETIME DEFAULT NULL COMMENT '发布者确认时间',

  PRIMARY KEY (`mtId`),
  FOREIGN KEY (`creatorId`) REFERENCES tbMsgJob(`creatorId`),
  FOREIGN KEY (`geterId`) REFERENCES tbUser(`userId`)

);



/**
 the credit table
 */

CREATE TABLE `tbCrdt`(
  `crdtId` BIGINT AUTO_INCREMENT COMMENT '学分表Id',
  `userId` VARCHAR(13) CHARACTER SET utf8 COMMENT '用户Id',
  `credit` INT DEFAULT 0 COMMENT '总学分',
  `frozen` INT DEFAULT 0 COMMENT '冻结学分',
  `useable` INT DEFAULT 0 COMMENT '可用学分',
  `describe` VARCHAR(2048) CHARACTER SET utf8 COMMENT '描述信息',

  PRIMARY KEY (`crdtId`, `userId`),
  FOREIGN KEY (`userId`) REFERENCES tbUser(`userId`)
);


/**
 the credit logs table
 */
CREATE TABLE `tbCrdtLog`(

  `logId` BIGINT AUTO_INCREMENT COMMENT '主键',
  `userId` VARCHAR(13) CHARACTER SET utf8 NOT NULL COMMENT '用户id',
  `credit` INT DEFAULT 0,
  `direction` ENUM('CHARGE','GAINS','COSTS','UNDEFINE') CHARACTER SET utf8 DEFAULT 'UNDEFINE',
  `describe` VARCHAR(2048) CHARACTER SET utf8 COMMENT '描述',

  PRIMARY KEY (`logId`),
  FOREIGN KEY (`userId`) REFERENCES tbUser(`userId`)

);





/**
 the expense(消费) table
 */

CREATE TABLE `tbExpns` (

  `expnsId` BIGINT AUTO_INCREMENT COMMENT '主键 消费Id',
  `userId` VARCHAR(13) CHARACTER SET  utf8 NOT NULL COMMENT '用户Id',
  `msgId` BIGINT NOT NULL COMMENT '消息Id',
  `time` DATETIME DEFAULT NULL COMMENT '消费生成时间',
  `status` ENUM('SUCCESS', 'FAILED') CHARACTER SET utf8 DEFAULT NULL COMMENT '消费状态',

  PRIMARY KEY (`expnsId`),
  FOREIGN KEY (`userId`) REFERENCES tbMsgTask(`creatorId`),
  FOREIGN KEY (`msgId`) REFERENCES tbMsgTask(`msgId`)

);


/**
 the pay table
 */

CREATE TABLE `tbPay`(

  `payId` BIGINT AUTO_INCREMENT,
  `goodsId` VARCHAR(64) CHARACTER SET utf8 NOT NULL ,
  `userId` VARCHAR(13) CHARACTER SET utf8 NOT NULL ,
  `credit` INT,
  `money` FLOAT(5,2),
  `status`ENUM('SUCCESS','FAILED','CLOSED','UNDEFINE') CHARACTER SET utf8 DEFAULT 'UNDEFINE',
  `createDate` DATETIME DEFAULT NULL,
  `delFlag` BOOLEAN DEFAULT FALSE,

  PRIMARY KEY (`payId`),
  FOREIGN KEY (`userId`) REFERENCES tbUser(`userId`)
);