import { Component, OnInit } from '@angular/core';
import { Admission } from '../model/admission';
import { AdmissionService } from '../service/admission.service';

@Component({
  selector: 'app-admission-list',
  templateUrl: './admission-list.component.html',
  styleUrls: ['./admission-list.component.css']
})
export class AdmissionListComponent implements OnInit {
  admission: Admission[];
  err: string;
  constructor(private admissionService: AdmissionService) { }

  ngOnInit(): void {
    this.admissionService.getAll().subscribe(
      (data) => this.admission = data,
      (err) => { console.log(err); this.err = "sorry. unable to retrieve data" }
    );
  }
  delete(admissionId: number) {
    if (confirm("Are you sure?")) {
      this.admissionService.deleteById(admissionId).subscribe(
        () => { this.admission.splice(this.admission.findIndex(e => e.admissionId == admissionId), 1) }
      );
    }
  }
}
