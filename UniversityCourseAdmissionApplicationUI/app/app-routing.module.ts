import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { HomeComponent } from './home/home.component';
import { LoginDashboardComponent } from './login-dashboard/login-dashboard.component';
import { HeaderComponent } from './header/header.component';
import { CourseComponent } from './course/course.component';
import { CourseListComponent } from './course-list/course-list.component';
import { CourseFormComponent } from './course-form/course-form.component';
import { UniversityStaffComponent } from './university-staff/university-staff.component';
import { StaffListComponent } from './staff-list/staff-list.component';
import { StaffFormComponent } from './staff-form/staff-form.component';
import { AdmissionCommitteememberComponent } from './admission-committeemember/admission-committeemember.component';
import { CommitteeMemberListComponent } from './committee-member-list/committee-member-list.component';
import { CommitteeMemberFormComponent } from './committee-member-form/committee-member-form.component';
import { AdmissionComponent } from './admission/admission.component';
import { AdmissionListComponent } from './admission-list/admission-list.component';
import { AdmissionFormComponent } from './admission-form/admission-form.component';
import { ApplicantFormComponent } from './applicant-form/applicant-form.component';
import { ApplicantComponent } from './applicant/applicant.component';
import { ApplicantListComponent } from './applicant-list/applicant-list.component';
import { LoginadmissionListComponent } from './loginadmission-list/loginadmission-list.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { HeaderapplicantComponent } from './headerapplicant/headerapplicant.component';
import { ApplicantregisterFormComponent } from './applicantregister-form/applicantregister-form.component';
import { ApplicantdashboardComponent } from './applicantdashboard/applicantdashboard.component';
import { GetAdmissionStatusFormComponent } from './get-admission-status-form/get-admission-status-form.component';
import { DashboardComponent } from './dashboard/dashboard.component';


const routes: Routes = [
  {path : '',pathMatch : 'full', component : HomeComponent},

  {path : 'register',pathMatch:'full',component :LoginDashboardComponent},
  {path : 'register1',pathMatch:'full',component :AdminHomeComponent},
   
  {path : 'header', component :HeaderComponent,
  children : [
    {path : '', component : DashboardComponent},
    { path : 'courses', component : CourseComponent, 
      children :[
        { path : 'list', component : CourseListComponent },
        { path : 'add', component : CourseFormComponent },
        { path : 'edit/:eid', component : CourseFormComponent },
        { path : '', redirectTo : 'list', pathMatch : 'full'}
   ]},
    { path : 'universitystaffs',
    component : UniversityStaffComponent, 
    children : [
      { path : 'list', component : StaffListComponent },
      { path : 'add', component : StaffFormComponent },
      { path : 'edit/:eid', component : StaffFormComponent },
      { path : 'courses/list', component : CourseListComponent },
      { path : 'courses/add', component : CourseFormComponent },
      { path : 'courses/edit/:eid', component : CourseFormComponent },
      { path : '', redirectTo : 'list', pathMatch : 'full'}
   ]},

   { path : 'admissioncommitteemember',
    component : AdmissionCommitteememberComponent, 
    children : [
      { path : 'list', component : CommitteeMemberListComponent },
      { path : 'add', component : CommitteeMemberFormComponent },
      { path : 'edit/:eid', component : CommitteeMemberFormComponent },
      { path : 'admissionstatus', component : GetAdmissionStatusFormComponent},
      { path : '', redirectTo : 'list', pathMatch : 'full'}
   ]},

    { path : 'applicants', component : ApplicantComponent, children : [
      { path : 'list', component : ApplicantListComponent },
      { path : 'add', component : ApplicantFormComponent },
      { path : 'edit/:eid', component : ApplicantFormComponent },
      { path : '', redirectTo : 'list', pathMatch : 'full'}
   ]},

   { path : 'admissions', component : AdmissionComponent, children : [
    { path : 'list', component : AdmissionListComponent },
    { path : 'add', component : AdmissionFormComponent },
    { path : 'edit/:admissionId', component : AdmissionFormComponent },
    { path : '', redirectTo : 'list', pathMatch : 'full'}
   ]}

]},
{ path : 'headerapplicant', component : HeaderapplicantComponent, 
      children :[
        { path : 'list', component : LoginadmissionListComponent },
        { path : 'add', component : ApplicantregisterFormComponent },
        { path : 'aboutus', component : AboutusComponent },
        { path : '',component : ApplicantdashboardComponent}
    ]}
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
