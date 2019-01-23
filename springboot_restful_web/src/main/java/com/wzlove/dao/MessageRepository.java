package com.wzlove.dao;

import com.wzlove.domain.Message;

import java.util.List;

/**
 * @ClassName MessageRepository
 * @Author wz157
 * @Date 2018/12/6 18:13
 * @Description TODO
 */
public interface MessageRepository {

    /**
     * 查询所有
     * @return
     */
    List<Message> findAll();

    /**
     * 保存
     * @param message
     * @return
     */
    Message save(Message message);

    /**
     * 修改
     * @param message
     * @return
     */
    Message update(Message message);

    /**
     * 修改text字段
     * @param message
     * @return
     */
    Message updateText(Message message);

    /**
     * 查询单个
     * @param id
     * @return
     */
    Message findMessage(Long id);

    /**
     * 删除
     * @param id
     */
    void deleteMessage(Long id);


}
