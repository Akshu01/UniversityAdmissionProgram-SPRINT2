import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Admission } from '../model/admission';

@Injectable({
  providedIn: 'root'
})
export class AdmissionService {
  admissionApi : string;
  constructor(private httpClient : HttpClient) { 
    this.admissionApi="http://localhost:8082/admissions";
  }
  getAll() : Observable<Admission[]>{
    return this.httpClient.get<Admission[]>(this.admissionApi);
  }

  getById(admissionId : number) : Observable<Admission>{
    return this.httpClient.get<Admission>(`${this.admissionApi}/${admissionId}`);
  }

  deleteById(admissionId : number): Observable<void> {
    return this.httpClient.delete<void>(`${this.admissionApi}/${admissionId}`);
  }

  add(admission : Admission) : Observable<Admission>{
    return this.httpClient.post<Admission>(this.admissionApi, admission);
  }

  update(admission : Admission) : Observable<Admission>{
    return this.httpClient.put<Admission>(this.admissionApi, admission);
  }

}
