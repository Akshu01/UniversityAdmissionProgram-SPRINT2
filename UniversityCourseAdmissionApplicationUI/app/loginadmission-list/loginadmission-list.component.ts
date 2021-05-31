import { Component, OnInit } from '@angular/core';
import { Admission } from '../model/admission';
import { AdmissionService } from '../service/admission.service';

@Component({
  selector: 'app-loginadmission-list',
  templateUrl: './loginadmission-list.component.html',
  styleUrls: ['./loginadmission-list.component.css']
})
export class LoginadmissionListComponent implements OnInit {
  admission: Admission[];
  err: string;

  constructor(private admissionService: AdmissionService) { }

  ngOnInit(): void {
    this.admissionService.getAll().subscribe(
      (data) => this.admission = data,
      (err) => { console.log(err); this.err = "sorry. unable to retrieve data" }
    );
  }

}
