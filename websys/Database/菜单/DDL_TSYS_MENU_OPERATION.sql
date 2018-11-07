create table TSYS_MENU_OPERATION
(
  urid        VARCHAR2(32) not null,
  menu_id     VARCHAR2(32) not null,
  code        VARCHAR2(32) not null,
  name        VARCHAR2(64) not null,
  url         VARCHAR2(256) not null,
  creator     VARCHAR2(32) not null,
  create_date TIMESTAMP(6) not null,
  updator     VARCHAR2(32) not null,
  update_date TIMESTAMP(6) not null,
  version     NUMBER(10) default 1 not null,
  remark      VARCHAR2(256),
  active_flag CHAR(1) not null
)
;
COMMIT ;
comment on table TSYS_MENU_OPERATION
  is '菜单操作表';
comment on column TSYS_MENU_OPERATION.urid
  is '菜单操作ID';
comment on column TSYS_MENU_OPERATION.menu_id
  is '菜单ID';
comment on column TSYS_MENU_OPERATION.code
  is '菜单操作代码';
comment on column TSYS_MENU_OPERATION.name
  is '菜单操作名称';
comment on column TSYS_MENU_OPERATION.url
  is '操作请求地址';
comment on column TSYS_MENU_OPERATION.creator
  is '创建人';
comment on column TSYS_MENU_OPERATION.create_date
  is '创建时间';
comment on column TSYS_MENU_OPERATION.updator
  is '更新人';
comment on column TSYS_MENU_OPERATION.update_date
  is '更新时间';
comment on column TSYS_MENU_OPERATION.version
  is '版本号';
comment on column TSYS_MENU_OPERATION.remark
  is '备注';
comment on column TSYS_MENU_OPERATION.active_flag
  is '是否启用：0-否；1-是';
alter table TSYS_MENU_OPERATION
  add primary key (URID);
alter table TSYS_MENU_OPERATION
  add unique (MENU_ID, CODE);
COMMIT ;