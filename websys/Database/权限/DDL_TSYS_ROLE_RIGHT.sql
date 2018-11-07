create table TSYS_ROLE_RIGHT
(
  urid         VARCHAR2(32) not null,
  operation_id VARCHAR2(32) not null,
  role_id      VARCHAR2(32) not null,
  creator      VARCHAR2(32) not null,
  create_date  TIMESTAMP(6) not null,
  updator      VARCHAR2(32) not null,
  update_date  TIMESTAMP(6) not null,
  version      NUMBER(10) default 1 not null,
  remark       VARCHAR2(256)
)
;
comment on table TSYS_ROLE_RIGHT
  is '角色权限表';
comment on column TSYS_ROLE_RIGHT.urid
  is '角色权限ID';
comment on column TSYS_ROLE_RIGHT.operation_id
  is '菜单操作ID';
comment on column TSYS_ROLE_RIGHT.role_id
  is '角色ID';
comment on column TSYS_ROLE_RIGHT.creator
  is '创建人';
comment on column TSYS_ROLE_RIGHT.create_date
  is '创建时间';
comment on column TSYS_ROLE_RIGHT.updator
  is '更新人';
comment on column TSYS_ROLE_RIGHT.update_date
  is '更新时间';
comment on column TSYS_ROLE_RIGHT.version
  is '版本号';
comment on column TSYS_ROLE_RIGHT.remark
  is '备注';
alter table TSYS_ROLE_RIGHT
  add primary key (URID);