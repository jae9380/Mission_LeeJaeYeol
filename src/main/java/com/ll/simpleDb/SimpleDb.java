package com.ll.simpleDb;


import java.sql.*;

public class SimpleDb {
    private Connection connection;

    public SimpleDb(String url, String username,String password, String databaseName){
        String connenectionUrl ="jdbc:mysql://"+url+"/"+databaseName;
        try {
            connection= DriverManager.getConnection(connenectionUrl,username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String sql, Object...params){
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            for (int i = 0; i <params.length;  i++) {
                statement.setObject(i+1,params[i]);
            }
            return statement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public int executeUpdate(String sql,Object... params){
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length ; i++) {
                statement.setObject(i+1,params[i]);
            }
            return statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
    }
    public void close(){
        if (connection!=null){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public void run(String command){

    }
}
