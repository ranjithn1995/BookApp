package com.testprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.programs.BookDAO;
import com.dto.programs.Book;

public class BookApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookDAO book = new BookDAO();
		while(true) {
			System.out.println("Enter the number : \n 1.AddBook \n 2.DeleteBook \n 3.SearchBook \n 4.DisplayAll \n 5.Update \n 6.Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter BookId: ");
				int bid = sc.nextInt();
				System.out.println("Enter BookName:");
				String bname = sc.next();
				System.out.println("Enter BookAuthour:");
				String authour = sc.next();
				System.out.println("Enter BookSubtitle:");
				String subtitle = sc.next();
				System.out.println("Enter Price");
				double price = sc.nextDouble();
				System.out.println("Enter Quantity: ");
				int quantity = sc.nextInt();
				if (book.addBook(new Book( bid, bname, authour,subtitle,price,quantity)))
				{
					System.out.println("Book Added SucessFully...");
				} else {
					System.out.println("Something Went Wrong.....");
				}

				break;
			case 2:
				System.out.println("Enter Id: ");
				bid = sc.nextInt();
				if (deleteBook(bid)) {
					System.out.println("Book Deleted SucessFully...");
				} else {
					System.out.println("Book Id is Invalid.....");
				}
				break;
			case 3:
				System.out.println("Enter the BookID");
				bid=sc.nextInt();
				if(book.search(bid)!=null) {
					System.out.println((book.search(bid)));
				}else {
					System.out.println("book is invalid.......!!!!!");
				}
				break;
				
			case 4:if(book.displayall()!=null) {
				List<Book>li=book.displayall();
				li.forEach(i->System.out.println(i));}
			else {
				System.out.println("there is no book in librarie");
			}
			break;
			case 5:
				System.out.println("Enter BookId: ");
			 bid = sc.nextInt();
			System.out.println("Enter BookName:");
			bname = sc.next();
			System.out.println("Enter BookAuthour:");
			 authour = sc.next();
			System.out.println("Enter BookSubtitle:");
			 subtitle = sc.next();
			System.out.println("Enter Price");
			 price = sc.nextDouble();
			System.out.println("Enter Quantity: ");
			 quantity = sc.nextInt();
			 if(book.updateBook(new Book(bid,bname,authour,subtitle,price,quantity))) {
					System.out.println("Book Updated SucessFully...");
				} else {
					System.out.println("Something went wrong.....!!!!!!");
				} 
			break;
			
			case 6:System.out.println("Thank you for using Application !!!!");
			System.exit(0);
			break;
			default:System.out.println("Enter the proper Numbers");
					
				}
		}
		

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
			while(rs.next()) {
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

	private static boolean deleteBook(int bid) {
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
			int nori = stmt.executeUpdate("insert into book values("+bk.getBid()+",'"+bk.getBname()+"','"+bk.getAuthour()+"','"+bk.getSubtitle()+"',"+bk.getPrice()+","+bk.getQuantity()+")");                                                               
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
	public boolean updateBook(Book usdt) {
		boolean rs = false;
		Connection con = null;
		Statement stmt = null;
		// 1.load and register the Drive
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2.Establish the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cfje3 ? user=root&password=Root");
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
}
	