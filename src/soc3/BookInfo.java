package soc3;

public class BookInfo {
	
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


