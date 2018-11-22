
drop database if exists shoppingdb;
create database	shoppingdb;
use shoppingdb;
#用户表
create table userinfo(
	userId int auto_increment,
	userName varchar(16) not null unique,
	userPassword varchar(256) not null,
	userPhone varchar(16),
	userEmail varchar(32),
	primary key(userId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into userinfo values(1,'lzx','123456','13102345511','2233@outlook.com');
insert into userinfo values(2,'pwd','123456','13456789089','1345@outlook.com');
insert into userinfo values(3,'ndx','123456','13901234414','1488@outlook.com');

#商品类型表
create table commoditytype(
	typeId int auto_increment,
	typeName varchar(8),
	primary key (typeId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into commoditytype(typeName) values('电脑');
insert into commoditytype(typeName) values('手机');
insert into commoditytype(typeName) values('家电');
insert into commoditytype(typeName) values('家具');
insert into commoditytype(typeName) values('运动');
insert into commoditytype(typeName) values('食品');
insert into commoditytype(typeName) values('办公');
insert into commoditytype(typeName) values('汽车');
insert into commoditytype(typeName) values('珠宝');
insert into commoditytype(typeName) values('玩具');

#商品信息表
create table commodityinfo(
	cmdId int auto_increment,
	typeId int,
	cmdPicture varchar(64),
	cmdName varchar(16),
	cmdPrice decimal(10,2),
	cmdDescribe varchar(256),
	cmdState bit,
	primary key (cmdId),
	key fk_typeId (typeId),
	constraint fk_typeId foreign key (typeId) references commoditytype (typeId) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into commodityinfo values(1,1,'img/1.jpg','MagicBook',4999,'荣耀MagicBook 14英寸轻薄窄边框笔记本电脑（AMD锐龙5 8G 256G FHD IPS 正版Office）冰河银',0);
insert into commodityinfo values(2,1,'img/2.jpg','Dell 燃7000',5399,'戴尔DELL灵越燃7000 II 14.0英寸轻薄窄边框笔记本电脑(i5-8250U 8G 128GSSD+1T MX150 2G独显 IPS)银',0);
insert into commodityinfo values(3,1,'img/3.jpg','MacBook Air',6599,'Apple MacBook Air 13.3英寸笔记本电脑 银色(2017款Core i5 处理器/8GB内存/128GB闪存 MQD32CH/A)',0);
insert into commodityinfo values(4,1,'img/4.jpg','Lenovo Y7000',7599,'联想(Lenovo)拯救者Y7000 15.6英寸游戏笔记本电脑(i7-8750H 8G 1T+128G GTX1050Ti 72%NTSC 黑)',0);
insert into commodityinfo values(5,1,'img/5.jpg','MacBook Pro',18888,'Apple MacBook Pro 15.4英寸笔记本电脑 深空灰色 配备Touch Bar 2018新款（六核八代i7 16G 256G固态硬盘 MR932CH/A）',0);
insert into commodityinfo values(6,10,'img/6.jpg','周六福',3499,'周六福 珠宝女款PT950铂金钻石戒指璀璨浪漫白金钻戒 PTDB021009 约10分 13号 一克拉效果 主石9分 副石7.2分',0);
insert into commodityinfo values(7,1,'img/7.jpg','MI Air',53999,'小米(MI)Air 13.3英寸全金属超轻薄笔记本电脑(i5-8250U 8G 256GSSD MX150 2G独显 预装Office 指纹版)银',0);
insert into commodityinfo values(8,2,'img/8.jpg','OPPO R17',3599,'OPPO R17 6.4英寸水滴屏 光感屏幕指纹 8G+128G 雾光渐变 全网通 移动联通电信4G 双卡双待手机',0);
insert into commodityinfo values(9,2,'img/9.jpg','OnePlus 6',4999,'一加手机6 8GB+128GB 墨岩黑 全面屏双摄游戏手机 全网通4G 双卡双待 超值优惠，速来抢购',0);
insert into commodityinfo values(10,3,'img/10.jpg','SIEMENS',3099,'西门子（SIEMENS） 8公斤 变频滚筒洗衣机 LED显示 触摸控制 洗涤分离（银色）XQG80-WM10N1C80W',0);
insert into commodityinfo values(11,3,'img/11.jpg','KONKA',2099,'康佳（KONKA）330升 十字对开门冰箱 四门家用 家电 水波纹钢化玻璃面板 保鲜静音BCD-330BX4S',0);
insert into commodityinfo values(12,3,'img/12.jpg','TCL',4787,'TCL 65A860U 65英寸32核人工智能 超智慧 超薄4K 超高清电视机（银色）全国联保 超值优惠，速来抢购',0);
insert into commodityinfo values(13,4,'img/13.jpg','文琪起',3599,'艾琪艺 简约美式皮床美式乡村酒店家具小美式实木床小户型储物婚床 A05 标准床 单床',0);
insert into commodityinfo values(14,4,'img/14.jpg','尚品宅配',2000,'尚品宅配 榻榻米床定制手动升降台板材榻榻米连体衣柜现代简约 家具全屋定制 定制金(非商品价格)',0);
insert into commodityinfo values(15,5,'img/15.jpg','小米手环3',239,'小米（MI）小米手环3 智能运动 心率监测 智能提醒 睡眠监测 计步 触摸大屏 50米防水',0);
insert into commodityinfo values(16,6,'img/16.jpg','手撕面包1050g',17,'良品铺子 手撕面包1050g整箱装 早餐食品蛋糕口袋小糕点点心孕妇儿童零食大礼包礼盒',0);
insert into commodityinfo values(17,7,'img/17.jpg','得力',10,'得力(deli)0359金属钢质耐用办公订书机套装（订书机+订书钉+起钉器）12#钉颜色随机',0);
insert into commodityinfo values(18,9,'img/18.jpg','G63',1299,'哈雷贝拉 奔驰G63儿童电动车四轮大号越野遥控玩具汽车可坐人小孩宝宝四驱摇摆车12v10A',0);
insert into commodityinfo values(19,9,'img/19.jpg','MSLD',1099,'加长版玛莎拉蒂儿童电动车四轮遥控1-7岁宝宝玩具车童车充电汽车可坐人 全国联保 超值优惠',0);
insert into commodityinfo values(20,10,'img/20.jpg','18K',2399,'佐卡伊 波点 18K金钻石吊坠项链项坠女结婚简约锁骨链送女友珠宝 18分F-G/SI 定制 全国联保',0);
insert into commodityinfo values(21,10,'img/21.jpg','DR',59999,'DR Darry Ring求婚钻戒结婚订婚钻石戒指钻戒珠宝正品专柜群镶佩戴女全国联保线下同款定制 ',0);


#购物车表
create table shoppingCart(
	cartId int auto_increment,
	cmdId int,
	userId int,
	cartNumber int,
	cartPrice decimal(10,2),		
	cartState bit,
	primary key (cartId),
	key fk_cmdId (cmdId),
	key fk_userId (userId),
	constraint fk_cmdId foreign key (cmdId) references commodityinfo(cmdId) on delete cascade on update cascade,
	constraint fk_userId foreign key (userId) references userinfo(userId) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into shoppingCart values(1,1,1,1,4999,0);
insert into shoppingCart values(2,20,1,1,2399,0);
insert into shoppingCart values(3,17,1,1,10,0);
insert into shoppingCart values(4,15,1,1,239,0);


#收货地址表
create table addressinfo(
	adiId int auto_increment,
	userId int,
	adiPlace varchar(512),
	adiName varchar(16),
	adiPhone varchar(11),
	primary key (adiId),
	key fk_adi_userId (userId),
	constraint fk_adi_userId foreign key (userId) references userinfo(userId) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into addressinfo values(1,1,'广东省珠海市斗门区白蕉4路666号','林志炫','14902312233');
insert into addressinfo values(2,1,'广东省珠香洲区白蕉10路66号','林则徐','13910102312');


#订单表
create table orderinfo(
	orderId int auto_increment,
	adiId int,
	cartId int,
	orderState bit,
	primary key (orderId),
	key fk_adiId (adiId),
	key fk_cartId(cartId),
	constraint fk_adiId foreign key (adiId) references addressinfo(adiId) on delete cascade on update cascade,
	constraint fk_cartId foreign key (cartId) references shoppingCart(cartId) on delete cascade on update cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into orderinfo values(1,1,1,0);
insert into orderinfo values(2,1,2,0);
insert into orderinfo values(3,1,3,0);




