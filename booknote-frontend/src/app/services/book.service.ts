import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Book } from '../model/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  private apiServerURL = environment.apiBaseURL;

  constructor(private http: HttpClient) { }

  public addBook(book: Book): Observable<Book> {
    return this.http.post<Book>(`${this.apiServerURL}/book`, book);
  }

  public getBooks(idTheme: number): Observable<Book[]> {
    return this.http.get<Book[]>(`${this.apiServerURL}/book/by-theme/${idTheme}`);
  }
}
