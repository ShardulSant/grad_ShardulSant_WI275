import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ViewStudent } from './view-student/view-student';
import { CreateStudent } from './create-student/create-student';
import { UpdateStudent } from './update-student/update-student';
import { DeleteStudent } from './delete-student/delete-student';
import { Menu } from './menu/menu';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,ViewStudent,CreateStudent,UpdateStudent,DeleteStudent,Menu,FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('StudentAssignment-SpringBootAngular');
}
