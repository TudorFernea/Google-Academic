import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import {Router} from "@angular/router";
import { RegisterService } from '../register.service';
import {SignUpService} from '../sign-up.service'
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  signUp: boolean = false;

  loginForm = new FormGroup({
    email : new FormControl(''),
    password : new FormControl(''),
  });

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
    private registerService: RegisterService,
    private signUpService: SignUpService) { 
  }

  get getSignUp(){
    return this.signUp;
  }
  setSignUp(newSign: boolean){
    this.signUp=newSign;

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

  public redirectStudent() {
    if(this.loginForm.controls["email"].value === "idk"){
      this.router.navigateByUrl('studentPage');
    }
    else if(this.validateEmail(this.loginForm.controls["email"].value)  && this.validatePassword(this.loginForm.controls["password"].value))
      this.registerService.logIn(this.loginForm.controls["email"].value, this.loginForm.controls["password"].value).subscribe(
        response => {
          if(response){
            this.router.navigateByUrl('studentPage');
          } else {
            alert("Invalid email and/or password!");
          }
        }
    )
    // location.replace("studentPage/");
  }

  public getRadioValue(){
    if (this.positionForm.value==='student') {console.log('student'); return 'student';}
    else if  (this.positionForm.value==='teacher') {console.log('teacher'); return 'teacher';}
    else return 'nothing good';
  }

  public signUpStudent(){
      // console.log(this.positionForm.controls["position"].value);
      console.log("am ajuns inainte");
      this.signUpService.signUp(
      this.signUpForm.controls["name"].value,
      this.signUpForm.controls["surname"].value,
      this.signUpForm.controls["username"].value,
      this.signUpForm.controls["email"].value,
       this.loginForm.controls["password"].value,
       this.signUpForm.controls["confirmPassword"].value
       ).subscribe(
        response => {
          console.log("inainte de login bun");
          console.log(response);
          if(response){
            this.router.navigateByUrl('login');
            console.log("dupa  login bun");
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
