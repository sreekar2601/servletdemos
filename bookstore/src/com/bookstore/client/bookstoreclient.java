package com.bookstore.client;

import java.util.ArrayList;
import java.util.List;

import com.bookstore.domain.Book;
import com.bookstore.domain.Chapter;
import com.bookstore.domain.Publisher;
import com.bookstore.services.bookstoreservice;

public class bookstoreclient {
public static void main(String[] args) {
		
	bookstoreservice bookStoreService = new bookstoreservice();
		Publisher publisher = new Publisher("MANN", "Manning Publications Co.");
		
		Book book = new Book("9876123456", "Hibernate book", publisher);
		
		Chapter chapter1 = new Chapter("Introduction", 1);
		Chapter chapter2 = new Chapter("Domain Models", 2);
		
		List<Chapter> chapters = new ArrayList<Chapter>();
		chapters.add(chapter1);
		chapters.add(chapter2);
		
		book.setChapters(chapters);
		
		//bookstoreservice bookStoreService = new bookstoreservice();
		////bookStoreService.persistObjectGraph(book);
		
		System.out.println(book);
		
		System.out.println(bookStoreService.retrieveObjectGraph("9876123456"));
		System.out.println(bookStoreService.retrieveObjectGraph("34522093093IHFDJ"));
}
}
