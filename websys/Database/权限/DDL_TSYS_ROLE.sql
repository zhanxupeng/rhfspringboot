create table TSYS_ROLE
(
  urid        VARCHAR2(32) not null,
  code        VARCHAR2(32) not null,
  name        VARCHAR2(64) not null,
  order_no    NUMBER(8),
  type        CHAR(1) not null,
  creator     VARCHAR2(32) not null,
  create_date TIMESTAMP(6) not null,
  updator     VARCHAR2(32) not null,
  update_date TIMESTAMP(6) not null,
  version     NUMBER(10) default 1 not null,
  remark      VARCHAR2(256)
)
;
comment on table TSYS_ROLE
  is '角色表';
comment on column TSYS_ROLE.urid
  is '角色ID';
comment on column TSYS_ROLE.code
  is '角色代码';
comment on column TSYS_ROLE.name
  is '角色名称';
comment on column TSYS_ROLE.order_no
  is '排序';
comment on column TSYS_ROLE.type
  is '角色类型：1-全局管理员2-租户管理员3-普通用户';
comment on column TSYS_ROLE.creator
  is '创建人';
comment on column TSYS_ROLE.create_date
  is '创建时间';
comment on column TSYS_ROLE.updator
  is '更新人';
comment on column TSYS_ROLE.update_date
  is '更新时间';
comment on column TSYS_ROLE.version
  is '版本号';
comment on column TSYS_ROLE.remark
  is '备注';
alter table TSYS_ROLE
  add primary key (URID);