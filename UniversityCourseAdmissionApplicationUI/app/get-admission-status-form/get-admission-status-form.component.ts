import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';
import { Admission } from '../model/admission';
import { AdmissionService } from '../service/admission.service';

@Component({
  selector: 'app-get-admission-status-form',
  templateUrl: './get-admission-status-form.component.html',
  styleUrls: ['./get-admission-status-form.component.css']
})
export class GetAdmissionStatusFormComponent implements OnInit {

  admission: Admission;
  check: boolean = false;
  errorShow = false;
  message: string;

  constructor(private admissionService: AdmissionService, private router: Router,
    private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
  }

  getAdmission(getAdmissionForm: any) {

    let admissionId = getAdmissionForm.value.admissionId;
    let response: Observable<Admission> = this.admissionService.getById(admissionId);
    response.subscribe((admission: Admission) => {
      this.admission = admission;
      this.check = true;
      this.errorShow = false;
    },
      error => {
        this.errorShow = true;
        this.check = false;
        this.message = "No admission with provided admission id";
        console.log("Error " + error)
      });

  }
}


