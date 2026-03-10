import { CanActivateFn } from '@angular/router';
import { User } from '../service/user';
import { inject } from '@angular/core';

export const staffGuard: CanActivateFn = (route, state) => {
  let user = inject(User);
  if(user.getName() != "Guest" && user.getRole() == "Staff") return true;
  else return false;
};
