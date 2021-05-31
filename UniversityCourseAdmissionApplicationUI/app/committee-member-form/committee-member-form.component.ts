import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AdmissionCommitteeMemberService } from '../service/admission-committee-member.service';

@Component({
  selector: 'app-committee-member-form',
  templateUrl: './committee-member-form.component.html',
  styleUrls: ['./committee-member-form.component.css']
})
export class CommitteeMemberFormComponent implements OnInit {
  adminIdfc: FormControl;
  adminNamefc: FormControl;
  adminContactfc: FormControl;

  committeeForm: FormGroup;

  isEditing: boolean;
  constructor(private committeeService: AdmissionCommitteeMemberService, private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.adminIdfc = new FormControl(null, Validators.required);
    this.adminNamefc = new FormControl(null, [Validators.required]);
    this.adminContactfc = new FormControl(null, [Validators.required]);

    this.committeeForm = new FormGroup({
      adminId: this.adminIdfc,
      adminName: this.adminNamefc,
      adminContact: this.adminContactfc
    });
    this.isEditing = false;
  }

  ngOnInit(): void {
    let eid = this.activatedRoute.snapshot.params.eid;
    if (eid) {
      this.isEditing = true;
      this.committeeService.getById(eid).subscribe(
        (data) => this.committeeForm.setValue(data)
      );
    }
  }

  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.committeeService.update(this.committeeForm.value);
    } else {
      obr = this.committeeService.add(this.committeeForm.value);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/header/admissioncommitteemember")
    );
  }

}
