import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Course } from '../model/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  courseApi : string;

  constructor(private httpClient : HttpClient) {
    this.courseApi = "http://localhost:8082/courses";
   }
   getAll() : Observable<Course[]>{
    return this.httpClient.get<Course[]>(this.courseApi);
  }

  getById(eid : number) : Observable<Course> {
    return this.httpClient.get<Course>(`${this.courseApi}/${eid}`);
  }

  deleteById(eid : number) : Observable<void> {
     return this.httpClient.delete<void>(`${this.courseApi}/${eid}`);
  }

  add(course : Course) : Observable<Course> {
     return this.httpClient.post<Course>(this.courseApi, course);
  }

  update(course : Course) : Observable<Course> {
     return this.httpClient.put<Course>(this.courseApi, course);
}

}
