package com.swagger.springbootswagger.controller;

import com.swagger.springbootswagger.config.BaseResult;
import com.swagger.springbootswagger.model.Message;
import com.swagger.springbootswagger.respoistory.MessageRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName MessageController
 * @Author Smith
 * @Date 2019/1/22 15:15
 * @Description TODO
 * @Version 4.1
 */
@Api(value = "消息",description = "消息操作 API", position = 100, protocols = "http")
@RestController
@RequestMapping("/")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @ApiOperation(
            value = "消息列表",
            notes = "完整的消息内容列表",
            produces = "application/json, application/xml",
            consumes = "application/json, application/xml",
            response = List.class,
            code = 200
    )
    @GetMapping(value = "messages")
    public BaseResult<List<Message>> list() {
        List<Message> messages = this.messageRepository.findAll();
        return BaseResult.successWithData(messages);
    }

    @ApiOperation(
            value = "添加信息",
            notes = "根据传递的参数创建信息"
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "消息ID", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "text", value = "消息正文", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "summary", value = "摘要", required = false, dataType = "String", paramType = "query"),

    })
    @PostMapping(value = "message")
    public BaseResult<Message> create(Message message) {
        message = this.messageRepository.save(message);
        return BaseResult.successWithData(message);
    }

    @ApiOperation(value = "修改信息", notes = "根据参数修改信息")
    @ApiResponses({
            @ApiResponse(code = 100, message = "请求信息有误"),
            @ApiResponse(code = 101, message = "未授权"),
            @ApiResponse(code = 103, message = "禁止访问"),
            @ApiResponse(code = 104, message = "请求路径不存在"),
            @ApiResponse(code = 200, message = "服务器内部错误"),
    })
    @PutMapping(value = "message")
    public BaseResult<Message> modify(Message message) {
        Message messageResult=this.messageRepository.update(message);
        return BaseResult.successWithData(messageResult);
    }

    @PatchMapping(value="/message/text")
    public BaseResult<Message> patch(Message message) {
        Message messageResult=this.messageRepository.updateText(message);
        return BaseResult.successWithData(messageResult);
    }

    @ApiOperation(
            value = "查询单个消息",
            notes = "单个消息的详细信息",
            response = BaseResult.class,
            code = 200
    )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "消息的id",required = true, dataType = "Long", paramType = "path")
    })
    @GetMapping(value = "message/{id}")
    public BaseResult<Message> get(@PathVariable Long id) {
        Message message = this.messageRepository.findMessage(id);
        return BaseResult.successWithData(message);
    }

    @ApiOperation(value = "删除消息",notes = "根据id删除消息",code = 200)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "消息的id",required = true, dataType = "Long", paramType = "path")
    })
    @DeleteMapping(value = "message/{id}")
    public BaseResult delete(@PathVariable("id") Long id) {
        this.messageRepository.deleteMessage(id);
        return BaseResult.success();
    }
}
