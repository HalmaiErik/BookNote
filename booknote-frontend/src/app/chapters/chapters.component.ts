import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Chapter } from '../model/chapter';
import { ChapterService } from '../services/chapter.service';

@Component({
  selector: 'app-chapters',
  templateUrl: './chapters.component.html',
  styleUrls: ['./chapters.component.css']
})
export class ChaptersComponent implements OnInit {

  chapters: Chapter[] = [];
  idBook: number;
  chapterToInsert: Chapter;

  constructor(private chapterService: ChapterService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(
      params => {
        this.idBook = +params['idBook'];
      }
    );

    this.getChapters();
  }

  public onAddChapter(addForm: NgForm): void {
    this.chapterToInsert = addForm.value;
    this.chapterToInsert.idBook = this.idBook;
    console.log(this.chapterToInsert);
    document.getElementById('add-chapter-form')!.click();
    this.chapterService.addChapter(this.chapterToInsert).subscribe(
      (response: Chapter) => {
        console.log(response);
        this.getChapters();
        addForm.reset();
      },
    );
  }

  getChapters(): void {
    this.chapterService.getChapters(this.idBook).subscribe(
      (resp: Chapter[]) => {
        this.chapters = resp;
      }
    )
  }

}
