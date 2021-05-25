import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Chapter } from '../model/chapter';

@Injectable({
  providedIn: 'root'
})
export class ChapterService {

  private apiServerURL = environment.apiBaseURL;

  constructor(private http: HttpClient) { }

  public addChapter(chapter: Chapter): Observable<Chapter> {
    console.log(chapter);
    return this.http.post<Chapter>(`${this.apiServerURL}/chapter`, chapter);
  }

  public getChapters(idBook: number): Observable<Chapter[]> {
    return this.http.get<Chapter[]>(`${this.apiServerURL}/chapter/by-book/${idBook}`);
  }
}
