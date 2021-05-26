package com.fawvw.zheda.HBase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;

import java.io.IOException;

public class VirtualHBaseTest {
/**
    public static Configuration conf;
    static{
//使用 HBaseConfiguration 的单例方法实例化
        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "192.168.126.128");
        conf.set("hbase.zookeeper.property.clientPort", "9000");
    }
    public static boolean isTableExist(String tableName) throws
            MasterNotRunningException,
            ZooKeeperConnectionException, IOException{
//在 HBase 中管理、访问表需要先创建 HBaseAdmin 对象尚硅谷大数据技术之 Hbase
//Connection connection =
        ConnectionFactory.createConnection(conf);
//HBaseAdmin admin = (HBaseAdmin) connection.getAdmin();
        HBaseAdmin admin = new HBaseAdmin(conf);
        return admin.tableExists(tableName);
    }
    public static void createTable(String tableName, String...
            columnFamily) throws
            MasterNotRunningException, ZooKeeperConnectionException,
            IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);
//判断表是否存在
        if(isTableExist(tableName)){
            System.out.println("表" + tableName + "已存在");
//System.exit(0);
        }else{
//创建表属性对象,表名需要转字节
            HTableDescriptor descriptor = new
                    HTableDescriptor(TableName.valueOf(tableName));
//创建多个列族
            for(String cf : columnFamily){
                descriptor.addFamily(new HColumnDescriptor(cf));
            }
//根据对表的配置，创建表
            admin.createTable(descriptor);
            System.out.println("表" + tableName + "创建成功！ ");
        }
    }
    public static void main(String[] args) {
        try{
            createTable("student","name","score");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
 */
}
