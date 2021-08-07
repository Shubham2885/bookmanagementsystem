package com.bridglabz.bookmanagementsystem.services;

import java.util.List;
import java.util.Scanner;

import com.bridglabz.bookmanagementsystem.interfaces.IBookService;
import com.bridglabz.bookmanagementsystem.model.Book;


public class BookServiceImpl implements IBookService {
	Scanner scanInput = new Scanner(System.in);

	@Override
	public void addBook(List<Book> books) {
		Book book = new Book();
		int i = 0;
		do {

			System.out.println("enter book id");
			int getId = scanInput.nextInt();
			

			if (books.stream().map(data -> data.getId()).anyMatch(data -> data == getId)) {
				System.out.print("book allready present - ");

			} else {
				book.setId(getId);
				System.out.print("Enter book name- ");
				String bookName = scanInput.next();
				book.setBookName(bookName);

				System.out.println("enter book author -");
				String bookAuthor = scanInput.next();
				book.setAuthor(bookAuthor);

				System.out.println("enter book edition -");
				int bookEdition = scanInput.nextInt();
				book.setEdition(bookEdition);

				System.out.println("enter book price -");
				int bookPrice = scanInput.nextInt();
				book.setPrice(bookPrice);

				System.out.println("enter book quantity -");
				int bookQuantity = scanInput.nextInt();
				book.setQuantity(bookQuantity);
				
				books.add(book);

			}

			System.out.print("want to repeat - ");
			i = scanInput.nextInt();

		} while (i == 1);

	}

}
