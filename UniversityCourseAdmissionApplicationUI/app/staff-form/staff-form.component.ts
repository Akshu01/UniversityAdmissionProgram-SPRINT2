import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UniversityStaffService } from '../service/university-staff.service';

@Component({
  selector: 'app-staff-form',
  templateUrl: './staff-form.component.html',
  styleUrls: ['./staff-form.component.css']
})
export class StaffFormComponent implements OnInit {
  staffIdfc: FormControl;
  passwordfc: FormControl;
  rolefc: FormControl;

  staffForm: FormGroup;

  isEditing: boolean;
  constructor(private staffService: UniversityStaffService, private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.staffIdfc = new FormControl(null, Validators.required);
    this.passwordfc = new FormControl(null, [Validators.required, Validators.max(20)]);
    this.rolefc = new FormControl(null, [Validators.required, Validators.max(30)]);

    this.staffForm = new FormGroup({
      staffId: this.staffIdfc,
      password: this.passwordfc,
      role: this.rolefc
    });
    this.isEditing = false;
  }

  ngOnInit(): void {
    let eid = this.activatedRoute.snapshot.params.eid;
    if (eid) {
      this.isEditing = true;
      this.staffService.getById(eid).subscribe(
        (data) => this.staffForm.setValue(data)
      );
    }
  }

  handleSubmit() {
    let obr = null;
    if (this.isEditing) {
      obr = this.staffService.update(this.staffForm.value);
    } else {
      obr = this.staffService.add(this.staffForm.value);
    }
    obr.subscribe(
      (data) => this.router.navigateByUrl("/header/universitystaffs")
    );
  }

}
