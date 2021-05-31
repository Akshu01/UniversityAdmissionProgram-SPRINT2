import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Login } from '../model/login';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  login: Login;
  message: string;

  constructor(private router: Router,
    private routerData: ActivatedRoute,
    private loginService: LoginService
  ) {
    this.login = {
      loginId: null,
      firstName: null,
      lastName: null,
      email: null,
      password: null,
      mobileNumber: null,
      address: null,
      postalCode: null
    };
  }

  ngOnInit() { }


  onSubmit() {
    let obr = null;
    obr = this.loginService.loginUSerFromRemote(this.login);
    obr.subscribe(
      (data) => {
        console.log(data);
        this.router.navigateByUrl("/headerapplicant"),
        {
          queryParams:
            { msg: "Login Successful with Applicant Id: " + data.loginId }
        }
      },
      error => {
        console.log("response not received")
        this.message = "Bad Credentials, Please Enter Correct Email Id and Password";
      }
    )
  }
}
