import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { User } from '../service/user';

export const userGuard: CanActivateFn = (route, state) => {
  let user = inject(User)
  let router = inject(Router)
  if(user.getName() != 'Guest' && user.getRole() == "Admin")return true;
  return false;
};
