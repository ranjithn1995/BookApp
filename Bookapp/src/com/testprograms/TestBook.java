package com.testprograms;

import com.dao.programs.BookDAOUsingPreparedStatements;


public class TestBook {

	public static void main(String[] args) {
		//BookDAO bl = new BookDAO();
		//System.out.println(bl.addBook(new Book(101, "java", "james gosling", "oops concept", 554.0, 20)));
        //.out.println(bl.updateBook(new Book(444, "musql", "oracle","dml" , 23.22, 4)));
		//System.err.println(bl.deleteBook(101));
		//System.err.println(bl.search(101));
		//System.out.println(bl.displayall())

		BookDAOUsingPreparedStatements bs = new BookDAOUsingPreparedStatements();
	//	System.out.println(bs.addBook(1234, "engish", "new potion", "qqq", 123.33, 5));
	//	System.out.println(bs.updateBook(1234, "commerce", "ranjith", "index", 135.0, 12));
		
	//	System.out.println(bs.deleteBook(1234));
	//	System.out.println(bs.search(444));
		System.out.println(bs.displayall());
		
		
	}

}
