create table TSYS_USER_LOGIN
(
  urid             VARCHAR2(32) not null,
  user_id          VARCHAR2(32) not null,
  last_login_date  TIMESTAMP(6),
  last_login_ip    VARCHAR2(128) not null,
  login_fail_times NUMBER(2) not null,
  last_fail_date   TIMESTAMP(6)
)
;
comment on table TSYS_USER_LOGIN
  is '用户登录表';
comment on column TSYS_USER_LOGIN.urid
  is 'URID';
comment on column TSYS_USER_LOGIN.user_id
  is '用户ID';
comment on column TSYS_USER_LOGIN.last_login_date
  is '上次登录成功时间';
comment on column TSYS_USER_LOGIN.last_login_ip
  is '上次登录IP';
comment on column TSYS_USER_LOGIN.login_fail_times
  is '登录失败次数';
comment on column TSYS_USER_LOGIN.last_fail_date
  is '上次登录失败时间';
alter table TSYS_USER_LOGIN
  add constraint PK_USER_LOGIN_URID primary key (URID);
alter table TSYS_USER_LOGIN
  add constraint UK_USER_LOGIN_USERID unique (USER_ID);