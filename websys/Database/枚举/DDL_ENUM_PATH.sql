create table ENUM_PATH
(
  urid         VARCHAR2(32) not null,
  CODE VARCHAR2(32) not null,
  PATH      VARCHAR2(256) not null,
  DESCRIPTION      VARCHAR2(64) not null
)
;
COMMIT ;
comment on table ENUM_PATH
  is '枚举路径表';
comment on column ENUM_PATH.urid
  is '枚举路径ID';
comment on column ENUM_PATH.CODE
  is '枚举编号';
comment on column ENUM_PATH.PATH
  is '枚举路径';
comment on column ENUM_PATH.DESCRIPTION
  is '描述';
alter table ENUM_PATH
  add primary key (URID);
COMMIT ;