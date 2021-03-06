import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { SignupRequest } from '../model/signup-request';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  signupForm: FormGroup;
  signupRequest: SignupRequest;

  constructor(private authService: AuthService, private router: Router, private toastr: ToastrService) { 
    this.signupRequest = {
      username: '',
      email: '',
      password: ''
    };
  }

  ngOnInit(): void {
    this.signupForm = new FormGroup({
      username: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', Validators.required)
    });
  }

  signup() {
    this.signupRequest.username = this.signupForm.get('username').value;
    this.signupRequest.email = this.signupForm.get('email').value;
    this.signupRequest.password = this.signupForm.get('password').value;

    this.authService.signup(this.signupRequest)
      .subscribe(() => {
        this.router.navigate(['/login'], 
          { queryParams: { registered: 'true' } });
      }, error => {
        console.log(error);
        this.toastr.error('Registration Failed! Please try again.');
      });
  }
}
