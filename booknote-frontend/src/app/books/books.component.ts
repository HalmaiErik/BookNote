import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../model/book';
import { BookService } from '../services/book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  books: Book[] = [];
  idTheme: number;
  bookToInsert: Book;

  constructor(private bookService: BookService, private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      params => {
        this.idTheme = +params['idTheme'];
      }
    );

    this.getBooks();
  }

  public onOpenModal(book: Book, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addModal');
    }
    container!.appendChild(button);
    button.click();
  }

  public onAddBook(addForm: NgForm): void {
    this.bookToInsert = addForm.value;
    this.bookToInsert.idTheme = this.idTheme;
    document.getElementById('add-book-form')!.click();
    this.bookService.addBook(this.bookToInsert).subscribe(
      (response: Book) => {
        this.getBooks();
        addForm.reset();
      },
    );
  }

  getBooks(): void {
    this.bookService.getBooks(this.idTheme).subscribe(
      (resp: Book[]) => {
        this.books = resp;
      }
    )
  }

  goChapters(idBook: number) {
    this.router.navigate([`/home/${this.idTheme}/${idBook}`]);
  }

}
