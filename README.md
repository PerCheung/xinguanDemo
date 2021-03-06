# 疫情管理系统

## 介绍

本系统基于纯java基础开发，使用jdbc操作mysql数据库，在控制台展现了登陆注册，物资捐赠，物资发放功能。



## 数据库构建

### 管理员表

```sql
create table user
(
    user_id  int auto_increment comment '用户ID'
        primary key,
    username varchar(255) not null comment '用户名',
    password varchar(255) not null comment '密码',
    constraint user_username_uindex
        unique (username)
)
    comment '管理员表';
```



### 仓库表

```sql
create table stock
(
    stock_id   int auto_increment comment '物品ID'
        primary key,
    thing_name varchar(255)  not null comment '物品名',
    thing_num  int default 0 not null comment '物品数量',
    updatetime datetime      null comment '更新时间'
)
    comment '仓库表';
```



### 入库表

```sql
create table instock
(
    instock_id int auto_increment comment '入库单号'
        primary key,
    createTime datetime                  not null comment '入库单创建时间',
    donor      varchar(255) default '匿名' not null comment '捐赠人',
    donation   varchar(255)              null comment '捐赠物',
    in_num     int                       null comment '捐赠数量'
)
    comment '入库表';
```



### 出库表

```sql
create table outstock
(
    outstock_id int auto_increment comment '出库单号'
        primary key,
    createtime  datetime     not null comment '出库时间',
    thing       varchar(255) null comment '出库物品',
    out_num     int          null comment '出库物品数量',
    for_who     varchar(255) null comment '受捐助者'
)
    comment '出库表';
```

