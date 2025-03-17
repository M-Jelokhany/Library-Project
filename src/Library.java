import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    public void addBook(Book book) throws InvalidBookException {
        if(book == null){
            throw new InvalidBookException("Book should not be null");
        }
        books.add(book);
    }

    private Book findBook(String title){
        for(Book x : books){
            if(x.getTitle().equals(title)){
                return x;
            }
        }
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException,EmptyLibraryException{
        if(books.isEmpty()){
            throw new EmptyLibraryException("Library is empty , no books to borrow");
        }
        if(findBook(title) == null){
            throw new BookNotFoundException("Book with title " + title + " not found");
        }
        System.out.println("Book " + findBook(title).toString() + " was successfully loaned");
    }

    public void returnBook(String title) throws BookNotFoundException{
        if(findBook(title) == null){
            throw new BookNotFoundException("Cannot return . Book with title " + title + " not found");
        }
    }

    public void listBooks() throws EmptyLibraryException{
        if(books.isEmpty()){
            throw new EmptyLibraryException("Library is empty");
        }
        System.out.println("Books in the library : ");
        for(Book x : books){
            System.out.println(x.toString());
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}
