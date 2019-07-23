-- Create table 部门表
create table sys_department
(
  id                  NUMBER not null,
  deptname              VARCHAR2(255)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table sys_department
  is '部门表';
-- Add comments to the columns
comment on column sys_department.id
  is 'id';
comment on column sys_department.deptname
  is '部门名称';
-- Create/Recreate primary, unique and foreign key constraints
alter table sys_department
  add constraint sys_departmentID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create sequence SEQ_sys_department_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

-- Create table 用户表
create table sys_user
(
  id                  NUMBER not null,
  username              VARCHAR2(255),
  password              VARCHAR2(255),
  duty              VARCHAR2(255),
  deptId              VARCHAR2(255)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table sys_user
  is '用户表';
-- Add comments to the columns
comment on column sys_user.id
  is 'id';
comment on column sys_user.username
  is '用户名';
comment on column sys_user.password
  is '密码';
comment on column sys_user.duty
  is '职务';
comment on column sys_user.deptId
  is '部门id';
-- Create/Recreate primary, unique and foreign key constraints
alter table sys_user
  add constraint sys_userID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create sequence SEQ_sys_user_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;


-- Create table 用户详情表
create table sys_userdetails
(
  id                  NUMBER not null,
  userId              VARCHAR2(255),
  allname              VARCHAR2(255),
  telephone              VARCHAR2(255)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table sys_userdetails
  is '用户详情表';
-- Add comments to the columns
comment on column sys_userdetails.id
  is 'id';
comment on column sys_userdetails.userId
  is '用户id';
comment on column sys_userdetails.allname
  is '姓名';
comment on column sys_userdetails.telephone
  is '手机号';
-- Create/Recreate primary, unique and foreign key constraints
alter table sys_userdetails
  add constraint sys_userdetailsID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create sequence SEQ_sys_userdetails_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

-- Create table 流程表
create table workflow
(
  id                  NUMBER not null,
  workflow_name              VARCHAR2(255),
  workflow_desc              VARCHAR2(255)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table workflow
  is '流程表';
-- Add comments to the columns
comment on column workflow.id
  is 'id';
comment on column workflow.workflow_name
  is '流程名称';
comment on column workflow.workflow_desc
  is '流程描述';
-- Create/Recreate primary, unique and foreign key constraints
alter table workflow
  add constraint workflowID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create sequence SEQ_workflow_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

-- Create table 流程节点表
create table workflow_node
(
  id                  NUMBER not null,
  deptId              VARCHAR2(255),
  workflow_order              VARCHAR2(255)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table workflow_node
  is '流程节点表';
-- Add comments to the columns
comment on column workflow_node.id
  is 'id';
comment on column workflow_node.deptId
  is '部门id';
comment on column workflow_node.workflow_order
  is '流程顺序';
-- Create/Recreate primary, unique and foreign key constraints
alter table workflow_node
  add constraint workflow_nodeID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create sequence SEQ_workflow_node_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

-- Create table 流程业务表
create table workflow_business
(
  id                  NUMBER not null,
  userId              VARCHAR2(255),
  nodes              VARCHAR2(255),
  steps              VARCHAR2(255),
  cjsj              TIMESTAMP(6)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table
comment on table workflow_business
  is '流程业务表';
-- Add comments to the columns
comment on column workflow_business.id
  is 'id';
comment on column workflow_business.userId
  is '用户id';
comment on column workflow_business.nodes
  is '节点组成';
comment on column workflow_business.steps
  is '所在步骤';
comment on column workflow_business.cjsj
  is '采集时间';
-- Create/Recreate primary, unique and foreign key constraints
alter table workflow_business
  add constraint workflow_businessID primary key (ID)
  using index
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create sequence SEQ_workflow_business_ID
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

alter table workflow add (cjsj TIMESTAMP(6));
comment on column workflow.cjsj is '采集时间';

alter table sys_department add (cjsj TIMESTAMP(6));
comment on column sys_department.cjsj is '采集时间';

alter table sys_user add (cjsj TIMESTAMP(6));
comment on column sys_user.cjsj is '采集时间';

alter table sys_userdetails add (cjsj TIMESTAMP(6));
comment on column sys_userdetails.cjsj is '采集时间';

alter table workflow_node add (workflowId VARCHAR2(255),cjsj TIMESTAMP(6));
comment on column workflow_node.workflowId is '流程id';
comment on column workflow_node.cjsj is '采集时间';

alter table workflow_business add (cjsj TIMESTAMP(6));
comment on column workflow_business.cjsj is '采集时间';

