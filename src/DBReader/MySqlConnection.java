package DBReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import GameManager.HighscoreCount;

public class MySqlConnection {
	
	private static Connection conn = null;
	private static String dbHost = "192.168.13.117";
	private static String dbPort = "3306";
	private static String database = "quizgame";
	private static String dbUser = "quizit";
	private static String dbPassword = "jean1988";

	public MySqlConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
			          + dbPort + "/" + database + "?useSSL=false&" + "user=" + dbUser + "&"
			          + "password=" + dbPassword);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<ArrayList<String>> getTableQuery(String sql, int selectCount) {
		
		ArrayList<ArrayList<String>> tableEntrys = new ArrayList<ArrayList<String>>();

		try {
			Statement query = conn.createStatement();
			ResultSet result = query.executeQuery(sql);
			
			while (result.next()) {
				ArrayList<String> dataset = new ArrayList<String>();
				if (selectCount > 1) {
			        for (int i = 1; i <= selectCount; i++) { 
			        	dataset.add(result.getString(i));
			        }
				} else {
					dataset.add(result.getString(1));
				}
		        tableEntrys.add(dataset);
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tableEntrys;
	}
	
	public static ArrayList<ArrayList<String>> getEntrys(String select, int selectCount, String table, String additional) {
		String sql = "SELECT " + select + " FROM " + table + additional;
		return getTableQuery(sql, selectCount);
	}
	
	public static ArrayList<ArrayList<String>> getEntrys(String select, int selectCount, String table) {
		return getEntrys(select, selectCount, table, "");
	}
	
	public static String getSingleEntry(String select, int selectCount, String table, String additional) {
		String sql = "SELECT " + select + " FROM " + table + additional;
		return getTableQuery(sql, selectCount).get(0).get(0);
	}
	
	public static void insertNewHighscore() {
		ArrayList<ArrayList<String>> highscore = HighscoreCount.getHighscore();
		String drop = "Drop Table Highscore;";
		String table = "Create Table Highscore (id int primary key,name varchar(25),punkte int);";
		
		Statement query;
		try {
			query = conn.createStatement();
			query.execute(drop);
			query.execute(table);
			for (ArrayList<String> singleRow : highscore) {
				query.execute("Insert into Highscore values (" + singleRow.get(0) + ",'" + singleRow.get(1) + "'," + singleRow.get(2) + ");");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
