import { Component, OnInit } from '@angular/core';
import { Course } from '../model/course';
import { CourseService } from '../service/course.service';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  courses: Course[];
  err: string;
  constructor(private courseService: CourseService) { }

  ngOnInit(): void {
    this.courseService.getAll().subscribe(
      (data) => { this.courses = data; console.log(data); },
      (err) => { console.log(err); this.err = "sorry. unable to retrieve data" }
    );
  }
  delete(courseId: number) {
    if (confirm("Are you sure?")) {
      this.courseService.deleteById(courseId).subscribe(
        () => { this.courses.splice(this.courses.findIndex(e => e.courseId == courseId), 1) }
      );
    }
  }

}
