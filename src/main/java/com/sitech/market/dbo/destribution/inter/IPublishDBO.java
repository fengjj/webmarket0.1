package com.sitech.market.dbo.destribution.inter;

import java.util.Map;


public interface IPublishDBO {

	/* 调用cms端发布接口返回发布地址 */
    public  String publish(Map bean);

    /* 调用cms端预发布接口返回预发布地址 */
    public  String prePublish(Map bean);

    /* 调用返回资费配置状态接口 */
    public  String getConfigStatus(Map bean);

    /* 活动暂停调用cms活动下线接口端预发布接口返回预发布地址 */
    public  String tellUnline(Map bean);
}
