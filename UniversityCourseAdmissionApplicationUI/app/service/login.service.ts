import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { AdmissionCommitteeMember } from '../model/admission-committee-member';
import { Applicant } from '../model/applicant';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  loginApi : string;
  private _currentLogin : Login;

  constructor(private httpClient : HttpClient) {
    this.loginApi="http://localhost:8082/logins";
   }

   get currentLogin(){
    return this._currentLogin;
  }

  set currentLogin(cc:Login){
    this._currentLogin=cc;
  }

  add(login : Login) : Observable<Login>{
    return this.httpClient.post<Login>(this.loginApi, login);
  }

  loginUSerFromRemote(login : Login) : Observable<Login>{
    return this.httpClient.post<Login>("http://localhost:8082/logins/login",login);
  }

  loginAdminFromRemote(admin : AdmissionCommitteeMember) : Observable<AdmissionCommitteeMember>{
    return this.httpClient.post<AdmissionCommitteeMember>("http://localhost:8082/logins/loginAdmin",admin);
  }

  addAdmin(admin : AdmissionCommitteeMember) : Observable<AdmissionCommitteeMember>{
    return this.httpClient.post<AdmissionCommitteeMember>("http://localhost:8082/logins/addAdmin", admin);
  }

  registerApplicant(applicant : Applicant) {
    return this.httpClient.post<Applicant>("http://localhost:8082/logins/addApplicant", applicant);
  }
}
