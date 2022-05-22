import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {Router} from "@angular/router";
import { SignUpService } from '../services/sign-up.service';
import { AuthService } from '../Servicies/auth.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent  {
  

 

  signUpForm= new FormGroup({
    name: new FormControl(''),
    surname : new FormControl(''),
    username: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    confirmPassword: new FormControl(''),


  })

  positionForm= new FormGroup({
    position: new FormControl('')
  })


  constructor(private router: Router, 
    private signUpService: SignUpService,
    private authService: AuthService) { 
  }

 

  validateEmail(input: String): boolean{
    if (input.indexOf("@yahoo.com")===-1 && input.indexOf("@gmail.com")===-1){
      alert("Invalid E-mail address!");
      return false;
    }
    return true;
  }

  validatePassword(input: String) : boolean{
    if (input.length <=4){
       alert("Password should be longer than that!");
       return false;
    }
    return true;
  }

 

  public getRadioValue(){
    if (this.positionForm.controls["position"].value==='student') {console.log('student'); return 'STUDENT';}
    else if  (this.positionForm.controls["position"].value==='teacher') {console.log('teacher'); return 'TEACHER';}
    else return 'nothing good';
  }

  public signUpStudent(){
      // console.log(this.positionForm.controls["position"].value);
      
      this.signUpService.signUp(
      this.signUpForm.controls["name"].value,
      this.signUpForm.controls["surname"].value,
      this.signUpForm.controls["username"].value,
      this.signUpForm.controls["email"].value,
       this.signUpForm.controls["password"].value,
       this.signUpForm.controls["confirmPassword"].value,
       this.getRadioValue()
       ).subscribe(
        response => {
          
          console.log(response);
          if(response){
            alert("Registered succesfully");
            this.router.navigateByUrl('/');
           
          } 
        }
       )
      }

  validateString(input: String){
    if (input==="") alert("Provide an input!")
  }
  comparePasswords(password: String, confPassword: String){
    if(password!==confPassword) alert("Passwords should be the same");

  }
  
}
