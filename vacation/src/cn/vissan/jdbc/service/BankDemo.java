package cn.vissan.jdbc.service;
import cn.vissan.jdbc.util.DBconnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class BankDemo {

    public static void main(String[] args) throws Exception {
        BankDemo bankDemo = new BankDemo();
        bankDemo.transfer();
    }

    public void transfer() throws Exception {

        try {
            PreparedStatement preparedStatement = null;
            final Connection conn = DBconnection.conn();
            conn.setAutoCommit(false);
            String sql = "select * from account where name = ? and balance > ?";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, "张无忌");
            preparedStatement.setBigDecimal(2, new BigDecimal(1000));
            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String multsql = "update account set balance = balance -1000 where name = ?";
                preparedStatement = conn.prepareStatement(multsql);
                preparedStatement.setString(1, "张无忌");
                preparedStatement.executeUpdate();


                String addsql = "update account set balance = balance +1000 where name = ?";
                preparedStatement = conn.prepareStatement(addsql);
                preparedStatement.setString(1, "赵敏");
                preparedStatement.executeUpdate();

                conn.commit();
                DBconnection.close(conn, preparedStatement, resultSet);
                System.out.println("转账成功");
            } else {
                System.out.println("转账失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            DBconnection.conn().rollback();
        }
    }
}
