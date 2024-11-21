import { Component } from '@angular/core';
import { PostListComponent } from "../../components/post-list/post-list.component";

@Component({
  selector: 'app-post-page',
  imports: [PostListComponent],
  templateUrl: './post-page.component.html',
  styleUrl: './post-page.component.css'
})
export class PostPageComponent {

}
