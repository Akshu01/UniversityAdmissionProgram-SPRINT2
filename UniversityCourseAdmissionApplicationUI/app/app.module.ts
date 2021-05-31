import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginDashboardComponent } from './login-dashboard/login-dashboard.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { HeaderComponent } from './header/header.component';
import { CourseComponent } from './course/course.component';
import { CourseFormComponent } from './course-form/course-form.component';
import { CourseListComponent } from './course-list/course-list.component';
import { UniversityStaffComponent } from './university-staff/university-staff.component';
import { StaffListComponent } from './staff-list/staff-list.component';
import { StaffFormComponent } from './staff-form/staff-form.component';
import { AdmissionCommitteememberComponent } from './admission-committeemember/admission-committeemember.component';
import { CommitteeMemberListComponent } from './committee-member-list/committee-member-list.component';
import { CommitteeMemberFormComponent } from './committee-member-form/committee-member-form.component';
import { ApplicantComponent } from './applicant/applicant.component';
import { ApplicantListComponent } from './applicant-list/applicant-list.component';
import { ApplicantFormComponent } from './applicant-form/applicant-form.component';
import { AdmissionListComponent } from './admission-list/admission-list.component';
import { AdmissionFormComponent } from './admission-form/admission-form.component';
import { AdmissionComponent } from './admission/admission.component';
import { LoginadmissionListComponent } from './loginadmission-list/loginadmission-list.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { HeaderapplicantComponent } from './headerapplicant/headerapplicant.component';
import { ApplicantregisterFormComponent } from './applicantregister-form/applicantregister-form.component';
import { ApplicantdashboardComponent } from './applicantdashboard/applicantdashboard.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { IvyCarouselModule } from 'angular-responsive-carousel';
import { GetAdmissionStatusFormComponent } from './get-admission-status-form/get-admission-status-form.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginDashboardComponent, 
    AdminHomeComponent,
    HeaderComponent,
    CourseComponent,
    CourseFormComponent,
    CourseListComponent,
    UniversityStaffComponent,
    StaffListComponent,
    StaffFormComponent,
    AdmissionCommitteememberComponent,
    CommitteeMemberListComponent,
    CommitteeMemberFormComponent,
    ApplicantComponent,
    ApplicantListComponent,
    ApplicantFormComponent,
    AdmissionListComponent,
    AdmissionFormComponent,
    AdmissionComponent,
    LoginadmissionListComponent,
    AboutusComponent,
    HeaderapplicantComponent,
    ApplicantregisterFormComponent,
    ApplicantdashboardComponent,
    GetAdmissionStatusFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    NgbModule,
    IvyCarouselModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
