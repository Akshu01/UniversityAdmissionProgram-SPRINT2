import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login-dashboard',
  templateUrl: './login-dashboard.component.html',
  styleUrls: ['./login-dashboard.component.css']
})
export class LoginDashboardComponent implements OnInit {

  loginIdfc: FormControl;
  firstNamefc: FormControl;
  lastNamefc: FormControl;
  emailfc: FormControl;
  passwordfc: FormControl;
  mobileNumberfc: FormControl;
  addressfc: FormControl;
  postalCodefc: FormControl;

  loginForm: FormGroup;

  constructor(private loginService: LoginService, private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.loginIdfc = new FormControl(0, Validators.required);
    this.firstNamefc = new FormControl(null, [Validators.required, Validators.minLength(4)]);
    this.lastNamefc = new FormControl(null, [Validators.required, Validators.minLength(4)]);
    this.emailfc = new FormControl(null, [Validators.required, Validators.email]);
    this.passwordfc = new FormControl(null, [Validators.required]);
    this.mobileNumberfc = new FormControl(null, [Validators.required]);
    this.addressfc = new FormControl(null, Validators.required);
    this.postalCodefc = new FormControl(null, [Validators.required, Validators.minLength(5), Validators.maxLength(6)]);

    this.loginForm = new FormGroup({
      loginId: this.loginIdfc,
      firstName: this.firstNamefc,
      lastName: this.lastNamefc,
      email: this.emailfc,
      password: this.passwordfc,
      mobileNumber: this.mobileNumberfc,
      address: this.addressfc,
      postalCode: this.postalCodefc
    });
  }

  ngOnInit(): void {
  }

  handleSubmit() {
    let obr = null;
    obr = this.loginService.add(this.loginForm.value);
    obr.subscribe(
      (data) => {
        this.router.navigateByUrl("/");
        alert("Registration Successful with Email Id: " + data.email + " ,Please Log in with your credentials.");
      }
    );

  }

}
