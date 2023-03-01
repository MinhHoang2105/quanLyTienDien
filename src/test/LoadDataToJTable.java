package test;

import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

public class LoadDataToJTable {
  public static void main(String[] args) {
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/quanlytiendien";
    String user = "root";
    String password = "";
    String query = "SELECT * FROM bienlai";
    try {
      con = DriverManager.getConnection(url, user, password);
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(query);
      ResultSetMetaData rsmd = rs.getMetaData();
      int columns = rsmd.getColumnCount();
      DefaultTableModel dtm = new DefaultTableModel();
      Vector columns_name = new Vector();
      Vector data_rows = new Vector();
      for (int i = 1; i <= columns; i++) {
        columns_name.addElement(rsmd.getColumnName(i));
      }
      dtm.setColumnIdentifiers(columns_name);
      while (rs.next()) {
        data_rows = new Vector();
        for (int j = 1; j <= columns; j++) {
          data_rows.addElement(rs.getString(j));
        }
        dtm.addRow(data_rows);
      }
      JTable table = new JTable(dtm);
      JFrame frame = new JFrame("Load Data To JTable");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(new JScrollPane(table));
      frame.setSize(400, 300);
      frame.setVisible(true);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}