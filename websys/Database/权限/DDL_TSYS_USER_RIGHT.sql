create table TSYS_USER_RIGHT
(
  urid         VARCHAR2(32) not null,
  operation_id VARCHAR2(32) not null,
  user_id      VARCHAR2(32) not null,
  creator      VARCHAR2(32) not null,
  create_date  TIMESTAMP(6) not null,
  updator      VARCHAR2(32) not null,
  update_date  TIMESTAMP(6) not null,
  version      NUMBER(10) default 1 not null,
  remark       VARCHAR2(256)
)
;
comment on table TSYS_USER_RIGHT
  is '用户权限表';
comment on column TSYS_USER_RIGHT.urid
  is '用户权限ID';
comment on column TSYS_USER_RIGHT.operation_id
  is '菜单操作ID';
comment on column TSYS_USER_RIGHT.user_id
  is '用户ID';
comment on column TSYS_USER_RIGHT.creator
  is '创建人';
comment on column TSYS_USER_RIGHT.create_date
  is '创建时间';
comment on column TSYS_USER_RIGHT.updator
  is '更新人';
comment on column TSYS_USER_RIGHT.update_date
  is '更新时间';
comment on column TSYS_USER_RIGHT.version
  is '版本号';
comment on column TSYS_USER_RIGHT.remark
  is '备注';
alter table TSYS_USER_RIGHT
  add primary key (URID);