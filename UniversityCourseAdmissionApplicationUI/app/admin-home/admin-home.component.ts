import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AdmissionCommitteeMember } from '../model/admission-committee-member';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})

export class AdminHomeComponent implements OnInit {

  admin: AdmissionCommitteeMember;
  infoMsg: string;
  errMsg: string;
  message: string;

  constructor(private router: Router,
    private routerData: ActivatedRoute,
    private loginService: LoginService
  ) {
    this.admin = {
      adminId: null,
      adminName: null,
      adminContact: null
    };
  }

  ngOnInit() {
    this.routerData.queryParams
      .subscribe(
        (params) => {
          if (params.msg) {
            this.infoMsg = params.msg;
          }
        }
      );
  }

  onSubmit() {
    let obr = null;
    obr = this.loginService.loginAdminFromRemote(this.admin);
    obr.subscribe(
      (data) => {
        console.log(data);
        this.router.navigateByUrl("/header"),
        {
          queryParams:
            { msg: "Login Successful with Admin Id: " + data.adminId }
        }
      },
      error => {
        console.log("response not received")
        this.message = "Bad Credentials, Please Enter Correct user Name and Mobile Number";
      }
    )
  }
}
