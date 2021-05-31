import { Component, OnInit } from '@angular/core';
import { AdmissionCommitteeMember } from '../model/admission-committee-member';
import { AdmissionCommitteeMemberService } from '../service/admission-committee-member.service';

@Component({
  selector: 'app-committee-member-list',
  templateUrl: './committee-member-list.component.html',
  styleUrls: ['./committee-member-list.component.css']
})
export class CommitteeMemberListComponent implements OnInit {
  committee: AdmissionCommitteeMember[];
  err: string;
  constructor(private committeeService: AdmissionCommitteeMemberService) { }

  ngOnInit(): void {
    this.committeeService.getAll().subscribe(
      (data) => this.committee = data,
      (err) => { console.log(err); this.err = "sorry. unable to retrieve data" }
    );
  }
  delete(adminId: number) {
    if (confirm("Are you sure?")) {
      this.committeeService.deleteById(adminId).subscribe(
        () => { this.committee.splice(this.committee.findIndex(e => e.adminId == adminId), 1) }
      );
    }
  }
}
