package boying.domain.book;

import boying.domain.BaseModel;

/**
 * Created by boying on 2017/7/4.
 */
public class Book extends BaseModel{
    private String name;
    private String isbn;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                "} " + super.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
