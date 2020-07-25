package cn.sher6j.concurrrency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author sher6j
 * @create 2020-07-23-16:31
 */
public class ThreadLoaclDemo {

    public static String DB_URL = "...";

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>() {
        @Override
        protected Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    public static Connection getConnection() {
        return connectionThreadLocal.get();
    }
}
