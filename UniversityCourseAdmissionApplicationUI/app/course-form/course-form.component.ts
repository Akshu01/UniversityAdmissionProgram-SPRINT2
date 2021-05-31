import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CourseService } from '../service/course.service';

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent implements OnInit {
  courseIdfc: FormControl;
  courseNamefc: FormControl;
  courseDurationfc: FormControl;
  courseStartDatefc: FormControl;
  courseEndDatefc: FormControl;
  courseFeesfc: FormControl;
  staff_idfc: FormControl;
  courseForm: FormGroup;

  isEditing: boolean;
  constructor(private courseService: CourseService, private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.courseIdfc = new FormControl(null, Validators.required);
    this.courseNamefc = new FormControl(null, Validators.required);
    this.courseDurationfc = new FormControl(null, Validators.required);
    this.courseStartDatefc = new FormControl(null, Validators.required);
    this.courseEndDatefc = new FormControl(null, Validators.required);
    this.courseFeesfc = new FormControl(null, Validators.required);
    this.staff_idfc = new FormControl(null, Validators.required)

    this.courseForm = new FormGroup({
      courseId: this.courseIdfc,
      courseName: this.courseNamefc,
      courseDuration: this.courseDurationfc,
      courseStartDate: this.courseStartDatefc,
      courseEndDate: this.courseEndDatefc,
      courseFees: this.courseFeesfc,
      staff_id: this.staff_idfc

    });
    this.isEditing = false;
  }

  ngOnInit(): void {
    let eid = this.activatedRoute.snapshot.params.eid;
    if (eid) {
      this.isEditing = true;
      this.courseService.getById(eid).subscribe(
        (data) => this.courseForm.setValue(data)
      );
    }
  }

  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.courseService.update(this.courseForm.value);
    } else {
      obr = this.courseService.add(this.courseForm.value);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/header/courses")
    );
  }

}
