package com.dao.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.programs.Book;

public class BookDAOUsingPreparedStatements {
	public boolean addBook(int bid,String bname,String authour ,String subtitle,double price,int quantity) {
		boolean rs = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3","root","Root");
			// 3.Create Query/Statement
			pstmt = con.prepareStatement("insert into book values(?,?,?,?,?,?)");
					// 4.Execute Querry
			
			pstmt.setInt(1, bid);
			pstmt.setString(2, bname);
			pstmt.setString(3, authour);
			pstmt.setString(4, subtitle);
			pstmt.setDouble(5, price);
			pstmt.setInt(6, quantity);
			int nori = pstmt.executeUpdate();
					
			if (nori == 1) {
				rs = true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// 5.process the result

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			}
		}
		return rs;

	}

	public boolean updateBook(int bid,String bname,String authour ,String subtitle,double price,int quantity) {
		boolean rs = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3 ? user=root&password=Root");
			// 3.Create Query/Statement
			pstmt = con.prepareStatement("update book set bname=?,authour=?,subtitle=?,price=?,quantity=? where bid=?");
			// 4.Execute Query
			pstmt.setString(1, bname);
			pstmt.setString(2, authour);
			pstmt.setString(3, subtitle);
			pstmt.setDouble(4, price);
			pstmt.setInt(5, quantity);
			pstmt.setInt(6, bid);
			int nori = pstmt.executeUpdate();
			//bname='" + usdt.getBname() + "',authour='"
				//	+ usdt.getAuthour() + "',subtitle='" + usdt.getSubtitle() + "',price=" + usdt.getPrice()
				//	+ ",quantity=" + usdt.getQuantity() + " where bid=" + usdt.getBid() + ";");
			if (nori == 1) {
				rs = true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// 5.process the result

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			}
		}
		return rs;
	}

	public boolean deleteBook(int bid) {
		boolean rs = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			// 3.Create Query/Statement
			pstmt = con.prepareStatement("delete from book where bid=?");
			pstmt.setInt(1, bid);
			// 4.Execute Querry
			int nori = pstmt.executeUpdate();
			if (nori == 1) {
				rs = true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// 5.process the result

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			}
		}
		return rs;
	}

	public Book search(int bid) {
		Book s = new Book();
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			// 3.Create Query/Statement
			pstmt = con.prepareStatement("select * from book where bid=?");
			pstmt.setInt(1, bid);
			// 4.Execute Querry
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				s.setBid(rs.getInt("bid"));
				s.setBname(rs.getString("bname"));
				s.setPrice(rs.getDouble("price"));
				s.setAuthour(rs.getString("authour"));
				s.setQuantity(rs.getInt("quantity"));
				s.setSubtitle(rs.getString("subtitle"));
			} else {
				System.out.println("Invalid book Id...!!!!!");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// 5.process the result

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			}
		}
		return s;

	}

	public List<Book> displayall() {
		List<Book> li = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			// 3.Create Query/Statement
			pstmt = con.prepareStatement("select * from book");
			// 4.Execute Querry
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Book s = new Book();
				s.setBid(rs.getInt("bid"));
				s.setBname(rs.getString("bname"));
				s.setPrice(rs.getDouble("price"));
				s.setAuthour(rs.getString("authour"));
				s.setQuantity(rs.getInt("quantity"));
				s.setSubtitle(rs.getString("subtitle"));

				li.add(s);

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			// 5.process the result

		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (pstmt != null) {
					try {
						pstmt.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			}
		}

		return li;

	}
}
