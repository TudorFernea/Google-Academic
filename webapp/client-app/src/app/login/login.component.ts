import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {Router} from "@angular/router";
import { RegisterService } from '../register.service';

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


  constructor(private router: Router, 
    private registerService: RegisterService) { 
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

  validateString(input: String){
    if (input==="") alert("Provide an input!")
  }
  comparePasswords(password: String, confPassword: String){
    if(password!==confPassword) alert("Passwords should be the same");

  }
  
}
