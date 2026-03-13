import { Routes } from '@angular/router';
import { ViewStudent } from './view-student/view-student';
import { CreateStudent } from './create-student/create-student';
import { UpdateStudent } from './update-student/update-student';
import { DeleteStudent } from './delete-student/delete-student';

export const routes: Routes = [
    {
        path:"login",
        component:ViewStudent
    },
    {
        path:"view",
        component:ViewStudent
    },
    {
        path:"add",
        component:CreateStudent
    },
    {
        path:"update",
        component:UpdateStudent
    },
    {
        path:"delete",
        component:DeleteStudent
    }
];
