package com.luoben.glmall.order.listener;


import com.luoben.glmall.order.entity.OrderEntity;
import com.luoben.glmall.order.service.OrderService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RabbitListener(queues = "order.release.order.queue")
@Component
public class OrderCloseListener {

    @Autowired
    OrderService orderService;

    @RabbitHandler
    public void listener(OrderEntity entity, Channel channel, Message message)throws IOException {
        System.out.println("收到过期的订单信息：准备关闭订单："+entity);
        try {
            //关闭订单
            orderService.closeOrder(entity);
            //TODO 手动调用收单
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }
    }
}
