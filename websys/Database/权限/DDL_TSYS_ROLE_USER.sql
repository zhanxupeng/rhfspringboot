create table TSYS_ROLE_USER
(
  urid        VARCHAR2(32) not null,
  user_id     VARCHAR2(32) not null,
  role_id     VARCHAR2(32) not null,
  creator     VARCHAR2(32) not null,
  create_date TIMESTAMP(6) not null,
  updator     VARCHAR2(32) not null,
  update_date TIMESTAMP(6) not null,
  version     NUMBER(10) default 1 not null,
  remark      VARCHAR2(256)
)
;
COMMIT ;
comment on table TSYS_ROLE_USER
  is '用户角色表';
comment on column TSYS_ROLE_USER.urid
  is '用户角色ID';
comment on column TSYS_ROLE_USER.user_id
  is '用户ID';
comment on column TSYS_ROLE_USER.role_id
  is '角色ID';
comment on column TSYS_ROLE_USER.creator
  is '创建人';
comment on column TSYS_ROLE_USER.create_date
  is '创建时间';
comment on column TSYS_ROLE_USER.updator
  is '更新人';
comment on column TSYS_ROLE_USER.update_date
  is '更新时间';
comment on column TSYS_ROLE_USER.version
  is '版本号';
comment on column TSYS_ROLE_USER.remark
  is '备注';
alter table TSYS_ROLE_USER
  add primary key (URID);
COMMIT ;