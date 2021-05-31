import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { UniversityStaff } from '../model/university-staff';

@Injectable({
  providedIn: 'root'
})
export class UniversityStaffService {

  staffApi : string;

  constructor(private httpClient : HttpClient) { 
      this.staffApi = "http://localhost:8082/universitystaffs";
  }
  getAll() : Observable<UniversityStaff[]>{
    return this.httpClient.get<UniversityStaff[]>(this.staffApi);
  }

  getById(eid : number) : Observable<UniversityStaff> {
    return this.httpClient.get<UniversityStaff>(`${this.staffApi}/${eid}`);
  }

  deleteById(eid : number) : Observable<void> {
     return this.httpClient.delete<void>(`${this.staffApi}/${eid}`);
  }

  add(staff : UniversityStaff) : Observable<UniversityStaff> {
     return this.httpClient.post<UniversityStaff>(this.staffApi, staff);
  }

  update(staff : UniversityStaff) : Observable<UniversityStaff> {
     return this.httpClient.put<UniversityStaff>(this.staffApi, staff);
  }

}
