package com.wx;

import com.wx.test1.DB1TestDao;
import com.wx.test2.DB2TestDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testttt {
  @Test
  public void contextLoads() {
  }
  @Autowired
  private DB1TestDao db1Dao;

  @Autowired
  private DB2TestDao db2Dao;

  @Transactional
  @Test
  public void testMulitSourceTransaction() {
    db1Dao.save();
    db2Dao.save();
  }

  @Test
  @Transactional
  @Rollback(false)
  public void testMulitSourceTransactionWithOutRollBack() {
    db1Dao.save();
    db2Dao.save();
  }
}
