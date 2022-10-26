package com.bookstore.Response;


import com.bookstore.model.Book;
import com.bookstore.model.Editorial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter @Setter
public class BookResponse {

    @JsonProperty("Book_Id")
    private long id;
    @JsonProperty("Book_Name")
    private String title ;
    @JsonProperty("Book_Author")
    private String author;
    @JsonProperty("Book_Publish_Date")
    private LocalDate publishDate;
    @JsonProperty("Book_Total_Pages")
    private int pages;
    @JsonProperty("Book_Description")
    private String description;
    @JsonProperty("Book_Editorial")
    private EditorialResponse editorialResponse;

    public BookResponse(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.publishDate = book.getPublishDate();
        this.pages = book.getPages();
        this.description = book.getDescription();
        this.editorialResponse = new EditorialResponse(book.getEditorial().getId(),book.getEditorial().getName());
    }

}