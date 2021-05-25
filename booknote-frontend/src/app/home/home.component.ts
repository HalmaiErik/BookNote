import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Theme } from '../model/theme';
import { ThemeService } from '../services/theme.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  themes: Theme[] = [];

  constructor(private themeService: ThemeService, private router: Router) { }

  ngOnInit(): void {
    this.getThemes();
  }

  public onOpenModal(theme: Theme, mode: string): void {
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
    console.log("Clicked");
  }

  public onAddTheme(addForm: NgForm): void {
    document.getElementById('add-theme-form')!.click();
    this.themeService.addTheme(addForm.value).subscribe(
      (response: Theme) => {
        console.log(response);
        this.getThemes();
        addForm.reset();
      },
    );
  }

  public getThemes(): void {
    this.themeService.getThemes().subscribe(
      (resp: Theme[]) => {
        this.themes = resp;
      }
    )
  }

  goBooks(idTheme: number) {
    this.router.navigate([`/home/${idTheme}`]);
  }
}
