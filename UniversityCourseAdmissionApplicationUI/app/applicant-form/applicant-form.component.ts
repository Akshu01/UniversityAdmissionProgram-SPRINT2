import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from '../model/course';
import { ApplicantService } from '../service/applicant.service';
import { CourseService } from '../service/course.service';

@Component({
  selector: 'app-applicant-form',
  templateUrl: './applicant-form.component.html',
  styleUrls: ['./applicant-form.component.css']
})
export class ApplicantFormComponent implements OnInit {
  applicantIdfc: FormControl;
  applicantNamefc: FormControl;
  mobileNumberfc: FormControl;
  applicantDegreefc: FormControl;
  applicantGradPercentfc: FormControl;

  applicantForm: FormGroup;

  isEditing: boolean;

  course: Course[];

  constructor(private applicantService: ApplicantService, private router: Router,
    private activatedRoute: ActivatedRoute, private courseService: CourseService) {
    this.applicantIdfc = new FormControl(null, Validators.required);
    this.applicantNamefc = new FormControl(null, Validators.required);
    this.mobileNumberfc = new FormControl(null, Validators.required);
    this.applicantDegreefc = new FormControl(null, Validators.required);
    this.applicantGradPercentfc = new FormControl(null, Validators.required);

    this.applicantForm = new FormGroup({
      applicantId: this.applicantIdfc,
      applicantName: this.applicantNamefc,
      mobileNumber: this.mobileNumberfc,
      applicantDegree: this.applicantDegreefc,
      applicantGradPercent: this.applicantGradPercentfc

    });
    this.isEditing = false;
  }

  ngOnInit(): void {
    this.courseService.getAll().subscribe(
      (data) => this.course = data,
    );

    let eid = this.activatedRoute.snapshot.params.eid;
    if (eid) {
      this.isEditing = true;
      this.applicantService.getById(eid).subscribe(
        (data) => this.applicantForm.setValue(data)
      );
    }
  }
  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.applicantService.update(this.applicantForm.value);
    } else {
      obr = this.applicantService.add(this.applicantForm.value);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/header/applicants")
    );
  }


}
