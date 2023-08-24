package com.dao.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.programs.Book;

public class BookDAO {
	public boolean addBook(Book bk) {
		boolean rs = false;
		Connection con = null;
		Statement stmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			// 3.Create Query/Statement
			stmt = con.createStatement();
			// 4.Execute Querry
			int nori = stmt.executeUpdate("insert into book values(" + bk.getBid() + ",'" + bk.getBname() + "','"
					+ bk.getAuthour() + "','" + bk.getSubtitle() + "'," + bk.getPrice() + "," + bk.getQuantity() + ")");
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
				if (stmt != null) {
					try {
						stmt.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			}
		}
		return rs;

	}

	public boolean updateBook(Book usdt) {
		boolean rs = false;
		Connection con = null;
		Statement stmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3? user=root&password=Root");
			// 3.Create Query/Statement
			stmt = con.createStatement();
			// 4.Execute Query
			int nori = stmt.executeUpdate("update book set bname='" + usdt.getBname() + "',authour='"
					+ usdt.getAuthour() + "',subtitle='" + usdt.getSubtitle() + "',price=" + usdt.getPrice()
					+ ",quantity=" + usdt.getQuantity() + " where bid=" + usdt.getBid() + ";");
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
				if (stmt != null) {
					try {
						stmt.close();

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
		Statement stmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			// 3.Create Query/Statement
			stmt = con.createStatement();
			// 4.Execute Querry
			int nori = stmt.executeUpdate("delete from book where bid=" + bid);
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
				if (stmt != null) {
					try {
						stmt.close();

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
		Statement stmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			// 3.Create Query/Statement
			stmt = con.createStatement();
			// 4.Execute Querry
			ResultSet rs = stmt.executeQuery("select * from book where bid=" + bid);
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
				if (stmt != null) {
					try {
						stmt.close();

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
		Statement stmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3", "root", "Root");
			// 3.Create Query/Statement
			stmt = con.createStatement();
			// 4.Execute Querry
			ResultSet rs = stmt.executeQuery("select * from book");
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
				if (stmt != null) {
					try {
						stmt.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}

				}
			}
		}

		return li;

	}
}
