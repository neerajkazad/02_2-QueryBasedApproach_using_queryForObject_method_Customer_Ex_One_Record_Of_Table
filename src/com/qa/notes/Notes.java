package com.qa.notes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class Notes {
	/**
	

jdbcTemplate.queryForObject(sql, String.class, new Object[] {mobile});

=> one primitive value when return out of that query then go for queryForObject() method.
Internal Code:

class JdbcTemplate {
  private DataSource source;
  
  //Default constructor
  public JdbcTemplate() {
  }

  //param constructor
  public JdbcTemplate(DataSource source) {
    this.source=source;
  }

  //setter   
  public void setDataSource(DataSource source) {
    this.source=source;
  }
  public Object queryForObject(String sql, Class classType, Object[]{params}) {
    Connection con = null;    
    PreparedStatement pstmt = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      Object ret=null;

      con=dataSource.getConnection();
      pstmt=con.prepareStatement(sql); //subtitute the positional params
      rs=pstmt.exceteQuery();
      
      if(rs.next()) {
        if(classType==String.class) {
         ret=rs.getString(1);
        } else if(classType==Integer.class) {
          ret=rs.getInt(1);
        } else if(classType==Double.class) {
          ret=rs.getDouble(1);
        }
      }
           
      return ret;
    } catch(SqlException e) {
      throw new DataAccessException(e);
    } finally() {
      //closing the resources
    }
    return null;     
  }

 => queryForObject(sql,RowMapper mapper,new Object[]{params})
 Internal code:

 class JdbcTemplate {
   private DataSource source;
  
   //Default constructor
   public JdbcTemplate() {
   }

   //param constructor
   public JdbcTemplate(DataSource source) {
     this.source=source;
   }

   //setter   
   public void setDataSource(DataSource source) {
     this.source=source;
   }

   public Object queryForObject(String sql, RowMapper mapper,new Object[] {params}) {
    
    try {
      Object ret=null;

      con=dataSource.getConnection();
      pstmt=con.prepareStatement(sql);            
      //subtitute the positional params
      rs=pstmt.exceteQuery();
      
      if(rs.next()) {
        Object obj =mapper.rowMap(rs, 1);
        //If we map one record then all the records also same and that
          if condition will executes only once here so we can pass "1"
        return studentBo;
      }
    } catch(SqlException sqe) {
      throw new DataAccessException(sqe);
    } finally() {
      //closing the resources
    }
    return null;     
  }

	 * 
	 */
	
	
}
