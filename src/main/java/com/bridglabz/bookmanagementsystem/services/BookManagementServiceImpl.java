package com.bridglabz.bookmanagementsystem.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.bridglabz.bookmanagementsystem.interfaces.IBookManagementService;
import com.bridglabz.bookmanagementsystem.interfaces.ICustomerService;
import com.bridglabz.bookmanagementsystem.model.Book;
import com.bridglabz.bookmanagementsystem.model.BookManagement;
import com.bridglabz.bookmanagementsystem.model.Customer;



public class BookManagementServiceImpl implements IBookManagementService {
	static Scanner scan = new Scanner(System.in);
	ICustomerService customerService= new CustomerServiceImpl(); 
	@Override
	public void buyBook(List<Book> books, List<Customer> customers, List<BookManagement> bookManagements) {
		
		Book book = books.stream()
				.filter(data -> data.getBookName().compareToIgnoreCase(getBookNameFromCustomer().get(0)) == 0)
				.collect(Collectors.toList()).get(0);
		Customer customer=customerService.getCustomer(customers);
		saveBookTransitionDetails(customer,book,getBookNameFromCustomer().get(1),bookManagements);
		
	}

	private List<String> getBookNameFromCustomer() {
		System.out.println("Enter book name");
		String bookName = scan.next();
		System.out.println("Enter number of quantity -");
		int quantity =scan.nextInt();
		List<String> bookDetail=new ArrayList<String>();
		bookDetail.add(bookName);
		bookDetail.add(String.valueOf(quantity));
		return bookDetail;
		
}
	
	public void saveBookTransitionDetails(Customer customer,Book book,String quantity, List<BookManagement> bookManagements) {
		BookManagement bookManagement=new BookManagement();
		bookManagement.setBookId(book.getId());
		bookManagement.setCustomerId(customer.getId());
		bookManagement.setManagementId((int)Math.random()+2);
	    Date date = new Date();  
		bookManagement.setDateOfIssue(date);
	    Date newDate = new Date(date.getYear(),date.getMonth(),date.getDay()+10);  
		bookManagement.setDataOfReturn(newDate);
		bookManagement.setQuantity((Integer.valueOf(quantity)));
		bookManagement.setTotalBillAmount((Integer.valueOf(quantity))*book.getPrice());
		bookManagements.add(bookManagement);
		bookManagement.setQuantity(bookManagement.getQuantity()-(Integer.valueOf(quantity)));
	}
}
