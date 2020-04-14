import java.sql.*;

public class Setup {

	/*create table book
	(ISBN		numeric(13,0),
	 name		varchar(20),
	 author		varchar(20),
	 genre		varchar(10),
	 price		numeric(3,2) check (price > 0),
	 page_number	numeric(4,0) check (page_number > 0),
	 book_copies	numeric(5,0) check (book_copies > 0),
	 primary key (ISBN)
	);
	 * 
	 * 
	 * create table customer
	(username		varchar(20),
	 password		varchar(20),
	 address		varchar(30),
	  primary key (username)
	);
	 * 
	 * create table checkout
	(username		varchar(20),
	 book_id		numeric(13,0),
	 quantity		numeric(5,0) check (quantity > 0),
	 price			numeric(10,0) check (price > 0),
	 primary key (username,book_id),
	 foreign key (username) references customer on delete cascade,
	 foreign key (book_id) references book (ISBN) on delete cascade,
	);
	 * 
	 * 
	 * */
	
}
