import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { AdmissionCommitteeMember } from '../model/admission-committee-member';

@Injectable({
  providedIn: 'root'
})
export class AdmissionCommitteeMemberService {
  committeeApi : string;

  constructor(private httpClient : HttpClient) { 
      this.committeeApi = "http://localhost:8082/admissioncommiteemember";
  }
  getAll() : Observable<AdmissionCommitteeMember[]>{
    return this.httpClient.get<AdmissionCommitteeMember[]>(this.committeeApi);
  }

  getById(eid : number) : Observable<AdmissionCommitteeMember> {
    return this.httpClient.get<AdmissionCommitteeMember>(`${this.committeeApi}/${eid}`);
  }

  deleteById(eid : number) : Observable<void> {
     return this.httpClient.delete<void>(`${this.committeeApi}/${eid}`);
  }

  add(member : AdmissionCommitteeMember) : Observable<AdmissionCommitteeMember> {
     return this.httpClient.post<AdmissionCommitteeMember>(this.committeeApi, member);
  }

  update(member : AdmissionCommitteeMember) : Observable<AdmissionCommitteeMember> {
     return this.httpClient.put<AdmissionCommitteeMember>(this.committeeApi, member);
  }

}
