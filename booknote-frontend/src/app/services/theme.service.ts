import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Theme } from '../model/theme';

@Injectable({
  providedIn: 'root'
})
export class ThemeService {

  private apiServerURL = environment.apiBaseURL;

  constructor(private http: HttpClient) { }

  public addTheme(theme: Theme): Observable<Theme> {
    return this.http.post<Theme>(`${this.apiServerURL}/theme`, theme);
  }

  public getThemes(): Observable<Theme[]> {
    return this.http.get<Theme[]>(`${this.apiServerURL}/theme`);
  }
}
