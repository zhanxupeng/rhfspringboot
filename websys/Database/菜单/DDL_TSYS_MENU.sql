create table TSYS_MENU
(
  urid        VARCHAR2(32) not null,
  code        VARCHAR2(32) not null,
  name        VARCHAR2(32) not null,
  icon        VARCHAR2(256),
  url         VARCHAR2(256) not null,
  active_flag CHAR(1) default 1 not null,
  parent_id   VARCHAR2(32),
  index_path  VARCHAR2(256) not null,
  order_no    NUMBER(8),
  creator     VARCHAR2(32) not null,
  create_date TIMESTAMP(6) not null,
  updator     VARCHAR2(32) not null,
  update_date TIMESTAMP(6) not null,
  version     NUMBER(10) default 1 not null,
  remark      VARCHAR2(256),
  show_flag   CHAR(1) default 1 not null
)
;
COMMIT ;
comment on table TSYS_MENU
  is '系统菜单表';
comment on column TSYS_MENU.urid
  is '菜单ID';
comment on column TSYS_MENU.code
  is '菜单编码';
comment on column TSYS_MENU.name
  is '菜单名称';
comment on column TSYS_MENU.icon
  is '菜单图标';
comment on column TSYS_MENU.url
  is '菜单请求地址';
comment on column TSYS_MENU.active_flag
  is '是否启用：0-否，1-是';
comment on column TSYS_MENU.parent_id
  is '上级菜单ID';
comment on column TSYS_MENU.index_path
  is '菜单索引路径';
comment on column TSYS_MENU.order_no
  is '排序';
comment on column TSYS_MENU.creator
  is '创建人';
comment on column TSYS_MENU.create_date
  is '创建时间';
comment on column TSYS_MENU.updator
  is '更新人';
comment on column TSYS_MENU.update_date
  is '更新时间';
comment on column TSYS_MENU.version
  is '版本号';
comment on column TSYS_MENU.remark
  is '备注';
comment on column TSYS_MENU.show_flag
  is '是否在菜单树展示：0-否，1-是';
alter table TSYS_MENU
  add primary key (URID);
alter table TSYS_MENU
  add unique (CODE);
COMMIT ;