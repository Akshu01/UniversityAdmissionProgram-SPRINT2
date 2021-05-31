import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Applicant } from '../model/applicant';

@Injectable({
  providedIn: 'root'
})
export class ApplicantService {
  applicantApi : string;
  private _currentApplicant : Applicant;

  constructor(private httpClient : HttpClient) {
    this.applicantApi="http://localhost:8082/applicants";
   }

   get currentApplicant(){
    return this._currentApplicant;
  }

  set currentApplicant(cc:Applicant){
    this._currentApplicant=cc;
  }

   getAll() : Observable<Applicant[]>{
    return this.httpClient.get<Applicant[]>(this.applicantApi);
  }

  getById(applicantId : number) : Observable<Applicant>{
    return this.httpClient.get<Applicant>(`${this.applicantApi}/${applicantId}`);
  }

  deleteById(applicantId : number): Observable<void> {
    return this.httpClient.delete<void>(`${this.applicantApi}/${applicantId}`);
  }

  add(applicant : Applicant) : Observable<Applicant>{
    return this.httpClient.post<Applicant>(this.applicantApi, applicant);
  }

  update(applicant : Applicant) : Observable<Applicant>{
    return this.httpClient.put<Applicant>(this.applicantApi, applicant);
  }

}
