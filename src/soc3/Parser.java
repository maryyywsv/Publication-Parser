package soc3;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.sql.*;

public class Parser {
	public static void main(String[] args) throws XMLStreamException,
	FileNotFoundException {
List<BookInfo> bookList = null;
BookInfo currInfo = null;
String tagContent = null;
XMLInputFactory factory = XMLInputFactory.newInstance();
FileInputStream str = new FileInputStream("/Users/yyw/Desktop/dblp.xml");
XMLStreamReader reader = factory.createXMLStreamReader(str);
int a = 2000;

while (reader.hasNext()) {
	int event = reader.next();

	switch (event) {
	case XMLStreamConstants.START_ELEMENT:
		if ("incollection".equals(reader.getLocalName())) {
			currInfo = new BookInfo();
			
		}
		if ("dblp".equals(reader.getLocalName())) {
			bookList = new ArrayList<BookInfo>();
		}
		break;

	case XMLStreamConstants.CHARACTERS:
		tagContent = reader.getText().trim();
		break;

	case XMLStreamConstants.END_ELEMENT:
		if (currInfo != null) {
			// System.out.println(tagContent);
			if (reader.getLocalName().equals("incollection")) {
				bookList.add(currInfo);
			} else if (reader.getLocalName().equals("author")){
				if(currInfo.author ==null){
					currInfo.author =tagContent;
				}
				else{
					currInfo.author+=","+tagContent;
					
				}
				
				
			} else if (reader.getLocalName() == "title") {
				currInfo.title = tagContent;
			} else if (reader.getLocalName().equals("pages")) {
				currInfo.pages = tagContent;
			} else if (reader.getLocalName().equals("year")) {
				currInfo.year = tagContent;
			}
			break;
		}

		break;

	case XMLStreamConstants.START_DOCUMENT:
		bookList = new ArrayList<BookInfo>();
		break;
	}

	a--;
	if (a == 0)
		break;

}

// Print the employee list populated from XML
for (BookInfo info : bookList) {
	System.out.println(info);
	insert(info);
}

}

/*class BookInfo {
String author;
String title;
String pages;
String year;

@Override
public String toString() {
	return "author: " + author + " " + "title: " + title + " "
			+ "pages: " + pages + " " + "year: " + year;
}
}
*/
private static void insert(BookInfo info) {
/*	Statement statement;
Connection connect = null;*/

try {
	Class.forName("com.mysql.jdbc.Driver"); // load MYSQL JDBC program
	System.out.println("Success loading Mysql Driver!");
} catch (Exception e) {
	System.out.print("Error loading Mysql Driver!");
	e.printStackTrace();
}
try {
	Connection connect = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/test", "root", "");
	// statement = connect.createStatement();
//	 String checkTable = "DROP TABLE IF EXISTS test.user1;";
	//	statement.executeUpdate(checkTable);
	//	String createTable="Create table test.user1(author VARCHAR(100 not null,title VARCHAR(100) not null,pages VARCHAR(100) not null,year VARCHAR(100) not null);";
	//statement.executeUpdate(createTable);
		PreparedStatement Statement = connect
			.prepareStatement("INSERT INTO user4 VALUES(?,?,?,?)");

	Statement.setString(1, info.author);
	Statement.setString(2, info.title);     
	Statement.setString(3, info.pages);
	Statement.setString(4, info.year);
	Statement.executeUpdate();
	System.out.println(info.author+info.title+info.pages+info.year);

	// } catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	// System.out.println("An error has occurred:"+e.toString());
	// e.printStackTrace();
	
    connect.close();
    //System.out.println("close");
} catch (SQLException e) {
}
//	finally
//   {
//     if (connect != null)
 //   {
   //     try
     //   {
       //     connect.close ();
         //   System.out.println ("Database connection terminated");
       // }
        //catch (Exception e) { /* ignore close errors */ }
   // }
// }

}
}
