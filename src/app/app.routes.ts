import { Routes } from '@angular/router';
import { CertificateListComponent } from './components/certificate-list/certificate-list.component';
import { CertificateFormComponent } from './components/certificate-form/certificate-form.component';

export const routes: Routes = [
  { path: '', component: CertificateListComponent },
  { path: 'add', component: CertificateFormComponent },
  { path: 'edit/:id', component: CertificateFormComponent }
];
