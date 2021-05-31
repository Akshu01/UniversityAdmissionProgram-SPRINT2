import { Component, OnInit } from '@angular/core';
import { UniversityStaff } from '../model/university-staff';
import { UniversityStaffService } from '../service/university-staff.service';

@Component({
  selector: 'app-staff-list',
  templateUrl: './staff-list.component.html',
  styleUrls: ['./staff-list.component.css']
})
export class StaffListComponent implements OnInit {
  staff: UniversityStaff[];
  err: string;
  constructor(private staffService: UniversityStaffService) {

  }

  ngOnInit(): void {
    this.staffService.getAll().subscribe(
      (data) => this.staff = data,
      (err) => { console.log(err); this.err = "sorry. unable to retrieve data" }
    );
  }
  delete(staffId: number) {
    if (confirm("Are you sure?")) {
      this.staffService.deleteById(staffId).subscribe(
        () => { this.staff.splice(this.staff.findIndex(e => e.staffId == staffId), 1) }
      );
    }
  }

}
