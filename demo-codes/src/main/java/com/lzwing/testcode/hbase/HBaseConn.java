package com.lzwing.testcode.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

import java.io.IOException;

/**
 * Created by jixin on 18-2-25.
 */
public class HBaseConn {

  private static final HBaseConn INSTANCE = new HBaseConn();
  private static Configuration configuration;
  private static Connection connection;

  private static final String ZK_URL = "192.168.1.112";

  private HBaseConn() {
    try {
      if (configuration == null) {
        configuration = HBaseConfiguration.create();
        configuration.set("hbase.zookeeper.quorum", ZK_URL+":2181");

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private Connection getConnection() {
    if (connection == null || connection.isClosed()) {
      try {
        connection = ConnectionFactory.createConnection(configuration);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return connection;
  }

  public static Connection getHBaseConn() {
    return INSTANCE.getConnection();
  }

  public static Table getTable(String tableName) throws IOException {
    return INSTANCE.getConnection().getTable(TableName.valueOf(tableName));
  }

  public static void closeConn() {
    if (connection != null) {
      try {
        connection.close();
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }
}
