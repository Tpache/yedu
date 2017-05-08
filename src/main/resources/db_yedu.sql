CREATE TABLE `msg_text` (
  `msg_text_id` char(1) NOT NULL COMMENT 'ID',
  `msgType` varchar(20) NOT NULL COMMENT '信息类型',
  `reqType` varchar(40) NOT NULL COMMENT '请求类型',
  `content` varchar(500) NOT NULL COMMENT '内容',
  `crtTime` datetime NOT NULL COMMENT '创建时间',
  `enabled` varchar(1) NOT NULL COMMENT '是否有效',
  PRIMARY KEY (`msg_text_id`),
  KEY `idx_msg_text_id` (`msg_text_id`),
  KEY `IDX_reqType` (`reqType`),
  KEY `idx_msgType` (`msgType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文本信息';

INSERT INTO `msg_text` (`msg_text_id`, `msgType`, `reqType`, `content`, `crtTime`, `enabled`) VALUES ('1001', 'text', '笑话','这是一个笑话文本111', now(), 'T');
INSERT INTO `msg_text` (`msg_text_id`, `msgType`, `reqType`, `content`, `crtTime`, `enabled`) VALUES ('1002', 'text', '笑话', '这是一个笑话文本222', now(), 'T');
INSERT INTO `msg_text` (`msg_text_id`, `msgType`, `reqType`, `content`, `crtTime`, `enabled`) VALUES ('1003', 'text', '笑话', '这是一个笑话文本333', now(), 'T');
INSERT INTO `msg_text` (`msg_text_id`, `msgType`, `reqType`, `content`, `crtTime`, `enabled`) VALUES ('1004', 'text', '笑话', '这是一个笑话文本444', now(), 'T');
INSERT INTO `msg_text` (`msg_text_id`, `msgType`, `reqType`, `content`, `crtTime`, `enabled`) VALUES ('1005', 'text', '笑话', '这是一个笑话文本555', now(), 'T');
INSERT INTO `msg_text` (`msg_text_id`, `msgType`, `reqType`, `content`, `crtTime`, `enabled`) VALUES ('1006', 'text', '笑话', '这是一个笑话文本666', now(), 'T');
INSERT INTO `msg_text` (`msg_text_id`, `msgType`, `reqType`, `content`, `crtTime`, `enabled`) VALUES ('1007', 'text', '笑话', '这是一个笑话文本777', now(), 'T');
INSERT INTO `msg_text` (`msg_text_id`, `msgType`, `reqType`, `content`, `crtTime`, `enabled`) VALUES ('1008', 'text', '笑话', '这是一个笑话文本888', now(), 'T');


