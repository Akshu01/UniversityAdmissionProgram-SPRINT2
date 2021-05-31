import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdmissionService } from '../service/admission.service';

@Component({
  selector: 'app-admission-form',
  templateUrl: './admission-form.component.html',
  styleUrls: ['./admission-form.component.css']
})
export class AdmissionFormComponent implements OnInit {
  admissionIdfc: FormControl;
  admissionDatefc: FormControl;
  admissionStatusfc: FormControl;
  courseIdfc: FormControl;
  applicantIdfc: FormControl;
  adminIdfc: FormControl

  admissionForm: FormGroup;

  isEditing: boolean;
  constructor(private admissionService: AdmissionService, private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.admissionIdfc = new FormControl(null, Validators.required);
    this.admissionDatefc = new FormControl(null, Validators.required);
    this.admissionStatusfc = new FormControl(null, Validators.required);
    this.courseIdfc = new FormControl(null, Validators.required);
    this.applicantIdfc = new FormControl(null, Validators.required);
    this.adminIdfc = new FormControl(null, Validators.required);

    this.admissionForm = new FormGroup({
      admissionId: this.admissionIdfc,
      admissionDate: this.admissionDatefc,
      admissionStatus: this.admissionStatusfc,
      courseId: this.courseIdfc,
      applicantId: this.applicantIdfc,
      adminId: this.adminIdfc
    });
    this.isEditing = false;
  }

  ngOnInit(): void {
    let admissionid = this.activatedRoute.snapshot.params.admissionId;
    if (admissionid) {
      this.isEditing = true;
      this.admissionService.getById(admissionid).subscribe(
        (data) => this.admissionForm.setValue(data)
      );
    }
  }
  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.admissionService.update(this.admissionForm.value);
    } else {
      obr = this.admissionService.add(this.admissionForm.value);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/header/admissions")
    );
  }



}
