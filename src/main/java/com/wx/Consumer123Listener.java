package com.wx;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer123Listener {

  @KafkaListener(groupId = "testTopic",topics = "testTopic")
  public void onMessage(String message){
    //insertIntoDb(buffer);//这里为插入数据库代码
    System.out.println("2" + message);
  }
}
