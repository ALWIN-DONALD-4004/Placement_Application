import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CertificateService, Certificate } from '../../services/certificate.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-certificate-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './certificate-form.component.html',
  styleUrls: ['./certificate-form.component.scss']
})
export class CertificateFormComponent {
  certificate: Certificate = {
    register_number: 0,
    name: '',
    coursename: '',
    verificationid: '',
    issueDate: '',
    course_duration: ''
  };

  constructor(
    private certificateService: CertificateService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.certificateService.getCertificateById(+id).subscribe(data => {
        this.certificate = data;
      });
    }
  }

  saveCertificate(): void {
    console.log("Saving Certificate:", this.certificate);

    if (this.certificate.register_number) {
    this.certificateService.addCertificate(this.certificate).subscribe({
  next: (response) => {
    console.log('Certificate added successfully:', response);
    alert('Certificate added successfully!');
    this.router.navigate(['/']);
  },
  error: (error) => {
    console.error('Error adding certificate:', error);
  }
  });
    }
    else{
      this.certificateService.updateCertificate(this.certificate.register_number, this.certificate).subscribe(
        () => {
          console.log("Certificate updated successfully!");
          this.router.navigate(['/']); // Redirect after success
        },
        error => {
          console.error("Error updating certificate:", error);
        }
      );
    }
  }

}
