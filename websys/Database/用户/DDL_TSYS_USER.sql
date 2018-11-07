create table TSYS_USER
(
  urid            VARCHAR2(32) not null,
  login_id        VARCHAR2(32) not null,
  password        VARCHAR2(256) not null,
  name            VARCHAR2(32) not null,
  type            VARCHAR2(8) not null,
  user_status     VARCHAR2(8) not null,
  pwd_modify_date TIMESTAMP(6) not null,
  mobile          VARCHAR2(32),
  email           VARCHAR2(256),
  order_no        NUMBER(8),
  creator         VARCHAR2(32) not null,
  create_date     TIMESTAMP(6) not null,
  updator         VARCHAR2(32) not null,
  update_date     TIMESTAMP(6) not null,
  version         NUMBER(10) default 1 not null,
  remark          VARCHAR2(256),
  lock_status     CHAR(1) default '0' not null
)
;
COMMIT ;
comment on table TSYS_USER
  is '用户表';
comment on column TSYS_USER.urid
  is '用户ID';
comment on column TSYS_USER.login_id
  is '登录ID';
comment on column TSYS_USER.password
  is '密码';
comment on column TSYS_USER.name
  is '用户名称';
comment on column TSYS_USER.type
  is '用户类型：1-全局管理员 2-租户管理员 3-普通用户';
comment on column TSYS_USER.user_status
  is '用户状态：0-正常 1-注销 2-禁用 3-锁定';
comment on column TSYS_USER.pwd_modify_date
  is '密码修改时间';
comment on column TSYS_USER.mobile
  is '用户手机号';
comment on column TSYS_USER.email
  is '用户邮箱';
comment on column TSYS_USER.order_no
  is '排序';
comment on column TSYS_USER.creator
  is '创建人';
comment on column TSYS_USER.create_date
  is '创建时间';
comment on column TSYS_USER.updator
  is '更新人';
comment on column TSYS_USER.update_date
  is '更新时间';
comment on column TSYS_USER.version
  is '版本号';
comment on column TSYS_USER.remark
  is '备注';
alter table TSYS_USER
  add primary key (URID);
COMMIT ;