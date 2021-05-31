import { Component, OnInit } from '@angular/core';
import { Applicant } from '../model/applicant';
import { ApplicantService } from '../service/applicant.service';

@Component({
  selector: 'app-applicant-list',
  templateUrl: './applicant-list.component.html',
  styleUrls: ['./applicant-list.component.css']
})
export class ApplicantListComponent implements OnInit {
  applicant: Applicant[];
  err: string;

  constructor(private applicantService: ApplicantService) { }

  ngOnInit(): void {
    this.applicantService.getAll().subscribe(
      (data) => this.applicant = data,
      (err) => { console.log(err); this.err = "sorry. unable to retrieve data" }
    );
  }
  delete(applicantId: number) {
    if (confirm("Are you sure?")) {
      this.applicantService.deleteById(applicantId).subscribe(
        () => { this.applicant.splice(this.applicant.findIndex(a => a.applicantId == applicantId), 1) }
      );
    }
  }
}
